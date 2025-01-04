package com.goit.pshcherba.dto.responce;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

/**
 * Response DTO for error responses.
 * Extends {@link NoteResponse} to reuse common response properties such as status and message.
 */
@JsonPropertyOrder({"status", "message"})
public class ErrorResponse extends NoteResponse {


    /**
     * Constructor to create an error response with a custom message.
     * The status is automatically set to ERROR.
     *
     * @param message the error message providing information about the error
     */
    @Builder
    public ErrorResponse(String message) {
        super(ResponseStatus.ERROR, message);
    }
}
