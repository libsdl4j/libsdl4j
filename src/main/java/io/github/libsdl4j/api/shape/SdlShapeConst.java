package io.github.libsdl4j.api.shape;

public final class SdlShapeConst {

    public static final int SDL_NONSHAPEABLE_WINDOW = -1;
    public static final int SDL_INVALID_SHAPE_ARGUMENT = -2;
    public static final int SDL_WINDOW_LACKS_SHAPE = -3;

    public static String toString(int value) {
        if (value == SDL_NONSHAPEABLE_WINDOW) {
            return "SDL_NONSHAPEABLE_WINDOW";
        } else if (value == SDL_INVALID_SHAPE_ARGUMENT) {
            return "SDL_INVALID_SHAPE_ARGUMENT";
        } else if (value == SDL_WINDOW_LACKS_SHAPE) {
            return "SDL_WINDOW_LACKS_SHAPE";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SdlShapeConst() {
    }
}
