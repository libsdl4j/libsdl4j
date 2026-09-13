package io.github.libsdl4j.api.gamecontroller;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_GameControllerType implements JnaEnum {

    public static final int SDL_CONTROLLER_TYPE_UNKNOWN = 0;
    public static final int SDL_CONTROLLER_TYPE_XBOX360 = 1;
    public static final int SDL_CONTROLLER_TYPE_XBOXONE = 2;
    public static final int SDL_CONTROLLER_TYPE_PS3 = 3;
    public static final int SDL_CONTROLLER_TYPE_PS4 = 4;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_PRO = 5;
    public static final int SDL_CONTROLLER_TYPE_VIRTUAL = 6;
    public static final int SDL_CONTROLLER_TYPE_PS5 = 7;
    public static final int SDL_CONTROLLER_TYPE_AMAZON_LUNA = 8;
    public static final int SDL_CONTROLLER_TYPE_GOOGLE_STADIA = 9;
    public static final int SDL_CONTROLLER_TYPE_NVIDIA_SHIELD = 10;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_LEFT = 11;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_RIGHT = 12;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_PAIR = 13;
    public static final int SDL_CONTROLLER_TYPE_MAX = 14;

    public static String toString(int value) {
        if (value == SDL_CONTROLLER_TYPE_UNKNOWN) {
            return "SDL_CONTROLLER_TYPE_UNKNOWN";
        } else if (value == SDL_CONTROLLER_TYPE_XBOX360) {
            return "SDL_CONTROLLER_TYPE_XBOX360";
        } else if (value == SDL_CONTROLLER_TYPE_XBOXONE) {
            return "SDL_CONTROLLER_TYPE_XBOXONE";
        } else if (value == SDL_CONTROLLER_TYPE_PS3) {
            return "SDL_CONTROLLER_TYPE_PS3";
        } else if (value == SDL_CONTROLLER_TYPE_PS4) {
            return "SDL_CONTROLLER_TYPE_PS4";
        } else if (value == SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_PRO) {
            return "SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_PRO";
        } else if (value == SDL_CONTROLLER_TYPE_VIRTUAL) {
            return "SDL_CONTROLLER_TYPE_VIRTUAL";
        } else if (value == SDL_CONTROLLER_TYPE_PS5) {
            return "SDL_CONTROLLER_TYPE_PS5";
        } else if (value == SDL_CONTROLLER_TYPE_AMAZON_LUNA) {
            return "SDL_CONTROLLER_TYPE_AMAZON_LUNA";
        } else if (value == SDL_CONTROLLER_TYPE_GOOGLE_STADIA) {
            return "SDL_CONTROLLER_TYPE_GOOGLE_STADIA";
        } else if (value == SDL_CONTROLLER_TYPE_NVIDIA_SHIELD) {
            return "SDL_CONTROLLER_TYPE_NVIDIA_SHIELD";
        } else if (value == SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_LEFT) {
            return "SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_LEFT";
        } else if (value == SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_RIGHT) {
            return "SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_RIGHT";
        } else if (value == SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_PAIR) {
            return "SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_PAIR";
        } else if (value == SDL_CONTROLLER_TYPE_MAX) {
            return "SDL_CONTROLLER_TYPE_MAX";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_GameControllerType() {
    }
}
