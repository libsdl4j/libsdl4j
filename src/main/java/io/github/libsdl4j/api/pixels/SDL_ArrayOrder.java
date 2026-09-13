package io.github.libsdl4j.api.pixels;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Array component order, low byte to high byte.
 */
public final class SDL_ArrayOrder implements JnaEnum {

    public static final int SDL_ARRAYORDER_NONE = 0;
    public static final int SDL_ARRAYORDER_RGB = 1;
    public static final int SDL_ARRAYORDER_RGBA = 2;
    public static final int SDL_ARRAYORDER_ARGB = 3;
    public static final int SDL_ARRAYORDER_BGR = 4;
    public static final int SDL_ARRAYORDER_BGRA = 5;
    public static final int SDL_ARRAYORDER_ABGR = 6;

    public static String toString(int value) {
        if (value == SDL_ARRAYORDER_NONE) {
            return "SDL_ARRAYORDER_NONE";
        } else if (value == SDL_ARRAYORDER_RGB) {
            return "SDL_ARRAYORDER_RGB";
        } else if (value == SDL_ARRAYORDER_RGBA) {
            return "SDL_ARRAYORDER_RGBA";
        } else if (value == SDL_ARRAYORDER_ARGB) {
            return "SDL_ARRAYORDER_ARGB";
        } else if (value == SDL_ARRAYORDER_BGR) {
            return "SDL_ARRAYORDER_BGR";
        } else if (value == SDL_ARRAYORDER_BGRA) {
            return "SDL_ARRAYORDER_BGRA";
        } else if (value == SDL_ARRAYORDER_ABGR) {
            return "SDL_ARRAYORDER_ABGR";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_ArrayOrder() {
    }
}
