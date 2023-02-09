package S1_05_N1_E3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Directory {

    public void showFilesInDirectory(String pathDirectory, String separador, BufferedWriter bw) throws IOException {

        File[] directory = new File(pathDirectory).listFiles();

        if (!(directory.length == 0))
            for (File file : directory) {
                String tipus = "";
                if (file.isDirectory()) tipus = "D-";
                else tipus = "F-";
                bw.write(separador + tipus + file.getName() + new Date(file.lastModified()) + "\n");
                if (file.isDirectory()) {
                    String nuevo_separador = separador + " ";
                    showFilesInDirectory(file.getAbsolutePath(), nuevo_separador, bw);
                }
            }
    }

}


