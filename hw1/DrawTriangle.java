/**Class that draw a triangle with arbitrary size
 * @author ShuAoJia
 * */
public class DrawTriangle{

    /** Method to draw the triangle */
    public static void Draw(int n){
        int i=1;
        int j=1;
        while(i<=n) {
            while (j <= i) {
                System.out.print("*");
                j=j+1;
            }
            System.out.print("\n");
            i=i+1;
            j=1;
        }
    }

    public static void main(String[] args){
        int m=7;
        Draw(m);
    }
}