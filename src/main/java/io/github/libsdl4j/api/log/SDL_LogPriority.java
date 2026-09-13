package io.github.libsdl4j.api.log;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The predefined log priorities
 */
public final class SDL_LogPriority implements JnaEnum {

    public static final int SDL_LOG_PRIORITY_VERBOSE = 1;
    public static final int SDL_LOG_PRIORITY_DEBUG = 2;
    public static final int SDL_LOG_PRIORITY_INFO = 3;
    public static final int SDL_LOG_PRIORITY_WARN = 4;
    public static final int SDL_LOG_PRIORITY_ERROR = 5;
    public static final int SDL_LOG_PRIORITY_CRITICAL = 6;
    public static final int SDL_NUM_LOG_PRIORITIES = 7;

    public static String toString(int value) {
        if (value == SDL_LOG_PRIORITY_VERBOSE) {
            return "SDL_LOG_PRIORITY_VERBOSE";
        } else if (value == SDL_LOG_PRIORITY_DEBUG) {
            return "SDL_LOG_PRIORITY_DEBUG";
        } else if (value == SDL_LOG_PRIORITY_INFO) {
            return "SDL_LOG_PRIORITY_INFO";
        } else if (value == SDL_LOG_PRIORITY_WARN) {
            return "SDL_LOG_PRIORITY_WARN";
        } else if (value == SDL_LOG_PRIORITY_ERROR) {
            return "SDL_LOG_PRIORITY_ERROR";
        } else if (value == SDL_LOG_PRIORITY_CRITICAL) {
            return "SDL_LOG_PRIORITY_CRITICAL";
        } else if (value == SDL_NUM_LOG_PRIORITIES) {
            return "SDL_NUM_LOG_PRIORITIES";
        } else {
            return "UNKNOWN(" + value + ")";
        }
    }

    private SDL_LogPriority() {
    }
}
