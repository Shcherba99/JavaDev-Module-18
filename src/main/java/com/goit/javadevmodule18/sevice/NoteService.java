package com.goit.javadevmodule18.sevice;

import com.goit.javadevmodule18.dto.request.CreateNoteRequest;
import com.goit.javadevmodule18.dto.request.UpdateNoteRequest;
import com.goit.javadevmodule18.dto.responce.*;

/**
 * Service interface for managing notes.
 * Provides methods for performing CRUD operations on notes.
 */
public interface NoteService {

    /**
     * Retrieves all notes.
     *
     * @return a response containing a list of all notes
     */
    GetAllNotesResponse getAllNotes();

    /**
     * Retrieves a note by its unique identifier.
     *
     * @param id the unique identifier of the note
     * @return a response containing the requested note or an error if not found
     */
    GetNoteResponse getNoteById(Long id);

    /**
     * Creates a new note.
     *
     * @param request the request object containing note data
     * @return a response indicating success or failure of note creation
     */
    CreateNoteResponse createNote(CreateNoteRequest request);

    /**
     * Updates an existing note.
     *
     * @param id the unique identifier of the note to be updated
     * @param request the request object containing updated note data
     * @return a response indicating success or failure of the update
     */
    UpdateNoteResponse updateNote(long id, UpdateNoteRequest request);

    /**
     * Deletes a note by its unique identifier.
     *
     * @param id the unique identifier of the note to be deleted
     * @return a response indicating success or failure of the deletion
     */
    DeleteNoteResponse deleteNote(long id);
}
