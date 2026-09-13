package io.github.libsdl4j.api.gamecontroller;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The list of axes available from a controller
 *
 * <p>Thumbstick axis values range from SDL_JOYSTICK_AXIS_MIN to SDL_JOYSTICK_AXIS_MAX,
 * and are centered within ~8000 of zero, though advanced UI will allow users to set
 * or autodetect the dead zone, which varies between controllers.</p>
 *
 * <p>Trigger axis values range from 0 to SDL_JOYSTICK_AXIS_MAX.</p>
 */
public final class SDL_GameControllerAxis implements JnaEnum {

    public static final int SDL_CONTROLLER_AXIS_INVALID = -1;
    public static final int SDL_CONTROLLER_AXIS_LEFTX = 0;
    public static final int SDL_CONTROLLER_AXIS_LEFTY = 1;
    public static final int SDL_CONTROLLER_AXIS_RIGHTX = 2;
    public static final int SDL_CONTROLLER_AXIS_RIGHTY = 3;
    public static final int SDL_CONTROLLER_AXIS_TRIGGERLEFT = 4;
    public static final int SDL_CONTROLLER_AXIS_TRIGGERRIGHT = 5;
    public static final int SDL_CONTROLLER_AXIS_MAX = 6;

    public static String toString(int value) {
        if (value == SDL_CONTROLLER_AXIS_INVALID) {
            return "SDL_CONTROLLER_AXIS_INVALID";
        } else if (value == SDL_CONTROLLER_AXIS_LEFTX) {
            return "SDL_CONTROLLER_AXIS_LEFTX";
        } else if (value == SDL_CONTROLLER_AXIS_LEFTY) {
            return "SDL_CONTROLLER_AXIS_LEFTY";
        } else if (value == SDL_CONTROLLER_AXIS_RIGHTX) {
            return "SDL_CONTROLLER_AXIS_RIGHTX";
        } else if (value == SDL_CONTROLLER_AXIS_RIGHTY) {
            return "SDL_CONTROLLER_AXIS_RIGHTY";
        } else if (value == SDL_CONTROLLER_AXIS_TRIGGERLEFT) {
            return "SDL_CONTROLLER_AXIS_TRIGGERLEFT";
        } else if (value == SDL_CONTROLLER_AXIS_TRIGGERRIGHT) {
            return "SDL_CONTROLLER_AXIS_TRIGGERRIGHT";
        } else if (value == SDL_CONTROLLER_AXIS_MAX) {
            return "SDL_CONTROLLER_AXIS_MAX";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_GameControllerAxis() {
    }
}
