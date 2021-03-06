package 第四章.流程控制与数组;

public class 打印圆 {
    public static void main(String[] args) {
        prinf(10);
    }
    //r圆的半径
    public static void prinf(int r) {
        //i代表每一行
        for (int i = 0; i <= 2 * r; i += 2) {
            //圆上点到竖着半径的距离
            long y = Math.round(Math.sqrt(Math.pow(r, 2) - Math.pow(r - i, 2)));
            //圆上点到外切正方形边的距离
            long x = r - y;
            //先打印出正方形左边边到圆上点的空白部位
            for (int j = 0; j < x; j++) {
                System.out.print(" ");
            }
            //打印出左边的圆上点
            System.out.print("*");
            //打印出中间空白部分
            for (int k = 0; k < 2 * (r - x); k++) {
                System.out.print(" ");
            }
            //打印出右边的圆上点 右边空白不要打直接换行
            System.out.println("*");
        }
    }


}
