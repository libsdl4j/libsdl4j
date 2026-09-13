package io.github.libsdl4j.api.gamecontroller;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.LongByReference;
import io.github.libsdl4j.api.SdlSubSystemConst;
import io.github.libsdl4j.api.joystick.SDL_Joystick;
import io.github.libsdl4j.api.joystick.SDL_JoystickGUID;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import io.github.libsdl4j.api.rwops.SDL_RWops;
import io.github.libsdl4j.api.sensor.SDL_SensorType;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.rwops.SdlRWops.SDL_RWFromFile;

/**
 * Definitions from file SDL_gamecontroller.h
 *
 * <p>Function definitions for SDL game controller event handling.</p>
 *
 * <p>In order to use these functions, SDL_Init() must have been called
 * with the {@link SdlSubSystemConst#SDL_INIT_GAMECONTROLLER SDL_INIT_GAMECONTROLLER} flag.
 * This causes SDL to scan the system
 * for game controllers, and load appropriate drivers.</p>
 *
 * <p>If you would like to receive controller updates while the application
 * is in the background, you should set the following hint before calling
 * SDL_Init(): SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS</p>
 *
 * <p>To count the number of game controllers in the system for the following:</p>
 *
 * <pre>
 *  int nJoysticks = SDL_NumJoysticks();
 *  int nGameControllers = 0;
 *  for (int i = 0; i &lt; nJoysticks; i++) {
 *      if (SDL_IsGameController(i)) {
 *          nGameControllers++;
 *      }
 *  }
 * </pre>
 *
 * <p>Using the SDL_HINT_GAMECONTROLLERCONFIG hint or the SDL_GameControllerAddMapping() you can add support for controllers SDL is unaware of or cause an existing controller to have a different binding. The format is:
 * guid,name,mappings</p>
 *
 * <p>Where GUID is the string value from SDL_JoystickGetGUIDString(), name is the human readable string for the device and mappings are controller mappings to joystick ones.
 * Under Windows there is a reserved GUID of "xinput" that covers any XInput devices.</p>
 *
 * <p>The mapping format for joystick is:</p>
 *  <ul>
 *      <li>bX - a joystick button, index X</li>
 *      <li>hX.Y - hat X with value Y</li>
 *      <li>aX - axis X of the joystick</li>
 *  </ul>
 *
 *  <p>Buttons can be used as a controller axis and vice versa.</p>
 *
 *  <p>This string shows an example of a valid mapping for a controller</p>
 *
 * <pre>
 * "03000000341a00003608000000000000,PS3 Controller,a:b1,b:b2,y:b3,x:b0,start:b9,guide:b12,back:b8,dpup:h0.1,dpleft:h0.8,dpdown:h0.4,dpright:h0.2,leftshoulder:b4,rightshoulder:b5,leftstick:b10,rightstick:b11,leftx:a0,lefty:a1,rightx:a2,righty:a3,lefttrigger:b6,righttrigger:b7",
 * </pre>
 */
public final class SdlGamecontroller {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlGamecontroller.class);
    }

    private SdlGamecontroller() {
    }

    /**
     * Load a set of Game Controller mappings from a seekable SDL data stream.
     *
     * <p>You can call this function several times, if needed, to load different
     * database files.</p>
     *
     * <p>If a new mapping is loaded for an already known controller GUID, the later
     * version will overwrite the one currently loaded.</p>
     *
     * <p>Mappings not belonging to the current platform or with no platform field
     * specified will be ignored (i.e. mappings for Linux will be ignored in
     * Windows, etc).</p>
     *
     * <p>This function will load the text database entirely in memory before
     * processing it, so take this into consideration if you are in a memory
     * constrained environment.</p>
     *
     * @param rw     the data stream for the mappings to be added
     * @param freerw non-zero to close the stream after being read
     * @return the number of mappings added or -1 on error; call SDL_GetError()
     * for more information.
     * @see #SDL_GameControllerAddMapping(String)
     * @see #SDL_GameControllerAddMappingsFromFile(String)
     * @see #SDL_GameControllerMappingForGUID(SDL_JoystickGUID)
     * @since This function is available since SDL 2.0.2.
     */
    public static native int SDL_GameControllerAddMappingsFromRW(
            SDL_RWops rw,
            int freerw);

    /**
     * Load a set of mappings from a file, filtered by the current SDL_GetPlatform()
     *
     * <p>Convenience method.</p>
     */
    public static int SDL_GameControllerAddMappingsFromFile(
            String file) {
        return SDL_GameControllerAddMappingsFromRW(SDL_RWFromFile(file, "rb"), 1);
    }

    /**
     * Add support for controllers that SDL is unaware of or to cause an existing
     * controller to have a different binding.
     *
     * <p>The mapping string has the format "GUID,name,mapping", where GUID is the
     * string value from SDL_JoystickGetGUIDString(), name is the human readable
     * string for the device and mappings are controller mappings to joystick
     * ones. Under Windows there is a reserved GUID of "xinput" that covers all
     * XInput devices. The mapping format for joystick is: {| |bX |a joystick
     * button, index X |- |hX.Y |hat X with value Y |- |aX |axis X of the joystick
     * |} Buttons can be used as a controller axes and vice versa.</p>
     *
     * <p>This string shows an example of a valid mapping for a controller:</p>
     *
     * <pre>
     * "341a3608000000000000504944564944,Afterglow PS3 Controller,a:b1,b:b2,y:b3,x:b0,start:b9,guide:b12,back:b8,dpup:h0.1,dpleft:h0.8,dpdown:h0.4,dpright:h0.2,leftshoulder:b4,rightshoulder:b5,leftstick:b10,rightstick:b11,leftx:a0,lefty:a1,rightx:a2,righty:a3,lefttrigger:b6,righttrigger:b7"
     * </pre>
     *
     * @param mappingString the mapping string
     * @return 1 if a new mapping is added, 0 if an existing mapping is updated,
     * -1 on error; call SDL_GetError() for more information.
     * @see #SDL_GameControllerMapping(SDL_GameController)
     * @see #SDL_GameControllerMappingForGUID(SDL_JoystickGUID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GameControllerAddMapping(
            String mappingString);

    /**
     * Get the number of mappings installed.
     *
     * @return the number of mappings.
     * @since This function is available since SDL 2.0.6.
     */
    public static native int SDL_GameControllerNumMappings();

    /**
     * Get the mapping at a particular index.
     *
     * @return the mapping string. Returns null if
     * the index is out of range.
     * @since This function is available since SDL 2.0.6.
     */
    public static String SDL_GameControllerMappingForIndex(
            int mappingIndex) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMappingForIndex(mappingIndex);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    /**
     * Get the game controller mapping string for a given GUID.
     *
     * @param guid a structure containing the GUID for which a mapping is desired
     * @return a mapping string or null on error; call SDL_GetError() for more
     * information.
     * @see io.github.libsdl4j.api.joystick.SdlJoystick#SDL_JoystickGetDeviceGUID(int)
     * @see io.github.libsdl4j.api.joystick.SdlJoystick#SDL_JoystickGetGUID(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static String SDL_GameControllerMappingForGUID(
            SDL_JoystickGUID guid) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMappingForGUID(guid);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    /**
     * Get the current mapping of a Game Controller.
     *
     * <p>Details about mappings are discussed with SDL_GameControllerAddMapping().</p>
     *
     * @param gamecontroller the game controller you want to get the current
     *                       mapping for
     * @return a string that has the controller's mapping or null if no mapping
     * is available; call SDL_GetError() for more information.
     * @see #SDL_GameControllerAddMapping(String)
     * @see #SDL_GameControllerMappingForGUID(SDL_JoystickGUID)
     * @since This function is available since SDL 2.0.0.
     */
    public static String SDL_GameControllerMapping(
            SDL_GameController gamecontroller) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMapping(gamecontroller);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    /**
     * Check if the given joystick is supported by the game controller interface.
     *
     * <p>{@code joystick_index} is the same as the {@code device_index} passed to
     * SDL_JoystickOpen().</p>
     *
     * @param joystickIndex the device_index of a device, up to
     *                      SDL_NumJoysticks()
     * @return true if the given joystick is supported by the game controller
     * interface, false if it isn't or it's an invalid index.
     * @see #SDL_GameControllerNameForIndex(int)
     * @see #SDL_GameControllerOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_IsGameController(
            int joystickIndex);

    /**
     * Get the implementation dependent name for the game controller.
     *
     * <p>This function can be called before any controllers are opened.</p>
     *
     * <p>{@code joystickIndex} is the same as the {@code deviceIndex} passed to
     * SDL_JoystickOpen().</p>
     *
     * @param joystickIndex the device_index of a device, from zero to
     *                      SDL_NumJoysticks()-1
     * @return the implementation-dependent name for the game controller, or null
     * if there is no name or the index is invalid.
     * @see #SDL_GameControllerName(SDL_GameController)
     * @see #SDL_GameControllerOpen(int)
     * @see #SDL_IsGameController(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GameControllerNameForIndex(
            int joystickIndex);

    /**
     * Get the implementation dependent path for the game controller.
     *
     * <p>This function can be called before any controllers are opened.</p>
     *
     * <p>{@code joystickIndex} is the same as the {@code deviceIndex} passed to
     * SDL_JoystickOpen().</p>
     *
     * @param joystickIndex the device_index of a device, from zero to
     *                      SDL_NumJoysticks()-1
     * @return the implementation-dependent path for the game controller, or NULL
     * if there is no path or the index is invalid.
     * @see #SDL_GameControllerPath(SDL_GameController)
     * @since This function is available since SDL 2.24.0.
     */
    public static native String SDL_GameControllerPathForIndex(
            int joystickIndex);

    /**
     * Get the type of a game controller.
     *
     * <p>This can be called before any controllers are opened.</p>
     *
     * @param joystickIndex the device_index of a device, from zero to
     *                      SDL_NumJoysticks()-1
     * @return the controller type.
     * @since This function is available since SDL 2.0.12.
     */
    @MagicConstant(valuesFromClass = SDL_GameControllerType.class)
    public static native int SDL_GameControllerTypeForIndex(
            int joystickIndex);

    /**
     * Get the mapping of a game controller.
     *
     * <p>This can be called before any controllers are opened.</p>
     *
     * @param joystickIndex the device_index of a device, from zero to
     *                      SDL_NumJoysticks()-1
     * @return the mapping string. Returns null if
     * no mapping is available.
     * @since This function is available since SDL 2.0.9.
     */
    public static String SDL_GameControllerMappingForDeviceIndex(
            int joystickIndex) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMappingForDeviceIndex(joystickIndex);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    /**
     * Open a game controller for use.
     *
     * <p>{@code joystick_index} is the same as the {@code device_index} passed to
     * SDL_JoystickOpen().</p>
     *
     * <p>The index passed as an argument refers to the N'th game controller on the
     * system. This index is not the value which will identify this controller in
     * future controller events. The joystick's instance id (SDL_JoystickID) will
     * be used there instead.</p>
     *
     * @param joystickIndex the device_index of a device, up to
     *                      SDL_NumJoysticks()
     * @return a gamecontroller identifier or null if an error occurred; call
     * SDL_GetError() for more information.
     * @see #SDL_GameControllerClose(SDL_GameController)
     * @see #SDL_GameControllerNameForIndex(int)
     * @see #SDL_IsGameController(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_GameController SDL_GameControllerOpen(
            int joystickIndex);

    /**
     * Get the SDL_GameController associated with an instance id.
     *
     * @param joyId the instance id to get the SDL_GameController for
     * @return an SDL_GameController on success or null on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.4.
     */
    public static native SDL_GameController SDL_GameControllerFromInstanceID(
            SDL_JoystickID joyId);

    /**
     * Get the SDL_GameController associated with a player index.
     *
     * <p>Please note that the player index is _not_ the device index, nor is it the
     * instance id!</p>
     *
     * @param playerIndex the player index, which is not the device index or the
     *                    instance id!
     * @return the SDL_GameController associated with a player index.
     * @see #SDL_GameControllerGetPlayerIndex(SDL_GameController)
     * @see #SDL_GameControllerSetPlayerIndex(SDL_GameController, int)
     * @since This function is available since SDL 2.0.12.
     */
    public static native SDL_GameController SDL_GameControllerFromPlayerIndex(
            int playerIndex);

    /**
     * Get the implementation-dependent name for an opened game controller.
     *
     * <p>This is the same name as returned by SDL_GameControllerNameForIndex(), but
     * it takes a controller identifier instead of the (unstable) device index.</p>
     *
     * @param gamecontroller a game controller identifier previously returned by
     *                       SDL_GameControllerOpen()
     * @return the implementation dependent name for the game controller, or null
     * if there is no name or the identifier passed is invalid.
     * @see #SDL_GameControllerNameForIndex(int)
     * @see #SDL_GameControllerOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GameControllerName(
            SDL_GameController gamecontroller);

    /**
     * Get the implementation-dependent path for an opened game controller.
     *
     * <p>This is the same path as returned by SDL_GameControllerNameForIndex(), but
     * it takes a controller identifier instead of the (unstable) device index.</p>
     *
     * @param gamecontroller a game controller identifier previously returned by
     *                       SDL_GameControllerOpen()
     * @return the implementation dependent path for the game controller, or NULL
     * if there is no path or the identifier passed is invalid.
     * @see #SDL_GameControllerPathForIndex(int)
     * @since This function is available since SDL 2.24.0.
     */
    public static native String SDL_GameControllerPath(
            SDL_GameController gamecontroller);

    /**
     * Get the type of this currently opened controller
     *
     * <p>This is the same name as returned by SDL_GameControllerTypeForIndex(), but
     * it takes a controller identifier instead of the (unstable) device index.</p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the controller type.
     * @since This function is available since SDL 2.0.12.
     */
    @MagicConstant(valuesFromClass = SDL_GameControllerType.class)
    public static native int SDL_GameControllerGetType(
            SDL_GameController gamecontroller);

    /**
     * Get the player index of an opened game controller.
     *
     * <p>For XInput controllers this returns the XInput user index.</p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the player index for controller, or -1 if it's not available.
     * @since This function is available since SDL 2.0.9.
     */
    public static native int SDL_GameControllerGetPlayerIndex(
            SDL_GameController gamecontroller);

    /**
     * Set the player index of an opened game controller.
     *
     * @param gamecontroller the game controller object to adjust.
     * @param playerIndex    Player index to assign to this controller, or -1 to
     *                       clear the player index and turn off player LEDs.
     * @since This function is available since SDL 2.0.12.
     */
    public static native void SDL_GameControllerSetPlayerIndex(
            SDL_GameController gamecontroller,
            int playerIndex);

    /**
     * Get the USB vendor ID of an opened controller, if available.
     *
     * <p>If the vendor ID isn't available this function returns 0.</p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the USB vendor ID, or zero if unavailable.
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_GameControllerGetVendor(
            SDL_GameController gamecontroller);

    /**
     * Get the USB product ID of an opened controller, if available.
     *
     * <p>If the product ID isn't available this function returns 0.</p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the USB product ID, or zero if unavailable.
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_GameControllerGetProduct(
            SDL_GameController gamecontroller);

    /**
     * Get the product version of an opened controller, if available.
     *
     * <p>If the product version isn't available this function returns 0.</p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the USB product version, or zero if unavailable.
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_GameControllerGetProductVersion(
            SDL_GameController gamecontroller);

    /**
     * Get the firmware version of an opened controller, if available.
     *
     * <p>If the firmware version isn't available this function returns 0.</p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the controller firmware version, or zero if unavailable.
     * @since This function is available since SDL 2.24.0.
     */
    public static native short SDL_GameControllerGetFirmwareVersion(
            SDL_GameController gamecontroller);

    /**
     * Get the serial number of an opened controller, if available.
     *
     * <p>Returns the serial number of the controller, or NULL if it is not
     * available.</p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the serial number, or NULL if unavailable.
     * @since This function is available since SDL 2.0.14.
     */
    public static native String SDL_GameControllerGetSerial(
            SDL_GameController gamecontroller);

    /**
     * Get the Steam Input handle of an opened controller, if available.
     *
     * <p>Returns an InputHandle_t for the controller that can be used with Steam
     * Input API: <a href="https://partner.steamgames.com/doc/api/ISteamInput">https://partner.steamgames.com/doc/api/ISteamInput</a></p>
     *
     * @param gamecontroller the game controller object to query.
     * @return the gamepad handle, or 0 if unavailable.
     * @since This function is available since SDL 2.30.0.
     */
    public static native long SDL_GameControllerGetSteamHandle(
            SDL_GameController gamecontroller);

    /**
     * Check if a controller has been opened and is currently connected.
     *
     * @param gamecontroller a game controller identifier previously returned by
     *                       SDL_GameControllerOpen()
     * @return true if the controller has been opened and is currently
     * connected, or false if not.
     * @see #SDL_GameControllerClose(SDL_GameController)
     * @see #SDL_GameControllerOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_GameControllerGetAttached(
            SDL_GameController gamecontroller);

    /**
     * Get the Joystick ID from a Game Controller.
     *
     * <p>This function will give you a SDL_Joystick object, which allows you to use
     * the SDL_Joystick functions with a SDL_GameController object. This would be
     * useful for getting a joystick's position at any given time, even if it
     * hasn't moved (moving it would produce an event, which would have the axis'
     * value).</p>
     *
     * <p>The pointer returned is owned by the SDL_GameController. You should not
     * call SDL_JoystickClose() on it, for example, since doing so will likely
     * cause SDL to crash.</p>
     *
     * @param gamecontroller the game controller object that you want to get a
     *                       joystick from
     * @return a SDL_Joystick object; call SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Joystick SDL_GameControllerGetJoystick(
            SDL_GameController gamecontroller);

    /**
     * Query or change current state of Game Controller events.
     *
     * <p>If controller events are disabled, you must call SDL_GameControllerUpdate()
     * yourself and check the state of the controller when you want controller
     * information.</p>
     *
     * <p>Any number can be passed to SDL_GameControllerEventState(), but only -1, 0,
     * and 1 will have any effect. Other numbers will just be returned.</p>
     *
     * @param state can be one of {@code SDL_QUERY}, {@code SDL_IGNORE}, or {@code SDL_ENABLE}
     * @return the same value passed to the function, with exception to -1
     * (SDL_QUERY), which will return the current state.
     * @see io.github.libsdl4j.api.joystick.SdlJoystick#SDL_JoystickEventState(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GameControllerEventState(
            int state);

    /**
     * Manually pump game controller updates if not using the loop.
     *
     * <p>This function is called automatically by the event loop if events are
     * enabled. Under such circumstances, it will not be necessary to call this
     * function.</p>
     *
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GameControllerUpdate();

    /**
     * Convert a string into SDL_GameControllerAxis enum.
     *
     * <p>This function is called internally to translate SDL_GameController mapping
     * strings for the underlying joystick device into the consistent
     * SDL_GameController mapping. You do not normally need to call this function
     * unless you are parsing SDL_GameController mappings in your own code.</p>
     *
     * <p>Note specially that "righttrigger" and "lefttrigger" map to
     * {@code SDL_CONTROLLER_AXIS_TRIGGERRIGHT} and {@code SDL_CONTROLLER_AXIS_TRIGGERLEFT},
     * respectively.</p>
     *
     * @param str string representing a SDL_GameController axis
     * @return the SDL_GameControllerAxis enum corresponding to the input string,
     * or {@code SDL_CONTROLLER_AXIS_INVALID} if no match was found.
     * @see #SDL_GameControllerGetStringForAxis(int)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class)
    public static native int SDL_GameControllerGetAxisFromString(
            String str);

    /**
     * Convert from an SDL_GameControllerAxis enum to a string.
     *
     * <p>The caller should not SDL_free() the returned string.</p>
     *
     * @param axis an enum value for a given SDL_GameControllerAxis
     * @return a string for the given axis, or NULL if an invalid axis is
     * specified. The string returned is of the format used by
     * SDL_GameController mapping strings.
     * @see #SDL_GameControllerGetAxisFromString(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GameControllerGetStringForAxis(
            @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

    /**
     * Get the SDL joystick layer binding for a controller axis mapping.
     *
     * @param gamecontroller a game controller
     * @param axis           an axis enum value (one of the SDL_GameControllerAxis values)
     * @return a SDL_GameControllerButtonBind describing the bind. On failure
     * (like the given Controller axis doesn't exist on the device), its
     * {@code .bindType} will be {@code SDL_CONTROLLER_BINDTYPE_NONE}.
     * @see #SDL_GameControllerGetBindForButton(SDL_GameController, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_GameControllerButtonBind SDL_GameControllerGetBindForAxis(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

    /**
     * Query whether a game controller has a given axis.
     *
     * <p>This merely reports whether the controller's mapping defined this axis, as
     * that is all the information SDL has about the physical device.</p>
     *
     * @param gamecontroller a game controller
     * @param axis           an axis enum value (an SDL_GameControllerAxis value)
     * @return true if the controller has this axis, false otherwise.
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_GameControllerHasAxis(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

    /**
     * Get the current state of an axis control on a game controller.
     *
     * <p>The axis indices start at index 0.</p>
     *
     * <p>The state is a value ranging from -32768 to 32767. Triggers, however, range
     * from 0 to 32767 (they never return a negative value).</p>
     *
     * @param gamecontroller a game controller
     * @param axis           an axis index (one of the SDL_GameControllerAxis values)
     * @return axis state (including 0) on success or 0 (also) on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GameControllerGetButton(SDL_GameController, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native short SDL_GameControllerGetAxis(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

    /**
     * Convert a string into an SDL_GameControllerButton enum.
     *
     * <p>This function is called internally to translate SDL_GameController mapping
     * strings for the underlying joystick device into the consistent
     * SDL_GameController mapping. You do not normally need to call this function
     * unless you are parsing SDL_GameController mappings in your own code.</p>
     *
     * @param str string representing a SDL_GameController axis
     * @return the SDL_GameControllerButton enum corresponding to the input
     * string, or {@code SDL_CONTROLLER_AXIS_INVALID} if no match was found.
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_GameControllerButton.class)
    public static native int SDL_GameControllerGetButtonFromString(
            String str);

    /**
     * Convert from an SDL_GameControllerButton enum to a string.
     *
     * <p>The caller should not SDL_free() the returned string.</p>
     *
     * @param button an enum value for a given SDL_GameControllerButton
     * @return a string for the given button, or null if an invalid button is
     * specified. The string returned is of the format used by
     * SDL_GameController mapping strings.
     * @see #SDL_GameControllerGetButtonFromString(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GameControllerGetStringForButton(
            @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

    /**
     * Get the SDL joystick layer binding for a controller button mapping.
     *
     * @param gamecontroller a game controller
     * @param button         an button enum value (an SDL_GameControllerButton value)
     * @return a SDL_GameControllerButtonBind describing the bind. On failure
     * (like the given Controller button doesn't exist on the device),
     * its {@code .bindType} will be {@code SDL_CONTROLLER_BINDTYPE_NONE}.
     * @see #SDL_GameControllerGetBindForAxis(SDL_GameController, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_GameControllerButtonBind SDL_GameControllerGetBindForButton(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

    /**
     * Query whether a game controller has a given button.
     *
     * <p>This merely reports whether the controller's mapping defined this button,
     * as that is all the information SDL has about the physical device.</p>
     *
     * @param gamecontroller a game controller
     * @param button         a button enum value (an SDL_GameControllerButton value)
     * @return true if the controller has this button, false otherwise.
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_GameControllerHasButton(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

    /**
     * Get the current state of a button on a game controller.
     *
     * @param gamecontroller a game controller
     * @param button         a button index (one of the SDL_GameControllerButton values)
     * @return 1 for pressed state or 0 for not pressed state or error; call
     * SDL_GetError() for more information.
     * @see #SDL_GameControllerGetAxis(SDL_GameController, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native byte SDL_GameControllerGetButton(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);


    /**
     * Get the number of touchpads on a game controller.
     *
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_GameControllerGetNumTouchpads(
            SDL_GameController gamecontroller);

    /**
     * Get the number of supported simultaneous fingers on a touchpad on a game
     * controller.
     *
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_GameControllerGetNumTouchpadFingers(
            SDL_GameController gamecontroller,
            int touchpad);

    /**
     * Get the current state of a finger on a touchpad on a game controller.
     *
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_GameControllerGetTouchpadFinger(
            SDL_GameController gamecontroller,
            int touchpad,
            int finger,
            ByteByReference state,
            FloatByReference x,
            FloatByReference y,
            FloatByReference pressure);

    /**
     * Return whether a game controller has a particular sensor.
     *
     * @param gamecontroller The controller to query
     * @param type           The type of sensor to query
     * @return true if the sensor exists, false otherwise.
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_GameControllerHasSensor(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

    /**
     * Set whether data reporting for a game controller sensor is enabled.
     *
     * @param gamecontroller The controller to update
     * @param type           The type of sensor to enable/disable
     * @param enabled        Whether data reporting should be enabled
     * @return 0 or -1 if an error occurred.
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_GameControllerSetSensorEnabled(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_SensorType.class) int type,
            boolean enabled);

    /**
     * Query whether sensor data reporting is enabled for a game controller.
     *
     * @param gamecontroller The controller to query
     * @param type           The type of sensor to query
     * @return true if the sensor is enabled, false otherwise.
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_GameControllerIsSensorEnabled(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

    /**
     * Get the data rate (number of events per second) of a game controller
     * sensor.
     *
     * @param gamecontroller The controller to query
     * @param type           The type of sensor to query
     * @return the data rate, or 0.0f if the data rate is not available.
     * @since This function is available since SDL 2.0.16.
     */
    public static native float SDL_GameControllerGetSensorDataRate(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

    /**
     * Get the current state of a game controller sensor.
     *
     * <p>The number of values and interpretation of the data is sensor dependent.
     * See {@link SDL_SensorType} for the details for each type of sensor.</p>
     *
     * @param gamecontroller The controller to query
     * @param type           The type of sensor to query
     * @param data           A pointer filled with the current sensor state
     * @param numValues      The number of values to write to data
     * @return 0 or -1 if an error occurred.
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_GameControllerGetSensorData(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_SensorType.class) int type,
            Pointer data,
            int numValues);

    /**
     * Get the current state of a game controller sensor with the timestamp of the
     * last update.
     *
     * <p>The number of values and interpretation of the data is sensor dependent.
     * See SDL_sensor.h for the details for each type of sensor.</p>
     *
     * @param gamecontroller The controller to query
     * @param type           The type of sensor to query
     * @param timestamp      A pointer filled with the timestamp in microseconds of the
     *                       current sensor reading if available, or 0 if not
     * @param data           A pointer filled with the current sensor state
     * @param numValues      The number of values to write to data
     * @return 0 or -1 if an error occurred.
     * @since This function is available since SDL 2.26.0.
     */
    public static native int SDL_GameControllerGetSensorDataWithTimestamp(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_SensorType.class) int type,
            LongByReference timestamp,
            Pointer data,
            int numValues);


    /**
     * Start a rumble effect on a game controller.
     *
     * <p>Each call to this function cancels any previous rumble effect, and calling
     * it with 0 intensity stops any rumbling.</p>
     *
     * @param gamecontroller      The controller to vibrate
     * @param lowFrequencyRumble  The intensity of the low frequency (left)
     *                            rumble motor, from 0 to 0xFFFF
     * @param highFrequencyRumble The intensity of the high frequency (right)
     *                            rumble motor, from 0 to 0xFFFF
     * @param durationMs          The duration of the rumble effect, in milliseconds
     * @return 0, or -1 if rumble isn't supported on this controller
     * @see #SDL_GameControllerHasRumble(SDL_GameController)
     * @since This function is available since SDL 2.0.9.
     */
    public static native int SDL_GameControllerRumble(
            SDL_GameController gamecontroller,
            short lowFrequencyRumble,
            short highFrequencyRumble,
            int durationMs);

    /**
     * Start a rumble effect in the game controller's triggers.
     *
     * <p>Each call to this function cancels any previous trigger rumble effect, and
     * calling it with 0 intensity stops any rumbling.</p>
     *
     * <p>Note that this is rumbling of the _triggers_ and not the game controller as
     * a whole. This is currently only supported on Xbox One controllers. If you
     * want the (more common) whole-controller rumble, use
     * SDL_GameControllerRumble() instead.</p>
     *
     * @param gamecontroller The controller to vibrate
     * @param leftRumble     The intensity of the left trigger rumble motor, from 0
     *                       to 0xFFFF
     * @param rightRumble    The intensity of the right trigger rumble motor, from 0
     *                       to 0xFFFF
     * @param durationMs     The duration of the rumble effect, in milliseconds
     * @return 0, or -1 if trigger rumble isn't supported on this controller
     * @see #SDL_GameControllerHasRumbleTriggers(SDL_GameController)
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_GameControllerRumbleTriggers(
            SDL_GameController gamecontroller,
            short leftRumble,
            short rightRumble,
            int durationMs);

    /**
     * Query whether a game controller has an LED.
     *
     * @param gamecontroller The controller to query
     * @return true if this controller has a modifiable LED, false otherwise
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_GameControllerHasLED(
            SDL_GameController gamecontroller);

    /**
     * Query whether a game controller has rumble support.
     *
     * @param gamecontroller The controller to query
     * @return true if this controller has rumble support, false otherwise
     * @see #SDL_GameControllerRumble(SDL_GameController, short, short, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native boolean SDL_GameControllerHasRumble(
            SDL_GameController gamecontroller);

    /**
     * Query whether a game controller has rumble support on triggers.
     *
     * @param gamecontroller The controller to query
     * @return true if this controller has trigger rumble support, false otherwise
     * @see #SDL_GameControllerRumbleTriggers(SDL_GameController, short, short, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native boolean SDL_GameControllerHasRumbleTriggers(
            SDL_GameController gamecontroller);

    /**
     * Update a game controller's LED color.
     *
     * @param gamecontroller The controller to update
     * @param red            The intensity of the red LED
     * @param green          The intensity of the green LED
     * @param blue           The intensity of the blue LED
     * @return 0, or -1 if this controller does not have a modifiable LED
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_GameControllerSetLED(
            SDL_GameController gamecontroller,
            byte red,
            byte green,
            byte blue);

    /**
     * Send a controller specific effect packet
     *
     * @param gamecontroller The controller to affect
     * @param data           The data to send to the controller
     * @param size           The size of the data to send to the controller
     * @return 0, or -1 if this controller or driver doesn't support effect
     * packets
     * @since This function is available since SDL 2.0.16.
     */
    public static native int SDL_GameControllerSendEffect(
            SDL_GameController gamecontroller,
            Pointer data,
            int size);

    /**
     * Close a game controller previously opened with SDL_GameControllerOpen().
     *
     * @param gamecontroller a game controller identifier previously returned by
     *                       SDL_GameControllerOpen()
     * @see #SDL_GameControllerOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GameControllerClose(
            SDL_GameController gamecontroller);

    /**
     * Return the sfSymbolsName for a given button on a game controller on Apple
     * platforms.
     *
     * @param gamecontroller the controller to query
     * @param button         a button on the game controller
     * @return the sfSymbolsName or null if the name can't be found
     * @see #SDL_GameControllerGetAppleSFSymbolsNameForAxis(SDL_GameController, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native String SDL_GameControllerGetAppleSFSymbolsNameForButton(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

    /**
     * Return the sfSymbolsName for a given axis on a game controller on Apple
     * platforms.
     *
     * @param gamecontroller the controller to query
     * @param axis           an axis on the game controller
     * @return the sfSymbolsName or null if the name can't be found
     * @see #SDL_GameControllerGetAppleSFSymbolsNameForButton(SDL_GameController, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native String SDL_GameControllerGetAppleSFSymbolsNameForAxis(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GameControllerMappingForIndex(
                int mappingIndex);

        public static native Pointer SDL_GameControllerMappingForGUID(
                SDL_JoystickGUID guid);

        public static native Pointer SDL_GameControllerMapping(
                SDL_GameController gamecontroller);

        public static native Pointer SDL_GameControllerMappingForDeviceIndex(
                int joystickIndex);
    }
}
