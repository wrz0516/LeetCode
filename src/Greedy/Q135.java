package Greedy;

public class Q135 {

public int candy(int[] ratings) {
    int len = ratings.length;
    int[] candyVec = new int[len];
    candyVec[0] = 1;
    for (int i = 1; i < len; i++) {
        candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
    }

    for (int i = len - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
        }
    }

    int ans = 0;
    for (int num : candyVec) {
        ans += num;
    }
    return ans;
}

    public static void main(String[] args) {
        int[] ratings = {1,3,2,2,1};
        int res = new Q135().candy(ratings);
        System.out.println(res);
    }
}
