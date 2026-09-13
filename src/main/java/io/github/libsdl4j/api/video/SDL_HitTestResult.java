package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Possible return values from the SDL_HitTest callback.
 *
 * @see SDL_HitTest
 */
public final class SDL_HitTestResult implements JnaEnum {

    /** Region is normal. No special properties. */
    public static final int SDL_HITTEST_NORMAL = 0;

    /** Region can drag entire window. */
    public static final int SDL_HITTEST_DRAGGABLE = 1;

    public static final int SDL_HITTEST_RESIZE_TOPLEFT = 2;
    public static final int SDL_HITTEST_RESIZE_TOP = 3;
    public static final int SDL_HITTEST_RESIZE_TOPRIGHT = 4;
    public static final int SDL_HITTEST_RESIZE_RIGHT = 5;
    public static final int SDL_HITTEST_RESIZE_BOTTOMRIGHT = 6;
    public static final int SDL_HITTEST_RESIZE_BOTTOM = 7;
    public static final int SDL_HITTEST_RESIZE_BOTTOMLEFT = 8;
    public static final int SDL_HITTEST_RESIZE_LEFT = 9;

    public static String toString(int value) {
        if (value == SDL_HITTEST_NORMAL) {
            return "SDL_HITTEST_NORMAL";
        } else if (value == SDL_HITTEST_DRAGGABLE) {
            return "SDL_HITTEST_DRAGGABLE";
        } else if (value == SDL_HITTEST_RESIZE_TOPLEFT) {
            return "SDL_HITTEST_RESIZE_TOPLEFT";
        } else if (value == SDL_HITTEST_RESIZE_TOP) {
            return "SDL_HITTEST_RESIZE_TOP";
        } else if (value == SDL_HITTEST_RESIZE_TOPRIGHT) {
            return "SDL_HITTEST_RESIZE_TOPRIGHT";
        } else if (value == SDL_HITTEST_RESIZE_RIGHT) {
            return "SDL_HITTEST_RESIZE_RIGHT";
        } else if (value == SDL_HITTEST_RESIZE_BOTTOMRIGHT) {
            return "SDL_HITTEST_RESIZE_BOTTOMRIGHT";
        } else if (value == SDL_HITTEST_RESIZE_BOTTOM) {
            return "SDL_HITTEST_RESIZE_BOTTOM";
        } else if (value == SDL_HITTEST_RESIZE_BOTTOMLEFT) {
            return "SDL_HITTEST_RESIZE_BOTTOMLEFT";
        } else if (value == SDL_HITTEST_RESIZE_LEFT) {
            return "SDL_HITTEST_RESIZE_LEFT";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_HitTestResult() {
    }
}
