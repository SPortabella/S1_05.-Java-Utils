package S1_05_N1_E1;

public class Main {

    public static void main(String[] args) {

        //String pathDirectory = "C:\\Users\\Susana\\Documents\\GitHub\\ProjectsITACADEMY\\S1\\";
        //Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre.

        Directory directory = new Directory();
        directory.showFilesInDirectory(args[0]);
    }
}