/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u6.gestorbiblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ap550
 */
class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public List<Libro> buscarLibrosPorAño(int año) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAño() == año) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public void realizarPrestamo(Libro libro) {
        if (libro.isDisponible()) {
            libro.setDisponible(false);
            System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido prestado.");
        } else {
            System.out.println("El libro \"" + libro.getTitulo() + "\" no está disponible para préstamo.");
        }
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles en la biblioteca:");
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getAño() + ")");
            }
        }
    }
}