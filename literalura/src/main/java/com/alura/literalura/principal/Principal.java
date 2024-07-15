package com.alura.literalura.principal;

import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final GutendexService gutendexService;

    @Autowired
    public Principal(LibroRepository libroRepository, AutorRepository autorRepository, GutendexService gutendexService) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.gutendexService = gutendexService;
    }

    public void muestraElMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("******************* Menu *******************");
            System.out.println("1 - Buscar libro por título");
            System.out.println("2 - Listar libros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos en un determinado año");
            System.out.println("5 - Listar libros por idioma");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    buscarLibroPorTitulo(titulo);
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int anio = scanner.nextInt();
                    listarAutoresVivosEnAnio(anio);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma (e.g., en, es): ");
                    String idioma = scanner.nextLine();
                    listarLibrosPorIdioma(idioma);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private void buscarLibroPorTitulo(String titulo) {
        String libros = gutendexService.toString();
        System.out.println(libros);
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    private void listarAutoresVivosEnAnio(int anio) {
        List<Autor> autores = autorRepository.findByFechaDeNacimientoLessThanEqualAndFechaDeFallecimientoGreaterThanEqual(anio);
        autores.forEach(System.out::println);
    }

    private void listarLibrosPorIdioma(String idioma) {
        String libros = libroRepository.toString();
        System.out.println(libros);
    }


}

