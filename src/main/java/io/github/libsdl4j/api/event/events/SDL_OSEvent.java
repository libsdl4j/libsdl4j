package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_APP_DIDENTERBACKGROUND;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_APP_DIDENTERFOREGROUND;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_APP_LOWMEMORY;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_APP_TERMINATING;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_APP_WILLENTERBACKGROUND;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_APP_WILLENTERFOREGROUND;

/**
 * OS Specific event
 *
 * <p>SDL removed this structure from the SDL_Event union in SDL 2.30.0. The
 * SDL_APP_* events it describes are still delivered and still have this exact
 * layout, which is identical to SDL_CommonEvent, so reading them through
 * SDL_Event.common is equivalent and forward compatible.</p>
 *
 * @see io.github.libsdl4j.api.event.events.SDL_CommonEvent
 */
@Structure.FieldOrder({
        "type",
        "timestamp"
})
@Deprecated
public final class SDL_OSEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_APP_TERMINATING SDL_APP_TERMINATING}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_APP_LOWMEMORY SDL_APP_LOWMEMORY}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_APP_WILLENTERBACKGROUND SDL_APP_WILLENTERBACKGROUND}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_APP_DIDENTERBACKGROUND SDL_APP_DIDENTERBACKGROUND}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_APP_WILLENTERFOREGROUND SDL_APP_WILLENTERFOREGROUND}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_APP_DIDENTERFOREGROUND SDL_APP_DIDENTERFOREGROUND}
     */
    @MagicConstant(intValues = {
            SDL_APP_TERMINATING,
            SDL_APP_LOWMEMORY,
            SDL_APP_WILLENTERBACKGROUND,
            SDL_APP_DIDENTERBACKGROUND,
            SDL_APP_WILLENTERFOREGROUND,
            SDL_APP_DIDENTERFOREGROUND
    })
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    public SDL_OSEvent() {
    }

    public SDL_OSEvent(Pointer p) {
        super(p);
    }
}
