package iut.sae.algo;


public class Algo{
    public static String RLE(String in){
        String str="";
		char lastChar=in.charAt(0),charAt;
		int len=in.length(), cpt=0;
		
		for(int i=0;i<len;i++) {
			charAt=in.charAt(i);
			if(lastChar!=charAt) {
				str+=cpt+"" +lastChar;
				lastChar=charAt;
				cpt=0;
			}
			cpt++;
		}
		str+=cpt+"" +lastChar;
		
		return str;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        return "NotYetImplemented";
    }

    public static String unRLE(String in) {
        String str="";
        int len=in.length(), times;
        char toAdd;

        for(int i=0;i<len;i+=2){
            times=in.charAt(i);
            toAdd=in.charAt(i+1);
            for(int j=0;j<times;j++)
                str+=toAdd;
        }
        return str;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        return "NotYetImplemented";

    }
}

