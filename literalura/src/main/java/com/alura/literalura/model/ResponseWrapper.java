package com.alura.literalura.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapper {
    private Integer count;
    private String next;
    private String previous;
    private List<Libro> results;
}
