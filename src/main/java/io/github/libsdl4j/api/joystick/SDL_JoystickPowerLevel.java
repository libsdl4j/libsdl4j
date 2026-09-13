package io.github.libsdl4j.api.joystick;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_JoystickPowerLevel implements JnaEnum {

    public static final int SDL_JOYSTICK_POWER_UNKNOWN = -1;
    public static final int SDL_JOYSTICK_POWER_EMPTY = 0;
    public static final int SDL_JOYSTICK_POWER_LOW = 1;
    public static final int SDL_JOYSTICK_POWER_MEDIUM = 2;
    public static final int SDL_JOYSTICK_POWER_FULL = 3;
    public static final int SDL_JOYSTICK_POWER_WIRED = 4;
    public static final int SDL_JOYSTICK_POWER_MAX = 5;

    public static String toString(int value) {
        if (value == SDL_JOYSTICK_POWER_UNKNOWN) {
            return "SDL_JOYSTICK_POWER_UNKNOWN";
        } else if (value == SDL_JOYSTICK_POWER_EMPTY) {
            return "SDL_JOYSTICK_POWER_EMPTY";
        } else if (value == SDL_JOYSTICK_POWER_LOW) {
            return "SDL_JOYSTICK_POWER_LOW";
        } else if (value == SDL_JOYSTICK_POWER_MEDIUM) {
            return "SDL_JOYSTICK_POWER_MEDIUM";
        } else if (value == SDL_JOYSTICK_POWER_FULL) {
            return "SDL_JOYSTICK_POWER_FULL";
        } else if (value == SDL_JOYSTICK_POWER_WIRED) {
            return "SDL_JOYSTICK_POWER_WIRED";
        } else if (value == SDL_JOYSTICK_POWER_MAX) {
            return "SDL_JOYSTICK_POWER_MAX";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_JoystickPowerLevel() {
    }
}
