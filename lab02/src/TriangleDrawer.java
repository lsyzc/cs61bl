public class TriangleDrawer {
    public static void main(String[] args) {
         drawTriangle();
    }
    public static void drawTriangle() {
        // your code here
        int SIZE = 5;
        int start = 0;
        int inner_start = 0;
        while (start < SIZE) {
            while (inner_start++ < start) {
                System.out.print("*");

            }
            System.out.println("*");
            inner_start = 0;
            start ++;
        }

    }

}
