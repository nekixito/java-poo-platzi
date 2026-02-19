package platzi.play.plataforma;

import platzi.play.contenido.Genero;
import platzi.play.contenido.Pelicula;
import platzi.play.contenido.ResumenContenido;
import platzi.play.excepcion.PeliculaExistenteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido;
    private Map<Pelicula, Integer> visualizaciones;

    public Plataforma(String nombre){
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agregar(Pelicula elemento){
        Pelicula contenido = this.buscarPorTitulo(elemento.getTitulo());

        if (contenido != null){
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        this.contenido.add(elemento);
    }

    public void reproducir(Pelicula contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido,0);
        System.out.println(contenido.getTitulo() + " ha sido reproducido " + conteoActual + " veces.");

        this.contarVisualizacion(contenido);
        visualizaciones.put(contenido, conteoActual + 1);
        contenido.reproducir();
    }

    private void contarVisualizacion(Pelicula contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido,0);
        visualizaciones.put(contenido, conteoActual);
    }

    public void mostrarTitulos(){
        //for (Pelicula pelicula : contenido) {
        //    System.out.println(pelicula.getTitulo());
        //}

        contenido.forEach(contenido -> System.out.println(contenido.getTitulo()));
    }

    public List<String> getTitulos(){
        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
    }


    public List<ResumenContenido> getResumenes(){
        return contenido.stream()
                .map(c -> new ResumenContenido(c.getTitulo(), c.getDuracion(),c.getGenero()))
                .toList();
    }

    public void eliminar(Pelicula elemento){
        this.contenido.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo){

        return contenido.stream()
                .filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);


        /*
        for (Pelicula pelicula: contenido){
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)){
                return pelicula;
            }
        }
        return null;
        */
    }

    public List<Pelicula> buscarPorGenero(Genero genero){
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }
}
