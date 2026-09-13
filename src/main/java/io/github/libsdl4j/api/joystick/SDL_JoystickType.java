package io.github.libsdl4j.api.joystick;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_JoystickType implements JnaEnum {

    public static final int SDL_JOYSTICK_TYPE_UNKNOWN = 0;
    public static final int SDL_JOYSTICK_TYPE_GAMECONTROLLER = 1;
    public static final int SDL_JOYSTICK_TYPE_WHEEL = 2;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_STICK = 3;
    public static final int SDL_JOYSTICK_TYPE_FLIGHT_STICK = 4;
    public static final int SDL_JOYSTICK_TYPE_DANCE_PAD = 5;
    public static final int SDL_JOYSTICK_TYPE_GUITAR = 6;
    public static final int SDL_JOYSTICK_TYPE_DRUM_KIT = 7;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_PAD = 8;
    public static final int SDL_JOYSTICK_TYPE_THROTTLE = 9;

    public static String toString(int value) {
        if (value == SDL_JOYSTICK_TYPE_UNKNOWN) {
            return "SDL_JOYSTICK_TYPE_UNKNOWN";
        } else if (value == SDL_JOYSTICK_TYPE_GAMECONTROLLER) {
            return "SDL_JOYSTICK_TYPE_GAMECONTROLLER";
        } else if (value == SDL_JOYSTICK_TYPE_WHEEL) {
            return "SDL_JOYSTICK_TYPE_WHEEL";
        } else if (value == SDL_JOYSTICK_TYPE_ARCADE_STICK) {
            return "SDL_JOYSTICK_TYPE_ARCADE_STICK";
        } else if (value == SDL_JOYSTICK_TYPE_FLIGHT_STICK) {
            return "SDL_JOYSTICK_TYPE_FLIGHT_STICK";
        } else if (value == SDL_JOYSTICK_TYPE_DANCE_PAD) {
            return "SDL_JOYSTICK_TYPE_DANCE_PAD";
        } else if (value == SDL_JOYSTICK_TYPE_GUITAR) {
            return "SDL_JOYSTICK_TYPE_GUITAR";
        } else if (value == SDL_JOYSTICK_TYPE_DRUM_KIT) {
            return "SDL_JOYSTICK_TYPE_DRUM_KIT";
        } else if (value == SDL_JOYSTICK_TYPE_ARCADE_PAD) {
            return "SDL_JOYSTICK_TYPE_ARCADE_PAD";
        } else if (value == SDL_JOYSTICK_TYPE_THROTTLE) {
            return "SDL_JOYSTICK_TYPE_THROTTLE";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_JoystickType() {
    }
}
