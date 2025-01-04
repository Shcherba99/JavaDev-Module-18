package com.goit.javadevmodule18.dto.responce;

import com.goit.javadevmodule18.entity.Note;
import lombok.Getter;
import lombok.Setter;

/**
 * Response object for the update note operation.
 * Contains the updated note if the operation was successful,
 * or an error message if the note with the given ID was not found.
 */
@Getter
@Setter
public class UpdateNoteResponse extends NoteResponse {
    private Note updatedNote;

    /**
     * Constructor to create an UpdateNoteResponse with status, message, and the updated note.
     *
     * @param status the status of the operation (OK or ERROR)
     * @param message a message detailing the operation result
     * @param updatedNote the note that was updated, or null if the operation failed
     */
    public UpdateNoteResponse(ResponseStatus status, String message, Note updatedNote) {
        super(status, message);
        this.updatedNote = updatedNote;
    }

    /**
     * Static method to return a successful response with the updated note.
     *
     * @param updatedNote the note that was successfully updated
     * @return an UpdateNoteResponse object with status OK and the updated note
     */
    public static UpdateNoteResponse success(Note updatedNote) {
        return new UpdateNoteResponse(ResponseStatus.OK, "Note updated successfully", updatedNote);
    }

    /**
     * Static method to return a failed response indicating that the note was not found.
     *
     * @return an UpdateNoteResponse object with status ERROR and a message indicating failure
     */
    public static UpdateNoteResponse failed() {
        return new UpdateNoteResponse(ResponseStatus.ERROR, "Note id not found", null);
    }
}
