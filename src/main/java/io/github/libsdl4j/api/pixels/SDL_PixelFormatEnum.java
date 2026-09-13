package io.github.libsdl4j.api.pixels;

import io.github.libsdl4j.api.stdinc.SdlStdinc;
import io.github.libsdl4j.jna.JnaEnum;

import static io.github.libsdl4j.api.endian.SdlEndianConst.SDL_BIG_ENDIAN;
import static io.github.libsdl4j.api.endian.SdlEndianConst.SDL_BYTEORDER;
import static io.github.libsdl4j.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_ABGR;
import static io.github.libsdl4j.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_ARGB;
import static io.github.libsdl4j.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_BGR;
import static io.github.libsdl4j.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_BGRA;
import static io.github.libsdl4j.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_RGB;
import static io.github.libsdl4j.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_RGBA;
import static io.github.libsdl4j.api.pixels.SDL_BitmapOrder.SDL_BITMAPORDER_1234;
import static io.github.libsdl4j.api.pixels.SDL_BitmapOrder.SDL_BITMAPORDER_4321;
import static io.github.libsdl4j.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_1555;
import static io.github.libsdl4j.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_2101010;
import static io.github.libsdl4j.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_332;
import static io.github.libsdl4j.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_4444;
import static io.github.libsdl4j.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_5551;
import static io.github.libsdl4j.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_565;
import static io.github.libsdl4j.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_8888;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_ABGR;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_ARGB;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_BGRA;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_BGRX;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_RGBA;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_RGBX;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_XBGR;
import static io.github.libsdl4j.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_XRGB;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYF16;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYF32;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYU16;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYU32;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYU8;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_INDEX1;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_INDEX2;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_INDEX4;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_INDEX8;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_PACKED16;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_PACKED32;
import static io.github.libsdl4j.api.pixels.SDL_PixelType.SDL_PIXELTYPE_PACKED8;

public final class SDL_PixelFormatEnum implements JnaEnum {

    public static final int SDL_PIXELFORMAT_UNKNOWN = 0;
    public static final int SDL_PIXELFORMAT_INDEX1LSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX1, SDL_BITMAPORDER_4321, 0, 1, 0);
    public static final int SDL_PIXELFORMAT_INDEX1MSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX1, SDL_BITMAPORDER_1234, 0, 1, 0);
    public static final int SDL_PIXELFORMAT_INDEX2LSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX2, SDL_BITMAPORDER_4321, 0, 2, 0);
    public static final int SDL_PIXELFORMAT_INDEX2MSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX2, SDL_BITMAPORDER_1234, 0, 2, 0);
    public static final int SDL_PIXELFORMAT_INDEX4LSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX4, SDL_BITMAPORDER_4321, 0, 4, 0);
    public static final int SDL_PIXELFORMAT_INDEX4MSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX4, SDL_BITMAPORDER_1234, 0, 4, 0);
    public static final int SDL_PIXELFORMAT_INDEX8 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX8, 0, 0, 8, 1);
    public static final int SDL_PIXELFORMAT_RGB332 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED8, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_332, 8, 1);
    public static final int SDL_PIXELFORMAT_XRGB4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_4444, 12, 2);
    public static final int SDL_PIXELFORMAT_RGB444 = SDL_PIXELFORMAT_XRGB4444;
    public static final int SDL_PIXELFORMAT_XBGR4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_4444, 12, 2);
    public static final int SDL_PIXELFORMAT_BGR444 = SDL_PIXELFORMAT_XBGR4444;
    public static final int SDL_PIXELFORMAT_XRGB1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_1555, 15, 2);
    public static final int SDL_PIXELFORMAT_RGB555 = SDL_PIXELFORMAT_XRGB1555;
    public static final int SDL_PIXELFORMAT_XBGR1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_1555, 15, 2);
    public static final int SDL_PIXELFORMAT_BGR555 = SDL_PIXELFORMAT_XBGR1555;
    public static final int SDL_PIXELFORMAT_ARGB4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_RGBA4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_RGBA, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_ABGR4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ABGR, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_BGRA4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_BGRA, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_ARGB1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_1555, 16, 2);
    public static final int SDL_PIXELFORMAT_RGBA5551 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_RGBA, SDL_PACKEDLAYOUT_5551, 16, 2);
    public static final int SDL_PIXELFORMAT_ABGR1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ABGR, SDL_PACKEDLAYOUT_1555, 16, 2);
    public static final int SDL_PIXELFORMAT_BGRA5551 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_BGRA, SDL_PACKEDLAYOUT_5551, 16, 2);
    public static final int SDL_PIXELFORMAT_RGB565 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_565, 16, 2);
    public static final int SDL_PIXELFORMAT_BGR565 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_565, 16, 2);
    public static final int SDL_PIXELFORMAT_RGB24 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_ARRAYU8, SDL_ARRAYORDER_RGB, 0, 24, 3);
    public static final int SDL_PIXELFORMAT_BGR24 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_ARRAYU8, SDL_ARRAYORDER_BGR, 0, 24, 3);
    public static final int SDL_PIXELFORMAT_XRGB8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_RGB888 = SDL_PIXELFORMAT_XRGB8888;
    public static final int SDL_PIXELFORMAT_RGBX8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_RGBX, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_XBGR8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_BGR888 = SDL_PIXELFORMAT_XBGR8888;
    public static final int SDL_PIXELFORMAT_BGRX8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_BGRX, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_ARGB8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_RGBA8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_RGBA, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_ABGR8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ABGR, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_BGRA8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_BGRA, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_ARGB2101010 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_2101010, 32, 4);

    /* Aliases for RGBA byte arrays of color data, for the current platform */
    public static final int SDL_PIXELFORMAT_RGBA32;
    public static final int SDL_PIXELFORMAT_ARGB32;
    public static final int SDL_PIXELFORMAT_BGRA32;
    public static final int SDL_PIXELFORMAT_ABGR32;
    public static final int SDL_PIXELFORMAT_RGBX32;
    public static final int SDL_PIXELFORMAT_XRGB32;
    public static final int SDL_PIXELFORMAT_BGRX32;
    public static final int SDL_PIXELFORMAT_XBGR32;

    static {
        if (SDL_BYTEORDER == SDL_BIG_ENDIAN) {
            SDL_PIXELFORMAT_RGBA32 = SDL_PIXELFORMAT_RGBA8888;
            SDL_PIXELFORMAT_ARGB32 = SDL_PIXELFORMAT_ARGB8888;
            SDL_PIXELFORMAT_BGRA32 = SDL_PIXELFORMAT_BGRA8888;
            SDL_PIXELFORMAT_ABGR32 = SDL_PIXELFORMAT_ABGR8888;
            SDL_PIXELFORMAT_RGBX32 = SDL_PIXELFORMAT_RGBX8888;
            SDL_PIXELFORMAT_XRGB32 = SDL_PIXELFORMAT_XRGB8888;
            SDL_PIXELFORMAT_BGRX32 = SDL_PIXELFORMAT_BGRX8888;
            SDL_PIXELFORMAT_XBGR32 = SDL_PIXELFORMAT_XBGR8888;
        } else {
            SDL_PIXELFORMAT_RGBA32 = SDL_PIXELFORMAT_ABGR8888;
            SDL_PIXELFORMAT_ARGB32 = SDL_PIXELFORMAT_BGRA8888;
            SDL_PIXELFORMAT_BGRA32 = SDL_PIXELFORMAT_ARGB8888;
            SDL_PIXELFORMAT_ABGR32 = SDL_PIXELFORMAT_RGBA8888;
            SDL_PIXELFORMAT_RGBX32 = SDL_PIXELFORMAT_XBGR8888;
            SDL_PIXELFORMAT_XRGB32 = SDL_PIXELFORMAT_BGRX8888;
            SDL_PIXELFORMAT_BGRX32 = SDL_PIXELFORMAT_XRGB8888;
            SDL_PIXELFORMAT_XBGR32 = SDL_PIXELFORMAT_RGBX8888;
        }
    }

    /** Planar mode: Y + V + U  (3 planes) */
    public static final int SDL_PIXELFORMAT_YV12 = SDL_DEFINE_PIXELFOURCC('Y', 'V', '1', '2');

    /** Planar mode: Y + U + V  (3 planes) */
    public static final int SDL_PIXELFORMAT_IYUV = SDL_DEFINE_PIXELFOURCC('I', 'Y', 'U', 'V');

    /** Packed mode: Y0+U0+Y1+V0 (1 plane) */
    public static final int SDL_PIXELFORMAT_YUY2 = SDL_DEFINE_PIXELFOURCC('Y', 'U', 'Y', '2');

    /** Packed mode: U0+Y0+V0+Y1 (1 plane) */
    public static final int SDL_PIXELFORMAT_UYVY = SDL_DEFINE_PIXELFOURCC('U', 'Y', 'V', 'Y');

    /** Packed mode: Y0+V0+Y1+U0 (1 plane) */
    public static final int SDL_PIXELFORMAT_YVYU = SDL_DEFINE_PIXELFOURCC('Y', 'V', 'Y', 'U');

    /** Planar mode: Y + U/V interleaved  (2 planes) */
    public static final int SDL_PIXELFORMAT_NV12 = SDL_DEFINE_PIXELFOURCC('N', 'V', '1', '2');

    /** Planar mode: Y + V/U interleaved  (2 planes) */
    public static final int SDL_PIXELFORMAT_NV21 = SDL_DEFINE_PIXELFOURCC('N', 'V', '2', '1');

    /** Android video texture format */
    public static final int SDL_PIXELFORMAT_EXTERNAL_OES = SDL_DEFINE_PIXELFOURCC('O', 'E', 'S', ' ');

    public static int SDL_DEFINE_PIXELFOURCC(
            int a,
            int b,
            int c,
            int d) {
        return SdlStdinc.SDL_FOURCC(a, b, c, d);
    }

    public static int SDL_DEFINE_PIXELFORMAT(
            int type,
            int order,
            int layout,
            int bits,
            int bytes) {
        return (1 << 28) | (type << 24) | (order << 20) | (layout << 16) | (bits << 8) | bytes;
    }

    public static int SDL_PIXELFLAG(
            int x) {
        return (x >> 28) & 0x0F;
    }

    public static int SDL_PIXELTYPE(
            int x) {
        return (x >> 24) & 0x0F;
    }

    public static int SDL_PIXELORDER(
            final int x) {
        return (x >> 20) & 0x0F;
    }

    public static int SDL_PIXELLAYOUT(
            int x) {
        return (x >> 16) & 0x0F;
    }

    public static int SDL_BITSPERPIXEL(
            final int x) {
        return (x >> 8) & 0xFF;
    }

    public static int SDL_BYTESPERPIXEL(
            int x) {
        return (SDL_ISPIXELFORMAT_FOURCC(x)
                ? (((x == SDL_PIXELFORMAT_YUY2)
                || (x == SDL_PIXELFORMAT_UYVY)
                || (x == SDL_PIXELFORMAT_YVYU)) ? 2 : 1) : (x & 0xFF));
    }

    public static boolean SDL_ISPIXELFORMAT_INDEXED(
            int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX1)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX2)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX4)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX8)));
    }

    public static boolean SDL_ISPIXELFORMAT_PACKED(
            int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED8)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED32)));
    }

    public static boolean SDL_ISPIXELFORMAT_ARRAY(
            int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU8)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU32)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYF16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYF32)));
    }

    public static boolean SDL_ISPIXELFORMAT_ALPHA(
            int format) {
        return ((SDL_ISPIXELFORMAT_PACKED(format)
                && ((SDL_PIXELORDER(format) == SDL_PACKEDORDER_ARGB)
                || (SDL_PIXELORDER(format) == SDL_PACKEDORDER_RGBA)
                || (SDL_PIXELORDER(format) == SDL_PACKEDORDER_ABGR)
                || (SDL_PIXELORDER(format) == SDL_PACKEDORDER_BGRA)))
                || (SDL_ISPIXELFORMAT_ARRAY(format)
                && ((SDL_PIXELORDER(format) == SDL_ARRAYORDER_ARGB)
                || (SDL_PIXELORDER(format) == SDL_ARRAYORDER_RGBA)
                || (SDL_PIXELORDER(format) == SDL_ARRAYORDER_ABGR)
                || (SDL_PIXELORDER(format) == SDL_ARRAYORDER_BGRA))));
    }

    public static boolean SDL_ISPIXELFORMAT_FOURCC(
            int format) {
        return (format != 0) && (SDL_PIXELFLAG(format) != 1);
    }

    public static String toString(int value) {
        if (value == SDL_PIXELFORMAT_UNKNOWN) {
            return "SDL_PIXELFORMAT_UNKNOWN";
        } else if (value == SDL_PIXELFORMAT_INDEX1LSB) {
            return "SDL_PIXELFORMAT_INDEX1LSB";
        } else if (value == SDL_PIXELFORMAT_INDEX1MSB) {
            return "SDL_PIXELFORMAT_INDEX1MSB";
        } else if (value == SDL_PIXELFORMAT_INDEX2LSB) {
            return "SDL_PIXELFORMAT_INDEX2LSB";
        } else if (value == SDL_PIXELFORMAT_INDEX2MSB) {
            return "SDL_PIXELFORMAT_INDEX2MSB";
        } else if (value == SDL_PIXELFORMAT_INDEX4LSB) {
            return "SDL_PIXELFORMAT_INDEX4LSB";
        } else if (value == SDL_PIXELFORMAT_INDEX4MSB) {
            return "SDL_PIXELFORMAT_INDEX4MSB";
        } else if (value == SDL_PIXELFORMAT_INDEX8) {
            return "SDL_PIXELFORMAT_INDEX8";
        } else if (value == SDL_PIXELFORMAT_RGB332) {
            return "SDL_PIXELFORMAT_RGB332";
        } else if (value == SDL_PIXELFORMAT_XRGB4444) {
            return "SDL_PIXELFORMAT_XRGB4444";
        } else if (value == SDL_PIXELFORMAT_RGB444) {
            return "SDL_PIXELFORMAT_RGB444";
        } else if (value == SDL_PIXELFORMAT_XBGR4444) {
            return "SDL_PIXELFORMAT_XBGR4444";
        } else if (value == SDL_PIXELFORMAT_BGR444) {
            return "SDL_PIXELFORMAT_BGR444";
        } else if (value == SDL_PIXELFORMAT_XRGB1555) {
            return "SDL_PIXELFORMAT_XRGB1555";
        } else if (value == SDL_PIXELFORMAT_RGB555) {
            return "SDL_PIXELFORMAT_RGB555";
        } else if (value == SDL_PIXELFORMAT_XBGR1555) {
            return "SDL_PIXELFORMAT_XBGR1555";
        } else if (value == SDL_PIXELFORMAT_BGR555) {
            return "SDL_PIXELFORMAT_BGR555";
        } else if (value == SDL_PIXELFORMAT_ARGB4444) {
            return "SDL_PIXELFORMAT_ARGB4444";
        } else if (value == SDL_PIXELFORMAT_RGBA4444) {
            return "SDL_PIXELFORMAT_RGBA4444";
        } else if (value == SDL_PIXELFORMAT_ABGR4444) {
            return "SDL_PIXELFORMAT_ABGR4444";
        } else if (value == SDL_PIXELFORMAT_BGRA4444) {
            return "SDL_PIXELFORMAT_BGRA4444";
        } else if (value == SDL_PIXELFORMAT_ARGB1555) {
            return "SDL_PIXELFORMAT_ARGB1555";
        } else if (value == SDL_PIXELFORMAT_RGBA5551) {
            return "SDL_PIXELFORMAT_RGBA5551";
        } else if (value == SDL_PIXELFORMAT_ABGR1555) {
            return "SDL_PIXELFORMAT_ABGR1555";
        } else if (value == SDL_PIXELFORMAT_BGRA5551) {
            return "SDL_PIXELFORMAT_BGRA5551";
        } else if (value == SDL_PIXELFORMAT_RGB565) {
            return "SDL_PIXELFORMAT_RGB565";
        } else if (value == SDL_PIXELFORMAT_BGR565) {
            return "SDL_PIXELFORMAT_BGR565";
        } else if (value == SDL_PIXELFORMAT_RGB24) {
            return "SDL_PIXELFORMAT_RGB24";
        } else if (value == SDL_PIXELFORMAT_BGR24) {
            return "SDL_PIXELFORMAT_BGR24";
        } else if (value == SDL_PIXELFORMAT_XRGB8888) {
            return "SDL_PIXELFORMAT_XRGB8888";
        } else if (value == SDL_PIXELFORMAT_RGB888) {
            return "SDL_PIXELFORMAT_RGB888";
        } else if (value == SDL_PIXELFORMAT_RGBX8888) {
            return "SDL_PIXELFORMAT_RGBX8888";
        } else if (value == SDL_PIXELFORMAT_XBGR8888) {
            return "SDL_PIXELFORMAT_XBGR8888";
        } else if (value == SDL_PIXELFORMAT_BGR888) {
            return "SDL_PIXELFORMAT_BGR888";
        } else if (value == SDL_PIXELFORMAT_BGRX8888) {
            return "SDL_PIXELFORMAT_BGRX8888";
        } else if (value == SDL_PIXELFORMAT_ARGB8888) {
            return "SDL_PIXELFORMAT_ARGB8888";
        } else if (value == SDL_PIXELFORMAT_RGBA8888) {
            return "SDL_PIXELFORMAT_RGBA8888";
        } else if (value == SDL_PIXELFORMAT_ABGR8888) {
            return "SDL_PIXELFORMAT_ABGR8888";
        } else if (value == SDL_PIXELFORMAT_BGRA8888) {
            return "SDL_PIXELFORMAT_BGRA8888";
        } else if (value == SDL_PIXELFORMAT_ARGB2101010) {
            return "SDL_PIXELFORMAT_ARGB2101010";
        } else if (value == SDL_PIXELFORMAT_YV12) {
            return "SDL_PIXELFORMAT_YV12";
        } else if (value == SDL_PIXELFORMAT_IYUV) {
            return "SDL_PIXELFORMAT_IYUV";
        } else if (value == SDL_PIXELFORMAT_YUY2) {
            return "SDL_PIXELFORMAT_YUY2";
        } else if (value == SDL_PIXELFORMAT_UYVY) {
            return "SDL_PIXELFORMAT_UYVY";
        } else if (value == SDL_PIXELFORMAT_YVYU) {
            return "SDL_PIXELFORMAT_YVYU";
        } else if (value == SDL_PIXELFORMAT_NV12) {
            return "SDL_PIXELFORMAT_NV12";
        } else if (value == SDL_PIXELFORMAT_NV21) {
            return "SDL_PIXELFORMAT_NV21";
        } else if (value == SDL_PIXELFORMAT_EXTERNAL_OES) {
            return "SDL_PIXELFORMAT_EXTERNAL_OES";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_PixelFormatEnum() {
    }
}
