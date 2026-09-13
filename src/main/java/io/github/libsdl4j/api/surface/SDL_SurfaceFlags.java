package io.github.libsdl4j.api.surface;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

public final class SDL_SurfaceFlags implements JnaEnum {

    /** Just here for compatibility */
    public static final int SDL_SWSURFACE = 0;

    /** Surface uses preallocated memory */
    public static final int SDL_PREALLOC = 0x00000001;

    /** Surface is RLE encoded */
    public static final int SDL_RLEACCEL = 0x00000002;

    /** Surface is referenced internally */
    public static final int SDL_DONTFREE = 0x00000004;

    /** Surface uses aligned memory */
    public static final int SDL_SIMD_ALIGNED = 0x00000008;

    public static String toString(int value) {
        if (value == SDL_SWSURFACE) {
            return "SDL_SWSURFACE";
        }
        StringBuilder result = new StringBuilder(16);
        if ((value & SDL_PREALLOC) > 0) {
            JnaUtils.append(result, "SDL_PREALLOC");
        }
        if ((value & SDL_RLEACCEL) > 0) {
            JnaUtils.append(result, "SDL_RLEACCEL");
        }
        if ((value & SDL_DONTFREE) > 0) {
            JnaUtils.append(result, "SDL_DONTFREE");
        }
        if ((value & SDL_SIMD_ALIGNED) > 0) {
            JnaUtils.append(result, "SDL_SIMD_ALIGNED");
        }
        if (result.length() != 0) {
            return result.toString();
        } else {
            return JnaUtils.flagsUnknown(value);
        }
    }

    private SDL_SurfaceFlags() {
    }
}
