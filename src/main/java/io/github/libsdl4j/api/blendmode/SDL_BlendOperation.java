package io.github.libsdl4j.api.blendmode;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The blend operation used when combining source and destination pixel components
 */
public final class SDL_BlendOperation implements JnaEnum {

    /** dst + src: supported by all renderers */
    public static final int SDL_BLENDOPERATION_ADD = 0x1;

    /** dst - src : supported by D3D9, D3D11, OpenGL, OpenGLES */
    public static final int SDL_BLENDOPERATION_SUBTRACT = 0x2;

    /** src - dst : supported by D3D9, D3D11, OpenGL, OpenGLES */
    public static final int SDL_BLENDOPERATION_REV_SUBTRACT = 0x3;

    /** min(dst, src) : supported by D3D9, D3D11 */
    public static final int SDL_BLENDOPERATION_MINIMUM = 0x4;

    /** max(dst, src) : supported by D3D9, D3D11 */
    public static final int SDL_BLENDOPERATION_MAXIMUM = 0x5;

    public static String toString(int value) {
        if (value == SDL_BLENDOPERATION_ADD) {
            return "SDL_BLENDOPERATION_ADD";
        } else if (value == SDL_BLENDOPERATION_SUBTRACT) {
            return "SDL_BLENDOPERATION_SUBTRACT";
        } else if (value == SDL_BLENDOPERATION_REV_SUBTRACT) {
            return "SDL_BLENDOPERATION_REV_SUBTRACT";
        } else if (value == SDL_BLENDOPERATION_MINIMUM) {
            return "SDL_BLENDOPERATION_MINIMUM";
        } else if (value == SDL_BLENDOPERATION_MAXIMUM) {
            return "SDL_BLENDOPERATION_MAXIMUM";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_BlendOperation() {
    }
}
