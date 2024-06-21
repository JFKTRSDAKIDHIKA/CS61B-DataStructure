public class FindMax {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int L=m.length;
        int i=0;
        int MaxValue=0;
        while(i<=L-1){
            if(m[i]>=MaxValue){
                MaxValue=m[i];
            }
            i=i+1;
        }
        return MaxValue;
    }

    public static void main(String[] args) {
        /** Assume the numbers in the array are all positive */
        int[] numbers = new int[]{9, 2, 23, 2, 22, 10, 6};
        System.out.print(max(numbers));
    }
}