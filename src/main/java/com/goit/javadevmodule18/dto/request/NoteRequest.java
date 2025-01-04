package com.goit.javadevmodule18.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Base DTO class for representing a note's title and content.
 * This class is used as a common parent for both creating and updating notes.
 */
@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
@Getter
@Setter
public class NoteRequest {

    /**
     * The title of the note.
     */
    @NotNull(message = "The note title must not be null")
    @NotBlank(message = "The note title must not be empty")
    @Size(
            min = 3,
            max = 50,
            message = "The length of the note title should be at least 3 and no more than 50 characters"
    )
    private String title;

    /**
     * The content of the note.
     */
    @NotNull(message = "The note content must not be null")
    @NotBlank(message = "The note content must not be empty")
    @Size(
            min = 5,
            max = 500,
            message = "The length of the note content should be at least 5 and no more than 500 characters"
    )
    private String content;
}
