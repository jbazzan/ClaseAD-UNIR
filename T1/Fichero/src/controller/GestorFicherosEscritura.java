package controller;

import java.io.*;
import java.util.Scanner;

public class GestorFicherosEscritura {

    public void escribirFichero(String path) {

            //Esta linea es para crear un fichero nuevo cada vez que ejecuto el metodo
//        contador++;
//        path += "_escritura"+contador+".txt";

        // FILE -> FILEWRITER (escritura caracter a caracter) | BUFFERWRITER (escritura linea a linea) -> PRINTWRITER -> CERRAR
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null; // Es el mas eficiente y no hay que cerrar el flujo de datos

        // Para hacer la entrada de texto por teclado
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Por favor, introduce lo que quieres guardar");
//        String lecturaFrase = scanner.nextLine();

        // Para elegi si sobreescribir el fichero o no
//        System.out.println("Indica si quieres sobreescribir el fichero");
//        boolean sobreescribir = scanner.nextBoolean();

        try {

//            fileWriter = new FileWriter(file, sobreescribir); // El parametro append -> Anexamos o no la escritura
            //Si el archivo no existe, se crea automaticamente.
//            bufferedWriter = new BufferedWriter(fileWriter);
//            fileWriter.write(lecturaFrase);
//            bufferedWriter.newLine();
//            bufferedWriter.write(lecturaFrase);

            printWriter = new PrintWriter(file); // Es para sobreescribir, si quiero anexar tengo que leer y copia
            printWriter.println("Linea escrita con un printWriter");
            printWriter.println("Linea segunda escrita con un printWriter");

        } catch (IOException e) {
            System.out.println("Error al escribir fichero, por permisos");
        } finally {
            try {
//                fileWriter.close(); // Cierro el flujo para que se guarde
//                bufferedWriter.close();
                printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error al cierre del flujo");;
            }
        }

    }

}
