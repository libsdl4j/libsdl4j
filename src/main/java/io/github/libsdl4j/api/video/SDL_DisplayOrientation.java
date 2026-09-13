package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Display orientation
 */
public final class SDL_DisplayOrientation implements JnaEnum {

    /** The display orientation can't be determined */
    public static final int SDL_ORIENTATION_UNKNOWN = 0;

    /** The display is in landscape mode, with the right side up, relative to portrait mode */
    public static final int SDL_ORIENTATION_LANDSCAPE = 1;

    /** The display is in landscape mode, with the left side up, relative to portrait mode */
    public static final int SDL_ORIENTATION_LANDSCAPE_FLIPPED = 2;

    /** The display is in portrait mode */
    public static final int SDL_ORIENTATION_PORTRAIT = 3;

    /** The display is in portrait mode, upside down */
    public static final int SDL_ORIENTATION_PORTRAIT_FLIPPED = 4;

    public static String toString(int value) {
        if (value == SDL_ORIENTATION_UNKNOWN) {
            return "SDL_ORIENTATION_UNKNOWN";
        } else if (value == SDL_ORIENTATION_LANDSCAPE) {
            return "SDL_ORIENTATION_LANDSCAPE";
        } else if (value == SDL_ORIENTATION_LANDSCAPE_FLIPPED) {
            return "SDL_ORIENTATION_LANDSCAPE_FLIPPED";
        } else if (value == SDL_ORIENTATION_PORTRAIT) {
            return "SDL_ORIENTATION_PORTRAIT";
        } else if (value == SDL_ORIENTATION_PORTRAIT_FLIPPED) {
            return "SDL_ORIENTATION_PORTRAIT_FLIPPED";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_DisplayOrientation() {
    }
}
