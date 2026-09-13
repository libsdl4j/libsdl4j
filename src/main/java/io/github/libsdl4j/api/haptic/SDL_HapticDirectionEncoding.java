package io.github.libsdl4j.api.haptic;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_HapticDirectionEncoding implements JnaEnum {

    /**
     * Uses polar coordinates for the direction.
     *
     * @see SDL_HapticDirection
     */
    public static final byte SDL_HAPTIC_POLAR = 0;

    /**
     * Uses cartesian coordinates for the direction.
     *
     * @see SDL_HapticDirection
     */
    public static final byte SDL_HAPTIC_CARTESIAN = 1;

    /**
     * Uses spherical coordinates for the direction.
     *
     * @see SDL_HapticDirection
     */
    public static final byte SDL_HAPTIC_SPHERICAL = 2;

    /**
     * Use this value to play an effect on the steering wheel axis. This
     * provides better compatibility across platforms and devices as SDL will guess
     * the correct axis.
     *
     * @see SDL_HapticDirection
     */
    public static final byte SDL_HAPTIC_STEERING_AXIS = 3;

    public static String toString(int value) {
        if (value == SDL_HAPTIC_POLAR) {
            return "SDL_HAPTIC_POLAR";
        } else if (value == SDL_HAPTIC_CARTESIAN) {
            return "SDL_HAPTIC_CARTESIAN";
        } else if (value == SDL_HAPTIC_SPHERICAL) {
            return "SDL_HAPTIC_SPHERICAL";
        } else if (value == SDL_HAPTIC_STEERING_AXIS) {
            return "SDL_HAPTIC_STEERING_AXIS";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_HapticDirectionEncoding() {
    }
}
