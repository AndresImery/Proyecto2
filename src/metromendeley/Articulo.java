/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metromendeley;

/**
 *
 * @author andresimery
 */
public class Articulo {
    
    private String titulo;
    private String[] autores;
    private String cuerpo;
    private PalabraClave[] palabrasClave;

    public Articulo(String titulo, String[] autores, String cuerpo, PalabraClave[] palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.cuerpo = cuerpo;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public PalabraClave[] getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(PalabraClave[] palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    
    public String stringArticle() {
        String articuloString = "";

        articuloString = articuloString + "Título: " + getTitulo() + "\n";
            // Hacemos algo con el objeto Articulo, por ejemplo:
      
        articuloString = articuloString + "Autores:\n";
        for (String autor : getAutores()) {
            articuloString = articuloString + "- " + autor + "\n";
                
        }
        
        articuloString = articuloString + "Resumen:\n" + getCuerpo() + "\n";
        
        articuloString = articuloString + "Palabras clave:\n";
            
        for (PalabraClave palabraClave : getPalabrasClave()) {
            articuloString = articuloString + "- " + palabraClave.getPalabra() + ": " + palabraClave.getFrecuencia() + "\n";
                
        }
            
        return articuloString;
    }
    
}
