package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannersUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static final String NOMBRE_PLATAFORMA = "PLATZI PLAY 🍿";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        System.out.println( NOMBRE_PLATAFORMA + " v" + VERSION);

        String nombre = ScannersUtils.capturarTexto("Nombre del contenido");
        String genero = ScannersUtils.capturarTexto("Genero del contenido");
        int duracion = ScannersUtils.capturarNumero("Duracion del contenido");
        double calificacion =  ScannersUtils.capturarDecimal("Calificación del contenido");

        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);

        System.out.println(pelicula.obtenerFichaTecnica());

        Usuario usuario = new Usuario("Miguel","miguel@mail.com");
        usuario.ver(pelicula);

    }
}
