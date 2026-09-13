package io.github.libsdl4j.api.hints;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * An enumeration of hint priorities
 */
public final class SDL_HintPriority implements JnaEnum {

    public static final int SDL_HINT_DEFAULT = 0;
    public static final int SDL_HINT_NORMAL = 1;
    public static final int SDL_HINT_OVERRIDE = 2;

    public static String toString(int value) {
        if (value == SDL_HINT_DEFAULT) {
            return "SDL_HINT_DEFAULT";
        } else if (value == SDL_HINT_NORMAL) {
            return "SDL_HINT_NORMAL";
        } else if (value == SDL_HINT_OVERRIDE) {
            return "SDL_HINT_OVERRIDE";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_HintPriority() {
    }
}
