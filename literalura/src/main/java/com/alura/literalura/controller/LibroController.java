package com.alura.literalura.controller;

import com.alura.literalura.model.Libro;
import com.alura.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {

    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/buscarLibro")
    public Libro buscarLibro(@RequestParam String titulo) {
        return gutendexService.buscarLibroPorTitulo(titulo);
    }
}
