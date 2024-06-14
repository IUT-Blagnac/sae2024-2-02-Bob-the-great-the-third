package iut.sae.algo;


public class Algo{
    public static String RLE(String in){
        String str="";
		char lastChar=in.charAt(0),charAt;
		int len=in.length(), cpt=0;
		 
		for(int i=0;i<len;i++) {
			charAt=in.charAt(i);
			if(lastChar!=charAt || cpt>=9) {
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
        String str = Algo.RLE(in);
        if(iteration==1){
            return str;
        }
        return RLE(str, iteration-1);
    }

    public static String unRLE(String in) {
        String str="";
        int len=in.length(), times;
        char toAdd;

        for(int i=0;i<len;i+=2){
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

