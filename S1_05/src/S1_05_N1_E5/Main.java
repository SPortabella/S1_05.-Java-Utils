package S1_05_N1_E5;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String pathDirectory = "C:\\Users\\Susana\\Documents\\GitHub\\ProjectsITACADEMY\\S1\\";
        String serFile = "fichero.ser";

        //Ara el programa ha de serialitzar un Objecte Java a un fitxer .ser i després l’ha de desserialitzar.
        System.out.println("--- Exercici 5 ---");
        serializableFile(pathDirectory, serFile);
        desserializableFile(pathDirectory, serFile);
    }

    private static void desserializableFile(String pathDirectory,
                                            String serFile) throws IOException, ClassNotFoundException {
        FileInputStream file;
        ObjectInputStream input;

        //Abrimos el fichero
        file = new FileInputStream(pathDirectory + serFile);
        input = new ObjectInputStream(file);

        Persona persona = null;

        // revisar si if i while repetido
        //if (input != null)
        //{
        try {
            while (input != null) {
                persona = (Persona) input.readObject();
                System.out.println("Persona:" + persona.getName());
            }


        } catch (EOFException | ClassNotFoundException eof) {
            // Fin del fichero
        } finally {
            //cerrar ficheros
        }
        // }
    }

    private static void serializableFile(String pathDirectory,
                                         String serFile) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            //Abrimos el fichero serializable
            fileOutputStream = new FileOutputStream(pathDirectory + serFile);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            if (objectOutputStream != null) {
                objectOutputStream.writeObject(new Persona("Sandra"));
                objectOutputStream.writeObject(new Persona("Eric"));
                objectOutputStream.writeObject(new Persona("Juan"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeOpenFiles(fileOutputStream, objectOutputStream);
        }
    }

    private static void closeOpenFiles(FileOutputStream fileOutputStream, ObjectOutputStream objectOutputStream) {
        try {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

}
