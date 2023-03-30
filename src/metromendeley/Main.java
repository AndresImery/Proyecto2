/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metromendeley;



/**
 *
 * @author andresimery
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Archivo archivo = new Archivo();
        HashTable hash = new HashTable();
        
//        hash = hash.loadHashTableFromFile("proyecto.txt");
        
        
        
//        String titulo = "Hola";
//        String[] autores = {"Andres", "Luis"};
//        PalabraClave[] palabras = {new PalabraClave("uno", 3), new PalabraClave("dos", 5)};
//        String cuerpo = "uno uno uno, dos dos dos dos dos.";
//        
//        Articulo articulo = new Articulo(titulo, autores, cuerpo, palabras);
//        hash.agregarArticulo(articulo);
//        
//        System.out.println(hash.buscarArticuloPorTitulo("Hola").getTitulo());
//        System.out.println(hash.buscarArticuloPorAutor("Andres").getTitulo());
//        System.out.println(hash.buscarArticuloPorPalabraClave("uno").getTitulo());
//        
//        Articulo articulo = archivo.cargar_archivo();
//        
//        hash.agregarArticulo(articulo);
        
        Ventana1 ventana1 = new Ventana1(hash);

    }
    
}
