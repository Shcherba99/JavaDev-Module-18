package com.goit.javadevmodule18.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class representing a note.
 * Contains fields for ID, title, and content, along with
 * relevant constructors, getters, and setters.
 */
@Entity
@Table(schema = "goit", name = "note")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    /**
     * Constructor for creating a note with a title and content.
     * The ID is not set and should be assigned later by the service.
     *
     * @param title   the title of the note.
     * @param content the content of the note.
     */
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}