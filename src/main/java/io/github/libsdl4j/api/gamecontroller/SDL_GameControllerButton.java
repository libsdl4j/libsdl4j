package io.github.libsdl4j.api.gamecontroller;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The list of buttons available from a controller
 */
public final class SDL_GameControllerButton implements JnaEnum {

    public static final int SDL_CONTROLLER_BUTTON_INVALID = -1;
    public static final int SDL_CONTROLLER_BUTTON_A = 0;
    public static final int SDL_CONTROLLER_BUTTON_B = 1;
    public static final int SDL_CONTROLLER_BUTTON_X = 2;
    public static final int SDL_CONTROLLER_BUTTON_Y = 3;
    public static final int SDL_CONTROLLER_BUTTON_BACK = 4;
    public static final int SDL_CONTROLLER_BUTTON_GUIDE = 5;
    public static final int SDL_CONTROLLER_BUTTON_START = 6;
    public static final int SDL_CONTROLLER_BUTTON_LEFTSTICK = 7;
    public static final int SDL_CONTROLLER_BUTTON_RIGHTSTICK = 8;
    public static final int SDL_CONTROLLER_BUTTON_LEFTSHOULDER = 9;
    public static final int SDL_CONTROLLER_BUTTON_RIGHTSHOULDER = 10;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_UP = 11;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_DOWN = 12;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_LEFT = 13;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_RIGHT = 14;

    /**
     * Xbox Series X share button, PS5 microphone button, Nintendo Switch Pro capture button, Amazon Luna microphone button
     */
    public static final int SDL_CONTROLLER_BUTTON_MISC1 = 15;

    /**
     * Xbox Elite paddle P1 (upper left, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE1 = 16;

    /**
     * Xbox Elite paddle P3 (upper right, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE2 = 17;

    /**
     * Xbox Elite paddle P2 (lower left, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE3 = 18;

    /**
     * Xbox Elite paddle P4 (lower right, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE4 = 19;

    /**
     * PS4/PS5 touchpad button
     */
    public static final int SDL_CONTROLLER_BUTTON_TOUCHPAD = 20;
    public static final int SDL_CONTROLLER_BUTTON_MAX = 21;

    public static String toString(int value) {
        if (value == SDL_CONTROLLER_BUTTON_INVALID) {
            return "SDL_CONTROLLER_BUTTON_INVALID";
        } else if (value == SDL_CONTROLLER_BUTTON_A) {
            return "SDL_CONTROLLER_BUTTON_A";
        } else if (value == SDL_CONTROLLER_BUTTON_B) {
            return "SDL_CONTROLLER_BUTTON_B";
        } else if (value == SDL_CONTROLLER_BUTTON_X) {
            return "SDL_CONTROLLER_BUTTON_X";
        } else if (value == SDL_CONTROLLER_BUTTON_Y) {
            return "SDL_CONTROLLER_BUTTON_Y";
        } else if (value == SDL_CONTROLLER_BUTTON_BACK) {
            return "SDL_CONTROLLER_BUTTON_BACK";
        } else if (value == SDL_CONTROLLER_BUTTON_GUIDE) {
            return "SDL_CONTROLLER_BUTTON_GUIDE";
        } else if (value == SDL_CONTROLLER_BUTTON_START) {
            return "SDL_CONTROLLER_BUTTON_START";
        } else if (value == SDL_CONTROLLER_BUTTON_LEFTSTICK) {
            return "SDL_CONTROLLER_BUTTON_LEFTSTICK";
        } else if (value == SDL_CONTROLLER_BUTTON_RIGHTSTICK) {
            return "SDL_CONTROLLER_BUTTON_RIGHTSTICK";
        } else if (value == SDL_CONTROLLER_BUTTON_LEFTSHOULDER) {
            return "SDL_CONTROLLER_BUTTON_LEFTSHOULDER";
        } else if (value == SDL_CONTROLLER_BUTTON_RIGHTSHOULDER) {
            return "SDL_CONTROLLER_BUTTON_RIGHTSHOULDER";
        } else if (value == SDL_CONTROLLER_BUTTON_DPAD_UP) {
            return "SDL_CONTROLLER_BUTTON_DPAD_UP";
        } else if (value == SDL_CONTROLLER_BUTTON_DPAD_DOWN) {
            return "SDL_CONTROLLER_BUTTON_DPAD_DOWN";
        } else if (value == SDL_CONTROLLER_BUTTON_DPAD_LEFT) {
            return "SDL_CONTROLLER_BUTTON_DPAD_LEFT";
        } else if (value == SDL_CONTROLLER_BUTTON_DPAD_RIGHT) {
            return "SDL_CONTROLLER_BUTTON_DPAD_RIGHT";
        } else if (value == SDL_CONTROLLER_BUTTON_MISC1) {
            return "SDL_CONTROLLER_BUTTON_MISC1";
        } else if (value == SDL_CONTROLLER_BUTTON_PADDLE1) {
            return "SDL_CONTROLLER_BUTTON_PADDLE1";
        } else if (value == SDL_CONTROLLER_BUTTON_PADDLE2) {
            return "SDL_CONTROLLER_BUTTON_PADDLE2";
        } else if (value == SDL_CONTROLLER_BUTTON_PADDLE3) {
            return "SDL_CONTROLLER_BUTTON_PADDLE3";
        } else if (value == SDL_CONTROLLER_BUTTON_PADDLE4) {
            return "SDL_CONTROLLER_BUTTON_PADDLE4";
        } else if (value == SDL_CONTROLLER_BUTTON_TOUCHPAD) {
            return "SDL_CONTROLLER_BUTTON_TOUCHPAD";
        } else if (value == SDL_CONTROLLER_BUTTON_MAX) {
            return "SDL_CONTROLLER_BUTTON_MAX";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_GameControllerButton() {
    }
}
