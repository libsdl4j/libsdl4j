package io.github.libsdl4j.api.messagebox;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_MessageBoxColorType implements JnaEnum {

    public static final int SDL_MESSAGEBOX_COLOR_BACKGROUND = 0;
    public static final int SDL_MESSAGEBOX_COLOR_TEXT = 1;
    public static final int SDL_MESSAGEBOX_COLOR_BUTTON_BORDER = 2;
    public static final int SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND = 3;
    public static final int SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED = 4;

    public static String toString(int value) {
        if (value == SDL_MESSAGEBOX_COLOR_BACKGROUND) {
            return "SDL_MESSAGEBOX_COLOR_BACKGROUND";
        } else if (value == SDL_MESSAGEBOX_COLOR_TEXT) {
            return "SDL_MESSAGEBOX_COLOR_TEXT";
        } else if (value == SDL_MESSAGEBOX_COLOR_BUTTON_BORDER) {
            return "SDL_MESSAGEBOX_COLOR_BUTTON_BORDER";
        } else if (value == SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND) {
            return "SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND";
        } else if (value == SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED) {
            return "SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_MessageBoxColorType() {
    }
}
