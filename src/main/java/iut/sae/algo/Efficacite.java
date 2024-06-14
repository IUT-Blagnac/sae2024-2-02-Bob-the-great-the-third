package iut.sae.algo;


public class Efficacite{

    public static String RLE(String in){
        int nbCharInARow;
        int len=in.length(), firstOfAkind=0;
        StringBuilder str=new StringBuilder(len);
		char lastChar=in.charAt(0),charAt;

		for(int i=0;i<len;i++) {

			charAt=in.charAt(i);

			if(lastChar!=charAt) {
                
                nbCharInARow=i-firstOfAkind;

                while(nbCharInARow>9){
                    
                    str.append(9);
                    str.append(charAt);

                    nbCharInARow-=9;
                }
				
                str.append(nbCharInARow);
                str.append(charAt);

				lastChar=charAt;
                firstOfAkind=i;

            }
		}
        
		return new String(str);
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        StringBuilder sb=new StringBuilder(in);
        return new String(Efficacite.RLE(sb,iteration,null));
    }

    private static StringBuilder RLE(StringBuilder in, int iteration, Void sig) throws AlgoException{
        StringBuilder str = Efficacite.RLE(in,null);
        if(iteration==1){
            return str;
        }
        return RLE(str, iteration-1,null);
    }

    private static StringBuilder RLE(StringBuilder in, Void diff){
        int nbCharInARow;
        int len=in.length(), firstOfAkind=0;
        StringBuilder str=new StringBuilder(len);
		char lastChar=in.charAt(0),charAt;

		for(int i=0;i<len;i++) {

			charAt=in.charAt(i);

			if(lastChar!=charAt) {
                
                nbCharInARow=i-firstOfAkind;

                while(nbCharInARow>9){
                    
                    str.append(9);
                    str.append(charAt);

                    nbCharInARow-=9;
                }
				
                str.append(nbCharInARow);
                str.append(charAt);

				lastChar=charAt;
                firstOfAkind=i;

            }
		}
        
		return new String(str);
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

