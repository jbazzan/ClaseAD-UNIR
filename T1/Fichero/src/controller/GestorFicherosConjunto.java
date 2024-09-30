package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorFicherosConjunto {

    public void lecturaEscritura(String path){
        Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        FileWriter fileWriter = null;

        System.out.println("Por favor, introduce el mensaje que quieres guardar");
        String mensaje = scanner.nextLine();

        try {
            fileWriter = new FileWriter(file); // Como esto esta fuera del for, me guarda todo
//            fileWriter.write(mensaje);
            // Necesitamos escribir caracter por caracter
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
//                fileWriter.write(letra + "\n");

                // Para cifrar el contenido
                int codigo = (int) letra;
//                fileWriter.write(String.valueOf(codigo) + "\n");

                // Para que quede cifrado lo multiplico
                fileWriter.write(String.valueOf(codigo*5) + "\n");
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el mensaje");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("No se pudo guardar el mensaje");
            }
        }

    }

}
