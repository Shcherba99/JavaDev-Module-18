package com.goit.javadevmodule18.error;

import com.goit.javadevmodule18.dto.responce.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

/**
 * Global exception handler for the application.
 * This class is responsible for handling validation errors that occur
 * during the processing of HTTP requests.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions thrown due to invalid method arguments,
     * specifically when a validation constraint is violated.
     *
     * @param ex the exception containing the validation errors
     * @return a ResponseEntity containing the error message in an ErrorResponse body
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationNoteException(MethodArgumentNotValidException ex) {
        String errorMessage = getErrorMessage(ex);
        return ResponseEntity.badRequest().body(ErrorResponse.builder().message(errorMessage).build());
    }

    /**
     * Extracts and constructs an error message from the validation errors.
     * The error messages are concatenated with a semicolon.
     *
     * @param ex the exception containing the validation errors
     * @return a concatenated string of validation error messages
     */
    private String getErrorMessage(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
    }
}
