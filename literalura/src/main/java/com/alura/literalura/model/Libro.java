package com.alura.literalura.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean copyright;
    private String mediaType;
    private Integer downloadCount;

    @ElementCollection
    private List<String> subjects;

    @ElementCollection
    private List<String> bookshelves;

    @ElementCollection
    private List<String> languages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> authors;



    @ElementCollection
    private List<String> formats;
}
