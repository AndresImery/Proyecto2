/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metromendeley;

/**
 *
 * @author andresimery
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Archivo {
    

    
    public Articulo cargar_archivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File archivo = fileChooser.getSelectedFile();

        try {
            Scanner scanner = new Scanner(archivo);

//            scanner.
            
            String titulo = scanner.nextLine();
//            System.out.println(scanner.nextLine());
            String autoresLine = "#";
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.startsWith("Resumen")) {
                    if (!line.contains("Autores")){
                        autoresLine = autoresLine +"#"+ line;//.split("\\n|\\r|\\r\\n");
                    }
                    
                } else {
                    break;
                }
            }
            
            autoresLine = autoresLine.replace("##", "");
            String[] autores = autoresLine.split("#");
            
//            String autoresString = scanner.nextLine();
//            String[] autores = autoresString.split(";");

            String cuerpo = "";
            String line = "";
            while (scanner.hasNextLine() && !(line = scanner.nextLine()).toLowerCase().contains("palabras claves:")) {
                cuerpo += line + "\n";
            }

            String palabrasClaveString = line.substring(16); // "Palabras clave: " tiene 16 caracteres
            String[] palabrasClaveArray = palabrasClaveString.split(", ");
            PalabraClave[] palabrasClave = new PalabraClave[palabrasClaveArray.length];
            for (int i = 0; i < palabrasClaveArray.length; i++) {
                palabrasClave[i] = new PalabraClave(palabrasClaveArray[i], 0); // Inicializamos la frecuencia en 0
            }


            Articulo articulo = new Articulo(titulo, autores, cuerpo, palabrasClave);

            scanner.close();
            
            for (PalabraClave palabrasClave1 : palabrasClave) {
                palabrasClave1.setFrecuencia(articulo.getCuerpo().split(palabrasClave1.getPalabra()).length - 1);
            }

            // Hacemos algo con el objeto Articulo, por ejemplo:
            System.out.println("Título: " + articulo.getTitulo());
            System.out.println("Autores:");
            for (String autor : articulo.getAutores()) {
                System.out.println("- " + autor);
            }
            System.out.println("Cuerpo:");
            System.out.println(articulo.getCuerpo());
            System.out.println("Palabras clave:");
            for (PalabraClave palabraClave : articulo.getPalabrasClave()) {
                System.out.println("- " + palabraClave.getPalabra() + ": " + palabraClave.getFrecuencia());
            }
            
            return articulo;
            
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        }
        return null;
    }
    


//    public void guardarEnArchivo(HashTable hash) {
//        File archivo = new File("proyecto.txt");
//        try {
//            if (archivo.createNewFile()) {
//                System.out.println("Archivo creado: " + archivo.getName());
//            } else {
//                System.out.println("El archivo ya existe.");
//            }
//        } catch (IOException e) {
//            System.out.println("Ocurrió un error al crear el archivo.");
//            e.printStackTrace();
//        }
//        
//        try {
//            FileWriter writer = new FileWriter("proyecto.txt");
//
//            // Recorrer la lista enlazada de nodos
//            Node current = hash.getKeys().getHead();
//            while (current != null) {
//                // Escribir la clave y los artículos en el archivo
//                writer.write(current.getKey() + "\n");
//
//                Articulo[] articulos = current.getArticulos();
//                for (int i = 0; i < articulos.length; i++) {
//                    Articulo articulo = articulos[i];
//                    String autores = String.join(", ", articulo.getAutores());
//                    PalabraClave[] palabrasClave = articulo.getPalabrasClave();
//                    String palabras = "";
//                    for (int j = 0; j < palabrasClave.length; j++) {
//                        palabras += palabrasClave[j].getPalabra() + "(" + palabrasClave[j].getFrecuencia() + ")";
//                        if (j < palabrasClave.length - 1) {
//                            palabras += ", ";
//                        }
//                    }
//
//                    writer.write(articulo.getTitulo() + "\n");
//                    writer.write(autores + "\n");
//                    writer.write(articulo.getCuerpo() + "\n");
//                    writer.write(palabras + "\n");
//                }
//
//                current = current.getNext();
//            }
//
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    
//
//    public void cargarDesdeArchivo(HashTable hash) {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("proyecto.txt"));
//            String line;
//
//            int currentKey = -1;
//            Articulo[] currentArticulos = null;
//            int articuloIndex = 0;
//
//            while ((line = reader.readLine()) != null) {
//                if (line.matches("[0-9]+")) {
//                    // Es una clave, crear un nuevo nodo
//                    currentKey = Integer.parseInt(line);
//                    currentArticulos = new Articulo[10];
//                    articuloIndex = 0;
//
//                    Node node = new Node(currentKey, currentArticulos);
//                    hash.getKeys().insertLast(node);
//                } else {
//                    // Es un artículo
//                    String titulo = line;
//                    String autoresLine = reader.readLine();
//                    String[] autores = autoresLine.split(", ");
//                    String cuerpo = reader.readLine();
//                    String palabrasLine = reader.readLine();
//                    String[] palabras = palabrasLine.split(", ");
//
//                    PalabraClave[] palabrasClave = new PalabraClave[palabras.length];
//                    for (int i = 0; i < palabras.length; i++) {
//                        String palabra = palabras[i].split("\\(")[0];
////                        int frecuencia = Integer.parseInt(palabras[i].split("\\(")[1].split("\\)")[0]);
//
////                        int frecuencia = Integer.parseInt(palabras[i].replaceAll(".*\\((\\d+)\\).*", "$1"));
//                        palabrasClave[i] = new PalabraClave(palabra, frecuencia);
//                    }
//
//                    Articulo articulo = new Articulo(titulo, autores, cuerpo, palabrasClave);
//                    currentArticulos[articuloIndex] = articulo;
//                    articuloIndex++;
//                }
//            }
//
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    




}
