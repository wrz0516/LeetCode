package Greedy;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i]; //从起始位置开始，到现在的位置的总油量减去总消耗
            totalSum += gas[i] - cost[i]; //totalSum为总油量减去总消耗，若totalSum<0说明不可能跑一圈
            if (curSum < 0) { //若curSum<0,则更新起始点
                index = (i + 1) % gas.length ; //更新起始点
                curSum = 0; //更新油量
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }

    public static void main(String[] args) {
        int[] gas={5,1,2,3,4};
        int[] cost={4,4,1,5,1};

        int res = new Q134().canCompleteCircuit(gas,cost);
        System.out.println(res);
    }
}
