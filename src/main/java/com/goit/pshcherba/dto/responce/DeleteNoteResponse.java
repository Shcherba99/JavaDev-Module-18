package com.goit.pshcherba.dto.responce;

/**
 * Response DTO for the deletion of a note.
 * Extends {@link NoteResponse} to reuse common response properties such as status and message.
 */
public class DeleteNoteResponse extends NoteResponse {

    /**
     * Constructor to initialize the response with status and message.
     *
     * @param status the status of the response (OK or ERROR)
     * @param message the message providing information about the response
     */
    public DeleteNoteResponse(ResponseStatus status, String message) {
        super(status, message);
    }

    /**
     * Factory method to create a successful response for note deletion.
     *
     * @return a {@link DeleteNoteResponse} with status OK and a success message
     */
    public static DeleteNoteResponse success() {
        return new DeleteNoteResponse(ResponseStatus.OK, "Note deleted successfully");
    }

    /**
     * Factory method to create a failed response for note deletion when the note ID is not found.
     *
     * @return a {@link DeleteNoteResponse} with status ERROR and an appropriate failure message
     */
    public static DeleteNoteResponse failed() {
        return new DeleteNoteResponse(ResponseStatus.ERROR, "Note id not found");
    }
}
