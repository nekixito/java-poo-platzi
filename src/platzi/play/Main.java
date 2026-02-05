package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannersUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static final String NOMBRE_PLATAFORMA = "PLATZI PLAY 🍿";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println( NOMBRE_PLATAFORMA + " v" + VERSION);

        String nombre = ScannersUtils.capturarTexto("Nombre del contenido");
        String genero = ScannersUtils.capturarTexto("Genero del contenido");
        int duracion = ScannersUtils.capturarNumero("Duracion del contenido");
        double calificacion =  ScannersUtils.capturarDecimal("Calificación del contenido");

        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);
        Pelicula pelicula2 = new Pelicula("F1 the movie",220,"Accion");

        plataforma.agregar(pelicula);
        plataforma.agregar(pelicula2);
        System.out.println("Numero de elementos en la plataforma: " + plataforma.getContenido().size());
        plataforma.eliminar(pelicula2);

        System.out.println(pelicula.obtenerFichaTecnica());

        plataforma.mostrarTitulos();;

        Usuario usuario = new Usuario("Miguel","miguel@mail.com");
        usuario.ver(pelicula);

    }
}
