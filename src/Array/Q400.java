package Array;

public class Q400 {
    public int findNthDigit(int n) {
        int digit = 1;//位数
        long num=1;
        long count = 9;
        while(n>count){
            n-=count;
            digit++;
            num*=10;
            count=digit*num*9;
        }
        long number = num+(n-1)/digit; //找到数字
        String s = String.valueOf(number);
        int res = s.charAt((n-1)%digit)-'0';
        return res;
    }

    public static void main(String[] args) {
        int n=1000000000;
        int res  = new Q400().findNthDigit(n);
        System.out.println(res);
    }
}
