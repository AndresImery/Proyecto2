/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metromendeley;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author andresimery
 */
public class HashTable {
    
    private List keys;

    public HashTable() {
        this.keys = new List();
    }

    public List getKeys() {
        return keys;
    }

    public void setKeys(List keys) {
        this.keys = keys;
    }
    
    public Integer funcionHash(String titulo) {
        int hash = 7;
        for (int i = 0; i < titulo.length(); i++) {
            hash = hash * 31 + titulo.charAt(i);
        }
        return hash;
    }
    
    public boolean containsKey(int clave) {
        if (getKeys().isEmpty()) {
            return false;
        }
        Node pointer = getKeys().getHead();
        
        while (pointer.getNext() != null) {
            if (pointer.getKey() == clave) {
                return true;
            }
            pointer = pointer.getNext();
        }
        
        if (pointer.getKey() == clave) {
            return true;
        }
        
        return false;
    }

    public boolean isEmpty() {
        return getKeys().getHead() == null;
    }
    
    public void agregarArticulo(Articulo articulo) {
        int clave = funcionHash(articulo.getTitulo());

        keys.insertArticle(clave, articulo, containsKey(clave));
    }
    
    public Articulo buscarArticuloPorTitulo(String titulo) {
        int clave = funcionHash(titulo);
        
        Articulo articulo = null;
        
        if (containsKey(clave)) {
            articulo = getKeys().buscarArticuloPorTitulo(clave, titulo);
        }
        
        return articulo;
        
    }
    
    public Articulo buscarArticuloPorAutor(String autor) {
        
        Articulo articulo = getKeys().buscarArticuloPorAutor(autor);
        
        return articulo;
        
    }
    
     public Articulo buscarArticuloPorPalabraClave(String palabra_clave) {
        
        Articulo articulo = getKeys().buscarArticuloPorPalabraClave(palabra_clave);
        
        return articulo;
        
    }
     
     public Articulo[] mostrarTodos() {
         if (getKeys().isEmpty()) {
             return null;
         }
         
         Node node = getKeys().getHead();
         Node node2 = getKeys().getHead();
         
         
         int size = 0;
         
         
         while (node != null) {
             for (int i = 0; i < node.getArticulos().length; i++) {
                 size = size + 1;
             }
             node = node.getNext();
         }
         
         Articulo[] articulos = new Articulo[size];
         
         int size2 = 0;
         
         while (node2 != null) {
             for (int i = 0; i < node2.getArticulos().length; i++) {
                 articulos[size2] = node2.getArticulos()[i];
                 size2 = size2 + 1;
             }
             node2 = node2.getNext();
         }
         
         return articulos;
         
     }
     
     public void saveHashTableToFile(HashTable hashTable, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            Node currentNode = hashTable.getKeys().getHead();
            while (currentNode != null) {
                bw.write(currentNode.getKey() + "\n");
                Articulo[] articulos = currentNode.getArticulos();
                for (Articulo articulo : articulos) {
                    bw.write(articulo.getTitulo() + "\n");
                    bw.write(String.join(",", articulo.getAutores()) + "\n");
                    bw.write(articulo.getCuerpo() + "\n");
                    PalabraClave[] palabrasClave = articulo.getPalabrasClave();
                    for (PalabraClave palabraClave : palabrasClave) {
                        bw.write(palabraClave.getPalabra() + "," + palabraClave.getFrecuencia() + "\n");
                    }
                }
                currentNode = currentNode.getNext();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public HashTable loadHashTableFromFile(String fileName) {
        HashTable hashTable = new HashTable();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            Node currentNode = null;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches("\\d+")) {
                    int key = Integer.parseInt(line);
                    Articulo[] articulos = new Articulo[5];
                    currentNode = new Node(key, articulos);
                    hashTable.getKeys().insertLast(currentNode);
                } else {
                    String[] parts = line.split(",");
                    if (parts.length == 1) {
                        currentNode.getArticulos()[0] = new Articulo(parts[0], null, null, null);
                    } else if (parts.length == 2) {
                        String[] autores = parts[1].split(",");
                        currentNode.getArticulos()[0] = new Articulo(parts[0], autores, null, null);
                    } else if (parts.length == 3) {
                        currentNode.getArticulos()[0] = new Articulo(parts[0], null, parts[2], null);
                    } else if (parts.length == 4) {
                        String[] autores = parts[1].split(",");
                        String cuerpo = parts[2];
                        String[] palabrasClaveStrs = parts[3].split(";");
                        PalabraClave[] palabrasClave = new PalabraClave[palabrasClaveStrs.length];
                        for (int i = 0; i < palabrasClaveStrs.length; i++) {
                            String[] palabraClaveParts = palabrasClaveStrs[i].split(",");
                            String palabra = palabraClaveParts[0];
                            int frecuencia = Integer.parseInt(palabraClaveParts[1]);
                            palabrasClave[i] = new PalabraClave(palabra, frecuencia);
                        }
                        currentNode.getArticulos()[0] = new Articulo(parts[0], autores, cuerpo, palabrasClave);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        return hashTable;
     }
    
}
