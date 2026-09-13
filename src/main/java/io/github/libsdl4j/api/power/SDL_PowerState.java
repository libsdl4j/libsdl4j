package io.github.libsdl4j.api.power;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The basic state for the system's power supply.
 */
public final class SDL_PowerState implements JnaEnum {

    /** cannot determine power status */
    public static final int SDL_POWERSTATE_UNKNOWN = 0;

    /** Not plugged in, running on the battery */
    public static final int SDL_POWERSTATE_ON_BATTERY = 1;

    /** Plugged in, no battery available */
    public static final int SDL_POWERSTATE_NO_BATTERY = 2;

    /** Plugged in, charging battery */
    public static final int SDL_POWERSTATE_CHARGING = 3;

    /** Plugged in, battery charged */
    public static final int SDL_POWERSTATE_CHARGED = 4;

    public static String toString(int value) {
        if (value == SDL_POWERSTATE_UNKNOWN) {
            return "SDL_POWERSTATE_UNKNOWN";
        } else if (value == SDL_POWERSTATE_ON_BATTERY) {
            return "SDL_POWERSTATE_ON_BATTERY";
        } else if (value == SDL_POWERSTATE_NO_BATTERY) {
            return "SDL_POWERSTATE_NO_BATTERY";
        } else if (value == SDL_POWERSTATE_CHARGING) {
            return "SDL_POWERSTATE_CHARGING";
        } else if (value == SDL_POWERSTATE_CHARGED) {
            return "SDL_POWERSTATE_CHARGED";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_PowerState() {
    }
}
