package S1_05_N1_E2;

public class Main {

    public static void main(String[] args) {

        //Afegeix a la classe de l’exercici anterior,
        // la funcionalitat de llistar un arbre de directoris amb el contingut de tots els seus nivells
        // (recursivament) de manera que s'imprimeixin en pantalla en ordre alfabètic dins de cada nivell,
        // indicant a més si és un directori (D) o un fitxer (F), i la seva última data de modificació.

        Directory directory = new Directory();
        directory.showFilesInDirectory(args[0], "");

    }


}