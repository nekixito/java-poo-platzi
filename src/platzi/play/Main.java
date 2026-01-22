package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannersUtils;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("PLATZI PLAY 🍿");

        String nombre = ScannersUtils.capturarTexto("Nombre del contenido");
        String genero = ScannersUtils.capturarTexto("Genero del contenido");
        int duracion = ScannersUtils.capturarNumero("Duracion del contenido");
        double calificacion =  ScannersUtils.capturarDecimal("Calificación del contenido");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = nombre;
        pelicula.fechaEstreno = LocalDate.of(2018,10,15);
        pelicula.genero = genero;
        pelicula.calificar(calificacion);
        pelicula.duracion = duracion;

        System.out.println(pelicula.obtenerFichaTecnica());

        Usuario usuario = new Usuario();
        usuario.nombre = "Miguel";
        usuario.fechaRegistro = LocalDateTime.of(2025,12,24,17,15,14);

        usuario.ver(pelicula);

    }
}
