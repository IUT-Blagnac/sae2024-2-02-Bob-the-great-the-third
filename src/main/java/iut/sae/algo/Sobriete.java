package iut.sae.algo;

public class Sobriete{

    // Méthode pour effectuer une compression RLE simple
    public static String RLE(String in){
        String str="";
        char lastChar=in.charAt(0); // Premier caractère de la chaîne
        int cpt=0; // Compteur pour le nombre de répétitions

        // Parcourt chaque caractère de la chaîne d'entrée
        for(int i=0;i<in.length();i++) {
            // Si le caractère actuel est différent du précédent ou si le compteur atteint 9
            if(lastChar!=in.charAt(i) || cpt>=9) {
                str+=cpt+"" +lastChar; // Ajoute le compteur et le caractère au résultat
                lastChar=in.charAt(i); // Met à jour le dernier caractère
                cpt=0; // Réinitialise le compteur
            }
            cpt++;
        }
        str+=cpt+"" +lastChar; // Ajoute le dernier groupe de caractères au résultat
        return str;
    }

    // Méthode pour effectuer plusieurs itérations de compression RLE
    public static String RLE(String in, int iteration) throws AlgoException{
        String str = Efficacite.RLE(in);
        if(iteration==1){
            return str;
        }
        return RLE(str, iteration-1); // Appelle récursivement la méthode RLE
    }

    // Méthode pour effectuer une décompression RLE simple
    public static String unRLE(String in) {
        String str="";
        int times; // Nombre de répétitions du caractère
        char toAdd; // Caractère à ajouter

        // Parcourt chaque paire de caractères (nombre + caractère) dans la chaîne d'entrée
        for(int i=0;i<in.length();i+=2){
            times=in.charAt(i)-'0'; // Convertit le caractère numérique en entier
            toAdd=in.charAt(i+1); // Caractère à répéter
            for(int j=0;j<times;j++)
                str+=toAdd; // Ajoute le caractère le nombre de fois spécifié
        }
        System.out.println(str); // Affiche le résultat
        return str;
    }

    // Méthode pour effectuer plusieurs itérations de décompression RLE
    public static String unRLE(String in, int iteration) throws AlgoException{
        if(iteration==0)
            return in;

        return unRLE(unRLE(in),iteration-1); // Appelle récursivement la méthode unRLE
    }
}
