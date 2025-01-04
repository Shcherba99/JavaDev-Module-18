package com.goit.pshcherba.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Base response class for all note-related responses.
 * Contains the status of the response and an associated message.
 * This class serves as the parent for more specific note response classes.
 */
@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
@Getter
@Setter
public class NoteResponse {
    private ResponseStatus status;
    private String message;
}
