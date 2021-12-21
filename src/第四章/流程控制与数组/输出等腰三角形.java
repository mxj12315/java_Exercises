package 第四章.流程控制与数组;

public class 输出等腰三角形 {
    public static void main(String[] args) {
        int num  = 10;
        for (int i = 1; i<=num; i++) {
            //空格分布
            for (int j =1; j<=num-i; j++) {
                System.out.print(" ");
            }
            //符号分布
            for (int k = 1; k<=2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
