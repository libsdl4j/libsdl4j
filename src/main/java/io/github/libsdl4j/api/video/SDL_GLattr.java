package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * OpenGL configuration attributes.
 *
 * @see SdlVideo#SDL_GL_SetAttribute(int, int) SDL_GL_SetAttribute(SDL_GLattr, ...)
 */
public final class SDL_GLattr implements JnaEnum {

    public static final int SDL_GL_RED_SIZE = 0;
    public static final int SDL_GL_GREEN_SIZE = 1;
    public static final int SDL_GL_BLUE_SIZE = 2;
    public static final int SDL_GL_ALPHA_SIZE = 3;
    public static final int SDL_GL_BUFFER_SIZE = 4;
    public static final int SDL_GL_DOUBLEBUFFER = 5;
    public static final int SDL_GL_DEPTH_SIZE = 6;
    public static final int SDL_GL_STENCIL_SIZE = 7;
    public static final int SDL_GL_ACCUM_RED_SIZE = 8;
    public static final int SDL_GL_ACCUM_GREEN_SIZE = 9;
    public static final int SDL_GL_ACCUM_BLUE_SIZE = 10;
    public static final int SDL_GL_ACCUM_ALPHA_SIZE = 11;
    public static final int SDL_GL_STEREO = 12;
    public static final int SDL_GL_MULTISAMPLEBUFFERS = 13;
    public static final int SDL_GL_MULTISAMPLESAMPLES = 14;
    public static final int SDL_GL_ACCELERATED_VISUAL = 15;
    public static final int SDL_GL_RETAINED_BACKING = 16;
    public static final int SDL_GL_CONTEXT_MAJOR_VERSION = 17;
    public static final int SDL_GL_CONTEXT_MINOR_VERSION = 18;
    public static final int SDL_GL_CONTEXT_EGL = 19;

    /** @see SDL_GLcontextFlag */
    public static final int SDL_GL_CONTEXT_FLAGS = 20;

    /** @see SDL_GLprofile */
    public static final int SDL_GL_CONTEXT_PROFILE_MASK = 21;

    public static final int SDL_GL_SHARE_WITH_CURRENT_CONTEXT = 22;

    public static final int SDL_GL_FRAMEBUFFER_SRGB_CAPABLE = 23;

    /** @see SDL_GLcontextReleaseFlag */
    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR = 24;

    /** @see SDL_GLContextResetNotification */
    public static final int SDL_GL_CONTEXT_RESET_NOTIFICATION = 25;

    public static final int SDL_GL_CONTEXT_NO_ERROR = 26;

    public static final int SDL_GL_FLOATBUFFERS = 27;

    public static String toString(int value) {
        if (value == SDL_GL_RED_SIZE) {
            return "SDL_GL_RED_SIZE";
        } else if (value == SDL_GL_GREEN_SIZE) {
            return "SDL_GL_GREEN_SIZE";
        } else if (value == SDL_GL_BLUE_SIZE) {
            return "SDL_GL_BLUE_SIZE";
        } else if (value == SDL_GL_ALPHA_SIZE) {
            return "SDL_GL_ALPHA_SIZE";
        } else if (value == SDL_GL_BUFFER_SIZE) {
            return "SDL_GL_BUFFER_SIZE";
        } else if (value == SDL_GL_DOUBLEBUFFER) {
            return "SDL_GL_DOUBLEBUFFER";
        } else if (value == SDL_GL_DEPTH_SIZE) {
            return "SDL_GL_DEPTH_SIZE";
        } else if (value == SDL_GL_STENCIL_SIZE) {
            return "SDL_GL_STENCIL_SIZE";
        } else if (value == SDL_GL_ACCUM_RED_SIZE) {
            return "SDL_GL_ACCUM_RED_SIZE";
        } else if (value == SDL_GL_ACCUM_GREEN_SIZE) {
            return "SDL_GL_ACCUM_GREEN_SIZE";
        } else if (value == SDL_GL_ACCUM_BLUE_SIZE) {
            return "SDL_GL_ACCUM_BLUE_SIZE";
        } else if (value == SDL_GL_ACCUM_ALPHA_SIZE) {
            return "SDL_GL_ACCUM_ALPHA_SIZE";
        } else if (value == SDL_GL_STEREO) {
            return "SDL_GL_STEREO";
        } else if (value == SDL_GL_MULTISAMPLEBUFFERS) {
            return "SDL_GL_MULTISAMPLEBUFFERS";
        } else if (value == SDL_GL_MULTISAMPLESAMPLES) {
            return "SDL_GL_MULTISAMPLESAMPLES";
        } else if (value == SDL_GL_ACCELERATED_VISUAL) {
            return "SDL_GL_ACCELERATED_VISUAL";
        } else if (value == SDL_GL_RETAINED_BACKING) {
            return "SDL_GL_RETAINED_BACKING";
        } else if (value == SDL_GL_CONTEXT_MAJOR_VERSION) {
            return "SDL_GL_CONTEXT_MAJOR_VERSION";
        } else if (value == SDL_GL_CONTEXT_MINOR_VERSION) {
            return "SDL_GL_CONTEXT_MINOR_VERSION";
        } else if (value == SDL_GL_CONTEXT_EGL) {
            return "SDL_GL_CONTEXT_EGL";
        } else if (value == SDL_GL_CONTEXT_FLAGS) {
            return "SDL_GL_CONTEXT_FLAGS";
        } else if (value == SDL_GL_CONTEXT_PROFILE_MASK) {
            return "SDL_GL_CONTEXT_PROFILE_MASK";
        } else if (value == SDL_GL_SHARE_WITH_CURRENT_CONTEXT) {
            return "SDL_GL_SHARE_WITH_CURRENT_CONTEXT";
        } else if (value == SDL_GL_FRAMEBUFFER_SRGB_CAPABLE) {
            return "SDL_GL_FRAMEBUFFER_SRGB_CAPABLE";
        } else if (value == SDL_GL_CONTEXT_RELEASE_BEHAVIOR) {
            return "SDL_GL_CONTEXT_RELEASE_BEHAVIOR";
        } else if (value == SDL_GL_CONTEXT_RESET_NOTIFICATION) {
            return "SDL_GL_CONTEXT_RESET_NOTIFICATION";
        } else if (value == SDL_GL_CONTEXT_NO_ERROR) {
            return "SDL_GL_CONTEXT_NO_ERROR";
        } else if (value == SDL_GL_FLOATBUFFERS) {
            return "SDL_GL_FLOATBUFFERS";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_GLattr() {
    }
}
