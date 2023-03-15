package Strings;

public class Q541 {
    public String reverseStr(String s, int k) {
        char[] str=s.toCharArray();
        int num=s.length()/(2*k);
        int rest=s.length()%(2*k);
        for(int i=0;i<num+1;i++){
            int left=i*2*k;
            int right=Math.min(left+k-1,s.length()-1);
            while(left<right){
                char temp=str[left];
                str[left]=str[right];
                str[right]=temp;
                left++;
                right--;
            }
        }
        int left=num*2*k;
        return new String(str);
    }

    public static void main(String[] args) {
        String s= "abcdefg";
        int k=2;
        String res=new Q541().reverseStr(s,k);

        System.out.println(res);
    }
}
