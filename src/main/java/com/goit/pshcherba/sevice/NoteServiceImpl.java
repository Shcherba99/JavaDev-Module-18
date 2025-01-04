package com.goit.pshcherba.sevice;

import com.goit.pshcherba.dto.request.CreateNoteRequest;
import com.goit.pshcherba.dto.request.UpdateNoteRequest;
import com.goit.pshcherba.dto.responce.*;
import com.goit.pshcherba.entity.Note;
import com.goit.pshcherba.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the {@link NoteService} interface.
 * Provides business logic for managing notes, including CRUD operations.
 */
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    /**
     * Retrieves all notes.
     *
     * @return a response containing a list of all notes, or an empty list message if no notes are found
     */
    @Override
    public GetAllNotesResponse getAllNotes() {
        return Optional.of(noteRepository.findAll())
                .filter(notes -> !notes.isEmpty())
                .map(GetAllNotesResponse::success)
                .orElseGet(GetAllNotesResponse::successEmptyList);
    }

    /**
     * Retrieves a note by its unique identifier.
     *
     * @param id the unique identifier of the note
     * @return a response containing the requested note or an error if not found
     */
    @Override
    public GetNoteResponse getNoteById(Long id) {
        return noteRepository.findById(id)
                .map(GetNoteResponse::success)
                .orElseGet(GetNoteResponse::failed);
    }

    /**
     * Creates a new note.
     *
     * @param request the request object containing the note data
     * @return a response indicating the success of note creation and the created note's ID
     */
    @Override
    public CreateNoteResponse createNote(CreateNoteRequest request) {
        Note createdNote = noteRepository.save(new Note(request.getTitle(), request.getContent()));
        return CreateNoteResponse.success(createdNote.getId());
    }

    /**
     * Updates an existing note.
     *
     * @param id the unique identifier of the note to be updated
     * @param request the request object containing the updated note data
     * @return a response indicating success or failure of the update
     */
    @Override
    public UpdateNoteResponse updateNote(long id, UpdateNoteRequest request) {
        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isEmpty()) {
            return UpdateNoteResponse.failed();
        }

        Note note = optionalNote.get();

        Optional.ofNullable(request.getTitle()).ifPresent(note::setTitle);
        Optional.ofNullable(request.getContent()).ifPresent(note::setContent);
        noteRepository.save(note);

        return UpdateNoteResponse.success(note);
    }

    /**
     * Deletes a note by its unique identifier.
     *
     * @param id the unique identifier of the note to be deleted
     * @return a response indicating success or failure of the deletion
     */
    @Override
    public DeleteNoteResponse deleteNote(long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isEmpty()) {
            return DeleteNoteResponse.failed();
        }

        Note note = optionalNote.get();
        noteRepository.delete(note);
        return DeleteNoteResponse.success();
    }
}
