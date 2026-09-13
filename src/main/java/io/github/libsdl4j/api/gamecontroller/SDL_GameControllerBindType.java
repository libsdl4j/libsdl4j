package io.github.libsdl4j.api.gamecontroller;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_GameControllerBindType implements JnaEnum {

    public static final int SDL_CONTROLLER_BINDTYPE_NONE = 0;
    public static final int SDL_CONTROLLER_BINDTYPE_BUTTON = 1;
    public static final int SDL_CONTROLLER_BINDTYPE_AXIS = 2;
    public static final int SDL_CONTROLLER_BINDTYPE_HAT = 3;

    public static String toString(int value) {
        if (value == SDL_CONTROLLER_BINDTYPE_NONE) {
            return "SDL_CONTROLLER_BINDTYPE_NONE";
        } else if (value == SDL_CONTROLLER_BINDTYPE_BUTTON) {
            return "SDL_CONTROLLER_BINDTYPE_BUTTON";
        } else if (value == SDL_CONTROLLER_BINDTYPE_AXIS) {
            return "SDL_CONTROLLER_BINDTYPE_AXIS";
        } else if (value == SDL_CONTROLLER_BINDTYPE_HAT) {
            return "SDL_CONTROLLER_BINDTYPE_HAT";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_GameControllerBindType() {
    }
}
