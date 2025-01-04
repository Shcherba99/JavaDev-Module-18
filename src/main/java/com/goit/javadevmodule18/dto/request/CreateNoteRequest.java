package com.goit.javadevmodule18.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO class for handling the creation of a new note.
 * Inherits common properties (title, content) from {@link NoteRequest}.
 */
@Getter
@Setter
public class CreateNoteRequest extends NoteRequest {

    /**
     * Constructs a CreateNoteRequest with the specified title and content.
     *
     * @param title   the title of the note
     * @param content the content of the note
     */
    public CreateNoteRequest(String title, String content) {
        super(title, content);
    }
}
