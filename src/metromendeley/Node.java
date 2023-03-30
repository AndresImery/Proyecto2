/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metromendeley;

/**
 *
 * @author andresimery
 */
public class Node {
    private int key;
    private Articulo[] articulos;
    private Node next;

    public Node(int key, Articulo[] articulos) {
        this.key = key;
        this.articulos = articulos;
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void addArticulo(Articulo articulo) {
        Articulo[] new_articulos = new Articulo[articulos.length + 1];
        for (int i = 0; i < articulos.length; i++) {
            new_articulos[i] = articulos[i];
        }
        new_articulos[articulos.length] = articulo;
        
        setArticulos(new_articulos);
    }
    
    
}
