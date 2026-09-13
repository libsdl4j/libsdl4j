package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Window flash operation
 */
public final class SDL_FlashOperation implements JnaEnum {

    /** Cancel any window flash state */
    public static final int SDL_FLASH_CANCEL = 0;

    /** Flash the window briefly to get attention */
    public static final int SDL_FLASH_BRIEFLY = 1;

    /** Flash the window until it gets focus */
    public static final int SDL_FLASH_UNTIL_FOCUSED = 2;

    public static String toString(int value) {
        if (value == SDL_FLASH_CANCEL) {
            return "SDL_FLASH_CANCEL";
        } else if (value == SDL_FLASH_BRIEFLY) {
            return "SDL_FLASH_BRIEFLY";
        } else if (value == SDL_FLASH_UNTIL_FOCUSED) {
            return "SDL_FLASH_UNTIL_FOCUSED";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_FlashOperation() {
    }
}
