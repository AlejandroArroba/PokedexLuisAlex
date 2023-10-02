package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Pokemon;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TypeToken<List<Pokemon>> pokemonListaType = new TypeToken<List<Pokemon>>().getType();

        System.out.println("Hello world!");

        Path rutaRelativaActual = Paths.get("");
        String ruta = rutaRelativaActual.toAbsolutePath().toString();
        String directorio = ruta + File.separator + "data";
        String archivoPokemon = directorio + File.separator + "pokemon.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileReader lector = new FileReader(archivoPokemon)){

            List<Pokemon> pokemons = gson.fromJson(lector, pokemonListaType);

            pokemons.forEach(System.out::println);
        }catch (IOException e){

        }

    }
}