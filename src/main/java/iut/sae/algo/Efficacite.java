package iut.sae.algo;


public class Efficacite{

    public static String RLE(String in){
        int len=in.length(), cpt=0;
        if(len==0){
            return "";
        }

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
        
		return new String(str);
    }


    public static String RLE(String in, int iteration) throws AlgoException{
        if(in.isEmpty())
            return "";

        StringBuilder sb=new StringBuilder(in);

        for(int i=0;i<iteration;i++){
            sb=RLE(sb);
        }

        return new String(sb);
    }

    private static StringBuilder RLE(StringBuilder in) {
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
        int len=in.length(),times;
        StringBuilder str=new StringBuilder(len);
        char toAdd;

        for(int i=0;i<len;i+=2){
            times=in.charAt(i)-'0';
            toAdd=in.charAt(i+1);
            for(int j=0;j<times;j++)
                str.append(toAdd);
        }
        return new String(str);
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if(in.isEmpty())
            return "";

        StringBuilder sb=new StringBuilder(in);
        
        for(int i=0;i<iteration;i++){
            sb=unRLE(sb);
        }
        
        return new String(sb);
    }

    private static StringBuilder unRLE(StringBuilder str){

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

