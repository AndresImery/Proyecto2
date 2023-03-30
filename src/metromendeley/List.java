/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metromendeley;

/**
 *
 * @author andresimery
 */
public class List {
    
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void insertLast(Node node) {
        
        if (isEmpty()) {
            setHead(node);
        } else {
            Node pointer = getHead();
            
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
    }
    
    public void insertArticle(int key, Articulo articulo, boolean contains_key) {
        if (!contains_key) {
            Articulo[] newArray = {articulo};
            Node node = new Node(key, newArray);
            insertLast(node);
        } else {
            Node pointer = getHead();
            while (pointer.getKey() != key) {
                pointer = pointer.getNext();
            }
            pointer.addArticulo(articulo);
        }
    }
    
    public Node findNode(int key) {
        Node pointer = getHead();
        while (pointer != null) {
            
            if (pointer.getKey() == key) {
                return pointer;
            }
            
            pointer = pointer.getNext();
        }
        
        return null;
        
    }
    
    public Articulo buscarArticuloPorTitulo(int key, String titulo) {
        Node node = findNode(key);
        
        if (node != null) {
            Articulo[] articulos = node.getArticulos();
            for (int i = 0; i < articulos.length; i++) {
                if (articulos[i].getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                    return articulos[i];
                }
            }
        }
        
        return null;
        
    }
    
    public Articulo buscarArticuloPorAutor(String autor) {
        Node pointer = getHead();
        if (isEmpty()) {
            return null;
        }
        
        Articulo[] articulos = null;
        String[] autores = null;
        
        while (pointer != null) {
            for (int i = 0; i < pointer.getArticulos().length; i++) {
                articulos = pointer.getArticulos();
                for (int j = 0; j < articulos[i].getAutores().length; j++) {
                    autores = articulos[i].getAutores();
                    if (autores[j].toLowerCase().equals(autor.toLowerCase())) {
                        return pointer.getArticulos()[i];
                    }
                }
            }
            pointer = pointer.getNext();
        }
        return null;
        
    }
    
    public Articulo buscarArticuloPorPalabraClave(String palabra_clave) {
        Node pointer = getHead();
        if (isEmpty()) {
            return null;
        }
        
        Articulo[] articulos = null;
        PalabraClave[] palabras = null;
        
        while (pointer != null) {
            for (int i = 0; i < pointer.getArticulos().length; i++) {
                articulos = pointer.getArticulos();
                for (int j = 0; j < articulos[i].getPalabrasClave().length; j++) {
                    palabras = articulos[i].getPalabrasClave();
                    if (palabras[j].getPalabra().toLowerCase().equals(palabra_clave.toLowerCase())) {
                        
                        return pointer.getArticulos()[i];
                    }
                }
            }
            pointer = pointer.getNext();
        }
        return null;
        
    }
    
}
