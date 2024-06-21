public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        int L=a.length;
        for(int i=0;i<L;i=i+1){
            if(a[i]>=0){
                if(i+n<=L-1){
                    for(int j=1;j<=n;j=j+1){
                        a[i]=a[i]+a[i+j];
                    }
                } else if (i+n==L-1){
                    break;
                    }else
                {
                    for(int j=1;j<L-i;j=j+1){
                        a[i]=a[i]+a[i+j];
                    }
                }
                }
            else{
                continue;
            }
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}