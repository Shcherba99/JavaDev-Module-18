package com.goit.javadevmodule18.dto.request;

/**
 * DTO class for updating an existing note.
 * Inherits from {@link NoteRequest} to reuse title and content validation logic.
 */
public class UpdateNoteRequest extends NoteRequest {

    /**
     * Constructor to initialize the title and content for the update request.
     *
     * @param title the new title of the note
     * @param content the new content of the note
     */
    public UpdateNoteRequest(String title, String content) {
        super(title, content);
    }
}
