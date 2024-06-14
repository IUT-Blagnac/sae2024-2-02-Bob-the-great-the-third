package iut.sae.algo;

public class Simplicite{
    public static String RLE(String in){
        String str="";
        
        if(in.isEmpty())
            return str;

		char lastChar=in.charAt(0);
        char charActuel;
		int len=in.length();
        int cpt=0;
		
		for(int i=0;i<len;i++) {

			charActuel=in.charAt(i);

			if(lastChar!=charActuel || cpt>=9) {

				str+=cpt+"" +lastChar;


				lastChar=charActuel;
				cpt=0;

			}
            
			cpt++;

		}


		str+=cpt+"" +lastChar;
		return str;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        while(iteration>0){
            in= RLE(in);
            iteration--;
        }

        return in;
    }

    public static String unRLE(String in) {

        String str="";
        int len=in.length();
        int times;
        char toAdd;

        for(int i=0;i<len;i+=2){

            times= in.charAt(i) - '0';
            toAdd= in.charAt(i+1);
            
            for(int j=0;j<times;j++)
                str+=toAdd;
        }

        return str;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        while(iteration>0){
            in= unRLE(in);
            iteration--;
        }

        return in;
    }
}

