LibSDL4J
========

LibSDL4J is a mapping of SDL2 APIs to Java. There are two goals for LibSDL4J:

* Provide as direct of a mapping of SDL APIs as possible.<br/>
  It should be easy to just 1:1 translate C-style source code to Java.
* Provide reasonably performant mapping.

Because of these goals, there is a lot of room for Java niceties (enums, encapsulation, AutoClosable, type-safety, exceptions etc.)
which are intentionally avoided. These can be applied by wrapping the raw API,
but it is outside the scope of this project.



## How to use it

Use Maven:

~~~xml
<dependency>
    <groupId>io.github.libsdl4j</groupId>
    <artifactId>libsdl4j</artifactId>
    <version>2.28.1-1.3</version>
</dependency>
~~~

or Gradle:

~~~kotlin
dependencies {
    implementation("io.github.libsdl4j:libsdl4j:2.28.1-1.3")
}
~~~

The library binary and source code is deployed to
[Maven Central](https://repo1.maven.org/maven2/io/github/libsdl4j/)
from where Maven and Gradle download it.



## Sample demo program

If you have LibSDL4J set up as a dependency of your project,
you can try to a sample program:

~~~
import io.github.libsdl4j.api.event.SDL_Event;
import io.github.libsdl4j.api.render.SDL_Renderer;
import io.github.libsdl4j.api.video.SDL_Window;

import static io.github.libsdl4j.api.Sdl.SDL_Init;
import static io.github.libsdl4j.api.Sdl.SDL_Quit;
import static io.github.libsdl4j.api.SdlSubSystemConst.SDL_INIT_EVERYTHING;
import static io.github.libsdl4j.api.error.SdlError.SDL_GetError;
import static io.github.libsdl4j.api.event.SDL_EventType.*;
import static io.github.libsdl4j.api.event.SdlEvents.SDL_PollEvent;
import static io.github.libsdl4j.api.keycode.SDL_Keycode.SDLK_SPACE;
import static io.github.libsdl4j.api.render.SDL_RendererFlags.SDL_RENDERER_ACCELERATED;
import static io.github.libsdl4j.api.render.SdlRender.*;
import static io.github.libsdl4j.api.video.SDL_WindowFlags.SDL_WINDOW_RESIZABLE;
import static io.github.libsdl4j.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_CreateWindow;
import static io.github.libsdl4j.api.video.SdlVideoConst.SDL_WINDOWPOS_CENTERED;

public class Demo {

    public static void main(String[] args) {
        // Initialize SDL
        int result = SDL_Init(SDL_INIT_EVERYTHING);
        if (result != 0) {
            throw new IllegalStateException("Unable to initialize SDL library (Error code " + result + "): " + SDL_GetError());
        }

        // Create and init the window
        SDL_Window window = SDL_CreateWindow("Demo SDL2", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, 1024, 768, SDL_WINDOW_SHOWN | SDL_WINDOW_RESIZABLE);
        if (window == null) {
            throw new IllegalStateException("Unable to create SDL window: " + SDL_GetError());
        }

        // Create and init the renderer
        SDL_Renderer renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
        if (renderer == null) {
            throw new IllegalStateException("Unable to create SDL renderer: " + SDL_GetError());
        }

        // Set color of renderer to green
        SDL_SetRenderDrawColor(renderer, (byte) 0, (byte) 255, (byte) 0, (byte) 255);

        // Clear the window and make it all red
        SDL_RenderClear(renderer);

        // Render the changes above ( which up until now had just happened behind the scenes )
        SDL_RenderPresent(renderer);

        // Start an event loop and react to events
        SDL_Event evt = new SDL_Event();
        boolean shouldRun = true;
        while (shouldRun) {
            while (SDL_PollEvent(evt) != 0) {
                switch (evt.type) {
                    case SDL_QUIT:
                        shouldRun = false;
                        break;
                    case SDL_KEYDOWN:
                        if (evt.key.keysym.sym == SDLK_SPACE) {
                            System.out.println("SPACE pressed");
                        }
                        break;
                    case SDL_WINDOWEVENT:
                        System.out.println("Window event " + evt.window.event);
                    default:
                        break;
                }
            }
        }

        SDL_Quit();
    }
}
~~~

If you are on macOS, you need to run the application with JVM option `-XstartOnFirstThread`.<br/>
Such as `java -classpath $YOUR_CLASSPATH -XstartOnFirstThread Demo`


### Next steps

You should be able to follow any C-style tutorial,
just tweak it very slightly to make it working in Java.

Some resources:
- https://headerphile.blogspot.com/2014/04/a-quick-introduction-to-sdl-2-part-1.html
- https://www.parallelrealities.co.uk/tutorials/shooter/shooter1.php



## Design choices


### SDL Functions

Each SDL C source file maps to a separate package in the API.

In each package, there is a Sdl*Name* class with `public static native` functions
corresponding to the SDL exported C functions.

If there are structs, enums, unions or other data types defined in the
C source file, corresponding Java classes are available.

If there are global constants in the C source file,
there is also an Sdl*Name*Const file present with the constants.

There is a reason to put the constants into a separate class rather than keeping it
within the Sdl*Name* class:
The first time you use any symbol from a Sdl*Name* class in a client code,
JNA loads the DLL/so into memory and maps
the Java functions to it, which is a costly operation.
It is not necessary for accessing constants, because they are mere values.
Therefore, they are placed in a separate class to avoid triggering
premature DLL/so loading.


### SDL Structures

SDL works with structures, which are translated 1:1 to Java as classes (such as `SDL_Point` or `SDL_Rect`).
However, for the sake of efficiency, there are sometimes overloaded methods present in the code:

-   One signature accepts Java objects
    as parameters (it serializes them to off-heap C memory),
    Such as `SDL_RenderDrawPoints(SDL_Renderer renderer, List<SDL_Point> points)`

-   Another signature that accepts just a [Pointer](https://java-native-access.github.io/jna/4.2.1/com/sun/jna/Pointer.html)
    (you are responsible for
    filling the data into memory - for maximum speed).
    Such as `SDL_RenderDrawPoints(SDL_Renderer renderer, Pointer points, int count)`.




## SDL2.Dll / libSDL2.so loading

The Java bindings will lookup the SDL2 dynamic library in the following locations
in order of precedence (algorithm built into `NativeLibrary.loadLibrary()`):

1. Any custom paths set by calling: `NativeLibrary.addSearchPath("SDL2", CUSTOM_PATHS)`.
2. Java Web Start (if used).
3. Any custom paths set to `jna.library.path` system property
   (`System.setProperty("jna.library.path", "CUSTOM_PATHS");` in the Java code
   or `-Djna.library.path=CUSTOM_PATHS` Java command line parameter).
4. Any OS standard library paths (`/usr/lib/`, `LD_LIBRARY_PATH` etc.)
   and custom paths set to `jna.platform.library.path` system property.
5. Embedded DLL/so in the `libsdl4j.jar` file itself.
   There are embedded libraries for Windows (x86, x86-64) and
   Linux (x86, x86-64, armhf, aarch64).

If you find it difficult to make it working, the process of searching for the dll/so library has debug logs:

| Logger                      | Minimum threshold level     |
|-----------------------------|-----------------------------|
| `com.sun.jna.NativeLibrary` | `DEBUG` / `FINE`            |

Note: If you set system property `jna.debug_load` to `true`,
the minimum threshold level will become `INFO`, and thus will likely be logged by default to the console.



### Embedded SDL2 libraries for Windows and Linux

Windows DLLs are the official ones from SDL2 distribution.

Linux .so are compiled on Ubuntu 2016 LTS (to use reasonably old glibc)
for x86 and x86-64
and on Raspberry Pi 4 for armhf and aarch64 (Raspberry Pi OS, version *buster*).
The compilation went on a newly installed and updated OS
(`sudo apt-get update`, `sudo apt-get upgrade`)
with all recommended build dependencies installed
(see SDL2's [README-linux.md](https://github.com/libsdl-org/SDL/blob/main/docs/README-linux.md#user-content-build-dependencies))
and with default `./configure` (<https://wiki.libsdl.org/Installation#cb1>).

On Linux, the embedded library might be missing support for a specific library or framework you have on your computer,
so it is advised to have the libSDL2 installed as a separate package. Watch out for the library version, though.
The embedded libraries should be fine in most cases.

On macOS, it is recommended to distribute the libSDL2 library
as a framework bundled in your `.app` package.



## What Is Not Implemented by LibSDL4J

Minor things that make little to no sense in the Java world were omitted from the Java bindings.
It's still possible to add those headers if someone contributes it to the project.
Amongst the omitted things are:

* **SDL_thread.h**, **SDL_mutex.h**, **SDL_atomic.h**
  * Thread functions could be supported but Java has plenty of that already.
    If there was an interest in these, file a feature request.
* **SDL_test_\*.h**, **SDL_assert.h**
  * Testing facilities are low priority.
    If there was an interest in these, file a feature request.
* **SDL_loadso.h**
  * Loading another dynamically-linked libraries must be done in Java specific way.
* **SDL_stdinc.h**
  * Most C-style functions were omitted.
  * However, memory management `malloc()`/`free()` is covered.
* **SDL_platform.h**.
  * Platform specific functions related to the platform specific APIs.
  * It could be done by splitting the functionality into a separate
    class for each OS, but many times platform specific
    header files and libraries would also need to be loaded,
    so it was left out of the scope of the project.
* **SDL_opengl_\*.h**, **SDL_opengles_\*.h**, **SDL_egl.h**



## Implementation details

C structs are implemented as JNA Structures.
If they are passed as arguments to the native functions or return types from native functions,
they will be passed-by-reference.
If they are a part of another struct, they are passed-by-value (exploded in the outer structure).
Unless they implement Structure.ByReference.
In rare cases, the structure is passed by value even to the native function.
In that case, the structure implements Structure.ByValue.

More documentation in the [JNA docs](https://github.com/java-native-access/jna/blob/master/www/StructuresAndUnions.md).

There are some SDL structures, which, for the sake of efficiency,
are not implemented as JNA Structures, but are plain POJOs.
This is used in places where many instances of these POJOs
are expected to be created.
Such as `SDL_Color`, `SDL_Point`, `SDL_FPoint`.
JNA Structure have certain memory footprint
and it would not be appreciated in large number of object instances.
