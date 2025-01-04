package com.goit.javadevmodule18.dto.responce;

import lombok.Getter;
import lombok.Setter;

/**
 * Response DTO for the creation of a note.
 * Extends {@link NoteResponse} to reuse common response properties such as status and message.
 */
@Getter
@Setter
public class CreateNoteResponse extends NoteResponse {

    /**
     * The ID of the newly created note.
     */
    private Long createdNoteId;

    /**
     * Constructor to initialize the response with status, message, and created note ID.
     *
     * @param status the status of the response (OK or ERROR)
     * @param message the message providing information about the response
     * @param createdNoteId the ID of the created note
     */
    public CreateNoteResponse(ResponseStatus status, String message, Long createdNoteId) {
        super(status, message);
        this.createdNoteId = createdNoteId;
    }

    /**
     * Factory method to create a successful response for note creation.
     *
     * @param createdNoteId the ID of the created note
     * @return a {@link CreateNoteResponse} with status OK and a success message
     */
    public static CreateNoteResponse success(long createdNoteId) {
        return new CreateNoteResponse(ResponseStatus.OK, "Note successfully created", createdNoteId);
    }
}
