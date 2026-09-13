package io.github.libsdl4j.api.surface;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The formula used for converting between YUV and RGB
 */
public final class SDL_YUV_CONVERSION_MODE implements JnaEnum {

    /** Full range JPEG */
    public static final int SDL_YUV_CONVERSION_JPEG = 0;

    /** BT.601 (the default) */
    public static final int SDL_YUV_CONVERSION_BT601 = 1;

    /** BT.709 */
    public static final int SDL_YUV_CONVERSION_BT709 = 2;

    /** BT.601 for SD content, BT.709 for HD content */
    public static final int SDL_YUV_CONVERSION_AUTOMATIC = 3;

    public static String toString(int value) {
        if (value == SDL_YUV_CONVERSION_JPEG) {
            return "SDL_YUV_CONVERSION_JPEG";
        } else if (value == SDL_YUV_CONVERSION_BT601) {
            return "SDL_YUV_CONVERSION_BT601";
        } else if (value == SDL_YUV_CONVERSION_BT709) {
            return "SDL_YUV_CONVERSION_BT709";
        } else if (value == SDL_YUV_CONVERSION_AUTOMATIC) {
            return "SDL_YUV_CONVERSION_AUTOMATIC";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_YUV_CONVERSION_MODE() {
    }
}
