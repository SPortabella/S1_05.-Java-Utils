package S1_05_N1_E4;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathDirectory = "C:\\Users\\Susana\\Documents\\GitHub\\ProjectsITACADEMY\\S1\\";

        //Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola.
        System.out.println("--- Exercici 4 ---");
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            file = new File(pathDirectory + askNameFile());
            if (!(file.exists())) {
                System.out.println("El fitxer no existeix");
            } else if (!(file.getName().endsWith(".txt"))) {
                System.out.println("El fitxer no es un .txt");
            } else {
                showLineOfFile(file, fr, br);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero
            closeOpenFiles(fr, br);
        }
    }

    private static void closeOpenFiles(FileReader fr, BufferedReader br) {
        try {
            if (null != fr) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void showLineOfFile(File file, FileReader fr, BufferedReader br) throws IOException {
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    }

    private static String askNameFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom del fitxer txt:");
        return sc.nextLine();

    }
}
