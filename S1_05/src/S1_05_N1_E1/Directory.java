package S1_05_N1_E1;

import java.io.File;

public class Directory {

    public void showFilesInDirectory(String pathDirectory) {

        File[] files =new File(pathDirectory).listFiles();

        if (files.length == 0)
            System.out.println("No hay elementos dentro de la carpeta actual");

        else
            for (File file : files) {
                System.out.println(file.getName());
            }
    }

}
