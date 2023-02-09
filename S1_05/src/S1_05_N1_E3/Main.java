package S1_05_N1_E3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla,
        //guarda el resultat en un fitxer TXT.

        String pathDirectory = args[0]; // "C:\\Users\\Susana\\Documents\\GitHub\\ProjectsITACADEMY\\S1\\";
        String writeFile = args[1]; //"showDirectory.txt";

        File file;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            file = new File(pathDirectory + writeFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            Directory directory = new Directory();
            directory.showFilesInDirectory(pathDirectory, "", bw);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
