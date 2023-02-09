package S1_05_N2_E1;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Executa l'exercici 3 del nivell anterior parametritzant tots els mètodes en un fitxer
        // de configuració.
        //Pots utilitzar un fitxer Java Properties, o bé la llibreria Apache Commons Configuration
        // si ho prefereixes.
        //De l'exercici anterior, parametritza el següent:
        //Directori a llegir.
        //Nom i directori del fitxer TXT resultant.

        Properties properties = readPropertiesFile();

        readFile((String) properties.get("PATH"), (String) properties.get("WRITEFILE"));

    }

    private static Properties readPropertiesFile() {

        Properties properties = new Properties();
        try {
            String dir = System.getProperty("user.dir");
            System.out.println();
            properties.load(new FileInputStream(dir + "\\" + "configuration.properties"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return properties;
    }

    private static void readFile(String pathDirectory, String writeFile) {
        File file = null;
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
            directory.showDirectory(pathDirectory, "", bw);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}