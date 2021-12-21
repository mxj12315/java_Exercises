package 第四章.流程控制与数组;

import java.util.ArrayList;

public class 按照字节截取字符串 {
    public static void main(String[] args) {
        String str = "12d4fg";
        String subStrings = subStrings(str, 2, 4);
        System.out.println(subStrings);
    }

    /**
     * 按照字节截取字符串
     *
     * @param str   要截取的字符串
     * @param start 截取的字符串开始
     * @param end   截取字符串结束
     * @return 截取后的字符串
     */
    public static String subStrings(String str, int start, int end) {
        byte[] bytes = str.getBytes();
        StringBuilder stringBuffer = new StringBuilder();
        if (start < 0) {
            start = 0;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start < end) {
            for (int i = start - 1; i < end; i++) {
                char aChar = (char) bytes[i];
//                System.out.println(aChar);
                stringBuffer.append(aChar);
            }
        } else {
            throw new IllegalArgumentException("参数异常，截取结束的长度应该大于开始");
        }

        return stringBuffer.toString();
    }
}
