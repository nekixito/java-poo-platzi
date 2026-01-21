package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("PLATZI PLAY 🍿");

        Pelicula pelicula = new Pelicula();

        pelicula.titulo = "El señor de los anillos";
        pelicula.anioEstreno = 2001;
        pelicula.genero = "Fantasia";
        pelicula.calificar(4.7);

        //System.out.println(pelicula.obtenerFichaTecnica());

        Usuario usuario = new Usuario();
        usuario.nombre = "Miguel";

        usuario.ver(pelicula);

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Cuál es tu nombre?");
        String nombre = scanner.nextLine();

        System.out.println("Hola " + nombre + ", esto es Platzi Play!");

        System.out.println(nombre + ", cuantos años tienes?");
        int edad = scanner.nextInt();

        System.out.println(nombre + " puedes ver contenido +" + edad);*/
    }
}
