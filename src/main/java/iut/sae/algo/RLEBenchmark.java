package iut.sae.algo;

import iut.sae.algo.testEfficacite.DataSet;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class RLEBenchmark {
    public static int[] iterations= {1,3,5,10,20};
    public static void main(String[] args) {

        //generateDataFile("./src/main/java/iut/sae/algo/testEfficacite/DataSet.java");

        ArrayList<String> compressedData=new ArrayList<String>();

        long startTime1, endTime1, avgTime1 = 0;
        String result1;
        boolean sameAsMine1 = true;

        // Test de RLE
        System.out.println("Algo RLE: ");

        for(int i=0;i<5;i++) {
            try {
                for (String str : DataSet.data) {
                    startTime1 = System.nanoTime();
                    result1 = Efficacite.RLE(str);
                    endTime1 = System.nanoTime();
                    avgTime1 += endTime1 - startTime1;

                    compressedData.add(EfficaciteTiti.RLE(str));

                    if (!compressedData.get(compressedData.size() - 1).equals(result1))
                        sameAsMine1 = false;
                }
            }catch (Exception e){
                System.out.println("Algo Rle Soulève exception inattendue");
                System.out.println(e.getMessage());
            }
        }

        avgTime1 = avgTime1 / (DataSet.data.length*5);
        System.out.println("Algorithme RLE durée: " + avgTime1 + " ns");
        System.out.println("Les résultat " + (sameAsMine1 ? "sont " : "ne sont pas ") + "conformes");


        // Test de unRLE

        System.out.println("Algo unRLE :");
        sameAsMine1 = true;
        for(int i=0;i<5;i++){
            try {
                for (String str : compressedData) {
                    try {
                        startTime1 = System.nanoTime();
                        result1 = Efficacite.unRLE(str);
                        endTime1 = System.nanoTime();
                        avgTime1 += endTime1 - startTime1;

                        if (!EfficaciteTiti.unRLE(str).equals(result1))
                            sameAsMine1 = false;
                    } catch (AlgoException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                System.out.println("Algo Unrle Soulève exception inattendue");
                System.out.println(e.getMessage());
            }
        }
        avgTime1 = avgTime1 / (DataSet.data.length*5);
        System.out.println("Algorithme unRLE durée: " + avgTime1 + " ns");
        System.out.println("Les résultat " + (sameAsMine1 ? "sont " : "ne sont pas ") + "conformes");

        // Test de RLE et UNRLE Récursif

        long startTime2,endTime2,avgTime2=0;
        boolean sameAsMine2=true;


        System.out.println("Algo RLE et UNRLE Récursifs :");
        sameAsMine1 = true;
        for(int i=0;i<5;i++){
            try {
                compressedData.clear();
                for (String str : DataSet.data) {
                    try {
                        startTime1 = System.nanoTime();
                        result1 = Efficacite.RLE(str, iterations[i]);
                        endTime1 = System.nanoTime();
                        avgTime1 += endTime1 - startTime1;

                        compressedData.add(EfficaciteTiti.RLE(str, iterations[i]));

                        if (!compressedData.get(compressedData.size() - 1).equals(result1))
                            sameAsMine1 = false;
                    } catch (AlgoException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                System.out.println("Algo Rle recursif Soulève exception inattendue");
                System.out.println(e.getMessage());
            }


            try {
                for (String str : compressedData) {
                    try {
                        startTime1 = System.nanoTime();
                        result1 = Efficacite.unRLE(str, iterations[i]);
                        endTime1 = System.nanoTime();
                        avgTime2 += endTime1 - startTime1;

                        if (!EfficaciteTiti.unRLE(str,iterations[i]).equals(result1))
                            sameAsMine2 = false;
                    } catch (AlgoException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e) {
                System.out.println("Algo Unrle recursif Soulève exception inattendue");
                System.out.println(e.getMessage());
            }
        }
        avgTime1 = avgTime1 / (DataSet.data.length*5);
        System.out.println("Algorithme RLE Récursif durée: " + avgTime1 + " ns");
        System.out.println("Les résultat " + (sameAsMine1 ? "sont " : "ne sont pas ") + "conformes");

        avgTime2 = avgTime2 / (DataSet.data.length*5);
        System.out.println("Algorithme unRLE Récursif durée: " + avgTime2 + " ns");
        System.out.println("Les résultat " + (sameAsMine2 ? "sont " : "ne sont pas ") + "conformes");

    }

    private static String generateTestData(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            if(Math.random()>0.5 || i==0)
                sb.append((char) ('A' + (random.nextInt()%26)));
            else
                sb.append(sb.charAt(i-1));
        }
        return sb.toString();
    }

    private static void generateDataFile(String file){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));

            String res="package iut.sae.algo.testEfficacite;\n" +
                    "public class DataSet {\n\n  " +
                    " public static String[] data = { ";

            pw.print(res);

            for(int i=0;i<100;i++) {
                res = "\n \"" + generateTestData(10000) + "\"";
                if (i < 99)
                    res += ",";
                pw.print(res);
            }



            pw.print("\n };\n\n");
            pw.print("\n}");
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}