package com.goit.pshcherba.dto.responce;

import com.goit.pshcherba.entity.Note;
import lombok.Getter;
import lombok.Setter;

/**
 * Response DTO for retrieving a single note.
 * Extends {@link NoteResponse} to reuse common response properties such as status and message.
 * Contains a single note as the response data.
 */
@Getter
@Setter
public class GetNoteResponse extends NoteResponse {
    private Note note;

    /**
     * Constructor to create a response with the given status, message, and note.
     *
     * @param status the status of the response
     * @param message the message accompanying the response
     * @param note the note to be returned in the response
     */
    public GetNoteResponse(ResponseStatus status, String message, Note note) {
        super(status, message);
        this.note = note;
    }

    /**
     * Factory method to create a successful response with the given note.
     *
     * @param note the note to be returned in the response
     * @return a {@link GetNoteResponse} with a status of OK and a success message
     */
    public static GetNoteResponse success(Note note) {
        return new GetNoteResponse(ResponseStatus.OK, "Note received successfully", note);
    }

    /**
     * Factory method to create a failed response when the note id is not found.
     *
     * @return a {@link GetNoteResponse} with a status of ERROR and an appropriate failure message
     */
    public static GetNoteResponse failed() {
        return new GetNoteResponse(ResponseStatus.ERROR, "Note id not found", null);
    }
}
