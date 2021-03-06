package leetcode.problems.Strings;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigZagRead {
    public static void main(String[] str){
        System.out.println(convert("paypalishiring",4));
    }

    public static String convert(String s, int numRows) {
        int strlen = s.length();
        if(strlen <= numRows || numRows ==1){
            return s;
        }
        String arr[] = new String[numRows];
        int i=0;
        while(i<strlen){
            for(int a =0 ;a<numRows && i<strlen; a++,i++){
                if(arr[a]==null){
                    arr[a] = ""+s.charAt(i);
                }else {
                    arr[a]+=s.charAt(i);
                }
                System.out.println("Rowwise  a:"+a+" i:"+i+" arr["+a+"]"+arr[a]);
            }
            for(int a=numRows-2; a>0 && i<strlen; a--,i++){
                arr[a]+=s.charAt(i);
                System.out.println("Colwise  a:"+a+" i:"+i+" arr["+a+"]"+arr[a]);
            }
        }
        String result ="";
        for(String item: arr){
            result+=item;
        }
        return result;
    }
}