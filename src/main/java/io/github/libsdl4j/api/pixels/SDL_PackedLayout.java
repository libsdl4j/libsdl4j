package io.github.libsdl4j.api.pixels;

import io.github.libsdl4j.jna.JnaEnum;

/** Packed component layout. */
public final class SDL_PackedLayout implements JnaEnum {

    public static final int SDL_PACKEDLAYOUT_NONE = 0;
    public static final int SDL_PACKEDLAYOUT_332 = 1;
    public static final int SDL_PACKEDLAYOUT_4444 = 2;
    public static final int SDL_PACKEDLAYOUT_1555 = 3;
    public static final int SDL_PACKEDLAYOUT_5551 = 4;
    public static final int SDL_PACKEDLAYOUT_565 = 5;
    public static final int SDL_PACKEDLAYOUT_8888 = 6;
    public static final int SDL_PACKEDLAYOUT_2101010 = 7;
    public static final int SDL_PACKEDLAYOUT_1010102 = 8;

    public static String toString(int value) {
        if (value == SDL_PACKEDLAYOUT_NONE) {
            return "SDL_PACKEDLAYOUT_NONE";
        } else if (value == SDL_PACKEDLAYOUT_332) {
            return "SDL_PACKEDLAYOUT_332";
        } else if (value == SDL_PACKEDLAYOUT_4444) {
            return "SDL_PACKEDLAYOUT_4444";
        } else if (value == SDL_PACKEDLAYOUT_1555) {
            return "SDL_PACKEDLAYOUT_1555";
        } else if (value == SDL_PACKEDLAYOUT_5551) {
            return "SDL_PACKEDLAYOUT_5551";
        } else if (value == SDL_PACKEDLAYOUT_565) {
            return "SDL_PACKEDLAYOUT_565";
        } else if (value == SDL_PACKEDLAYOUT_8888) {
            return "SDL_PACKEDLAYOUT_8888";
        } else if (value == SDL_PACKEDLAYOUT_2101010) {
            return "SDL_PACKEDLAYOUT_2101010";
        } else if (value == SDL_PACKEDLAYOUT_1010102) {
            return "SDL_PACKEDLAYOUT_1010102";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_PackedLayout() {
    }
}
