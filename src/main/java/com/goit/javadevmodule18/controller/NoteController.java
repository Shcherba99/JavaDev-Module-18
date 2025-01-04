package com.goit.javadevmodule18.controller;

import com.goit.javadevmodule18.dto.request.CreateNoteRequest;
import com.goit.javadevmodule18.dto.request.UpdateNoteRequest;
import com.goit.javadevmodule18.dto.responce.*;
import com.goit.javadevmodule18.dto.responce.ResponseStatus;
import com.goit.javadevmodule18.sevice.NoteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class that handles requests related to notes.
 * Provides endpoints to create, update, delete, and fetch notes.
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteServiceImpl noteService;

    /**
     * Retrieves all notes.
     *
     * @return A response entity containing all notes with a status of OK.
     */
    @GetMapping
    public ResponseEntity<GetAllNotesResponse> getAllNotes() {
        GetAllNotesResponse response = noteService.getAllNotes();
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves a single note by its ID.
     *
     * @param id The ID of the note to retrieve.
     * @return A response entity containing the note or a NOT_FOUND status if the note is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<GetNoteResponse> getNote(@PathVariable Long id) {
        GetNoteResponse response = noteService.getNoteById(id);
        return response.getStatus() == ResponseStatus.OK
                ? ResponseEntity.status(HttpStatus.OK).body(response)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Creates a new note.
     *
     * @param request The request body containing the data for the new note.
     * @return A response entity containing the created note with a CREATED status,
     * or a BAD_REQUEST status if creation fails.
     */
    @PostMapping
    public ResponseEntity<CreateNoteResponse> createNote(@Valid @RequestBody CreateNoteRequest request) {
        CreateNoteResponse response = noteService.createNote(request);
        return response.getStatus() == ResponseStatus.OK
                ? ResponseEntity.status(HttpStatus.CREATED).body(response)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Updates an existing note by its ID.
     *
     * @param id      The ID of the note to update.
     * @param request The request body containing the updated data for the note.
     * @return A response entity containing the updated note with a status of OK,
     * or NOT_FOUND if the note was not found.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<UpdateNoteResponse> updateNote(@PathVariable long id,
                                                         @Valid @RequestBody UpdateNoteRequest request) {
        UpdateNoteResponse response = noteService.updateNote(id, request);
        return response.getStatus() == ResponseStatus.OK
                ? ResponseEntity.ok(response)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Deletes a note by its ID.
     *
     * @param id The ID of the note to delete.
     * @return A response entity indicating whether the deletion was successful, with a status of OK or NOT_FOUND.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteNoteResponse> deleteNote(@PathVariable long id) {
        DeleteNoteResponse response = noteService.deleteNote(id);

        return response.getStatus() == ResponseStatus.OK
                ? ResponseEntity.ok(response)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
