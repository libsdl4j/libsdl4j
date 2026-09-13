package io.github.libsdl4j.api.event;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_eventaction implements JnaEnum {

    public static final int SDL_ADDEVENT = 0;
    public static final int SDL_PEEKEVENT = 1;
    public static final int SDL_GETEVENT = 2;

    public static String toString(int value) {
        if (value == SDL_ADDEVENT) {
            return "SDL_ADDEVENT";
        } else if (value == SDL_PEEKEVENT) {
            return "SDL_PEEKEVENT";
        } else if (value == SDL_GETEVENT) {
            return "SDL_GETEVENT";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_eventaction() {
    }
}
