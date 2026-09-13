package io.github.libsdl4j.api.sensor;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The different sensors defined by SDL
 *
 * Additional sensors may be available, using platform dependent semantics.
 *
 * Hare are the additional Android sensors:
 * https://developer.android.com/reference/android/hardware/SensorEvent.html#values
 */
public final class SDL_SensorType implements JnaEnum {

    /** Returned for an invalid sensor */
    public static final int SDL_SENSOR_INVALID = -1;

    /** Unknown sensor type */
    public static final int SDL_SENSOR_UNKNOWN = 0;

    /** Accelerometer */
    public static final int SDL_SENSOR_ACCEL = 1;

    /** Gyroscope */
    public static final int SDL_SENSOR_GYRO = 2;

    /** Accelerometer for left Joy-Con controller and Wii nunchuk */
    public static final int SDL_SENSOR_ACCEL_L = 3;

    /** Gyroscope for left Joy-Con controller */
    public static final int SDL_SENSOR_GYRO_L = 4;

    /** Accelerometer for right Joy-Con controller */
    public static final int SDL_SENSOR_ACCEL_R = 5;

    /** Gyroscope for right Joy-Con controller */
    public static final int SDL_SENSOR_GYRO_R = 6;

    public static String toString(int value) {
        if (value == SDL_SENSOR_INVALID) {
            return "SDL_SENSOR_INVALID";
        } else if (value == SDL_SENSOR_UNKNOWN) {
            return "SDL_SENSOR_UNKNOWN";
        } else if (value == SDL_SENSOR_ACCEL) {
            return "SDL_SENSOR_ACCEL";
        } else if (value == SDL_SENSOR_GYRO) {
            return "SDL_SENSOR_GYRO";
        } else if (value == SDL_SENSOR_ACCEL_L) {
            return "SDL_SENSOR_ACCEL_L";
        } else if (value == SDL_SENSOR_GYRO_L) {
            return "SDL_SENSOR_GYRO_L";
        } else if (value == SDL_SENSOR_ACCEL_R) {
            return "SDL_SENSOR_ACCEL_R";
        } else if (value == SDL_SENSOR_GYRO_R) {
            return "SDL_SENSOR_GYRO_R";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_SensorType() {
    }
}
