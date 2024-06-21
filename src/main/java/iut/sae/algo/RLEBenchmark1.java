package iut.sae.algo;

import java.util.Random;

public class RLEBenchmark1 {

    public static void main(String[] args) {

        generateDataFile();

        /*String input = generateTestData(100000); // Génère une chaîne de test de 100 000 caractères

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
        System.out.println("Les résultats sont identiques: " + result1.equals(result2));*/
    }

    private static String generateTestData(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random=new Random();
        for (int i = 0; i < length; i++) {
            sb.append((char) ('A' + (random.nextInt() % 26))); // Génère des caractères de A à Z
        }
        return sb.toString();
    }

    private static void generateDataFile(){
        String res="public class DataSet {\n   public static String[] data = { \"";


        for(int i=0;i<100;i++){
            res+="\n "+ generateTestData(10000)+",";
        }
        res=res.substring(res.length()-2);

        res+="\n } \n }";

        System.out.println(res);

    }
}