package io.github.libsdl4j.api.rwops;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_RWopsType implements JnaEnum {

    /** Unknown stream type */
    public static final int SDL_RWOPS_UNKNOWN = 0;

    /** Win32 file */
    public static final int SDL_RWOPS_WINFILE = 1;

    /** Stdio file */
    public static final int SDL_RWOPS_STDFILE = 2;

    /** Android asset */
    public static final int SDL_RWOPS_JNIFILE = 3;

    /** Memory stream */
    public static final int SDL_RWOPS_MEMORY = 4;

    /** Read-Only memory stream */
    public static final int SDL_RWOPS_MEMORY_RO = 5;

    public static String toString(int value) {
        if (value == SDL_RWOPS_UNKNOWN) {
            return "SDL_RWOPS_UNKNOWN";
        } else if (value == SDL_RWOPS_WINFILE) {
            return "SDL_RWOPS_WINFILE";
        } else if (value == SDL_RWOPS_STDFILE) {
            return "SDL_RWOPS_STDFILE";
        } else if (value == SDL_RWOPS_JNIFILE) {
            return "SDL_RWOPS_JNIFILE";
        } else if (value == SDL_RWOPS_MEMORY) {
            return "SDL_RWOPS_MEMORY";
        } else if (value == SDL_RWOPS_MEMORY_RO) {
            return "SDL_RWOPS_MEMORY_RO";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_RWopsType() {
    }
}
