package Array;

public class QLCR120 {
    public int findRepeatDocument(int[] documents) {
        int i=0;
        while(i < documents.length) {
            if(documents[i] == i) {
                i++;
                continue;
            }
            if(documents[documents[i]] == documents[i]) return documents[i];
            int tmp = documents[i];
            documents[i] = documents[tmp];
            documents[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={3,4,2,1,1,0};
        int res = new QLCR120().findRepeatDocument(nums);
        System.out.println(res);
    }
}
