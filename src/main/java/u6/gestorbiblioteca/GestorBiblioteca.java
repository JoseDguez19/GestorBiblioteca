/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package u6.gestorbiblioteca;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ap550
 */
public class GestorBiblioteca{
    
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        // Ejemplo: Agregar libros a la biblioteca
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));
        biblioteca.agregarLibro(new Libro("1984", "George Orwell", 1949));
        biblioteca.agregarLibro(new Libro("El principito", "Antoine de Saint-Exupéry", 1943));
        biblioteca.agregarLibro(new Libro("Colorin colorado este cuento aun no se ha acabado", "Odin Dupeyron", 2001));
        biblioteca.agregarLibro(new Libro("Ángeles y demonios", "Dan Brown", 2000));
        biblioteca.agregarLibro(new Libro("Deception Point", "Dan Brown", 2001));
        biblioteca.agregarLibro(new Libro("Digital Fortress", "Dan Brown", 1998));
        biblioteca.agregarLibro(new Libro("El código Da Vinci", "Dan Brown", 2003));
        biblioteca.agregarLibro(new Libro("El símbolo perdido", "Dan Brown", 2009));
        biblioteca.agregarLibro(new Libro("Inferno", "Dan Brown", 2013));
        biblioteca.agregarLibro(new Libro("Origen", "Dan Brown", 2017));
        biblioteca.agregarLibro(new Libro("Wild Symphony", "Dan Brown", 2020));
        biblioteca.agregarLibro(new Libro("El Psicoanalista","John Katznebach",1997));
        biblioteca.agregarLibro(new Libro("El Profesor","John Katznebach",2000));
        biblioteca.agregarLibro(new Libro("Juegos de Ingenio","John Katznebach",2001));
        biblioteca.agregarLibro(new Libro("El Estudiante","John Katznebach",2003));
        biblioteca.agregarLibro(new Libro("Dias de Ira","John Katznebach",2006));    
        biblioteca.agregarLibro(new Libro("El Principe","Nicolas Maquiavelo",1532));
        biblioteca.agregarLibro(new Libro("El arte de la Guerra","Sun Tzu",0000));
        biblioteca.agregarLibro(new Libro("Tiende tu cama","William H. McRaven",2017));

        // Menú de opciones
        int opcion;
        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libros por título");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Buscar libros por año");
            System.out.println("6. Realizar préstamo");
            System.out.println("7. Mostrar libros disponibles");
            System.out.println("0. Salir");
            System.out.print("Ingresa una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingresa el año de publicación del libro: ");
                    int año = scanner.nextInt();
                    biblioteca.agregarLibro(new Libro(titulo, autor, año));
                    System.out.println("Libro agregado correctamente.");
                    break;
                case 2:
                    System.out.print("Ingresa el título del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    List<Libro> librosEncontrados = biblioteca.buscarLibrosPorTitulo(tituloEliminar);
                    if (!librosEncontrados.isEmpty()) {
                        for (Libro libro : librosEncontrados) {
                            biblioteca.eliminarLibro(libro);
                        }
                        System.out.println("Libro(s) eliminado(s) correctamente.");
                    } else {
                        System.out.println("No se encontró ningún libro con ese título.");
                    }
                    break;
                case 3:
                    System.out.print("Ingresa el título del libro a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    List<Libro> librosEncontradosTitulo = biblioteca.buscarLibrosPorTitulo(tituloBuscar);
                    if (!librosEncontradosTitulo.isEmpty()) {
                        System.out.println("Libros encontrados:");
                        for (Libro libro : librosEncontradosTitulo) {
                            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getAño() + ")");
                        }
                    } else {
                        System.out.println("No se encontró ningún libro con ese título.");
                    }
                    break;
                case 4:
                    System.out.print("Ingresa el autor del libro a buscar: ");
                    String autorBuscar = scanner.nextLine();
                    List<Libro> librosEncontradosAutor = biblioteca.buscarLibrosPorAutor(autorBuscar);
                    if (!librosEncontradosAutor.isEmpty()) {
                        System.out.println("Libros encontrados:");
                        for (Libro libro : librosEncontradosAutor) {
                            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getAño() + ")");
                        }
                    } else {
                        System.out.println("No se encontró ningún libro con ese autor.");
                    }
                    break;
                case 5:
                    System.out.print("Ingresa el año del libro a buscar: ");
                    int añoBuscar = scanner.nextInt();
                    List<Libro> librosEncontradosAño = biblioteca.buscarLibrosPorAño(añoBuscar);
                    if (!librosEncontradosAño.isEmpty()) {
                        System.out.println("Libros encontrados:");
                        for (Libro libro : librosEncontradosAño) {
                            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getAño() + ")");
                        }
                    } else {
                        System.out.println("No se encontró ningún libro con ese año.");
                    }
                    break;
                case 6:
                    System.out.print("Ingresa el título del libro a prestar: ");
                    String tituloPrestamo = scanner.nextLine();
                    List<Libro> librosEncontradosPrestamo = biblioteca.buscarLibrosPorTitulo(tituloPrestamo);
                    if (!librosEncontradosPrestamo.isEmpty()) {
                        biblioteca.realizarPrestamo(librosEncontradosPrestamo.get(0));
                    } else {
                        System.out.println("No se encontró ningún libro con ese título.");
                    }
                    break;
                case 7:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }
}