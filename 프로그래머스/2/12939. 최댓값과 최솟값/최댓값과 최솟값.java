import java.util.*;
class Solution {
    public String solution(String s) {
        String[] strArray =s.split(" ");
        int[] iArray = new int[strArray.length];
        for(int i=0;i<iArray.length;i++){
            iArray[i]=Integer.valueOf(strArray[i]);
        }
        int min = iArray[0];
        int max = iArray[0];
        for(int val : iArray){
            if (val<min){min=val;}
            if (max<val){max=val;}
        }
        return(String.valueOf(min)+" "+String.valueOf(max));
    }
}