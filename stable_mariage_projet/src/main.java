import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
	
	
	public static void main(String[] args){
		String test_string ="0123-456";
		String[] parts = test_string.split("-");
		System.out.println(parts[0]);
		
		//appel de la méthode lectureCSV
		lectureCSV("/home/n7student/Documents/test.csv");
	}	
    
	/*
	 * Méthode permettant de compter le nombre de ligne du fichier
	 *
	 */
	
	/**
     * Cette méthode lit un fichier csv
     * @param nomFichier
     */
    public static void lectureCSV(String nomFichier) {
        String ligne;
        int nbLigne = 0; //récupère le nombre de ligne du fichier CSV
        
        String[] ligne_split; 
        
        String[][] arrayCSV; //tableau multidimensionnel contenant le contenu du csv
        
        // Ouverture du fichier
        try (BufferedReader fichierNotes = new BufferedReader(
                                           new FileReader(nomFichier))) {

            // Lecture du fichier ligne par ligne
            while ((ligne = fichierNotes.readLine()) != null) {
            	
            	//n'affiche pas la première ligne
                if(nbLigne > 0 ) {
                	
                	ligne_split = ligne.split(",");
                	
                	for(int i = 0;i < ligne_split.length;i++) {
                		
                	}
                	
                	System.out.println(ligne_split.length);
                	System.out.println(ligne);
                	                	
                }
            	
                nbLigne++;
                
            }
            
            System.out.println(nbLigne);

            // Le fichier est fermé automatiquement puisque sa classe 
            // implémente l'interface AutoCloseable

        } catch (IOException erreur) {
            System.out.println("Problème d'accès ou de lecture du fichier!");
        }
    }
	
}
