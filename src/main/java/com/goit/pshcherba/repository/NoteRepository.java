package com.goit.pshcherba.repository;

import com.goit.pshcherba.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for managing {@link Note} entities.
 * This interface extends {@link JpaRepository}, providing standard CRUD operations for notes.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
