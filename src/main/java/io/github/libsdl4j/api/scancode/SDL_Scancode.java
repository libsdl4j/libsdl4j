package io.github.libsdl4j.api.scancode;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The SDL keyboard scancode representation.
 *
 * <p>Values of this type are used to represent keyboard keys, among other places
 * in the {@link io.github.libsdl4j.api.keyboard.SDL_Keysym#scancode} and {@code SDL_Event.key.keysym.scancode} field.</p>
 *
 * <p>The values in this enumeration are based on the USB usage page standard:
 * https://www.usb.org/sites/default/files/documents/hut1_12v2.pdf</p>
 */
public final class SDL_Scancode implements JnaEnum {

    public static final int SDL_SCANCODE_UNKNOWN = 0;

    public static final int SDL_SCANCODE_A = 4;
    public static final int SDL_SCANCODE_B = 5;
    public static final int SDL_SCANCODE_C = 6;
    public static final int SDL_SCANCODE_D = 7;
    public static final int SDL_SCANCODE_E = 8;
    public static final int SDL_SCANCODE_F = 9;
    public static final int SDL_SCANCODE_G = 10;
    public static final int SDL_SCANCODE_H = 11;
    public static final int SDL_SCANCODE_I = 12;
    public static final int SDL_SCANCODE_J = 13;
    public static final int SDL_SCANCODE_K = 14;
    public static final int SDL_SCANCODE_L = 15;
    public static final int SDL_SCANCODE_M = 16;
    public static final int SDL_SCANCODE_N = 17;
    public static final int SDL_SCANCODE_O = 18;
    public static final int SDL_SCANCODE_P = 19;
    public static final int SDL_SCANCODE_Q = 20;
    public static final int SDL_SCANCODE_R = 21;
    public static final int SDL_SCANCODE_S = 22;
    public static final int SDL_SCANCODE_T = 23;
    public static final int SDL_SCANCODE_U = 24;
    public static final int SDL_SCANCODE_V = 25;
    public static final int SDL_SCANCODE_W = 26;
    public static final int SDL_SCANCODE_X = 27;
    public static final int SDL_SCANCODE_Y = 28;
    public static final int SDL_SCANCODE_Z = 29;

    public static final int SDL_SCANCODE_1 = 30;
    public static final int SDL_SCANCODE_2 = 31;
    public static final int SDL_SCANCODE_3 = 32;
    public static final int SDL_SCANCODE_4 = 33;
    public static final int SDL_SCANCODE_5 = 34;
    public static final int SDL_SCANCODE_6 = 35;
    public static final int SDL_SCANCODE_7 = 36;
    public static final int SDL_SCANCODE_8 = 37;
    public static final int SDL_SCANCODE_9 = 38;
    public static final int SDL_SCANCODE_0 = 39;

    public static final int SDL_SCANCODE_RETURN = 40;
    public static final int SDL_SCANCODE_ESCAPE = 41;
    public static final int SDL_SCANCODE_BACKSPACE = 42;
    public static final int SDL_SCANCODE_TAB = 43;
    public static final int SDL_SCANCODE_SPACE = 44;

    public static final int SDL_SCANCODE_MINUS = 45;
    public static final int SDL_SCANCODE_EQUALS = 46;
    public static final int SDL_SCANCODE_LEFTBRACKET = 47;
    public static final int SDL_SCANCODE_RIGHTBRACKET = 48;

    /**
     * Located at the lower left of the return
     * key on ISO keyboards and at the right end
     * of the QWERTY row on ANSI keyboards.
     * Produces REVERSE SOLIDUS (backslash) and
     * VERTICAL LINE in a US layout, REVERSE
     * SOLIDUS and VERTICAL LINE in a UK Mac
     * layout, NUMBER SIGN and TILDE in a UK
     * Windows layout, DOLLAR SIGN and POUND SIGN
     * in a Swiss German layout, NUMBER SIGN and
     * APOSTROPHE in a German layout, GRAVE
     * ACCENT and POUND SIGN in a French Mac
     * layout, and ASTERISK and MICRO SIGN in a
     * French Windows layout.
     */
    public static final int SDL_SCANCODE_BACKSLASH = 49;

    /**
     * ISO USB keyboards actually use this code
     * instead of 49 for the same key, but all
     * OSes I've seen treat the two codes
     * identically. So, as an implementor, unless
     * your keyboard generates both of those
     * codes and your OS treats them differently,
     * you should generate SDL_SCANCODE_BACKSLASH
     * instead of this code. As a user, you
     * should not rely on this code because SDL
     * will never generate it with most (all?)
     * keyboards.
     */
    public static final int SDL_SCANCODE_NONUSHASH = 50;
    public static final int SDL_SCANCODE_SEMICOLON = 51;
    public static final int SDL_SCANCODE_APOSTROPHE = 52;

    /**
     * Located in the top left corner (on both ANSI
     * and ISO keyboards). Produces GRAVE ACCENT and
     * TILDE in a US Windows layout and in US and UK
     * Mac layouts on ANSI keyboards, GRAVE ACCENT
     * and NOT SIGN in a UK Windows layout, SECTION
     * SIGN and PLUS-MINUS SIGN in US and UK Mac
     * layouts on ISO keyboards, SECTION SIGN and
     * DEGREE SIGN in a Swiss German layout (Mac:
     * only on ISO keyboards), CIRCUMFLEX ACCENT and
     * DEGREE SIGN in a German layout (Mac: only on
     * ISO keyboards), SUPERSCRIPT TWO and TILDE in a
     * French Windows layout, COMMERCIAL AT and
     * NUMBER SIGN in a French Mac layout on ISO
     * keyboards, and LESS-THAN SIGN and GREATER-THAN
     * SIGN in a Swiss German, German, or French Mac
     * layout on ANSI keyboards.
     */
    public static final int SDL_SCANCODE_GRAVE = 53;
    public static final int SDL_SCANCODE_COMMA = 54;
    public static final int SDL_SCANCODE_PERIOD = 55;
    public static final int SDL_SCANCODE_SLASH = 56;

    public static final int SDL_SCANCODE_CAPSLOCK = 57;

    public static final int SDL_SCANCODE_F1 = 58;
    public static final int SDL_SCANCODE_F2 = 59;
    public static final int SDL_SCANCODE_F3 = 60;
    public static final int SDL_SCANCODE_F4 = 61;
    public static final int SDL_SCANCODE_F5 = 62;
    public static final int SDL_SCANCODE_F6 = 63;
    public static final int SDL_SCANCODE_F7 = 64;
    public static final int SDL_SCANCODE_F8 = 65;
    public static final int SDL_SCANCODE_F9 = 66;
    public static final int SDL_SCANCODE_F10 = 67;
    public static final int SDL_SCANCODE_F11 = 68;
    public static final int SDL_SCANCODE_F12 = 69;

    public static final int SDL_SCANCODE_PRINTSCREEN = 70;
    public static final int SDL_SCANCODE_SCROLLLOCK = 71;
    public static final int SDL_SCANCODE_PAUSE = 72;

    /**
     * insert on PC, help on some Mac keyboards (but
     * does send code 73, not 117)
     */
    public static final int SDL_SCANCODE_INSERT = 73;
    public static final int SDL_SCANCODE_HOME = 74;
    public static final int SDL_SCANCODE_PAGEUP = 75;
    public static final int SDL_SCANCODE_DELETE = 76;
    public static final int SDL_SCANCODE_END = 77;
    public static final int SDL_SCANCODE_PAGEDOWN = 78;
    public static final int SDL_SCANCODE_RIGHT = 79;
    public static final int SDL_SCANCODE_LEFT = 80;
    public static final int SDL_SCANCODE_DOWN = 81;
    public static final int SDL_SCANCODE_UP = 82;

    /**
     * num lock on PC, clear on Mac keyboards
     */
    public static final int SDL_SCANCODE_NUMLOCKCLEAR = 83;
    public static final int SDL_SCANCODE_KP_DIVIDE = 84;
    public static final int SDL_SCANCODE_KP_MULTIPLY = 85;
    public static final int SDL_SCANCODE_KP_MINUS = 86;
    public static final int SDL_SCANCODE_KP_PLUS = 87;
    public static final int SDL_SCANCODE_KP_ENTER = 88;
    public static final int SDL_SCANCODE_KP_1 = 89;
    public static final int SDL_SCANCODE_KP_2 = 90;
    public static final int SDL_SCANCODE_KP_3 = 91;
    public static final int SDL_SCANCODE_KP_4 = 92;
    public static final int SDL_SCANCODE_KP_5 = 93;
    public static final int SDL_SCANCODE_KP_6 = 94;
    public static final int SDL_SCANCODE_KP_7 = 95;
    public static final int SDL_SCANCODE_KP_8 = 96;
    public static final int SDL_SCANCODE_KP_9 = 97;
    public static final int SDL_SCANCODE_KP_0 = 98;
    public static final int SDL_SCANCODE_KP_PERIOD = 99;

    /**
     * This is the additional key that ISO
     * keyboards have over ANSI ones,
     * located between left shift and Y.
     * Produces GRAVE ACCENT and TILDE in a
     * US or UK Mac layout, REVERSE SOLIDUS
     * (backslash) and VERTICAL LINE in a
     * US or UK Windows layout, and
     * LESS-THAN SIGN and GREATER-THAN SIGN
     * in a Swiss German, German, or French
     * layout.
     */
    public static final int SDL_SCANCODE_NONUSBACKSLASH = 100;

    /** windows contextual menu, compose */
    public static final int SDL_SCANCODE_APPLICATION = 101;

    /**
     * The USB document says this is a status flag,
     * not a physical key - but some Mac keyboards
     * do have a power key.
     */
    public static final int SDL_SCANCODE_POWER = 102;
    public static final int SDL_SCANCODE_KP_EQUALS = 103;
    public static final int SDL_SCANCODE_F13 = 104;
    public static final int SDL_SCANCODE_F14 = 105;
    public static final int SDL_SCANCODE_F15 = 106;
    public static final int SDL_SCANCODE_F16 = 107;
    public static final int SDL_SCANCODE_F17 = 108;
    public static final int SDL_SCANCODE_F18 = 109;
    public static final int SDL_SCANCODE_F19 = 110;
    public static final int SDL_SCANCODE_F20 = 111;
    public static final int SDL_SCANCODE_F21 = 112;
    public static final int SDL_SCANCODE_F22 = 113;
    public static final int SDL_SCANCODE_F23 = 114;
    public static final int SDL_SCANCODE_F24 = 115;
    public static final int SDL_SCANCODE_EXECUTE = 116;

    /** AL Integrated Help Center */
    public static final int SDL_SCANCODE_HELP = 117;

    /** Menu (show menu) */
    public static final int SDL_SCANCODE_MENU = 118;
    public static final int SDL_SCANCODE_SELECT = 119;

    /** AC Stop */
    public static final int SDL_SCANCODE_STOP = 120;

    /** AC Redo/Repeat */
    public static final int SDL_SCANCODE_AGAIN = 121;

    /** AC Undo */
    public static final int SDL_SCANCODE_UNDO = 122;

    /** AC Cut */
    public static final int SDL_SCANCODE_CUT = 123;

    /** AC Copy */
    public static final int SDL_SCANCODE_COPY = 124;

    /** AC Paste */
    public static final int SDL_SCANCODE_PASTE = 125;

    /** AC Find */
    public static final int SDL_SCANCODE_FIND = 126;
    public static final int SDL_SCANCODE_MUTE = 127;
    public static final int SDL_SCANCODE_VOLUMEUP = 128;
    public static final int SDL_SCANCODE_VOLUMEDOWN = 129;
    /* not sure whether there's a reason to enable these */
    /*     public static final int SDL_SCANCODE_LOCKINGCAPSLOCK = 130,  */
    /*     public static final int SDL_SCANCODE_LOCKINGNUMLOCK = 131, */
    /*     public static final int SDL_SCANCODE_LOCKINGSCROLLLOCK = 132, */
    public static final int SDL_SCANCODE_KP_COMMA = 133;
    public static final int SDL_SCANCODE_KP_EQUALSAS400 = 134;

    /**
     * used on Asian keyboards, see
     * footnotes in USB doc
     */
    public static final int SDL_SCANCODE_INTERNATIONAL1 = 135;
    public static final int SDL_SCANCODE_INTERNATIONAL2 = 136;

    /** Yen */
    public static final int SDL_SCANCODE_INTERNATIONAL3 = 137;
    public static final int SDL_SCANCODE_INTERNATIONAL4 = 138;
    public static final int SDL_SCANCODE_INTERNATIONAL5 = 139;
    public static final int SDL_SCANCODE_INTERNATIONAL6 = 140;
    public static final int SDL_SCANCODE_INTERNATIONAL7 = 141;
    public static final int SDL_SCANCODE_INTERNATIONAL8 = 142;
    public static final int SDL_SCANCODE_INTERNATIONAL9 = 143;

    /** Hangul/English toggle */
    public static final int SDL_SCANCODE_LANG1 = 144;

    /** Hanja conversion */
    public static final int SDL_SCANCODE_LANG2 = 145;

    /** Katakana */
    public static final int SDL_SCANCODE_LANG3 = 146;

    /** Hiragana */
    public static final int SDL_SCANCODE_LANG4 = 147;

    /** Zenkaku/Hankaku */
    public static final int SDL_SCANCODE_LANG5 = 148;

    /** reserved */
    public static final int SDL_SCANCODE_LANG6 = 149;

    /** reserved */
    public static final int SDL_SCANCODE_LANG7 = 150;

    /** reserved */
    public static final int SDL_SCANCODE_LANG8 = 151;

    /** reserved */
    public static final int SDL_SCANCODE_LANG9 = 152;

    /** Erase-Eaze */
    public static final int SDL_SCANCODE_ALTERASE = 153;
    public static final int SDL_SCANCODE_SYSREQ = 154;

    /** AC Cancel */
    public static final int SDL_SCANCODE_CANCEL = 155;
    public static final int SDL_SCANCODE_CLEAR = 156;
    public static final int SDL_SCANCODE_PRIOR = 157;
    public static final int SDL_SCANCODE_RETURN2 = 158;
    public static final int SDL_SCANCODE_SEPARATOR = 159;
    public static final int SDL_SCANCODE_OUT = 160;
    public static final int SDL_SCANCODE_OPER = 161;
    public static final int SDL_SCANCODE_CLEARAGAIN = 162;
    public static final int SDL_SCANCODE_CRSEL = 163;
    public static final int SDL_SCANCODE_EXSEL = 164;

    public static final int SDL_SCANCODE_KP_00 = 176;
    public static final int SDL_SCANCODE_KP_000 = 177;
    public static final int SDL_SCANCODE_THOUSANDSSEPARATOR = 178;
    public static final int SDL_SCANCODE_DECIMALSEPARATOR = 179;
    public static final int SDL_SCANCODE_CURRENCYUNIT = 180;
    public static final int SDL_SCANCODE_CURRENCYSUBUNIT = 181;
    public static final int SDL_SCANCODE_KP_LEFTPAREN = 182;
    public static final int SDL_SCANCODE_KP_RIGHTPAREN = 183;
    public static final int SDL_SCANCODE_KP_LEFTBRACE = 184;
    public static final int SDL_SCANCODE_KP_RIGHTBRACE = 185;
    public static final int SDL_SCANCODE_KP_TAB = 186;
    public static final int SDL_SCANCODE_KP_BACKSPACE = 187;
    public static final int SDL_SCANCODE_KP_A = 188;
    public static final int SDL_SCANCODE_KP_B = 189;
    public static final int SDL_SCANCODE_KP_C = 190;
    public static final int SDL_SCANCODE_KP_D = 191;
    public static final int SDL_SCANCODE_KP_E = 192;
    public static final int SDL_SCANCODE_KP_F = 193;
    public static final int SDL_SCANCODE_KP_XOR = 194;
    public static final int SDL_SCANCODE_KP_POWER = 195;
    public static final int SDL_SCANCODE_KP_PERCENT = 196;
    public static final int SDL_SCANCODE_KP_LESS = 197;
    public static final int SDL_SCANCODE_KP_GREATER = 198;
    public static final int SDL_SCANCODE_KP_AMPERSAND = 199;
    public static final int SDL_SCANCODE_KP_DBLAMPERSAND = 200;
    public static final int SDL_SCANCODE_KP_VERTICALBAR = 201;
    public static final int SDL_SCANCODE_KP_DBLVERTICALBAR = 202;
    public static final int SDL_SCANCODE_KP_COLON = 203;
    public static final int SDL_SCANCODE_KP_HASH = 204;
    public static final int SDL_SCANCODE_KP_SPACE = 205;
    public static final int SDL_SCANCODE_KP_AT = 206;
    public static final int SDL_SCANCODE_KP_EXCLAM = 207;
    public static final int SDL_SCANCODE_KP_MEMSTORE = 208;
    public static final int SDL_SCANCODE_KP_MEMRECALL = 209;
    public static final int SDL_SCANCODE_KP_MEMCLEAR = 210;
    public static final int SDL_SCANCODE_KP_MEMADD = 211;
    public static final int SDL_SCANCODE_KP_MEMSUBTRACT = 212;
    public static final int SDL_SCANCODE_KP_MEMMULTIPLY = 213;
    public static final int SDL_SCANCODE_KP_MEMDIVIDE = 214;
    public static final int SDL_SCANCODE_KP_PLUSMINUS = 215;
    public static final int SDL_SCANCODE_KP_CLEAR = 216;
    public static final int SDL_SCANCODE_KP_CLEARENTRY = 217;
    public static final int SDL_SCANCODE_KP_BINARY = 218;
    public static final int SDL_SCANCODE_KP_OCTAL = 219;
    public static final int SDL_SCANCODE_KP_DECIMAL = 220;
    public static final int SDL_SCANCODE_KP_HEXADECIMAL = 221;

    public static final int SDL_SCANCODE_LCTRL = 224;
    public static final int SDL_SCANCODE_LSHIFT = 225;

    /** alt, option */
    public static final int SDL_SCANCODE_LALT = 226;

    /** windows, command (apple), meta */
    public static final int SDL_SCANCODE_LGUI = 227;
    public static final int SDL_SCANCODE_RCTRL = 228;
    public static final int SDL_SCANCODE_RSHIFT = 229;

    /** alt gr, option */
    public static final int SDL_SCANCODE_RALT = 230;

    /** windows, command (apple), meta */
    public static final int SDL_SCANCODE_RGUI = 231;

    /**
     * I'm not sure if this is really not covered
     * by any of the above, but since there's a
     * special KMOD_MODE for it I'm adding it here
     */
    public static final int SDL_SCANCODE_MODE = 257;

    public static final int SDL_SCANCODE_AUDIONEXT = 258;
    public static final int SDL_SCANCODE_AUDIOPREV = 259;
    public static final int SDL_SCANCODE_AUDIOSTOP = 260;
    public static final int SDL_SCANCODE_AUDIOPLAY = 261;
    public static final int SDL_SCANCODE_AUDIOMUTE = 262;
    public static final int SDL_SCANCODE_MEDIASELECT = 263;

    /** AL Internet Browser */
    public static final int SDL_SCANCODE_WWW = 264;
    public static final int SDL_SCANCODE_MAIL = 265;

    /** AL Calculator */
    public static final int SDL_SCANCODE_CALCULATOR = 266;
    public static final int SDL_SCANCODE_COMPUTER = 267;

    /** AC Search */
    public static final int SDL_SCANCODE_AC_SEARCH = 268;

    /** AC Home */
    public static final int SDL_SCANCODE_AC_HOME = 269;

    /** AC Back */
    public static final int SDL_SCANCODE_AC_BACK = 270;

    /** AC Forward */
    public static final int SDL_SCANCODE_AC_FORWARD = 271;

    /** AC Stop */
    public static final int SDL_SCANCODE_AC_STOP = 272;

    /** AC Refresh */
    public static final int SDL_SCANCODE_AC_REFRESH = 273;

    /** AC Bookmarks */
    public static final int SDL_SCANCODE_AC_BOOKMARKS = 274;

    public static final int SDL_SCANCODE_BRIGHTNESSDOWN = 275;
    public static final int SDL_SCANCODE_BRIGHTNESSUP = 276;

    /**
     * display mirroring/dual display
     * switch, video mode switch
     */
    public static final int SDL_SCANCODE_DISPLAYSWITCH = 277;
    public static final int SDL_SCANCODE_KBDILLUMTOGGLE = 278;
    public static final int SDL_SCANCODE_KBDILLUMDOWN = 279;
    public static final int SDL_SCANCODE_KBDILLUMUP = 280;
    public static final int SDL_SCANCODE_EJECT = 281;

    /** SC System Sleep */
    public static final int SDL_SCANCODE_SLEEP = 282;

    public static final int SDL_SCANCODE_APP1 = 283;
    public static final int SDL_SCANCODE_APP2 = 284;

    public static final int SDL_SCANCODE_AUDIOREWIND = 285;
    public static final int SDL_SCANCODE_AUDIOFASTFORWARD = 286;

    /**
     * Usually situated below the display on phones and
     * used as a multi-function feature key for selecting
     * a software defined function shown on the bottom left
     * of the display.
     */
    public static final int SDL_SCANCODE_SOFTLEFT = 287;

    /**
     * Usually situated below the display on phones and
     * used as a multi-function feature key for selecting
     * a software defined function shown on the bottom right
     * of the display.
     */
    public static final int SDL_SCANCODE_SOFTRIGHT = 288;

    /** Used for accepting phone calls. */
    public static final int SDL_SCANCODE_CALL = 289;

    /** Used for rejecting phone calls. */
    public static final int SDL_SCANCODE_ENDCALL = 290;

    public static String toString(int value) {
        if (value == SDL_SCANCODE_UNKNOWN) {
            return "SDL_SCANCODE_UNKNOWN";
        } else if (value == SDL_SCANCODE_A) {
            return "SDL_SCANCODE_A";
        } else if (value == SDL_SCANCODE_B) {
            return "SDL_SCANCODE_B";
        } else if (value == SDL_SCANCODE_C) {
            return "SDL_SCANCODE_C";
        } else if (value == SDL_SCANCODE_D) {
            return "SDL_SCANCODE_D";
        } else if (value == SDL_SCANCODE_E) {
            return "SDL_SCANCODE_E";
        } else if (value == SDL_SCANCODE_F) {
            return "SDL_SCANCODE_F";
        } else if (value == SDL_SCANCODE_G) {
            return "SDL_SCANCODE_G";
        } else if (value == SDL_SCANCODE_H) {
            return "SDL_SCANCODE_H";
        } else if (value == SDL_SCANCODE_I) {
            return "SDL_SCANCODE_I";
        } else if (value == SDL_SCANCODE_J) {
            return "SDL_SCANCODE_J";
        } else if (value == SDL_SCANCODE_K) {
            return "SDL_SCANCODE_K";
        } else if (value == SDL_SCANCODE_L) {
            return "SDL_SCANCODE_L";
        } else if (value == SDL_SCANCODE_M) {
            return "SDL_SCANCODE_M";
        } else if (value == SDL_SCANCODE_N) {
            return "SDL_SCANCODE_N";
        } else if (value == SDL_SCANCODE_O) {
            return "SDL_SCANCODE_O";
        } else if (value == SDL_SCANCODE_P) {
            return "SDL_SCANCODE_P";
        } else if (value == SDL_SCANCODE_Q) {
            return "SDL_SCANCODE_Q";
        } else if (value == SDL_SCANCODE_R) {
            return "SDL_SCANCODE_R";
        } else if (value == SDL_SCANCODE_S) {
            return "SDL_SCANCODE_S";
        } else if (value == SDL_SCANCODE_T) {
            return "SDL_SCANCODE_T";
        } else if (value == SDL_SCANCODE_U) {
            return "SDL_SCANCODE_U";
        } else if (value == SDL_SCANCODE_V) {
            return "SDL_SCANCODE_V";
        } else if (value == SDL_SCANCODE_W) {
            return "SDL_SCANCODE_W";
        } else if (value == SDL_SCANCODE_X) {
            return "SDL_SCANCODE_X";
        } else if (value == SDL_SCANCODE_Y) {
            return "SDL_SCANCODE_Y";
        } else if (value == SDL_SCANCODE_Z) {
            return "SDL_SCANCODE_Z";
        } else if (value == SDL_SCANCODE_1) {
            return "SDL_SCANCODE_1";
        } else if (value == SDL_SCANCODE_2) {
            return "SDL_SCANCODE_2";
        } else if (value == SDL_SCANCODE_3) {
            return "SDL_SCANCODE_3";
        } else if (value == SDL_SCANCODE_4) {
            return "SDL_SCANCODE_4";
        } else if (value == SDL_SCANCODE_5) {
            return "SDL_SCANCODE_5";
        } else if (value == SDL_SCANCODE_6) {
            return "SDL_SCANCODE_6";
        } else if (value == SDL_SCANCODE_7) {
            return "SDL_SCANCODE_7";
        } else if (value == SDL_SCANCODE_8) {
            return "SDL_SCANCODE_8";
        } else if (value == SDL_SCANCODE_9) {
            return "SDL_SCANCODE_9";
        } else if (value == SDL_SCANCODE_0) {
            return "SDL_SCANCODE_0";
        } else if (value == SDL_SCANCODE_RETURN) {
            return "SDL_SCANCODE_RETURN";
        } else if (value == SDL_SCANCODE_ESCAPE) {
            return "SDL_SCANCODE_ESCAPE";
        } else if (value == SDL_SCANCODE_BACKSPACE) {
            return "SDL_SCANCODE_BACKSPACE";
        } else if (value == SDL_SCANCODE_TAB) {
            return "SDL_SCANCODE_TAB";
        } else if (value == SDL_SCANCODE_SPACE) {
            return "SDL_SCANCODE_SPACE";
        } else if (value == SDL_SCANCODE_MINUS) {
            return "SDL_SCANCODE_MINUS";
        } else if (value == SDL_SCANCODE_EQUALS) {
            return "SDL_SCANCODE_EQUALS";
        } else if (value == SDL_SCANCODE_LEFTBRACKET) {
            return "SDL_SCANCODE_LEFTBRACKET";
        } else if (value == SDL_SCANCODE_RIGHTBRACKET) {
            return "SDL_SCANCODE_RIGHTBRACKET";
        } else if (value == SDL_SCANCODE_BACKSLASH) {
            return "SDL_SCANCODE_BACKSLASH";
        } else if (value == SDL_SCANCODE_NONUSHASH) {
            return "SDL_SCANCODE_NONUSHASH";
        } else if (value == SDL_SCANCODE_SEMICOLON) {
            return "SDL_SCANCODE_SEMICOLON";
        } else if (value == SDL_SCANCODE_APOSTROPHE) {
            return "SDL_SCANCODE_APOSTROPHE";
        } else if (value == SDL_SCANCODE_GRAVE) {
            return "SDL_SCANCODE_GRAVE";
        } else if (value == SDL_SCANCODE_COMMA) {
            return "SDL_SCANCODE_COMMA";
        } else if (value == SDL_SCANCODE_PERIOD) {
            return "SDL_SCANCODE_PERIOD";
        } else if (value == SDL_SCANCODE_SLASH) {
            return "SDL_SCANCODE_SLASH";
        } else if (value == SDL_SCANCODE_CAPSLOCK) {
            return "SDL_SCANCODE_CAPSLOCK";
        } else if (value == SDL_SCANCODE_F1) {
            return "SDL_SCANCODE_F1";
        } else if (value == SDL_SCANCODE_F2) {
            return "SDL_SCANCODE_F2";
        } else if (value == SDL_SCANCODE_F3) {
            return "SDL_SCANCODE_F3";
        } else if (value == SDL_SCANCODE_F4) {
            return "SDL_SCANCODE_F4";
        } else if (value == SDL_SCANCODE_F5) {
            return "SDL_SCANCODE_F5";
        } else if (value == SDL_SCANCODE_F6) {
            return "SDL_SCANCODE_F6";
        } else if (value == SDL_SCANCODE_F7) {
            return "SDL_SCANCODE_F7";
        } else if (value == SDL_SCANCODE_F8) {
            return "SDL_SCANCODE_F8";
        } else if (value == SDL_SCANCODE_F9) {
            return "SDL_SCANCODE_F9";
        } else if (value == SDL_SCANCODE_F10) {
            return "SDL_SCANCODE_F10";
        } else if (value == SDL_SCANCODE_F11) {
            return "SDL_SCANCODE_F11";
        } else if (value == SDL_SCANCODE_F12) {
            return "SDL_SCANCODE_F12";
        } else if (value == SDL_SCANCODE_PRINTSCREEN) {
            return "SDL_SCANCODE_PRINTSCREEN";
        } else if (value == SDL_SCANCODE_SCROLLLOCK) {
            return "SDL_SCANCODE_SCROLLLOCK";
        } else if (value == SDL_SCANCODE_PAUSE) {
            return "SDL_SCANCODE_PAUSE";
        } else if (value == SDL_SCANCODE_INSERT) {
            return "SDL_SCANCODE_INSERT";
        } else if (value == SDL_SCANCODE_HOME) {
            return "SDL_SCANCODE_HOME";
        } else if (value == SDL_SCANCODE_PAGEUP) {
            return "SDL_SCANCODE_PAGEUP";
        } else if (value == SDL_SCANCODE_DELETE) {
            return "SDL_SCANCODE_DELETE";
        } else if (value == SDL_SCANCODE_END) {
            return "SDL_SCANCODE_END";
        } else if (value == SDL_SCANCODE_PAGEDOWN) {
            return "SDL_SCANCODE_PAGEDOWN";
        } else if (value == SDL_SCANCODE_RIGHT) {
            return "SDL_SCANCODE_RIGHT";
        } else if (value == SDL_SCANCODE_LEFT) {
            return "SDL_SCANCODE_LEFT";
        } else if (value == SDL_SCANCODE_DOWN) {
            return "SDL_SCANCODE_DOWN";
        } else if (value == SDL_SCANCODE_UP) {
            return "SDL_SCANCODE_UP";
        } else if (value == SDL_SCANCODE_NUMLOCKCLEAR) {
            return "SDL_SCANCODE_NUMLOCKCLEAR";
        } else if (value == SDL_SCANCODE_KP_DIVIDE) {
            return "SDL_SCANCODE_KP_DIVIDE";
        } else if (value == SDL_SCANCODE_KP_MULTIPLY) {
            return "SDL_SCANCODE_KP_MULTIPLY";
        } else if (value == SDL_SCANCODE_KP_MINUS) {
            return "SDL_SCANCODE_KP_MINUS";
        } else if (value == SDL_SCANCODE_KP_PLUS) {
            return "SDL_SCANCODE_KP_PLUS";
        } else if (value == SDL_SCANCODE_KP_ENTER) {
            return "SDL_SCANCODE_KP_ENTER";
        } else if (value == SDL_SCANCODE_KP_1) {
            return "SDL_SCANCODE_KP_1";
        } else if (value == SDL_SCANCODE_KP_2) {
            return "SDL_SCANCODE_KP_2";
        } else if (value == SDL_SCANCODE_KP_3) {
            return "SDL_SCANCODE_KP_3";
        } else if (value == SDL_SCANCODE_KP_4) {
            return "SDL_SCANCODE_KP_4";
        } else if (value == SDL_SCANCODE_KP_5) {
            return "SDL_SCANCODE_KP_5";
        } else if (value == SDL_SCANCODE_KP_6) {
            return "SDL_SCANCODE_KP_6";
        } else if (value == SDL_SCANCODE_KP_7) {
            return "SDL_SCANCODE_KP_7";
        } else if (value == SDL_SCANCODE_KP_8) {
            return "SDL_SCANCODE_KP_8";
        } else if (value == SDL_SCANCODE_KP_9) {
            return "SDL_SCANCODE_KP_9";
        } else if (value == SDL_SCANCODE_KP_0) {
            return "SDL_SCANCODE_KP_0";
        } else if (value == SDL_SCANCODE_KP_PERIOD) {
            return "SDL_SCANCODE_KP_PERIOD";
        } else if (value == SDL_SCANCODE_NONUSBACKSLASH) {
            return "SDL_SCANCODE_NONUSBACKSLASH";
        } else if (value == SDL_SCANCODE_APPLICATION) {
            return "SDL_SCANCODE_APPLICATION";
        } else if (value == SDL_SCANCODE_POWER) {
            return "SDL_SCANCODE_POWER";
        } else if (value == SDL_SCANCODE_KP_EQUALS) {
            return "SDL_SCANCODE_KP_EQUALS";
        } else if (value == SDL_SCANCODE_F13) {
            return "SDL_SCANCODE_F13";
        } else if (value == SDL_SCANCODE_F14) {
            return "SDL_SCANCODE_F14";
        } else if (value == SDL_SCANCODE_F15) {
            return "SDL_SCANCODE_F15";
        } else if (value == SDL_SCANCODE_F16) {
            return "SDL_SCANCODE_F16";
        } else if (value == SDL_SCANCODE_F17) {
            return "SDL_SCANCODE_F17";
        } else if (value == SDL_SCANCODE_F18) {
            return "SDL_SCANCODE_F18";
        } else if (value == SDL_SCANCODE_F19) {
            return "SDL_SCANCODE_F19";
        } else if (value == SDL_SCANCODE_F20) {
            return "SDL_SCANCODE_F20";
        } else if (value == SDL_SCANCODE_F21) {
            return "SDL_SCANCODE_F21";
        } else if (value == SDL_SCANCODE_F22) {
            return "SDL_SCANCODE_F22";
        } else if (value == SDL_SCANCODE_F23) {
            return "SDL_SCANCODE_F23";
        } else if (value == SDL_SCANCODE_F24) {
            return "SDL_SCANCODE_F24";
        } else if (value == SDL_SCANCODE_EXECUTE) {
            return "SDL_SCANCODE_EXECUTE";
        } else if (value == SDL_SCANCODE_HELP) {
            return "SDL_SCANCODE_HELP";
        } else if (value == SDL_SCANCODE_MENU) {
            return "SDL_SCANCODE_MENU";
        } else if (value == SDL_SCANCODE_SELECT) {
            return "SDL_SCANCODE_SELECT";
        } else if (value == SDL_SCANCODE_STOP) {
            return "SDL_SCANCODE_STOP";
        } else if (value == SDL_SCANCODE_AGAIN) {
            return "SDL_SCANCODE_AGAIN";
        } else if (value == SDL_SCANCODE_UNDO) {
            return "SDL_SCANCODE_UNDO";
        } else if (value == SDL_SCANCODE_CUT) {
            return "SDL_SCANCODE_CUT";
        } else if (value == SDL_SCANCODE_COPY) {
            return "SDL_SCANCODE_COPY";
        } else if (value == SDL_SCANCODE_PASTE) {
            return "SDL_SCANCODE_PASTE";
        } else if (value == SDL_SCANCODE_FIND) {
            return "SDL_SCANCODE_FIND";
        } else if (value == SDL_SCANCODE_MUTE) {
            return "SDL_SCANCODE_MUTE";
        } else if (value == SDL_SCANCODE_VOLUMEUP) {
            return "SDL_SCANCODE_VOLUMEUP";
        } else if (value == SDL_SCANCODE_VOLUMEDOWN) {
            return "SDL_SCANCODE_VOLUMEDOWN";
        } else if (value == SDL_SCANCODE_KP_COMMA) {
            return "SDL_SCANCODE_KP_COMMA";
        } else if (value == SDL_SCANCODE_KP_EQUALSAS400) {
            return "SDL_SCANCODE_KP_EQUALSAS400";
        } else if (value == SDL_SCANCODE_INTERNATIONAL1) {
            return "SDL_SCANCODE_INTERNATIONAL1";
        } else if (value == SDL_SCANCODE_INTERNATIONAL2) {
            return "SDL_SCANCODE_INTERNATIONAL2";
        } else if (value == SDL_SCANCODE_INTERNATIONAL3) {
            return "SDL_SCANCODE_INTERNATIONAL3";
        } else if (value == SDL_SCANCODE_INTERNATIONAL4) {
            return "SDL_SCANCODE_INTERNATIONAL4";
        } else if (value == SDL_SCANCODE_INTERNATIONAL5) {
            return "SDL_SCANCODE_INTERNATIONAL5";
        } else if (value == SDL_SCANCODE_INTERNATIONAL6) {
            return "SDL_SCANCODE_INTERNATIONAL6";
        } else if (value == SDL_SCANCODE_INTERNATIONAL7) {
            return "SDL_SCANCODE_INTERNATIONAL7";
        } else if (value == SDL_SCANCODE_INTERNATIONAL8) {
            return "SDL_SCANCODE_INTERNATIONAL8";
        } else if (value == SDL_SCANCODE_INTERNATIONAL9) {
            return "SDL_SCANCODE_INTERNATIONAL9";
        } else if (value == SDL_SCANCODE_LANG1) {
            return "SDL_SCANCODE_LANG1";
        } else if (value == SDL_SCANCODE_LANG2) {
            return "SDL_SCANCODE_LANG2";
        } else if (value == SDL_SCANCODE_LANG3) {
            return "SDL_SCANCODE_LANG3";
        } else if (value == SDL_SCANCODE_LANG4) {
            return "SDL_SCANCODE_LANG4";
        } else if (value == SDL_SCANCODE_LANG5) {
            return "SDL_SCANCODE_LANG5";
        } else if (value == SDL_SCANCODE_LANG6) {
            return "SDL_SCANCODE_LANG6";
        } else if (value == SDL_SCANCODE_LANG7) {
            return "SDL_SCANCODE_LANG7";
        } else if (value == SDL_SCANCODE_LANG8) {
            return "SDL_SCANCODE_LANG8";
        } else if (value == SDL_SCANCODE_LANG9) {
            return "SDL_SCANCODE_LANG9";
        } else if (value == SDL_SCANCODE_ALTERASE) {
            return "SDL_SCANCODE_ALTERASE";
        } else if (value == SDL_SCANCODE_SYSREQ) {
            return "SDL_SCANCODE_SYSREQ";
        } else if (value == SDL_SCANCODE_CANCEL) {
            return "SDL_SCANCODE_CANCEL";
        } else if (value == SDL_SCANCODE_CLEAR) {
            return "SDL_SCANCODE_CLEAR";
        } else if (value == SDL_SCANCODE_PRIOR) {
            return "SDL_SCANCODE_PRIOR";
        } else if (value == SDL_SCANCODE_RETURN2) {
            return "SDL_SCANCODE_RETURN2";
        } else if (value == SDL_SCANCODE_SEPARATOR) {
            return "SDL_SCANCODE_SEPARATOR";
        } else if (value == SDL_SCANCODE_OUT) {
            return "SDL_SCANCODE_OUT";
        } else if (value == SDL_SCANCODE_OPER) {
            return "SDL_SCANCODE_OPER";
        } else if (value == SDL_SCANCODE_CLEARAGAIN) {
            return "SDL_SCANCODE_CLEARAGAIN";
        } else if (value == SDL_SCANCODE_CRSEL) {
            return "SDL_SCANCODE_CRSEL";
        } else if (value == SDL_SCANCODE_EXSEL) {
            return "SDL_SCANCODE_EXSEL";
        } else if (value == SDL_SCANCODE_KP_00) {
            return "SDL_SCANCODE_KP_00";
        } else if (value == SDL_SCANCODE_KP_000) {
            return "SDL_SCANCODE_KP_000";
        } else if (value == SDL_SCANCODE_THOUSANDSSEPARATOR) {
            return "SDL_SCANCODE_THOUSANDSSEPARATOR";
        } else if (value == SDL_SCANCODE_DECIMALSEPARATOR) {
            return "SDL_SCANCODE_DECIMALSEPARATOR";
        } else if (value == SDL_SCANCODE_CURRENCYUNIT) {
            return "SDL_SCANCODE_CURRENCYUNIT";
        } else if (value == SDL_SCANCODE_CURRENCYSUBUNIT) {
            return "SDL_SCANCODE_CURRENCYSUBUNIT";
        } else if (value == SDL_SCANCODE_KP_LEFTPAREN) {
            return "SDL_SCANCODE_KP_LEFTPAREN";
        } else if (value == SDL_SCANCODE_KP_RIGHTPAREN) {
            return "SDL_SCANCODE_KP_RIGHTPAREN";
        } else if (value == SDL_SCANCODE_KP_LEFTBRACE) {
            return "SDL_SCANCODE_KP_LEFTBRACE";
        } else if (value == SDL_SCANCODE_KP_RIGHTBRACE) {
            return "SDL_SCANCODE_KP_RIGHTBRACE";
        } else if (value == SDL_SCANCODE_KP_TAB) {
            return "SDL_SCANCODE_KP_TAB";
        } else if (value == SDL_SCANCODE_KP_BACKSPACE) {
            return "SDL_SCANCODE_KP_BACKSPACE";
        } else if (value == SDL_SCANCODE_KP_A) {
            return "SDL_SCANCODE_KP_A";
        } else if (value == SDL_SCANCODE_KP_B) {
            return "SDL_SCANCODE_KP_B";
        } else if (value == SDL_SCANCODE_KP_C) {
            return "SDL_SCANCODE_KP_C";
        } else if (value == SDL_SCANCODE_KP_D) {
            return "SDL_SCANCODE_KP_D";
        } else if (value == SDL_SCANCODE_KP_E) {
            return "SDL_SCANCODE_KP_E";
        } else if (value == SDL_SCANCODE_KP_F) {
            return "SDL_SCANCODE_KP_F";
        } else if (value == SDL_SCANCODE_KP_XOR) {
            return "SDL_SCANCODE_KP_XOR";
        } else if (value == SDL_SCANCODE_KP_POWER) {
            return "SDL_SCANCODE_KP_POWER";
        } else if (value == SDL_SCANCODE_KP_PERCENT) {
            return "SDL_SCANCODE_KP_PERCENT";
        } else if (value == SDL_SCANCODE_KP_LESS) {
            return "SDL_SCANCODE_KP_LESS";
        } else if (value == SDL_SCANCODE_KP_GREATER) {
            return "SDL_SCANCODE_KP_GREATER";
        } else if (value == SDL_SCANCODE_KP_AMPERSAND) {
            return "SDL_SCANCODE_KP_AMPERSAND";
        } else if (value == SDL_SCANCODE_KP_DBLAMPERSAND) {
            return "SDL_SCANCODE_KP_DBLAMPERSAND";
        } else if (value == SDL_SCANCODE_KP_VERTICALBAR) {
            return "SDL_SCANCODE_KP_VERTICALBAR";
        } else if (value == SDL_SCANCODE_KP_DBLVERTICALBAR) {
            return "SDL_SCANCODE_KP_DBLVERTICALBAR";
        } else if (value == SDL_SCANCODE_KP_COLON) {
            return "SDL_SCANCODE_KP_COLON";
        } else if (value == SDL_SCANCODE_KP_HASH) {
            return "SDL_SCANCODE_KP_HASH";
        } else if (value == SDL_SCANCODE_KP_SPACE) {
            return "SDL_SCANCODE_KP_SPACE";
        } else if (value == SDL_SCANCODE_KP_AT) {
            return "SDL_SCANCODE_KP_AT";
        } else if (value == SDL_SCANCODE_KP_EXCLAM) {
            return "SDL_SCANCODE_KP_EXCLAM";
        } else if (value == SDL_SCANCODE_KP_MEMSTORE) {
            return "SDL_SCANCODE_KP_MEMSTORE";
        } else if (value == SDL_SCANCODE_KP_MEMRECALL) {
            return "SDL_SCANCODE_KP_MEMRECALL";
        } else if (value == SDL_SCANCODE_KP_MEMCLEAR) {
            return "SDL_SCANCODE_KP_MEMCLEAR";
        } else if (value == SDL_SCANCODE_KP_MEMADD) {
            return "SDL_SCANCODE_KP_MEMADD";
        } else if (value == SDL_SCANCODE_KP_MEMSUBTRACT) {
            return "SDL_SCANCODE_KP_MEMSUBTRACT";
        } else if (value == SDL_SCANCODE_KP_MEMMULTIPLY) {
            return "SDL_SCANCODE_KP_MEMMULTIPLY";
        } else if (value == SDL_SCANCODE_KP_MEMDIVIDE) {
            return "SDL_SCANCODE_KP_MEMDIVIDE";
        } else if (value == SDL_SCANCODE_KP_PLUSMINUS) {
            return "SDL_SCANCODE_KP_PLUSMINUS";
        } else if (value == SDL_SCANCODE_KP_CLEAR) {
            return "SDL_SCANCODE_KP_CLEAR";
        } else if (value == SDL_SCANCODE_KP_CLEARENTRY) {
            return "SDL_SCANCODE_KP_CLEARENTRY";
        } else if (value == SDL_SCANCODE_KP_BINARY) {
            return "SDL_SCANCODE_KP_BINARY";
        } else if (value == SDL_SCANCODE_KP_OCTAL) {
            return "SDL_SCANCODE_KP_OCTAL";
        } else if (value == SDL_SCANCODE_KP_DECIMAL) {
            return "SDL_SCANCODE_KP_DECIMAL";
        } else if (value == SDL_SCANCODE_KP_HEXADECIMAL) {
            return "SDL_SCANCODE_KP_HEXADECIMAL";
        } else if (value == SDL_SCANCODE_LCTRL) {
            return "SDL_SCANCODE_LCTRL";
        } else if (value == SDL_SCANCODE_LSHIFT) {
            return "SDL_SCANCODE_LSHIFT";
        } else if (value == SDL_SCANCODE_LALT) {
            return "SDL_SCANCODE_LALT";
        } else if (value == SDL_SCANCODE_LGUI) {
            return "SDL_SCANCODE_LGUI";
        } else if (value == SDL_SCANCODE_RCTRL) {
            return "SDL_SCANCODE_RCTRL";
        } else if (value == SDL_SCANCODE_RSHIFT) {
            return "SDL_SCANCODE_RSHIFT";
        } else if (value == SDL_SCANCODE_RALT) {
            return "SDL_SCANCODE_RALT";
        } else if (value == SDL_SCANCODE_RGUI) {
            return "SDL_SCANCODE_RGUI";
        } else if (value == SDL_SCANCODE_MODE) {
            return "SDL_SCANCODE_MODE";
        } else if (value == SDL_SCANCODE_AUDIONEXT) {
            return "SDL_SCANCODE_AUDIONEXT";
        } else if (value == SDL_SCANCODE_AUDIOPREV) {
            return "SDL_SCANCODE_AUDIOPREV";
        } else if (value == SDL_SCANCODE_AUDIOSTOP) {
            return "SDL_SCANCODE_AUDIOSTOP";
        } else if (value == SDL_SCANCODE_AUDIOPLAY) {
            return "SDL_SCANCODE_AUDIOPLAY";
        } else if (value == SDL_SCANCODE_AUDIOMUTE) {
            return "SDL_SCANCODE_AUDIOMUTE";
        } else if (value == SDL_SCANCODE_MEDIASELECT) {
            return "SDL_SCANCODE_MEDIASELECT";
        } else if (value == SDL_SCANCODE_WWW) {
            return "SDL_SCANCODE_WWW";
        } else if (value == SDL_SCANCODE_MAIL) {
            return "SDL_SCANCODE_MAIL";
        } else if (value == SDL_SCANCODE_CALCULATOR) {
            return "SDL_SCANCODE_CALCULATOR";
        } else if (value == SDL_SCANCODE_COMPUTER) {
            return "SDL_SCANCODE_COMPUTER";
        } else if (value == SDL_SCANCODE_AC_SEARCH) {
            return "SDL_SCANCODE_AC_SEARCH";
        } else if (value == SDL_SCANCODE_AC_HOME) {
            return "SDL_SCANCODE_AC_HOME";
        } else if (value == SDL_SCANCODE_AC_BACK) {
            return "SDL_SCANCODE_AC_BACK";
        } else if (value == SDL_SCANCODE_AC_FORWARD) {
            return "SDL_SCANCODE_AC_FORWARD";
        } else if (value == SDL_SCANCODE_AC_STOP) {
            return "SDL_SCANCODE_AC_STOP";
        } else if (value == SDL_SCANCODE_AC_REFRESH) {
            return "SDL_SCANCODE_AC_REFRESH";
        } else if (value == SDL_SCANCODE_AC_BOOKMARKS) {
            return "SDL_SCANCODE_AC_BOOKMARKS";
        } else if (value == SDL_SCANCODE_BRIGHTNESSDOWN) {
            return "SDL_SCANCODE_BRIGHTNESSDOWN";
        } else if (value == SDL_SCANCODE_BRIGHTNESSUP) {
            return "SDL_SCANCODE_BRIGHTNESSUP";
        } else if (value == SDL_SCANCODE_DISPLAYSWITCH) {
            return "SDL_SCANCODE_DISPLAYSWITCH";
        } else if (value == SDL_SCANCODE_KBDILLUMTOGGLE) {
            return "SDL_SCANCODE_KBDILLUMTOGGLE";
        } else if (value == SDL_SCANCODE_KBDILLUMDOWN) {
            return "SDL_SCANCODE_KBDILLUMDOWN";
        } else if (value == SDL_SCANCODE_KBDILLUMUP) {
            return "SDL_SCANCODE_KBDILLUMUP";
        } else if (value == SDL_SCANCODE_EJECT) {
            return "SDL_SCANCODE_EJECT";
        } else if (value == SDL_SCANCODE_SLEEP) {
            return "SDL_SCANCODE_SLEEP";
        } else if (value == SDL_SCANCODE_APP1) {
            return "SDL_SCANCODE_APP1";
        } else if (value == SDL_SCANCODE_APP2) {
            return "SDL_SCANCODE_APP2";
        } else if (value == SDL_SCANCODE_AUDIOREWIND) {
            return "SDL_SCANCODE_AUDIOREWIND";
        } else if (value == SDL_SCANCODE_AUDIOFASTFORWARD) {
            return "SDL_SCANCODE_AUDIOFASTFORWARD";
        } else if (value == SDL_SCANCODE_SOFTLEFT) {
            return "SDL_SCANCODE_SOFTLEFT";
        } else if (value == SDL_SCANCODE_SOFTRIGHT) {
            return "SDL_SCANCODE_SOFTRIGHT";
        } else if (value == SDL_SCANCODE_CALL) {
            return "SDL_SCANCODE_CALL";
        } else if (value == SDL_SCANCODE_ENDCALL) {
            return "SDL_SCANCODE_ENDCALL";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_Scancode() {
    }
}
