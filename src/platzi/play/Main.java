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

    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int ELIMINAR  = 4;
    public static final int SALIR = 5;



    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println( NOMBRE_PLATAFORMA + " v" + VERSION);

        while (true){
            int opcionElegiada = ScannersUtils.capturarNumero("""
                    Ingrese una de las siguientes opciones:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por titulo
                    4. Eliminar
                    5. Salir
                    """);
            System.out.println("Opcion elegina: " + opcionElegiada);

            switch (opcionElegiada){
                case AGREGAR -> {
                    String nombre = ScannersUtils.capturarTexto("Nombre del contenido");
                    String genero = ScannersUtils.capturarTexto("Genero del contenido");
                    int duracion = ScannersUtils.capturarNumero("Duracion del contenido");
                    double calificacion =  ScannersUtils.capturarDecimal("Calificación del contenido");

                    plataforma.agregar(new Pelicula(nombre,duracion,genero,calificacion));
                }
                case MOSTRAR_TODO -> plataforma.mostrarTitulos();
                case BUSCAR_POR_TITULO -> {
                    //Falta
                }
                case ELIMINAR -> {
                    //Falta
                }
                case SALIR -> {
                    System.exit(0);
                }
            }
        }

        /*
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
        */
    }
}
