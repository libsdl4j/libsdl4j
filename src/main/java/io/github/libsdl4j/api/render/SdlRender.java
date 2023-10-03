package io.github.libsdl4j.api.render;

import java.util.List;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.blendmode.SDL_BlendMode;
import io.github.libsdl4j.api.pixels.SDL_PixelFormatEnum;
import io.github.libsdl4j.api.rect.SDL_FPoint;
import io.github.libsdl4j.api.rect.SDL_FRect;
import io.github.libsdl4j.api.rect.SDL_Point;
import io.github.libsdl4j.api.rect.SDL_Rect;
import io.github.libsdl4j.api.surface.SDL_Surface;
import io.github.libsdl4j.api.video.SDL_GLContext;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.api.video.SDL_WindowFlags;
import io.github.libsdl4j.jna.ContiguousArrayList;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.error.SdlError.SDL_SetError;

/**
 * Definitions from file SDL_render.h
 *
 * <p>Header file for SDL 2D rendering functions.</p>
 *
 * <p>This API supports the following features:
 * <ul>
 *     <li>single pixel points</li>
 *     <li>single pixel lines</li>
 *     <li>filled rectangles</li>
 *     <li>texture images</li>
 * </ul>
 *
 * <p>The primitives may be drawn in opaque, blended, or additive modes.</p>
 *
 * <p>The texture images may be drawn in opaque, blended, or additive modes.
 * They can have an additional color tint or alpha modulation applied to
 * them, and may also be stretched with linear interpolation.</p>
 *
 * <p>This API is designed to accelerate simple 2D operations. You may
 * want more functionality such as polygons and particle effects and
 * in that case you should use SDL's OpenGL/Direct3D support or one
 * of the many good 3D engines.</p>
 *
 * <p>These functions must be called from the main thread.
 * See this bug for details: http://bugzilla.libsdl.org/show_bug.cgi?id=1995</p>
 */
public final class SdlRender {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlRender.class);
    }

    private SdlRender() {
    }

    /**
     * Get the number of 2D rendering drivers available for the current display.
     *
     * <p>A render driver is a set of code that handles rendering and texture
     * management on a particular display. Normally there is only one, but some
     * drivers may have several available with different capabilities.</p>
     *
     * <p>There may be none if SDL was compiled without render support.</p>
     *
     * @return a number greater or equal to 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateRenderer(SDL_Window, int, int)
     * @see #SDL_GetRenderDriverInfo(int, SDL_RendererInfo)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumRenderDrivers();

    /**
     * Get info about a specific 2D rendering driver for the current display.
     *
     * @param index the index of the driver to query information about
     * @param info  an SDL_RendererInfo structure to be filled with information on
     *              the rendering driver
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateRenderer(SDL_Window, int, int)
     * @see #SDL_GetNumRenderDrivers()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetRenderDriverInfo(
            int index,
            SDL_RendererInfo info);

    /**
     * Create a window and default renderer.
     *
     * @param width       the width of the window
     * @param height      the height of the window
     * @param windowFlags the flags used to create the window (see
     *                    SDL_CreateWindow())
     * @param window      a pointer filled with the window, or null on error
     * @param renderer    a pointer filled with the renderer, or null on error
     * @return 0 on success, or -1 on error; call SDL_GetError() for more
     * information.
     * @see #SDL_CreateRenderer(SDL_Window, int, int)
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_CreateWindow(String, int, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_CreateWindowAndRenderer(
            int width,
            int height,
            @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int windowFlags,
            SDL_Window.Ref window,
            SDL_Renderer.Ref renderer);

    /**
     * Create a 2D rendering context for a window.
     *
     * @param window the window where rendering is displayed
     * @param index  the index of the rendering driver to initialize, or -1 to
     *               initialize the first one supporting the requested flags
     * @param flags  0, or one or more SDL_RendererFlags OR'd together
     * @return a valid rendering context or null if there was an error; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateSoftwareRenderer(SDL_Surface)
     * @see #SDL_DestroyRenderer(SDL_Renderer)
     * @see #SDL_GetNumRenderDrivers()
     * @see #SDL_GetRendererInfo(SDL_Renderer, SDL_RendererInfo)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Renderer SDL_CreateRenderer(
            SDL_Window window,
            int index,
            @MagicConstant(valuesFromClass = SDL_RendererFlags.class) int flags);

    /**
     * Create a 2D software rendering context for a surface.
     *
     * <p>Two other API which can be used to create SDL_Renderer:
     * SDL_CreateRenderer() and SDL_CreateWindowAndRenderer(). These can _also_
     * create a software renderer, but they are intended to be used with an
     * SDL_Window as the final destination and not an SDL_Surface.</p>
     *
     * @param surface the SDL_Surface structure representing the surface where
     *                rendering is done
     * @return a valid rendering context or null if there was an error; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateRenderer(SDL_Window, int, int)
     * @see #SDL_CreateWindowAndRenderer(int, int, int, SDL_Window.Ref, SDL_Renderer.Ref)
     * @see #SDL_DestroyRenderer(SDL_Renderer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Renderer SDL_CreateSoftwareRenderer(
            SDL_Surface surface);

    /**
     * Get the renderer associated with a window.
     *
     * @param window the window to query
     * @return the rendering context on success or null on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateRenderer(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Renderer SDL_GetRenderer(
            SDL_Window window);

    /**
     * Get the window associated with a renderer.
     *
     * @param renderer the renderer to query
     * @return the window on success or null on failure; call SDL_GetError() for
     * more information.
     * @since This function is available since SDL 2.0.22.
     */
    public static native SDL_Window SDL_RenderGetWindow(
            SDL_Renderer renderer);

    /**
     * Get information about a rendering context.
     *
     * @param renderer the rendering context
     * @param info     an SDL_RendererInfo structure filled with information about the
     *                 current renderer
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateRenderer(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetRendererInfo(
            SDL_Renderer renderer,
            SDL_RendererInfo info);

    /**
     * Get the output size in pixels of a rendering context.
     *
     * <p>Due to high-dpi displays, you might end up with a rendering context that
     * has more pixels than the window that contains it, so use this instead of
     * SDL_GetWindowSize() to decide how much drawing area you have.</p>
     *
     * @param renderer the rendering context
     * @param w        an int filled with the width
     * @param h        an int filled with the height
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetRenderer(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetRendererOutputSize(
            SDL_Renderer renderer,
            IntByReference w,
            IntByReference h);

    /**
     * Create a texture for a rendering context.
     *
     * <p>You can set the texture scaling method by setting
     * {@code SDL_HINT_RENDER_SCALE_QUALITY} before creating the texture.</p>
     *
     * @param renderer the rendering context
     * @param format   one of the enumerated values in SDL_PixelFormatEnum
     * @param access   one of the enumerated values in SDL_TextureAccess
     * @param w        the width of the texture in pixels
     * @param h        the height of the texture in pixels
     * @return a pointer to the created texture or null if no rendering context
     * was active, the format was unsupported, or the width or height
     * were out of range; call SDL_GetError() for more information.
     * @see #SDL_CreateTextureFromSurface(SDL_Renderer, SDL_Surface)
     * @see #SDL_DestroyTexture(SDL_Texture)
     * @see #SDL_QueryTexture(SDL_Texture, IntByReference, IntByReference, IntByReference, IntByReference)
     * @see #SDL_UpdateTexture(SDL_Texture, SDL_Rect, Pointer, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Texture SDL_CreateTexture(
            SDL_Renderer renderer,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format,
            @MagicConstant(valuesFromClass = SDL_TextureAccess.class) int access,
            int w,
            int h);

    /**
     * Create a texture from an existing surface.
     *
     * <p>The surface is not modified or freed by this function.</p>
     *
     * <p>The SDL_TextureAccess hint for the created texture is
     * {@code SDL_TEXTUREACCESS_STATIC}.</p>
     *
     * <p>The pixel format of the created texture may be different from the pixel
     * format of the surface. Use SDL_QueryTexture() to query the pixel format of
     * the texture.</p>
     *
     * @param renderer the rendering context
     * @param surface  the SDL_Surface structure containing pixel data used to fill
     *                 the texture
     * @return the created texture or null on failure; call SDL_GetError() for
     * more information.
     * @see #SDL_CreateTexture(SDL_Renderer, int, int, int, int)
     * @see #SDL_DestroyTexture(SDL_Texture)
     * @see #SDL_QueryTexture(SDL_Texture, IntByReference, IntByReference, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Texture SDL_CreateTextureFromSurface(
            SDL_Renderer renderer,
            SDL_Surface surface);

    /**
     * Query the attributes of a texture.
     *
     * @param texture the texture to query
     * @param format  a pointer filled in with the raw format of the texture; the
     *                actual format may differ, but pixel transfers will use this
     *                format (one of the SDL_PixelFormatEnum values). This argument
     *                can be null if you don't need this information.
     * @param access  a pointer filled in with the actual access to the texture
     *                (one of the SDL_TextureAccess values). This argument can be
     *                null if you don't need this information.
     * @param w       a pointer filled in with the width of the texture in pixels. This
     *                argument can be null if you don't need this information.
     * @param h       a pointer filled in with the height of the texture in pixels. This
     *                argument can be null if you don't need this information.
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateTexture(SDL_Renderer, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_QueryTexture(
            SDL_Texture texture,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) IntByReference format,
            @MagicConstant(valuesFromClass = SDL_TextureAccess.class) IntByReference access,
            IntByReference w,
            IntByReference h);

    /**
     * Set an additional color value multiplied into render copy operations.
     *
     * <p>When this texture is rendered, during the copy operation each source color
     * channel is modulated by the appropriate color value according to the
     * following formula:</p>
     *
     * <pre>
     * srcC = srcC * (color / 255)
     * </pre>
     *
     * <p>Color modulation is not always supported by the renderer; it will return -1
     * if color modulation is not supported.</p>
     *
     * @param texture the texture to update
     * @param r       the red color value multiplied into copy operations
     * @param g       the green color value multiplied into copy operations
     * @param b       the blue color value multiplied into copy operations
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetTextureColorMod(SDL_Texture, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_SetTextureAlphaMod(SDL_Texture, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetTextureColorMod(
            SDL_Texture texture,
            byte r,
            byte g,
            byte b);

    /**
     * Get the additional color value multiplied into render copy operations.
     *
     * @param texture the texture to query
     * @param r       a pointer filled in with the current red color value
     * @param g       a pointer filled in with the current green color value
     * @param b       a pointer filled in with the current blue color value
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetTextureAlphaMod(SDL_Texture, ByteByReference)
     * @see #SDL_SetTextureColorMod(SDL_Texture, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetTextureColorMod(
            SDL_Texture texture,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b);

    /**
     * Set an additional alpha value multiplied into render copy operations.
     *
     * <p>When this texture is rendered, during the copy operation the source alpha
     * value is modulated by this alpha value according to the following formula:</p>
     *
     * <pre>
     * srcA = srcA * (alpha / 255)
     * </pre>
     *
     * <p>Alpha modulation is not always supported by the renderer; it will return -1
     * if alpha modulation is not supported.</p>
     *
     * @param texture the texture to update
     * @param alpha   the source alpha value multiplied into copy operations
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetTextureAlphaMod(SDL_Texture, ByteByReference)
     * @see #SDL_SetTextureColorMod(SDL_Texture, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetTextureAlphaMod(
            SDL_Texture texture,
            byte alpha);

    /**
     * Get the additional alpha value multiplied into render copy operations.
     *
     * @param texture the texture to query
     * @param alpha   a pointer filled in with the current alpha value
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetTextureColorMod(SDL_Texture, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_SetTextureAlphaMod(SDL_Texture, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetTextureAlphaMod(
            SDL_Texture texture,
            ByteByReference alpha);

    /**
     * Set the blend mode for a texture, used by SDL_RenderCopy().
     *
     * <p>If the blend mode is not supported, the closest supported mode is chosen
     * and this function returns -1.</p>
     *
     * @param texture   the texture to update
     * @param blendMode the SDL_BlendMode to use for texture blending
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetTextureBlendMode(SDL_Texture, SDL_BlendMode.Ref)
     * @see #SDL_RenderCopy(SDL_Renderer, SDL_Texture, SDL_Rect, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetTextureBlendMode(
            SDL_Texture texture,
            @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

    /**
     * Get the blend mode used for texture copy operations.
     *
     * @param texture   the texture to query
     * @param blendMode a pointer filled in with the current SDL_BlendMode
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetTextureBlendMode(SDL_Texture, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetTextureBlendMode(
            SDL_Texture texture,
            SDL_BlendMode.Ref blendMode);

    /**
     * Set the scale mode used for texture scale operations.
     *
     * <p>If the scale mode is not supported, the closest supported mode is chosen.</p>
     *
     * @param texture   The texture to update.
     * @param scaleMode the SDL_ScaleMode to use for texture scaling.
     * @return 0 on success, or -1 if the texture is not valid.
     * @see #SDL_GetTextureScaleMode(SDL_Texture, SDL_ScaleMode.Ref)
     * @since This function is available since SDL 2.0.12.
     */
    public static native int SDL_SetTextureScaleMode(
            SDL_Texture texture,
            @MagicConstant(valuesFromClass = SDL_ScaleMode.class) int scaleMode);

    /**
     * Get the scale mode used for texture scale operations.
     *
     * @param texture   the texture to query.
     * @param scaleMode a pointer filled in with the current scale mode.
     * @return 0 on success, or -1 if the texture is not valid.
     * @see #SDL_SetTextureScaleMode(SDL_Texture, int)
     * @since This function is available since SDL 2.0.12.
     */
    public static native int SDL_GetTextureScaleMode(
            SDL_Texture texture,
            SDL_ScaleMode.Ref scaleMode);

    /**
     * Associate a user-specified pointer with a texture.
     *
     * @param texture  the texture to update.
     * @param userdata the pointer to associate with the texture.
     * @return 0 on success, or -1 if the texture is not valid.
     * @see #SDL_GetTextureUserData(SDL_Texture)
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_SetTextureUserData(
            SDL_Texture texture,
            Pointer userdata);

    /**
     * Get the user-specified pointer associated with a texture
     *
     * @param texture the texture to query.
     * @return the pointer associated with the texture, or null if the texture is
     * not valid.
     * @see #SDL_SetTextureUserData(SDL_Texture, Pointer)
     * @since This function is available since SDL 2.0.18.
     */
    public static native Pointer SDL_GetTextureUserData(
            SDL_Texture texture);

    /**
     * Update the given texture rectangle with new pixel data.
     *
     * <p>The pixel data must be in the pixel format of the texture. Use
     * SDL_QueryTexture() to query the pixel format of the texture.</p>
     *
     * <p>This is a fairly slow function, intended for use with static textures that
     * do not change often.</p>
     *
     * <p>If the texture is intended to be updated often, it is preferred to create
     * the texture as streaming and use the locking functions referenced below.
     * While this function will work with streaming textures, for optimization
     * reasons you may not get the pixels back if you lock the texture afterward.</p>
     *
     * @param texture the texture to update
     * @param rect    an SDL_Rect structure representing the area to update, or null
     *                to update the entire texture
     * @param pixels  the raw pixel data in the format of the texture
     * @param pitch   the number of bytes in a row of pixel data, including padding
     *                between lines
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateTexture(SDL_Renderer, int, int, int, int)
     * @see #SDL_LockTexture(SDL_Texture, SDL_Rect, PointerByReference, IntByReference)
     * @see #SDL_UnlockTexture(SDL_Texture)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_UpdateTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer pixels,
            int pitch);

    /**
     * Update a rectangle within a planar YV12 or IYUV texture with new pixel
     * data.
     *
     * <p>You can use SDL_UpdateTexture() as long as your pixel data is a contiguous
     * block of Y and U/V planes in the proper order, but this function is
     * available if your pixel data is not contiguous.</p>
     *
     * @param texture the texture to update
     * @param rect    a pointer to the rectangle of pixels to update, or null to
     *                update the entire texture
     * @param yPlane  the raw pixel data for the Y plane
     * @param yPitch  the number of bytes between rows of pixel data for the Y
     *                plane
     * @param uPlane  the raw pixel data for the U plane
     * @param uPitch  the number of bytes between rows of pixel data for the U
     *                plane
     * @param vPlane  the raw pixel data for the V plane
     * @param vPitch  the number of bytes between rows of pixel data for the V
     *                plane
     * @return 0 on success or -1 if the texture is not valid; call
     * SDL_GetError() for more information.
     * @see #SDL_UpdateTexture(SDL_Texture, SDL_Rect, Pointer, int)
     * @since This function is available since SDL 2.0.1.
     */
    public static native int SDL_UpdateYUVTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer yPlane,
            int yPitch,
            Pointer uPlane,
            int uPitch,
            Pointer vPlane,
            int vPitch);

    /**
     * Update a rectangle within a planar NV12 or NV21 texture with new pixels.
     *
     * <p>You can use SDL_UpdateTexture() as long as your pixel data is a contiguous
     * block of NV12/21 planes in the proper order, but this function is available
     * if your pixel data is not contiguous.</p>
     *
     * @param texture the texture to update
     * @param rect    a pointer to the rectangle of pixels to update, or null to
     *                update the entire texture.
     * @param yPlane  the raw pixel data for the Y plane.
     * @param yPitch  the number of bytes between rows of pixel data for the Y
     *                plane.
     * @param uvPlane the raw pixel data for the UV plane.
     * @param uvPitch the number of bytes between rows of pixel data for the UV
     *                plane.
     * @return 0 on success, or -1 if the texture is not valid.
     * @since This function is available since SDL 2.0.16.
     */
    public static native int SDL_UpdateNVTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer yPlane,
            int yPitch,
            Pointer uvPlane,
            int uvPitch);

    /**
     * Lock a portion of the texture for **write-only** pixel access.
     *
     * <p>As an optimization, the pixels made available for editing don't necessarily
     * contain the old texture data. This is a write-only operation, and if you
     * need to keep a copy of the texture data you should do that at the
     * application level.</p>
     *
     * <p>You must use SDL_UnlockTexture() to unlock the pixels and apply any
     * changes.</p>
     *
     * @param texture the texture to lock for access, which was created with
     *                {@code SDL_TEXTUREACCESS_STREAMING}
     * @param rect    an SDL_Rect structure representing the area to lock for access;
     *                null to lock the entire texture
     * @param pixels  this is filled in with a pointer to the locked pixels,
     *                appropriately offset by the locked area
     * @param pitch   this is filled in with the pitch of the locked pixels; the
     *                pitch is the length of one row in bytes
     * @return 0 on success or a negative error code if the texture is not valid
     * or was not created with {@code SDL_TEXTUREACCESS_STREAMING}; call
     * SDL_GetError() for more information.
     * @see #SDL_UnlockTexture(SDL_Texture)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_LockTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            PointerByReference pixels,
            IntByReference pitch);

    /**
     * Lock a portion of the texture for **write-only** pixel access, and expose
     * it as a SDL surface.
     *
     * <p>Besides providing an SDL_Surface instead of raw pixel data, this function
     * operates like SDL_LockTexture.</p>
     *
     * <p>As an optimization, the pixels made available for editing don't necessarily
     * contain the old texture data. This is a write-only operation, and if you
     * need to keep a copy of the texture data you should do that at the
     * application level.</p>
     *
     * <p>You must use SDL_UnlockTexture() to unlock the pixels and apply any
     * changes.</p>
     *
     * <p>The returned surface is freed internally after calling SDL_UnlockTexture()
     * or SDL_DestroyTexture(). The caller should not free it.</p>
     *
     * @param texture the texture to lock for access, which was created with
     *                {@code SDL_TEXTUREACCESS_STREAMING}
     * @param rect    a pointer to the rectangle to lock for access. If the rect is
     *                null, the entire texture will be locked
     * @param surface this is filled in with an SDL surface representing the
     *                locked area
     * @return 0 on success, or -1 if the texture is not valid or was not created
     * with {@code SDL_TEXTUREACCESS_STREAMING}
     * @see #SDL_LockTexture(SDL_Texture, SDL_Rect, PointerByReference, IntByReference)
     * @see #SDL_UnlockTexture(SDL_Texture)
     * @since This function is available since SDL 2.0.12.
     */
    public static native int SDL_LockTextureToSurface(
            SDL_Texture texture,
            SDL_Rect rect,
            SDL_Surface.Ref surface);

    /**
     * Unlock a texture, uploading the changes to video memory, if needed.
     *
     * <p><b>Warning:</b> Please note that SDL_LockTexture() is intended to be
     * write-only; it will not guarantee the previous contents of the texture will
     * be provided. You must fully initialize any area of a texture that you lock
     * before unlocking it, as the pixels might otherwise be uninitialized memory.</p>
     *
     * <p>Which is to say: locking and immediately unlocking a texture can result in
     * corrupted textures, depending on the renderer in use.</p>
     *
     * @param texture a texture locked by SDL_LockTexture()
     * @see #SDL_LockTexture(SDL_Texture, SDL_Rect, PointerByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_UnlockTexture(
            SDL_Texture texture);

    /**
     * Determine whether a renderer supports the use of render targets.
     *
     * @param renderer the renderer that will be checked
     * @return true if supported or false if not.
     * @see #SDL_SetRenderTarget(SDL_Renderer, SDL_Texture)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_RenderTargetSupported(
            SDL_Renderer renderer);

    /**
     * Set a texture as the current rendering target.
     *
     * <p>Before using this function, you should check the
     * {@code SDL_RENDERER_TARGETTEXTURE} bit in the flags of SDL_RendererInfo to see if
     * render targets are supported.</p>
     *
     * <p>The default render target is the window for which the renderer was created.
     * To stop rendering to a texture and render to the window again, call this
     * function with a null {@code texture}.</p>
     *
     * @param renderer the rendering context
     * @param texture  the targeted texture, which must be created with the
     *                 {@code SDL_TEXTUREACCESS_TARGET} flag, or null to render to the
     *                 window instead of a texture.
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetRenderTarget(SDL_Renderer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetRenderTarget(
            SDL_Renderer renderer,
            SDL_Texture texture);

    /**
     * Get the current render target.
     *
     * <p>The default render target is the window for which the renderer was created,
     * and is reported a null here.</p>
     *
     * @param renderer the rendering context
     * @return the current render target or null for the default render target.
     * @see #SDL_SetRenderTarget(SDL_Renderer, SDL_Texture)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Texture SDL_GetRenderTarget(
            SDL_Renderer renderer);

    /**
     * Set a device independent resolution for rendering.
     *
     * <p>This function uses the viewport and scaling functionality to allow a fixed
     * logical resolution for rendering, regardless of the actual output
     * resolution. If the actual output resolution doesn't have the same aspect
     * ratio the output rendering will be centered within the output display.</p>
     *
     * <p>If the output display is a window, mouse and touch events in the window
     * will be filtered and scaled so they seem to arrive within the logical
     * resolution. The SDL_HINT_MOUSE_RELATIVE_SCALING hint controls whether
     * relative motion events are also scaled.</p>
     *
     * <p>If this function results in scaling or subpixel drawing by the rendering
     * backend, it will be handled using the appropriate quality hints.</p>
     *
     * @param renderer the renderer for which resolution should be set
     * @param w        the width of the logical resolution
     * @param h        the height of the logical resolution
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderGetLogicalSize(SDL_Renderer, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderSetLogicalSize(
            SDL_Renderer renderer,
            int w,
            int h);

    /**
     * Get device independent resolution for rendering.
     *
     * <p>When using the main rendering target (eg no target texture is set): this
     * may return 0 for {@code w} and {@code h} if the SDL_Renderer has never had its logical
     * size set by SDL_RenderSetLogicalSize(). Otherwise it returns the logical
     * width and height.</p>
     *
     * <p>When using a target texture: Never return 0 for {@code w} and {@code h} at first. Then
     * it returns the logical width and height that are set.</p>
     *
     * @param renderer a rendering context
     * @param w        an int to be filled with the width
     * @param h        an int to be filled with the height
     * @see #SDL_RenderSetLogicalSize(SDL_Renderer, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_RenderGetLogicalSize(
            SDL_Renderer renderer,
            IntByReference w,
            IntByReference h);

    /**
     * Set whether to force integer scales for resolution-independent rendering.
     *
     * <p>This function restricts the logical viewport to integer values - that is,
     * when a resolution is between two multiples of a logical size, the viewport
     * size is rounded down to the lower multiple.</p>
     *
     * @param renderer the renderer for which integer scaling should be set
     * @param enable   enable or disable the integer scaling for rendering
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderGetIntegerScale(SDL_Renderer)
     * @see #SDL_RenderSetLogicalSize(SDL_Renderer, int, int)
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_RenderSetIntegerScale(
            SDL_Renderer renderer,
            boolean enable);

    /**
     * Get whether integer scales are forced for resolution-independent rendering.
     *
     * @param renderer the renderer from which integer scaling should be queried
     * @return true if integer scales are forced or false if not and on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_RenderSetIntegerScale(SDL_Renderer, boolean)
     * @since This function is available since SDL 2.0.5.
     */
    public static native boolean SDL_RenderGetIntegerScale(
            SDL_Renderer renderer);

    /**
     * Set the drawing area for rendering on the current target.
     *
     * <p>When the window is resized, the viewport is reset to fill the entire new
     * window size.</p>
     *
     * @param renderer the rendering context
     * @param rect     the SDL_Rect structure representing the drawing area, or null
     *                 to set the viewport to the entire target
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderGetViewport(SDL_Renderer, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderSetViewport(
            SDL_Renderer renderer,
            SDL_Rect rect);

    /**
     * Get the drawing area for the current target.
     *
     * @param renderer the rendering context
     * @param rect     an SDL_Rect structure filled in with the current drawing area
     * @see #SDL_RenderSetViewport(SDL_Renderer, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_RenderGetViewport(
            SDL_Renderer renderer,
            SDL_Rect rect);

    /**
     * Set the clip rectangle for rendering on the specified target.
     *
     * @param renderer the rendering context for which clip rectangle should be
     *                 set
     * @param rect     an SDL_Rect structure representing the clip area, relative to
     *                 the viewport, or null to disable clipping
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderGetClipRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderIsClipEnabled(SDL_Renderer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderSetClipRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    /**
     * Get the clip rectangle for the current target.
     *
     * @param renderer the rendering context from which clip rectangle should be
     *                 queried
     * @param rect     an SDL_Rect structure filled in with the current clipping area
     *                 or an empty rectangle if clipping is disabled
     * @see #SDL_RenderIsClipEnabled(SDL_Renderer)
     * @see #SDL_RenderSetClipRect(SDL_Renderer, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_RenderGetClipRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    /**
     * Get whether clipping is enabled on the given renderer.
     *
     * @param renderer the renderer from which clip state should be queried
     * @return true if clipping is enabled or false if not; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderGetClipRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderSetClipRect(SDL_Renderer, SDL_Rect)
     * @since This function is available since SDL 2.0.4.
     */
    public static native boolean SDL_RenderIsClipEnabled(
            SDL_Renderer renderer);

    /**
     * Set the drawing scale for rendering on the current target.
     *
     * <p>The drawing coordinates are scaled by the x/y scaling factors before they
     * are used by the renderer. This allows resolution independent drawing with a
     * single coordinate system.</p>
     *
     * <p>If this results in scaling or subpixel drawing by the rendering backend, it
     * will be handled using the appropriate quality hints. For best results use
     * integer scaling factors.</p>
     *
     * @param renderer a rendering context
     * @param scaleX   the horizontal scaling factor
     * @param scaleY   the vertical scaling factor
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderGetScale(SDL_Renderer, FloatByReference, FloatByReference)
     * @see #SDL_RenderSetLogicalSize(SDL_Renderer, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderSetScale(
            SDL_Renderer renderer,
            float scaleX,
            float scaleY);

    /**
     * Get the drawing scale for the current target.
     *
     * @param renderer the renderer from which drawing scale should be queried
     * @param scaleX   a pointer filled in with the horizontal scaling factor
     * @param scaleY   a pointer filled in with the vertical scaling factor
     * @see #SDL_RenderSetScale(SDL_Renderer, float, float)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_RenderGetScale(
            SDL_Renderer renderer,
            FloatByReference scaleX,
            FloatByReference scaleY);

    /**
     * Get logical coordinates of point in renderer when given real coordinates of
     * point in window.
     *
     * <p>Logical coordinates will differ from real coordinates when render is scaled
     * and logical renderer size set</p>
     *
     * @param renderer the renderer from which the logical coordinates should be
     *                 calculated
     * @param windowX  the real X coordinate in the window
     * @param windowY  the real Y coordinate in the window
     * @param logicalX the pointer filled with the logical x coordinate
     * @param logicalY the pointer filled with the logical y coordinate
     * @see #SDL_RenderGetScale(SDL_Renderer, FloatByReference, FloatByReference)
     * @see #SDL_RenderSetScale(SDL_Renderer, float, float)
     * @see #SDL_RenderGetLogicalSize(SDL_Renderer, IntByReference, IntByReference)
     * @see #SDL_RenderSetLogicalSize(SDL_Renderer, int, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native void SDL_RenderWindowToLogical(
            SDL_Renderer renderer,
            int windowX,
            int windowY,
            FloatByReference logicalX,
            FloatByReference logicalY);


    /**
     * Get real coordinates of point in window when given logical coordinates of
     * point in renderer.
     *
     * <p>Logical coordinates will differ from real coordinates when render is scaled
     * and logical renderer size set</p>
     *
     * @param renderer the renderer from which the window coordinates should be
     *                 calculated
     * @param logicalX the logical x coordinate
     * @param logicalY the logical y coordinate
     * @param windowX  the pointer filled with the real X coordinate in the window
     * @param windowY  the pointer filled with the real Y coordinate in the window
     * @see #SDL_RenderGetScale(SDL_Renderer, FloatByReference, FloatByReference)
     * @see #SDL_RenderSetScale(SDL_Renderer, float, float)
     * @see #SDL_RenderGetLogicalSize(SDL_Renderer, IntByReference, IntByReference)
     * @see #SDL_RenderSetLogicalSize(SDL_Renderer, int, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native void SDL_RenderLogicalToWindow(
            SDL_Renderer renderer,
            float logicalX,
            float logicalY,
            IntByReference windowX,
            IntByReference windowY);

    /**
     * Set the color used for drawing operations (Rect, Line and Clear).
     *
     * <p>Set the color for drawing or filling rectangles, lines, and points, and for
     * SDL_RenderClear().</p>
     *
     * @param renderer the rendering context
     * @param r        the red value used to draw on the rendering target
     * @param g        the green value used to draw on the rendering target
     * @param b        the blue value used to draw on the rendering target
     * @param a        the alpha value used to draw on the rendering target; usually
     *                 {@code SDL_ALPHA_OPAQUE} (255). Use SDL_SetRenderDrawBlendMode to
     *                 specify how the alpha channel is used
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetRenderDrawColor(SDL_Renderer, ByteByReference, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_RenderClear(SDL_Renderer)
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetRenderDrawColor(
            SDL_Renderer renderer,
            byte r,
            byte g,
            byte b,
            byte a);

    /**
     * Get the color used for drawing operations (Rect, Line and Clear).
     *
     * @param renderer the rendering context
     * @param r        a pointer filled in with the red value used to draw on the
     *                 rendering target
     * @param g        a pointer filled in with the green value used to draw on the
     *                 rendering target
     * @param b        a pointer filled in with the blue value used to draw on the
     *                 rendering target
     * @param a        a pointer filled in with the alpha value used to draw on the
     *                 rendering target; usually {@code SDL_ALPHA_OPAQUE} (255)
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetRenderDrawColor(
            SDL_Renderer renderer,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b,
            ByteByReference a);

    /**
     * Set the blend mode used for drawing operations (Fill and Line).
     *
     * <p>If the blend mode is not supported, the closest supported mode is chosen.</p>
     *
     * @param renderer  the rendering context
     * @param blendMode the SDL_BlendMode to use for blending
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetRenderDrawBlendMode(SDL_Renderer, SDL_BlendMode.Ref)
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetRenderDrawBlendMode(
            SDL_Renderer renderer,
            @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

    /**
     * Get the blend mode used for drawing operations.
     *
     * @param renderer  the rendering context
     * @param blendMode a pointer filled in with the current SDL_BlendMode
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetRenderDrawBlendMode(
            SDL_Renderer renderer,
            SDL_BlendMode.Ref blendMode);

    /**
     * Clear the current rendering target with the drawing color.
     *
     * <p>This function clears the entire rendering target, ignoring the viewport and
     * the clip rectangle.</p>
     *
     * @param renderer the rendering context
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderClear(
            SDL_Renderer renderer);

    /**
     * Draw a point on the current rendering target.
     *
     * <p>SDL_RenderDrawPoint() draws a single point. If you want to draw multiple,
     * use SDL_RenderDrawPoints() instead.</p>
     *
     * @param renderer the rendering context
     * @param x        the x coordinate of the point
     * @param y        the y coordinate of the point
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderDrawPoint(
            SDL_Renderer renderer,
            int x,
            int y);

    /**
     * Draw multiple points on the current rendering target.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer the rendering context
     * @param points   an array of SDL_Point structures that represent the points to
     *                 draw
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_RenderDrawPoints(
            SDL_Renderer renderer,
            List<SDL_Point> points) {
        if (points.size() == 0) {
            return 0;
        }
        try (Memory pointsBuffer = JnaUtils.writeListToNativeMemory(points)) {
            return SDL_RenderDrawPoints(renderer, pointsBuffer, points.size());
        }
    }

    /**
     * Draw multiple points on the current rendering target.
     *
     * <p>This is a raw int[]-style function.
     * You can use it for efficiency if you do not use SDL_Point,
     * because have your own data structure for points.
     * If you used {@link #SDL_RenderDrawPoints(SDL_Renderer, List)}
     * you would have to copy data from your structures to SDL_Point first
     * and then they would be copied again into na off-heap buffer.
     * Using this method, you can skip the artificial conversion
     * and fill the int[] with X and Y values interleaving one another.</p>
     *
     * @param renderer the rendering context
     * @param intXandY an array of X and Y int values that represent the points to
     *                 draw
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_RenderDrawPoints(
            SDL_Renderer renderer,
            int[] intXandY) {
        if (intXandY.length == 0) {
            return 0;
        }
        if (intXandY.length % 2 != 0) {
            SDL_SetError("Invalid length of the int[] array. It must consist of pairs of `int x` and `int y`.");
            return -1;
        }
        try (Memory pointsBuffer = JnaUtils.writeArrayToNativeMemory(intXandY)) {
            return SDL_RenderDrawPoints(renderer, pointsBuffer, intXandY.length / 2);
        }
    }

    /**
     * Draw multiple points on the current rendering target.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderDrawPoints(SDL_Renderer, List)}.</p>
     *
     * @param renderer the rendering context
     * @param points   an array of SDL_Point structures that represent the points to
     *                 draw
     * @param count    the number of points to draw
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderDrawPoints(
            SDL_Renderer renderer,
            Pointer points,
            int count);

    /**
     * Draw a line on the current rendering target.
     *
     * <p>SDL_RenderDrawLine() draws the line to include both end points. If you want
     * to draw multiple, connecting lines use SDL_RenderDrawLines() instead.</p>
     *
     * @param renderer the rendering context
     * @param x1       the x coordinate of the start point
     * @param y1       the y coordinate of the start point
     * @param x2       the x coordinate of the end point
     * @param y2       the y coordinate of the end point
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderDrawLine(
            SDL_Renderer renderer,
            int x1,
            int y1,
            int x2,
            int y2);

    /**
     * Draw a series of connected lines on the current rendering target.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer the rendering context
     * @param points   an array of SDL_Point structures representing points along
     *                 the lines
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_RenderDrawLines(
            SDL_Renderer renderer,
            List<SDL_Point> points) {
        if (points.size() == 0) {
            return 0;
        }
        try (Memory pointsBuffer = JnaUtils.writeListToNativeMemory(points)) {
            return SDL_RenderDrawLines(renderer, pointsBuffer, points.size());
        }
    }

    /**
     * Draw a series of connected lines on the current rendering target.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderDrawLines(SDL_Renderer, List)}.</p>
     *
     * @param renderer the rendering context
     * @param points   an array of SDL_Point structures representing points along
     *                 the lines
     * @param count    the number of points, drawing count-1 lines
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderDrawLines(
            SDL_Renderer renderer,
            Pointer points,
            int count);

    /**
     * Draw a rectangle on the current rendering target.
     *
     * @param renderer the rendering context
     * @param rect     an SDL_Rect structure representing the rectangle to draw, or
     *                 null to outline the entire rendering target
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderDrawRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    /**
     * Draw some number of rectangles on the current rendering target.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer the rendering context
     * @param rects    an array of SDL_Rect structures representing the rectangles to
     *                 be drawn
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_RenderDrawRects(
            SDL_Renderer renderer,
            ContiguousArrayList<SDL_Rect> rects) {
        if (rects.size() == 0) {
            return 0;
        }
        return SDL_RenderDrawRects(renderer, rects.autoWriteAndGetPointer(), rects.size());
    }

    /**
     * Draw some number of rectangles on the current rendering target.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)}.</p>
     *
     * @param renderer the rendering context
     * @param rects    an array of SDL_Rect structures representing the rectangles to
     *                 be drawn
     * @param count    the number of rectangles
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderDrawRects(
            SDL_Renderer renderer,
            Pointer rects,
            int count);

    /**
     * Fill a rectangle on the current rendering target with the drawing color.
     *
     * <p>The current drawing color is set by SDL_SetRenderDrawColor(), and the
     * color's alpha value is ignored unless blending is enabled with the
     * appropriate call to SDL_SetRenderDrawBlendMode().</p>
     *
     * @param renderer the rendering context
     * @param rect     the SDL_Rect structure representing the rectangle to fill, or
     *                 null for the entire rendering target
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderFillRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    /**
     * Fill some number of rectangles on the current rendering target with the
     * drawing color.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer the rendering context
     * @param rects    an array of SDL_Rect structures representing the rectangles to
     *                 be filled
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_RenderFillRects(
            SDL_Renderer renderer,
            ContiguousArrayList<SDL_Rect> rects) {
        if (rects.size() == 0) {
            return 0;
        }
        return SDL_RenderFillRects(renderer, rects.autoWriteAndGetPointer(), rects.size());
    }

    /**
     * Fill some number of rectangles on the current rendering target with the
     * drawing color.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)}.</p>
     *
     * @param renderer the rendering context
     * @param rects    an array of SDL_Rect structures representing the rectangles to
     *                 be filled
     * @param count    the number of rectangles
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderPresent(SDL_Renderer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderFillRects(
            SDL_Renderer renderer,
            Pointer rects,
            int count);

    /**
     * Copy a portion of the texture to the current rendering target.
     *
     * <p>The texture is blended with the destination based on its blend mode set
     * with SDL_SetTextureBlendMode().</p>
     *
     * <p>The texture color is affected based on its color modulation set by
     * SDL_SetTextureColorMod().</p>
     *
     * <p>The texture alpha is affected based on its alpha modulation set by
     * SDL_SetTextureAlphaMod().</p>
     *
     * @param renderer the rendering context
     * @param texture  the source texture
     * @param srcRect  the source SDL_Rect structure or null for the entire texture
     * @param dstRect  the destination SDL_Rect structure or null for the entire
     *                 rendering target; the texture will be stretched to fill the
     *                 given rectangle
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderCopyEx(SDL_Renderer, SDL_Texture, SDL_Rect, SDL_Rect, double, SDL_Point, int)
     * @see #SDL_SetTextureAlphaMod(SDL_Texture, byte)
     * @see #SDL_SetTextureBlendMode(SDL_Texture, int)
     * @see #SDL_SetTextureColorMod(SDL_Texture, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderCopy(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_Rect dstRect);

    /**
     * Copy a portion of the texture to the current rendering, with optional
     * rotation and flipping.
     *
     * <p>Copy a portion of the texture to the current rendering target, optionally
     * rotating it by angle around the given center and also flipping it
     * top-bottom and/or left-right.</p>
     *
     * <p>The texture is blended with the destination based on its blend mode set
     * with SDL_SetTextureBlendMode().</p>
     *
     * <p>The texture color is affected based on its color modulation set by
     * SDL_SetTextureColorMod().</p>
     *
     * <p>The texture alpha is affected based on its alpha modulation set by
     * SDL_SetTextureAlphaMod().</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer the rendering context
     * @param texture  the source texture
     * @param srcRect  the source SDL_Rect structure or null for the entire texture
     * @param dstRect  the destination SDL_Rect structure or null for the entire
     *                 rendering target
     * @param angle    an angle in degrees that indicates the rotation that will be
     *                 applied to dstrect, rotating it in a clockwise direction
     * @param center   a pointer to a point indicating the point around which
     *                 dstRect will be rotated (if null, rotation will be done
     *                 around {@code dstRect.w / 2}, {@code dstRect.h / 2})
     * @param flip     a SDL_RendererFlip value stating which flipping actions should
     *                 be performed on the texture
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderCopy(SDL_Renderer, SDL_Texture, SDL_Rect, SDL_Rect)
     * @see #SDL_SetTextureAlphaMod(SDL_Texture, byte)
     * @see #SDL_SetTextureBlendMode(SDL_Texture, int)
     * @see #SDL_SetTextureColorMod(SDL_Texture, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_RenderCopyEx(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_Rect dstRect,
            double angle,
            SDL_Point center,
            @MagicConstant(valuesFromClass = SDL_RendererFlip.class) int flip) {
        if (center == null) {
            return SDL_RenderCopyEx(renderer, texture, srcRect, dstRect, angle, (Pointer) null, flip);
        } else {
            try (Memory rawCenterPoint = new Memory(center.size())) {
                center.write(rawCenterPoint, 0L);
                return SDL_RenderCopyEx(renderer, texture, srcRect, dstRect, angle, rawCenterPoint, flip);
            }
        }
    }

    /**
     * Copy a portion of the texture to the current rendering, with optional
     * rotation and flipping.
     *
     * <p>Copy a portion of the texture to the current rendering target, optionally
     * rotating it by angle around the given center and also flipping it
     * top-bottom and/or left-right.</p>
     *
     * <p>The texture is blended with the destination based on its blend mode set
     * with SDL_SetTextureBlendMode().</p>
     *
     * <p>The texture color is affected based on its color modulation set by
     * SDL_SetTextureColorMod().</p>
     *
     * <p>The texture alpha is affected based on its alpha modulation set by
     * SDL_SetTextureAlphaMod().</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderCopyEx(SDL_Renderer, SDL_Texture, SDL_Rect, SDL_Rect, double, SDL_Point, int)}.</p>
     *
     * @param renderer the rendering context
     * @param texture  the source texture
     * @param srcRect  the source SDL_Rect structure or null for the entire texture
     * @param dstRect  the destination SDL_Rect structure or null for the entire
     *                 rendering target
     * @param angle    an angle in degrees that indicates the rotation that will be
     *                 applied to dstrect, rotating it in a clockwise direction
     * @param center   a pointer to an SDL_Point struct indicating the point around which
     *                 dstRect will be rotated (if null, rotation will be done
     *                 around {@code dstRect.w / 2}, {@code dstRect.h / 2})
     * @param flip     a SDL_RendererFlip value stating which flipping actions should
     *                 be performed on the texture
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_RenderCopy(SDL_Renderer, SDL_Texture, SDL_Rect, SDL_Rect)
     * @see #SDL_SetTextureAlphaMod(SDL_Texture, byte)
     * @see #SDL_SetTextureBlendMode(SDL_Texture, int)
     * @see #SDL_SetTextureColorMod(SDL_Texture, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderCopyEx(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_Rect dstRect,
            double angle,
            Pointer center,
            @MagicConstant(valuesFromClass = SDL_RendererFlip.class) int flip);

    /**
     * Draw a point on the current rendering target at subpixel precision.
     *
     * @param renderer The renderer which should draw a point.
     * @param x        The x coordinate of the point.
     * @param y        The y coordinate of the point.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderDrawPointF(
            SDL_Renderer renderer,
            float x,
            float y);

    /**
     * Draw multiple points on the current rendering target at subpixel precision.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer The renderer which should draw multiple points.
     * @param fPoints  The points to draw
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static int SDL_RenderDrawPointsF(
            SDL_Renderer renderer,
            List<SDL_FPoint> fPoints) {
        if (fPoints.size() == 0) {
            return 0;
        }
        try (Memory fPointsBuffer = JnaUtils.writeListToNativeMemory(fPoints)) {
            return SDL_RenderDrawPointsF(renderer, fPointsBuffer, fPoints.size());
        }
    }

    /**
     * Draw multiple points on the current rendering target at subpixel precision.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderDrawPointsF(SDL_Renderer, List)}.</p>
     *
     * @param renderer The renderer which should draw multiple points.
     * @param fPoints  The points to draw
     * @param count    The number of points to draw
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderDrawPointsF(
            SDL_Renderer renderer,
            Pointer fPoints,
            int count);

    /**
     * Draw a line on the current rendering target at subpixel precision.
     *
     * @param renderer The renderer which should draw a line.
     * @param x1       The x coordinate of the start point.
     * @param y1       The y coordinate of the start point.
     * @param x2       The x coordinate of the end point.
     * @param y2       The y coordinate of the end point.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderDrawLineF(
            SDL_Renderer renderer,
            float x1,
            float y1,
            float x2,
            float y2);

    /**
     * Draw a series of connected lines on the current rendering target at
     * subpixel precision.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer The renderer which should draw multiple lines.
     * @param fPoints  The points along the lines
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static int SDL_RenderDrawLinesF(
            SDL_Renderer renderer,
            List<SDL_FPoint> fPoints) {
        if (fPoints.size() == 0) {
            return 0;
        }
        try (Memory fPointsBuffer = JnaUtils.writeListToNativeMemory(fPoints)) {
            return SDL_RenderDrawLinesF(renderer, fPointsBuffer, fPoints.size());
        }
    }

    /**
     * Draw a series of connected lines on the current rendering target at
     * subpixel precision.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderDrawLinesF(SDL_Renderer, List)}.</p>
     *
     * @param renderer The renderer which should draw multiple lines.
     * @param fPoints  The points along the lines
     * @param count    The number of points, drawing count-1 lines
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderDrawLinesF(
            SDL_Renderer renderer,
            Pointer fPoints,
            int count);

    /**
     * Draw a rectangle on the current rendering target at subpixel precision.
     *
     * @param renderer The renderer which should draw a rectangle.
     * @param rect     A pointer to the destination rectangle, or null to outline the
     *                 entire rendering target.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderDrawRectF(
            SDL_Renderer renderer,
            SDL_FRect rect);

    /**
     * Draw some number of rectangles on the current rendering target at subpixel
     * precision.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer The renderer which should draw multiple rectangles.
     * @param fRects   A pointer to an array of destination rectangles.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static int SDL_RenderDrawRectsF(
            SDL_Renderer renderer,
            ContiguousArrayList<SDL_FRect> fRects) {
        if (fRects.size() == 0) {
            return 0;
        }
        return SDL_RenderDrawRectsF(renderer, fRects.autoWriteAndGetPointer(), fRects.size());
    }

    /**
     * Draw some number of rectangles on the current rendering target at subpixel
     * precision.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderDrawRectsF(SDL_Renderer, ContiguousArrayList)}.</p>
     *
     * @param renderer The renderer which should draw multiple rectangles.
     * @param fRects   A pointer to an array of destination rectangles.
     * @param count    The number of rectangles.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderDrawRectsF(
            SDL_Renderer renderer,
            Pointer fRects,
            int count);

    /**
     * Fill a rectangle on the current rendering target with the drawing color at
     * subpixel precision.
     *
     * @param renderer The renderer which should fill a rectangle.
     * @param rect     A pointer to the destination rectangle, or null for the entire
     *                 rendering target.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderFillRectF(
            SDL_Renderer renderer,
            SDL_FRect rect);

    /**
     * Fill some number of rectangles on the current rendering target with the
     * drawing color at subpixel precision.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer The renderer which should fill multiple rectangles.
     * @param fRects   A pointer to an array of destination rectangles.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static int SDL_RenderFillRectsF(
            SDL_Renderer renderer,
            ContiguousArrayList<SDL_FRect> fRects) {
        if (fRects.size() == 0) {
            return 0;
        }
        return SDL_RenderFillRectsF(renderer, fRects.autoWriteAndGetPointer(), fRects.size());
    }

    /**
     * Fill some number of rectangles on the current rendering target with the
     * drawing color at subpixel precision.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderFillRectsF(SDL_Renderer, ContiguousArrayList)}.</p>
     *
     * @param renderer The renderer which should fill multiple rectangles.
     * @param rects    A pointer to an array of destination rectangles.
     * @param count    The number of rectangles.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderFillRectsF(
            SDL_Renderer renderer,
            Pointer rects,
            int count);

    /**
     * Copy a portion of the texture to the current rendering target at subpixel
     * precision.
     *
     * @param renderer The renderer which should copy parts of a texture.
     * @param texture  The source texture.
     * @param srcRect  A pointer to the source rectangle, or null for the entire
     *                 texture.
     * @param dstFRect A pointer to the destination rectangle, or null for the
     *                 entire rendering target.
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderCopyF(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_FRect dstFRect);

    /**
     * Copy a portion of the source texture to the current rendering target, with
     * rotation and flipping, at subpixel precision.
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer The renderer which should copy parts of a texture.
     * @param texture  The source texture.
     * @param srcRect  A pointer to the source rectangle, or null for the entire
     *                 texture.
     * @param dstFRect A pointer to the destination rectangle, or null for the
     *                 entire rendering target.
     * @param angle    An angle in degrees that indicates the rotation that will be
     *                 applied to dstrect, rotating it in a clockwise direction
     * @param center   An {@code SDL_FPoint} indicating the point around which
     *                 {@code dstFRect} will be rotated (if null, rotation will be done
     *                 around {@code dstFRect.w/2}, {@code dstFRect.h/2}).
     * @param flip     An SDL_RendererFlip value stating which flipping actions should
     *                 be performed on the texture
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static int SDL_RenderCopyExF(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_FRect dstFRect,
            double angle,
            SDL_FPoint center,
            @MagicConstant(valuesFromClass = SDL_RendererFlip.class) int flip) {
        if (center == null) {
            return SDL_RenderCopyExF(renderer, texture, srcRect, dstFRect, angle, (Pointer) null, flip);
        } else {
            try (Memory rawCenterPoint = new Memory(center.size())) {
                center.write(rawCenterPoint, 0L);
                return SDL_RenderCopyExF(renderer, texture, srcRect, dstFRect, angle, rawCenterPoint, flip);
            }
        }
    }

    /**
     * Copy a portion of the source texture to the current rendering target, with
     * rotation and flipping, at subpixel precision.
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderCopyExF(SDL_Renderer, SDL_Texture, SDL_Rect, SDL_FRect, double, SDL_FPoint, int)}.</p>
     *
     * @param renderer The renderer which should copy parts of a texture.
     * @param texture  The source texture.
     * @param srcRect  A pointer to the source rectangle, or null for the entire
     *                 texture.
     * @param dstFRect A pointer to the destination rectangle, or null for the
     *                 entire rendering target.
     * @param angle    An angle in degrees that indicates the rotation that will be
     *                 applied to dstrect, rotating it in a clockwise direction
     * @param center   A pointer to an {@code SDL_FPoint} indicating the point around which
     *                 {@code dstFRect} will be rotated (if null, rotation will be done
     *                 around {@code dstFRect.w/2}, {@code dstFRect.h/2}).
     * @param flip     An SDL_RendererFlip value stating which flipping actions should
     *                 be performed on the texture
     * @return 0 on success, or -1 on error
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderCopyExF(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_FRect dstFRect,
            double angle,
            Pointer center,
            @MagicConstant(valuesFromClass = SDL_RendererFlip.class) int flip);

    /**
     * Render a list of triangles, optionally using a texture and indices into the
     * vertex array Color and alpha modulation is done per vertex
     * (SDL_SetTextureColorMod and SDL_SetTextureAlphaMod are ignored).
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param renderer The rendering context.
     * @param texture  (optional) The SDL texture to use.
     * @param vertices Vertices.
     * @param indices  (optional) An array of integer indices into the 'vertices'
     *                 array, if null all vertices will be rendered in sequential
     *                 order.
     * @return 0 on success, or -1 if the operation is not supported
     * @see #SDL_RenderGeometryRaw(SDL_Renderer, SDL_Texture, Pointer, int, Pointer, int, Pointer, int, int, Pointer, int, int)
     * @see SDL_Vertex
     * @since This function is available since SDL 2.0.18.
     */
    public static int SDL_RenderGeometry(
            SDL_Renderer renderer,
            SDL_Texture texture,
            List<SDL_Vertex> vertices,
            int[] indices) {
        if (vertices.size() == 0) {
            return 0;
        }
        try (Memory buffer = JnaUtils.writeListToNativeMemory(vertices);
             Memory indicesBuffer = JnaUtils.writeArrayToNativeMemory(indices)) {
            return SDL_RenderGeometry(renderer, texture, buffer, vertices.size(), indicesBuffer, indices != null ? indices.length : 0);
        }
    }

    /**
     * Render a list of triangles, optionally using a texture and indices into the
     * vertex array Color and alpha modulation is done per vertex
     * (SDL_SetTextureColorMod and SDL_SetTextureAlphaMod are ignored).
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_RenderGeometry(SDL_Renderer, SDL_Texture, List, int[])}.</p>
     *
     * @param renderer    The rendering context.
     * @param texture     (optional) The SDL texture to use.
     * @param vertices    Vertices.
     * @param numVertices Number of vertices.
     * @param indices     (optional) An array of integer indices into the 'vertices'
     *                    array, if null all vertices will be rendered in sequential
     *                    order.
     * @param numIndices  Number of indices.
     * @return 0 on success, or -1 if the operation is not supported
     * @see #SDL_RenderGeometryRaw(SDL_Renderer, SDL_Texture, Pointer, int, Pointer, int, Pointer, int, int, Pointer, int, int)
     * @see SDL_Vertex
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_RenderGeometry(
            SDL_Renderer renderer,
            SDL_Texture texture,
            Pointer vertices,
            int numVertices,
            Pointer indices,
            int numIndices);

    /**
     * Render a list of triangles, optionally using a texture and indices into the
     * vertex arrays Color and alpha modulation is done per vertex
     * (SDL_SetTextureColorMod and SDL_SetTextureAlphaMod are ignored).
     *
     * @param renderer    The rendering context.
     * @param texture     (optional) The SDL texture to use.
     * @param xy          Vertex positions
     * @param xyStride    Byte size to move from one element to the next element
     * @param color       Vertex colors (as SDL_Color)
     * @param colorStride Byte size to move from one element to the next element
     * @param uv          Vertex normalized texture coordinates
     * @param uvStride    Byte size to move from one element to the next element
     * @param numVertices Number of vertices.
     * @param indices     (optional) An array of indices into the 'vertices' arrays,
     *                    if null all vertices will be rendered in sequential order.
     * @param numIndices  Number of indices.
     * @param sizeIndices Index size: 1 (byte), 2 (short), 4 (int)
     * @return 0 on success, or -1 if the operation is not supported
     * @see #SDL_RenderGeometry(SDL_Renderer, SDL_Texture, List, int[])
     * @see SDL_Vertex
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_RenderGeometryRaw(
            SDL_Renderer renderer,
            SDL_Texture texture,
            Pointer xy,
            int xyStride,
            Pointer color,
            int colorStride,
            Pointer uv,
            int uvStride,
            int numVertices,
            Pointer indices,
            int numIndices,
            int sizeIndices);

    /**
     * Read pixels from the current rendering target to an array of pixels.
     *
     * <p><b>WARNING:</b> This is a very slow operation, and should not be used
     * frequently. If you're using this on the main rendering target, it should be
     * called after rendering and before SDL_RenderPresent().</p>
     *
     * <p>{@code pitch} specifies the number of bytes between rows in the destination
     * {@code pixels} data. This allows you to write to a subrectangle or have padded
     * rows in the destination. Generally, {@code pitch} should equal the number of
     * pixels per row in the {@code pixels} data times the number of bytes per pixel,
     * but it might contain additional padding (for example, 24bit RGB Windows
     * Bitmap data pads all rows to multiples of 4 bytes).</p>
     *
     * @param renderer the rendering context
     * @param rect     an SDL_Rect structure representing the area to read, or null
     *                 for the entire render target
     * @param format   an SDL_PixelFormatEnum value of the desired format of the
     *                 pixel data, or 0 to use the format of the rendering target
     * @param pixels   a pointer to the pixel data to copy into
     * @param pitch    the pitch of the {@code pixels} parameter
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RenderReadPixels(
            SDL_Renderer renderer,
            SDL_Rect rect,
            int format,
            Pointer pixels,
            int pitch);

    /**
     * Update the screen with any rendering performed since the previous call.
     *
     * <p>SDL's rendering functions operate on a backbuffer; that is, calling a
     * rendering function such as SDL_RenderDrawLine() does not directly put a
     * line on the screen, but rather updates the backbuffer. As such, you compose
     * your entire scene and *present* the composed backbuffer to the screen as a
     * complete picture.</p>
     *
     * <p>Therefore, when using SDL's rendering API, one does all drawing intended
     * for the frame, and then calls this function once per frame to present the
     * final drawing to the user.</p>
     *
     * <p>The backbuffer should be considered invalidated after each present; do not
     * assume that previous contents will exist between frames. You are strongly
     * encouraged to call SDL_RenderClear() to initialize the backbuffer before
     * starting each new frame's drawing, even if you plan to overwrite every
     * pixel.</p>
     *
     * <p>You may only call this function on the main thread. If this
     * happens to work on a background thread on any given platform
     * or backend, it's purely by luck and you should not rely on it
     * to work next time.</p>
     *
     * @param renderer the rendering context
     * @see #SDL_RenderClear(SDL_Renderer)
     * @see #SDL_RenderDrawLine(SDL_Renderer, int, int, int, int)
     * @see #SDL_RenderDrawLines(SDL_Renderer, List)
     * @see #SDL_RenderDrawPoint(SDL_Renderer, int, int)
     * @see #SDL_RenderDrawPoints(SDL_Renderer, List)
     * @see #SDL_RenderDrawRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderDrawRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_RenderFillRect(SDL_Renderer, SDL_Rect)
     * @see #SDL_RenderFillRects(SDL_Renderer, ContiguousArrayList)
     * @see #SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see #SDL_SetRenderDrawColor(SDL_Renderer, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_RenderPresent(
            SDL_Renderer renderer);

    /**
     * Destroy the specified texture.
     *
     * <p>Passing null or an otherwise invalid texture will set the SDL error message
     * to "Invalid texture".</p>
     *
     * @param texture the texture to destroy
     * @see #SDL_CreateTexture(SDL_Renderer, int, int, int, int)
     * @see #SDL_CreateTextureFromSurface(SDL_Renderer, SDL_Surface)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_DestroyTexture(
            SDL_Texture texture);

    /**
     * Destroy the rendering context for a window and free associated textures.
     *
     * If {@code renderer} is null, this function will return immediately after setting
     * the SDL error message to "Invalid renderer". See SDL_GetError().
     *
     * @param renderer the rendering context
     * @see #SDL_CreateRenderer(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_DestroyRenderer(
            SDL_Renderer renderer);

    /**
     * Force the rendering context to flush any pending commands to the underlying
     * rendering API.
     *
     * <p>You do not need to (and in fact, shouldn't) call this function unless you
     * are planning to call into OpenGL/Direct3D/Metal/whatever directly in
     * addition to using an SDL_Renderer.</p>
     *
     * <p>This is for a very-specific case: if you are using SDL's render API, you
     * asked for a specific renderer backend (OpenGL, Direct3D, etc), you set
     * SDL_HINT_RENDER_BATCHING to "1", and you plan to make OpenGL/D3D/whatever
     * calls in addition to SDL render API calls. If all of this applies, you
     * should call SDL_RenderFlush() between calls to SDL's render API and the
     * low-level API you're using in cooperation.</p>
     *
     * <p>In all other cases, you can ignore this function. This is only here to get
     * maximum performance out of a specific situation. In all other cases, SDL
     * will do the right thing, perhaps at a performance loss.</p>
     *
     * <p>This function is first available in SDL 2.0.10, and is not needed in 2.0.9
     * and earlier, as earlier versions did not queue rendering commands at all,
     * instead flushing them to the OS immediately.</p>
     *
     * @param renderer the rendering context
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.10.
     */
    public static native int SDL_RenderFlush(
            SDL_Renderer renderer);

    /**
     * Bind an OpenGL/ES/ES2 texture to the current context.
     *
     * <p>This is for use with OpenGL instructions when rendering OpenGL primitives
     * directly.</p>
     *
     * <p>If not null, {@code texw} and {@code texh} will be filled with the width and height
     * values suitable for the provided texture. In most cases, both will be 1.0,
     * however, on systems that support the GL_ARB_texture_rectangle extension,
     * these values will actually be the pixel width and height used to create the
     * texture, so this factor needs to be taken into account when providing
     * texture coordinates to OpenGL.</p>
     *
     * <p>You need a renderer to create an SDL_Texture, therefore you can only use
     * this function with an implicit OpenGL context from SDL_CreateRenderer(),
     * not with your own OpenGL context. If you need control over your OpenGL
     * context, you need to write your own texture-loading methods.</p>
     *
     * <p>Also note that SDL may upload RGB textures as BGR (or vice-versa), and
     * re-order the color channels in the shaders phase, so the uploaded texture
     * may have swapped color channels.</p>
     *
     * @param texture the texture to bind to the current OpenGL/ES/ES2 context
     * @param texw    a pointer to a float value which will be filled with the
     *                texture width or null if you don't need that value
     * @param texh    a pointer to a float value which will be filled with the
     *                texture height or null if you don't need that value
     * @return 0 on success, or -1 if the operation is not supported; call
     * SDL_GetError() for more information.
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_GL_MakeCurrent(SDL_Window, SDL_GLContext)
     * @see #SDL_GL_UnbindTexture(SDL_Texture)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_BindTexture(
            SDL_Texture texture,
            FloatByReference texw,
            FloatByReference texh);

    /**
     * Unbind an OpenGL/ES/ES2 texture from the current context.
     *
     * <p>See SDL_GL_BindTexture() for examples on how to use these functions</p>
     *
     * @param texture the texture to unbind from the current OpenGL/ES/ES2 context
     * @return 0 on success, or -1 if the operation is not supported
     * @see #SDL_GL_BindTexture(SDL_Texture, FloatByReference, FloatByReference)
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_GL_MakeCurrent(SDL_Window, SDL_GLContext)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GL_UnbindTexture(
            SDL_Texture texture);

    /**
     * Get the CAMetalLayer associated with the given Metal renderer.
     *
     * <p>This function returns raw pointer, so SDL doesn't have to include Metal's
     * headers, but it can be safely cast to a pointer to {@code CAMetalLayer}.</p>
     *
     * @param renderer The renderer to query
     * @return a pointer {@code CAMetalLayer} on success, or null if the renderer isn't a
     * Metal renderer
     * @see #SDL_RenderGetMetalCommandEncoder(SDL_Renderer)
     * @since This function is available since SDL 2.0.8.
     */
    public static native Pointer SDL_RenderGetMetalLayer(
            SDL_Renderer renderer);

    /**
     * Get the Metal command encoder for the current frame
     *
     * <p>This function returns raw pointer, so SDL doesn't have to include Metal's
     * headers, but it can be safely cast to an {@code id<MTLRenderCommandEncoder>}.</p>
     *
     * <p>Note that as of SDL 2.0.18, this will return null if Metal refuses to give
     * SDL a drawable to render to, which might happen if the window is
     * hidden/minimized/offscreen. This doesn't apply to command encoders for
     * render targets, just the window's backbuffer. Check your return values!</p>
     *
     * @param renderer The renderer to query
     * @return an {@code id<MTLRenderCommandEncoder>} on success, or null if the
     * renderer isn't a Metal renderer or there was an error.
     * @see #SDL_RenderGetMetalLayer(SDL_Renderer)
     * @since This function is available since SDL 2.0.8.
     */
    public static native Pointer SDL_RenderGetMetalCommandEncoder(
            SDL_Renderer renderer);

    /**
     * Toggle VSync of the given renderer.
     *
     * @param renderer The renderer to toggle
     * @param vsync    1 for on, 0 for off. All other values are reserved
     * @return a 0 int on success, or non-zero on failure
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_RenderSetVSync(
            SDL_Renderer renderer,
            int vsync);
}
