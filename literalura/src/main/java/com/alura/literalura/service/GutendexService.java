package com.alura.literalura.service;

import com.alura.literalura.model.Libro;
import com.alura.literalura.model.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GutendexService {

    @Autowired
    private ConsumoAPI consumoAPI;

    @Autowired
    private ConvierteDatos convierteDatos;

    public Libro buscarLibroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo.replace(" ", "%20");
        String jsonResponse = consumoAPI.obtenerDatos(url);
        ResponseWrapper responseWrapper = convierteDatos.obtenerDatos(jsonResponse, ResponseWrapper.class);
        if (responseWrapper.getResults().isEmpty()) {
            throw new RuntimeException("No se encontraron libros con el título: " + titulo);
        }
        return responseWrapper.getResults().get(0);
    }
}
