package 第四章.流程控制与数组;

public class 九九乘法表 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {  // 外层控制行
            for (int j = 1; j <= i; j++) {  // 内层控制列
                System.out.print(i + "*" + j+ "=" +  i*j + "，");
            }
            System.out.println();
        }
    }
}
