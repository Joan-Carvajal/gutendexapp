package com.alura.gutendexapi.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> tClass);
}
