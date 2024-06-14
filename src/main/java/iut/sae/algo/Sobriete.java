package iut.sae.algo;


public class Sobriete{
    public static String RLE(String in){
        String str="";
		char lastChar=in.charAt(0);
		int cpt=0;
		 
		for(int i=0;i<in.length();i++) {
			
			if(lastChar!=in.charAt(i) || cpt>=9) {
				str+=cpt+"" +lastChar;
				lastChar=in.charAt(i);
				cpt=0;
			}
			cpt++;
		}
		str+=cpt+"" +lastChar;
		return str;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        String str = Algo.RLE(in);
        if(iteration==1){
            return str;
        }
        return RLE(str, iteration-1);
    }

    public static String unRLE(String in) {
        String str="";
        int times;
        char toAdd;

        for(int i=0;i<in.length();i+=2){
            times=in.charAt(i)-'0';
            toAdd=in.charAt(i+1);
            for(int j=0;j<times;j++)
                str+=toAdd;
        }
        System.out.println(str);
        return str;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if(iteration==0)
            return in;

        return unRLE(unRLE(in),iteration-1);
    }
}

