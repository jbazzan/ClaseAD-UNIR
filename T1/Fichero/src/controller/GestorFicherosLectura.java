package controller;

import java.io.*;

public class GestorFicherosLectura {

    public void lecturaDirectorios(String path){

        File file = new File(path);
//        String[] nombres = file.list();
//        for (String item : nombres) {
//                System.out.println(item);
//        }
//        Para tratar archivos ocultos, sino quiero que aparezcan

//        String[] nombres = file.list();
//        for (String item : nombres) {
//            if (!item.charAt(0) == "." ){
//                System.out.println(item);
//            }
//        }

        File[] ficheros = file.listFiles();
        for ( File item : ficheros ){
            System.out.println(item.getName());
            if ( item.isDirectory() ){
                File[] subdirectorio = item.listFiles();
                for ( File subitem : subdirectorio ){
                    System.out.println("\t" + subitem.getName());
                }
            }
        }

//        Para tratar archivos ocultos, sino quiero que aparezcan

//        File[] ficheros = file.listFiles();
//        for ( File item : ficheros ){
//            if (!item.isHidden()){
//                System.out.println(item.getName());
//            }
//        }
    }

    public void lecturaRecursiva(String path){
        File file = new File(path); // paso a un fichero lógico y fisico
        File[] ficheros = file.listFiles();
        for ( File item : ficheros ){
            System.out.println(item.getName());
            // pregunto si es directorio
            if ( item.isDirectory() ){
                //si es directorio saco todos los ficheros y los muestro -> NO SE CUANTAS VECES PREGUNTO
                lecturaSubdirectorios(item);
            }

        }
    }

    // UTILIZO LA RECURSIVIDAD, CON CUIDADO TIENE QUE TENER UNA SALIDA
    // como el metodo solo lo quiero utilizar aquí es privado
    private void lecturaSubdirectorios(File fichero){
        for (File file : fichero.listFiles()) {
            System.out.println("\t" + file.getName());
            if (file.isDirectory()) {
                lecturaSubdirectorios(file);
            }
        }
    }

    public void lecturaTextoPlano(String path){
        //Creo el FILE -> FILEREADER -> BUFFEREDREADER -> SE CIERRA EL FLUJO
        File file = new File(path);
        //FileReader fileReader = null;   // SE CREAN AQUÍ PORQUE LUEGO TENGO QUE CERRAR EL FUJO
        BufferedReader bufferedReader = null;
        // Hay que preguntar si existe y si es un fichero
        if(file.exists() && file.isFile()){
            // Hay que proceder a su lectura. De un FILE hay que crear un FILEREADER y lo vamos a hacer desde afuera
            // primera opción para la excepción: tratarla aquí
            try {
//                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(new FileReader(file));

                //Lectura con FILEREADER
               // int lectura = 0;
//                // mientras exista el numero has la lectura e imprime
//                while ( (lectura = fileReader.read()) != -1) { // el -1 es el unico caracter que no existe
//                    //cuando lo imprime?
//                    System.out.print((char)lectura);
//                }
//              Lectura con BUFFEREDREADER
               String lectura = null;   // PRIMERA OPCION
                /*   while ((lectura = bufferedReader.readLine()) != null) {
                    System.out.println(lectura);
                } */
                // StringBuffer lecturaCompleta = new StringBuffer(); // -> es sincronizado (si tengo varios hilos,
                // se comunican entre ellos para decir quien tiene el objeto ocupado. Ocupa muchos recusos

                StringBuilder lecturaCompleta = new StringBuilder(); // Este solo utiliza un hilo. Ocupa menos
                while ((lectura = bufferedReader.readLine()) != null) {
                    lecturaCompleta.append(lectura);
                    lecturaCompleta.append("\n");
                }
                System.out.println(lecturaCompleta.toString());


//                int lectura = fileReader.read(); // Me da el valor UNICODE del mensaje
//                System.out.print((char) lectura );
//                lectura = fileReader.read(); // Me da el valor UNICODE del mensaje
//                System.out.print((char) lectura );
//                lectura = fileReader.read(); // Me da el valor UNICODE del mensaje
//                System.out.print((char) lectura );
            } catch (FileNotFoundException e) {
                System.out.println("No se puede leer el fichero");
                // con trow e -> se para la ejecución del programa y es justo lo que no quiero que ocurra
            } catch (IOException e) {
                System.out.println("Error en la escritura");
            } finally {
                // es opcional en la estructura, pero en este caso es obligatorio porque hay que cerrar el flujo de datos
                // SINO no se crea nada
                try {
                    // Tenemos que manejar la excepción NULLPOINTEREXCEPTION
                    // Primera opción
                    // if (fileReader!= null) { copiamos la sentencia}
                    // también lo podemos agregar en el catch (IOException | NullPointerException e) con esta opción sigue apareciendo el amarillo
                    // la segunda es la recomendada por el profesor
                    if (bufferedReader!= null){
                       bufferedReader.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error en el cerrado del flujo");
                }
            }
        }
    }

}
