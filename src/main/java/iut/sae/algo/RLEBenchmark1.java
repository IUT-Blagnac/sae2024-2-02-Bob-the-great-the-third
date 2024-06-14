package iut.sae.algo;

public class RLEBenchmark1 {

    public static void main(String[] args) {
        String input = generateTestData(100000); // Génère une chaîne de test de 100 000 caractères

        long startTime, endTime, duration1, duration2;
        int nbIte=(int)(Math.random() * (10) + 1);

        // Test de l'Algorithme 1
        startTime = System.nanoTime();
        String result1 = RLE1(input,nbIte);
        endTime = System.nanoTime();
        duration1 = endTime - startTime;
        System.out.println("Algorithme 1 durée: " + duration1 + " ns");

        // Test de l'Algorithme 2
        startTime = System.nanoTime();
        String result2 = RLE2(input,nbIte);
        endTime = System.nanoTime();
        duration2 = endTime - startTime;
        System.out.println("Algorithme 2 durée: " + duration2 + " ns");

        // Vérifier que les résultats sont identiques
        System.out.println("Les résultats sont identiques: " + result1.equals(result2));
    }

    private static String generateTestData(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('A' + (i % 26))); // Génère des caractères de A à Z
        }
        return sb.toString();
    }

    // Algorithme 1
    public static String RLE1(String in, int iteration) {
        String resultat=in;

        for(int i=0;i<iteration;i++){
            resultat=RLE1Aide(resultat);
        }
        return resultat;
    }

    private static String RLE1Aide(String in) {
        StringBuilder rle = new StringBuilder();
        int compteur = 1;
        int TailleIn=in.length();
        for (int i = 0; i < TailleIn; i++) {
            if (i+1 < TailleIn && in.charAt(i) == in.charAt(i+1) && compteur!=9) {
                compteur++;
            } else {
                rle.append(compteur).append(in.charAt(i));
                compteur = 1;
            }
        }
        return rle.toString();
    }

    // Algorithme 2
    public static String RLE2(String in, int iteration) {
        StringBuilder sb=new StringBuilder(in);

        for(int i=0;i<iteration;i++){
            sb=RLE2Aide(sb);
        }

        return new String(sb);
    }

    private static StringBuilder RLE2Aide(StringBuilder in){
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
}