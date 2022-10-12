package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

/**
 * @apiNote Everything in the pixel format structure is read-only.
 */
@Structure.FieldOrder({
        "format",
        "palette",
        "bitsPerPixel",
        "bytesPerPixel",
        "padding0",
        "padding1",
        "rMask",
        "gMask",
        "bMask",
        "aMask",
        "rLoss",
        "gLoss",
        "bLoss",
        "aLoss",
        "rShift",
        "gShift",
        "bShift",
        "aShift",
        "refcount",
        "next"
})
public final class SDL_PixelFormat_internal extends Structure {

    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public int format;
    public SDL_Palette palette;
    public byte bitsPerPixel;
    public byte bytesPerPixel;
    public byte padding0;
    public byte padding1;
    public int rMask;
    public int gMask;
    public int bMask;
    public int aMask;
    public byte rLoss;
    public byte gLoss;
    public byte bLoss;
    public byte aLoss;
    public byte rShift;
    public byte gShift;
    public byte bShift;
    public byte aShift;
    public int refcount;
    public Pointer next;

    public SDL_PixelFormat_internal(Pointer p) {
        super(p);
    }
}
