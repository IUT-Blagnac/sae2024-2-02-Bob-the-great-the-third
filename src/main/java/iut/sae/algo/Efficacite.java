package iut.sae.algo;


public class Efficacite{


    public static String RLE(String in){
        // Initialisation de la variable de longueur et de compteur des charactères
        int len=in.length(), cpt=0;

        // Si le String passé en paramêtre est vide
        if(len==0){
            // On retourne un String vide
            return "";
        }

        // On itialise un Objet StringBuilder classe optimisée semblable à String
        // On initialise sa longueur à la longueur du String plutôt que la longueur par défault(16) pour éviter une perte de 
        // temps lors de l'ajout de charactères 
        StringBuilder str=new StringBuilder(len);
        // On initialise la variable du charactère que l'on compte actuellement
		char lastChar=in.charAt(0);
        // Puis une variable pour le charactère actuel lorsque l'on parcours le String
        char charAt;

        // On parcours le String
		for(int i=0;i<len;i++) {

            // On sauvegarde le charactère actuel
			charAt=in.charAt(i);

            // Si ce dernier est différent du précédent ou si le compteur atteint 9 
			if(lastChar!=charAt || cpt>=9) {

                // On ajoute le charactère précédé par son nombre d'apparition
                str.append(cpt);
                str.append(lastChar);

                // On mémorise le nouveau charactère
                lastChar=charAt;
                // Et l'on réinitialise le compteur
                cpt=0;
            }

            // Dans tous les cas l'on incrémente le compteur
            cpt++;
		}

        // On sauvegarde le dernier charactère et son nombre d'apparition qui n'est pas traité par le code précédent
        str.append(cpt);
        str.append(lastChar);
        
        // Enfin l'on convertit le StringBuilder en String
		return new String(str);
    }


    public static String RLE(String in, int iteration) throws AlgoException{
        // Si la chaine est vide on retourne un String vide
        if(in.isEmpty())
            return "";

        // Sinon l'on crée un nouveau StringBuilder 
        StringBuilder sb=new StringBuilder(in);

        for(int i=0;i<iteration;i++){
            // On appelle une fonction semblable à celle au dessus mais qui traite uniquement des StringBuilder pour éviter
            //  la perte de temps de la conversion en String
            sb=RLE(sb);
        }

        // Enfin on convertit notre chaine en String
        return new String(sb);
    }

    /** Fonction appliquant l'algorithme de compression RLE.
     * 
     * Fonction appliquant l'algorithme de compression RLE avec des StringBuilder.
     * 
     * @param in IN: StringBuilder de la chaine de charactères à compresser 
     * @return un StringBuilder de la chaine compressée
     */
    private static StringBuilder RLE(StringBuilder in) {

        // La fonction est identique à celle publique simplement sans conversion en String 
        // Elle évite la perte de temps de la conversion StringBuilder -> String.

        int len=in.length(), cpt=0;

        StringBuilder str=new StringBuilder(len);
		char lastChar=in.charAt(0),charAt;

		for(int i=0;i<len;i++) {

			charAt=in.charAt(i);

			if(lastChar!=charAt || cpt>=9) {

                str.append(cpt);
                str.append(lastChar);

                lastChar=charAt;
                cpt=0;
            }

            cpt++;
		}

        str.append(cpt);
        str.append(lastChar);
        
		return str;
    }

    public static String unRLE(String in) {
        // Initialisation de la longueur de la chaîne à décompresser
        int len=in.length();
        // Déclaration d'une variable stockant le nombre de fois dont on doit ajouter le charactère
        int times;

        // Initialisation d'un StringBuilder avec une taille de len. Pour accélerer les appels de la méthode append
        StringBuilder str=new StringBuilder(len);

        char toAdd; // Charactère à ajouter

        // On parcours la chaine à décompresser
        for(int i=0;i<len;i+=2){

            // On récupère le nombre devant le charactère
            times=in.charAt(i)-'0';

            // On récupère le charactère à ajouter
            toAdd=in.charAt(i+1);

            // On ajoute times fois le charactère 
            for(int j=0;j<times;j++)
                str.append(toAdd);
        }

        // Enfin on retourne le StringBuilder converti en String
        return new String(str);
    }


    public static String unRLE(String in, int iteration) throws AlgoException{
        // Si la chaîne de charactère est vide on retourne la chaîne
        // Si la chaîne ne doit pas être convertie cette condition permet d'éviter le temps de conversion
        //  de String -> StringBuilder et StringBuilder -> String.
        if(in.isEmpty() || iteration<=0)
            return in;

        
        // On initialise un StringBuilder correspondant au String in
        StringBuilder sb=new StringBuilder(in);
        
        for(int i=0;i<iteration;i++){
            // On appelle une méthode similaire a unRLE mais utilisant et retournant des StringBuilder
            sb=unRLE(sb);
        }
        
        // Retourne le String correspondant au StringBuilder 
        return new String(sb);
    }


    /**  Fonction appliquant l'algorithme de cécompression RLE.
     * 
     * Fonction appliquant l'algorithme de décompression RLE avec des StringBuilder.
     * 
     * @param str IN: StringBuilder de la chaine de charactères à décompresser 
     * @return un StringBuilder de la chaine décompressée
     */
    private static StringBuilder unRLE(StringBuilder str){

        // La fonction est identique à celle publique simplement sans conversion en String 
        // Elle évite la perte de temps de la conversion StringBuilder -> String.

        int len=str.length(),times;
        StringBuilder sb=new StringBuilder(len);
        char toAdd;

        for(int i=0;i<len;i+=2){
            times=str.charAt(i)-'0';
            toAdd=str.charAt(i+1);
            for(int j=0;j<times;j++)
                sb.append(toAdd);
        }

        return sb;
    }
}

