import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
	
    /** Déclaration d'un objet Scanner pour effectuer les saisies */
    private static Scanner entree = new Scanner(System.in);  
    
    /** Stockage du classement des élèves */
    private static String[][] rankStudent;
    
    /** Stockage du classement des écoles*/
    private static String[][] rankSchool;
    
    /** Stockage des couples formées après les algorithmes de mariage */
    private static String[][] couples;
	
	public static void main(String[] args){

        /*********Test du split************
		*String test_string ="0123-456";
		*String[] parts = test_string.split("-");
		*System.out.println(parts[0]);
        ***********************************/
		
        //initialise le tableau pour les écoles
		initLigneTab("./schoolsRanking.csv",rankSchool);

        //initialise le tableau pour les étudiants
        initLigneTab("./studentsRanking.csv",rankStudent);

        System.out.println(rankStudent);

        //lecture du fichier schoolsRanking.csv
        lectureCSV("./schoolsRanking.csv",rankSchool);

	}	


    
    /**
     * Cette méthode initialise un tableau de dim 2 avec le nombre de ligne
     * du fichier CSV
     * @param nomFichier fichier CSV à étudier
     */
    private static String[][] initLigneTab(String nomFichier,String[][] rank) {
        int nbLignes = 0;
        String ligne;
              
        // Ouverture du fichier
        try (BufferedReader fichierRank = new BufferedReader(
                                           new FileReader(nomFichier))) {
            
            // On compte le nombre de lignes pour les dimensions du tableau
            while ((ligne = fichierRank.readLine()) != null) {
                nbLignes++;
            }
            rank = new String[nbLignes][];

            System.out.println(rank);
                        
            // Le fichier est fermé automatiquement puisque sa classe 
            // implémente l'interface AutoCloseable

            System.out.println(nbLignes);

            return rank;
            
        } catch (IOException erreur) {
            System.out.println("Problème d'accès ou de lecture du fichier!");
            return null;
        }
        
        nbLignes = 0;
    }

    /* Méthode de lecture des fichiers CSV
    * @param nomFichier: fichier CSV à lire
    */
    public static void lectureCSV(String nomFichier,String rank[][]) {
        String ligne;
        
        String[] ligne_split; 
        
        int i;
        
        String[][] arrayCSV; //tableau multidimensionnel contenant le contenu du csv
        
        // Ouverture du fichier
        try (BufferedReader fichierNotes = new BufferedReader(
                                           new FileReader(nomFichier))) {

            // Lecture du fichier ligne par ligne
            i=0;
            while ((ligne = fichierNotes.readLine()) != null) {
                	
                    //split la ligne en fonction de l'opérateur ";"
                	ligne_split = ligne.split(";");


                    //rank[i] = new String[ligne_split.length];

                    i++;



                	//affiche la taille de la chaine séparée
                	System.out.println(ligne_split.length);

                	System.out.println(ligne);
                	                	
                //}
            	                
            }
            

            // Le fichier est fermé automatiquement puisque sa classe 
            // implémente l'interface AutoCloseable

        } catch (IOException erreur) {
            System.out.println("Problème d'accès ou de lecture du fichier!");
        }
    }


    

}