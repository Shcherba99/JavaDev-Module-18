package com.goit.pshcherba.dto.responce;

import com.goit.pshcherba.entity.Note;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Response DTO for retrieving all notes.
 * Extends {@link NoteResponse} to reuse common response properties such as status and message.
 * Contains a list of notes as the response data.
 */
@Getter
@Setter
public class GetAllNotesResponse extends NoteResponse {
    private final List<Note> notes;

    /**
     * Constructor to create a response with the given status, message, and list of notes.
     *
     * @param status the status of the response
     * @param message the message accompanying the response
     * @param notes the list of notes to be returned in the response
     */
    public GetAllNotesResponse(ResponseStatus status, String message, List<Note> notes) {
        super(status, message);
        this.notes = notes;
    }

    /**
     * Factory method to create a successful response with a list of notes.
     *
     * @param notes the list of notes to be returned in the response
     * @return a {@link GetAllNotesResponse} with a status of OK and a success message
     */
    public static GetAllNotesResponse success(List<Note> notes) {
        return new GetAllNotesResponse(ResponseStatus.OK, "Notes received successfully", notes);
    }

    /**
     * Factory method to create a successful response with an empty list of notes.
     *
     * @return a {@link GetAllNotesResponse} with a status of OK and a message indicating the list is empty
     */
    public static GetAllNotesResponse successEmptyList() {
        return new GetAllNotesResponse(ResponseStatus.OK, "The list of notes is empty", new ArrayList<>());
    }
}
