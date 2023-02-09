package S1_05_N1_E2;

import java.io.File;
import java.util.Date;


public class  Directory {

    public void showFilesInDirectory(String pathDirectory, String separador) {

        File[] directory = new File(pathDirectory).listFiles();

        if (!(directory.length == 0)) {
            for (File file : directory) {
                String tipus = "";
                if (file.isDirectory()) tipus = "D-";
                else tipus = "F-";
                System.out.println(separador + tipus + file.getName() + " - " + new Date(file.lastModified()));
                if (file.isDirectory()) {
                    String nuevo_separador = separador + " ";
                    showFilesInDirectory(file.getAbsolutePath(), nuevo_separador);
                }
            }
        }
    }

}


