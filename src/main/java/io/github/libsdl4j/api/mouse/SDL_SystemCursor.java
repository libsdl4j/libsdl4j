package io.github.libsdl4j.api.mouse;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Cursor types for SDL_CreateSystemCursor().
 */
public final class SDL_SystemCursor implements JnaEnum {

    /** Arrow */
    public static final int SDL_SYSTEM_CURSOR_ARROW = 0;

    /** I-beam */
    public static final int SDL_SYSTEM_CURSOR_IBEAM = 1;

    /** Wait */
    public static final int SDL_SYSTEM_CURSOR_WAIT = 2;

    /** Crosshair */
    public static final int SDL_SYSTEM_CURSOR_CROSSHAIR = 3;

    /** Small wait cursor (or Wait if not available) */
    public static final int SDL_SYSTEM_CURSOR_WAITARROW = 4;

    /** Double arrow pointing northwest and southeast */
    public static final int SDL_SYSTEM_CURSOR_SIZENWSE = 5;

    /** Double arrow pointing northeast and southwest */
    public static final int SDL_SYSTEM_CURSOR_SIZENESW = 6;

    /** Double arrow pointing west and east */
    public static final int SDL_SYSTEM_CURSOR_SIZEWE = 7;

    /** Double arrow pointing north and south */
    public static final int SDL_SYSTEM_CURSOR_SIZENS = 8;

    /** Four pointed arrow pointing north, south, east, and west */
    public static final int SDL_SYSTEM_CURSOR_SIZEALL = 9;

    /** Slashed circle or crossbones */
    public static final int SDL_SYSTEM_CURSOR_NO = 10;

    /** Hand */
    public static final int SDL_SYSTEM_CURSOR_HAND = 11;

    public static final int SDL_NUM_SYSTEM_CURSORS = 12;

    public static String toString(int value) {
        if (value == SDL_SYSTEM_CURSOR_ARROW) {
            return "SDL_SYSTEM_CURSOR_ARROW";
        } else if (value == SDL_SYSTEM_CURSOR_IBEAM) {
            return "SDL_SYSTEM_CURSOR_IBEAM";
        } else if (value == SDL_SYSTEM_CURSOR_WAIT) {
            return "SDL_SYSTEM_CURSOR_WAIT";
        } else if (value == SDL_SYSTEM_CURSOR_CROSSHAIR) {
            return "SDL_SYSTEM_CURSOR_CROSSHAIR";
        } else if (value == SDL_SYSTEM_CURSOR_WAITARROW) {
            return "SDL_SYSTEM_CURSOR_WAITARROW";
        } else if (value == SDL_SYSTEM_CURSOR_SIZENWSE) {
            return "SDL_SYSTEM_CURSOR_SIZENWSE";
        } else if (value == SDL_SYSTEM_CURSOR_SIZENESW) {
            return "SDL_SYSTEM_CURSOR_SIZENESW";
        } else if (value == SDL_SYSTEM_CURSOR_SIZEWE) {
            return "SDL_SYSTEM_CURSOR_SIZEWE";
        } else if (value == SDL_SYSTEM_CURSOR_SIZENS) {
            return "SDL_SYSTEM_CURSOR_SIZENS";
        } else if (value == SDL_SYSTEM_CURSOR_SIZEALL) {
            return "SDL_SYSTEM_CURSOR_SIZEALL";
        } else if (value == SDL_SYSTEM_CURSOR_NO) {
            return "SDL_SYSTEM_CURSOR_NO";
        } else if (value == SDL_SYSTEM_CURSOR_HAND) {
            return "SDL_SYSTEM_CURSOR_HAND";
        } else if (value == SDL_NUM_SYSTEM_CURSORS) {
            return "SDL_NUM_SYSTEM_CURSORS";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_SystemCursor() {
    }
}
