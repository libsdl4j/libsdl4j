package io.github.libsdl4j.api.render;

import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.jna.JnaEnum;
import org.intellij.lang.annotations.MagicConstant;

/**
 * The scaling mode for a texture.
 */
public final class SDL_ScaleMode implements JnaEnum {

    /** nearest pixel sampling */
    public static final int SDL_ScaleModeNearest = 0;

    /** linear filtering */
    public static final int SDL_ScaleModeLinear = 1;

    /** anisotropic filtering */
    public static final int SDL_ScaleModeBest = 2;

    public static String toString(int value) {
        if (value == SDL_ScaleModeNearest) {
            return "SDL_ScaleModeNearest";
        } else if (value == SDL_ScaleModeLinear) {
            return "SDL_ScaleModeLinear";
        } else if (value == SDL_ScaleModeBest) {
            return "SDL_ScaleModeBest";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_ScaleMode() {
    }

    public static final class Ref extends IntByReference {

        public Ref() {
        }

        public Ref(int ordinal) {
            super(ordinal);
        }

        @Override
        public void setValue(
                @MagicConstant(valuesFromClass = SDL_ScaleMode.class) int value) {
            super.setValue(value);
        }

        @Override
        @SuppressWarnings("MagicConstant")
        @MagicConstant(valuesFromClass = SDL_ScaleMode.class)
        public int getValue() {
            return super.getValue();
        }
    }
}
