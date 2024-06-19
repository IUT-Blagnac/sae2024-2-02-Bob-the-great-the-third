package iut.sae.algo;

public class Algo {

    /** Permet de compresser une chaîne de caractères
     *  pour passer d'une suite de caractères à une suite de paires de valeur composée de : nombre de répétitions, valeur répétée
     * @param in la chaîne de caractères à compresser
     * @return la chaine de caractères compressée
     */
    public static String RLE(String in) {
        long debut = System.nanoTime(); // Chronomètre qui va récupérer la durée avant la fin du programme
        
        // Condition qui vérifie que la chaine n'est pas vide
        if (in.isEmpty()) { 
            return "";
        }
    
        StringBuilder resultat = new StringBuilder();
        int length = in.length(); // Calculer la longueur de la chaîne une fois
        int i = 0; // Index de parcours
        
        // Boucle qui parcourt tout les caractères de la chaîne
        while (i < length) { 
            char caractere_temp = in.charAt(i); // On récupère le premier caractère
            int nbOccurences = 1;
            
            // Boucle qui compte le nombre de fois que le caractère apparaît dans la chaîne
            while (i + 1 < length && in.charAt(i + 1) == caractere_temp) {
                nbOccurences++;
                i++;
            }
            
            // Ajout des caractères et de leur nombre d'occurrences
            while (nbOccurences > 9) {
                resultat.append(9).append(caractere_temp); // Ajoute notre caractère et son nombre de répétition dans la chaîne
                nbOccurences -= 9;
            }
            resultat.append(nbOccurences).append(caractere_temp); // Ajoute notre caractère et son nombre de répétition dans la chaîne
            i++; // On passe au prochain caractère de la chaîne
        }
        
        long fin = System.nanoTime(); // Chronomètre qui va récupérer la durée vers la fin du programme
    
        // Calcul de la latence
        long latence = fin - debut; // Calcul de la latence en nanosecondes
        double latence_ms = (double) latence / 1000000.0; // Conversion en millisecondes
        
        // Affichage du temps de réponse
        System.out.println("RESULTATS DE LA COMPRESSION");
        System.out.println("Temps de réponse : " + latence + " ns"); // En nanoseconde
        System.out.println("Temps de réponse : " + String.format("%.3f", latence_ms) + " ms\n"); // En milliseconde
        
        return resultat.toString();
    }
    
    

    /** Permet de lancer un nombre de fois notre fonction de compressage
     * @param in la chaîne de caractères à compresser
     * @param iteration le nombre de fois la fonction RLE que va être appeler
     * @return la dernière chaine de caractères compressée
     */
    public static String RLE(String in, int iteration) throws AlgoException {
        String resultat = in;

        for (int i = 0; i < iteration; i++) {
            resultat = RLE(resultat);
            if (resultat == null) {
                System.out.println("Le paramètre est vide !");
                break;
            }
        }

        return resultat;
    }

    /** Permet de décoder notre chaîne  
     *  pour passer d'une suite de paires de valeur à sa chaîne d'origine
     * @param in la chaîne de caractères à décompresser
     * @return la chaîne de caractères décompressée
     */
    public static String unRLE(String in) throws AlgoException {
        long debut = System.nanoTime(); // Début du chrono
        
        // Condition qui vérifie que la chaîne n'est pas vide
        if (in.isEmpty()) {
            return "";
        }

        // Condition qui vérifie que la taille de la chaîne est paire
        if (in.length() % 2 != 0) {
            throw new AlgoException("ERREUR: La longueur de la chaîne est impaire !");
        }

        StringBuilder resultat = new StringBuilder();
        int length = in.length(); // Calculer la longueur de la chaîne une seule fois
        
        // Boucle qui parcourt tous les caractères de la chaîne
        for (int i = 0; i < length; i += 2) {
            char cpt_temp = in.charAt(i); // On récupère le nombre de répétition
            char caractere_temp = in.charAt(i + 1); // On récupère le caractère
            
            // Condition pour récupérer le nombre de répétition
            if (Character.isDigit(cpt_temp)) {
                int nbFois = Character.getNumericValue(cpt_temp);
                
                // Ajout du caractère nbFois dans le résultat
                for (int j = 0; j < nbFois; j++) {
                    resultat.append(caractere_temp);
                }
            } else {
                throw new AlgoException("ERREUR: Caractère de comptage invalide !");
            }
        }

        long fin = System.nanoTime(); // Fin du chrono
        long latence = fin - debut; // Calcul de la latence en nanosecondes
        double latence_ms = (double) latence / 1000000.0; // Conversion en millisecondes

        // Affichage du temps de réponse
        System.out.println("RESULTATS DE LA DECOMPRESSION");
        System.out.println("Temps de réponse : " + latence + " ns"); // En nanosecondes
        System.out.println("Temps de réponse : " + String.format("%.3f", latence_ms) + " ms\n"); // En millisecondes

        return resultat.toString();
    }

    

    /** Permet de lancer un nombre de fois notre fonction de décompressage
     * @param in la chaîne de caractères à décompresser
     * @param iteration le nombre de fois la fonction unRLE que va être appeler
     * @return la dernière chaine de caractères décompressée
     */
    public static String unRLE(String in, int iteration) throws AlgoException {
        String resultat = in;

        for (int i = 0; i < iteration; i++) {
            resultat = unRLE(in);
            if (resultat == null) {
                System.out.println("Le paramètre est vide !");
                break;
            }
        }

        return resultat;
    }
}
