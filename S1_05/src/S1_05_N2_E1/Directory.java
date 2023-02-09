package S1_05_N2_E1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Directory {

    public void showDirectory(String pathDirectory, String separador, BufferedWriter bw) throws IOException {

        File[] directory = new File(pathDirectory).listFiles();

        if (!(directory.length == 0))
            for (File file : directory) {
                String tipus = "";
                if (file.isDirectory()) tipus = "D-";
                else tipus = "F-";
                System.out.println(separador + tipus + file.getName() + " - " + new Date(file.lastModified()));
                bw.write(separador + tipus + file.getName() + new Date(file.lastModified()) + "\n");
                if (file.isDirectory()) {
                    String nuevo_separador = separador + " ";
                    showDirectory(file.getAbsolutePath(), nuevo_separador, bw);
                }
            }
    }

}


