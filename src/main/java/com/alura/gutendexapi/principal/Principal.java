package com.alura.gutendexapi.principal;

import com.alura.gutendexapi.model.Datos;
import com.alura.gutendexapi.model.DatosLibro;
import com.alura.gutendexapi.service.ConsumoApi;
import com.alura.gutendexapi.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE="https://gutendex.com/books/";

    public void muestraDatos(){

        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);

      var datos = convierteDatos.obtenerDatos(json, Datos.class);

        datos.libros().stream()
                .limit(5)
                .forEach(System.out::println);

        // top 10 de libros mas descargado

        System.out.println("Top 10 de libros mas descargados");
        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibro::cantidadDeDescargas).reversed())
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Ingrese el nombre del libro que desea buscar");
        var nombreDelLibro = scanner.nextLine();
        var busqueda = consumoApi.obtenerDatos(URL_BASE+"?search="+nombreDelLibro.replace(" ","+"));
         var covertirBusqueda = convierteDatos.obtenerDatos(busqueda,Datos.class);
        Optional<DatosLibro> libroBuscado = covertirBusqueda.libros().stream()
                        .filter(t->t.titulo().toUpperCase().contains(nombreDelLibro.toUpperCase()))
                                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("No se encontro el libro");
        }

        // Estadisticas
        IntSummaryStatistics est = datos.libros().stream()
                .collect(Collectors.summarizingInt(DatosLibro::cantidadDeDescargas));
        System.out.println(est);





    }
}
