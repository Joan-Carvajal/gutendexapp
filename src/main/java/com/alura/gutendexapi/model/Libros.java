package com.alura.gutendexapi.model;

import java.util.List;

public class Libros {
    private String titulo;
    private List<String> autor;
    private List<String> idiomas;
    private Integer cantidadDeDescargas;

    public Libros(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutor() {
        return autor;
    }

    public void setAutor(List<String> autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    public void setCantidadDeDescargas(Integer cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }
}
