import controller.GestorFicherosConjunto;
import controller.GestorFicherosEscritura;
import controller.GestorFicherosLectura;

public class Entrada {

    public static void main(String[] args) {

        // File = fichero lógico -> físico
        // Ejemplo de uso con ruta absoluta. Se recomienda usar la relativa
        // File ficheroSinPuntero =new File("C:\\Users\\javie\\Documentos\\GitHub\\ClaseAD-UNIR\\T1\\Fichero\\src\\resources\\directorio\\ejemplo_fichero.md");

        // Ejemplo de ruta relativa
//        File ficheroSinPuntero =new File("src/resources/directorio/ejemplo_fichero.md");

//        System.out.println(ficheroSinPuntero.getName());
//        System.out.println(ficheroSinPuntero.getParent());
//        System.out.println(ficheroSinPuntero.length());
//        System.out.println(ficheroSinPuntero.exists());

        // File[] -> Devuelve todos los FICHEROS que están dentro del directorio
//        ficheroSinPuntero.listFiles();

        // String -> Devuelve todas las rutas de los FICHEROS que están dentro del directorio
//        ficheroSinPuntero.list();
        // Ejemplo de como crear un fichero
//        if (!ficheroSinPuntero.exists()) {
//            try {
//                ficheroSinPuntero.createNewFile();
//            } catch (IOException e) {
//                System.out.println("No se pudo crear el archivo");
//            }
//        }

            // USAMOS LA CLASE GestorFicheosLectura
//        GestorFicherosLectura gestorFicherosLectura = new GestorFicherosLectura();
////        gestorFicheros.lecturaDirectorios("src/resources/directorio");
////        gestorFicheros.lecturaRecursiva("src/resources/directorio");
//        gestorFicherosLectura.lecturaTextoPlano("src/resources/ficheros/lectura.txt");

        // Usamos la clase GestorFicherosEscritura

//        GestorFicherosEscritura gestorFicherosEscritura = new GestorFicherosEscritura();
//        gestorFicherosEscritura.escribirFichero("src/resources/ficheros/escritura.txt");

        GestorFicherosConjunto gestorFicherosConjunto = new GestorFicherosConjunto();
        gestorFicherosConjunto.lecturaEscritura("src/resources/ficheros/cifrado.txt");


    }
}
