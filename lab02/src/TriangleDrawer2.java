public class TriangleDrawer2 {
    public static void main(String[] args) {
        drawTriangle();

    }
    public static void drawTriangle() {
        // your code here
        int SIZE = 5;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }
}
