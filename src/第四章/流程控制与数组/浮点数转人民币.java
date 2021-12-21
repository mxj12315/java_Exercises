package 第四章.流程控制与数组;

import java.text.DecimalFormat;
import java.util.Scanner;

public class 浮点数转人民币 {
    public static final String ZERO = "零";
    public static final String YUAN = "元";
    public static final String WAN = "万";
    public static final String YI = "亿";
    public static final String ZHAO = "兆";

    private static final String[] CN_UNIT = {"角", "分", "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟"};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要转换的数字");
            try {
                processing(sc.nextDouble());

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取传入数据的小数点之前和之后的数字
     *
     * @param money 输入要转换的金额
     * @return 数字的整数部分和小数部分
     */
    public static String[] doubleToString(double money) {
        DecimalFormat df = new DecimalFormat("#.00");
        String moneyS = df.format(money); //四舍五入为整数
        System.out.println(moneyS);
        String[] split = moneyS.split("\\.");
        System.out.println("整数部分:[" + split[0] + "]小数部分:[" + split[1] + "]");

        return new String[]{split[0], split[1]};

    }

    /**
     * 处理整数部分
     *
     * @param digit 整数部分的字符串
     */
    public static StringBuilder handleDigit(String digit) {
        int length = digit.length();
        if (length > 15) {
            throw new IllegalArgumentException("只支持15位数字");
        }

        char[] chars = digit.toCharArray();//转换为字节数组


        StringBuilder resultDigit = new StringBuilder(); // 存放结果
        StringBuilder resultNum = new StringBuilder(); // 存放数字转换为大写
        StringBuilder resultUnit = new StringBuilder();// 存放单位

        // 转换大写
        // 获取char[] 中的每个值并转为大写
        for (char aChar : chars) {
            String s = switchMach(aChar);
            resultNum.append(s);
        }

        // 遍历resultNum，从高位开始向低位遍历，并对应的获取位所在的单位
        for (int i = resultNum.length(); i > 0; i--) {
            resultUnit.append(CN_UNIT[i + 1]);
        }
        // 将对应的大写与对应的单位拼接在一起
        for (int i = 0; i < resultNum.length(); i++) {
            char c = resultNum.charAt(i);
            char c1 = resultUnit.charAt(i);
            resultDigit.append(c).append((c1));

        }

        // 处理零兆、零亿、零万、零仟、零佰、零拾、零零问题
        int index;
        while ((index = resultDigit.indexOf("零仟")) != -1) {
            resultDigit.replace(index, index + 2, ZERO);
        }

        while ((index = resultDigit.indexOf("零佰")) != -1) {
            resultDigit.replace(index, index + 2, ZERO);
        }


        while ((index = resultDigit.indexOf("零拾")) != -1) {
            resultDigit.replace(index, index + 2, ZERO);
        }

        while ((index = resultDigit.indexOf("零零")) != -1) {
            resultDigit.replace(index, index + 2, ZERO);
        }

        while ((index = resultDigit.indexOf("零万")) != -1) {
            resultDigit.replace(index, index + 2, WAN);
        }

        while ((index = resultDigit.indexOf("零亿")) != -1) {
            resultDigit.replace(index, index + 2, YI);
        }
        while ((index = resultDigit.indexOf("零兆")) != -1) {
            resultDigit.replace(index, index + 2, ZHAO);
        }
        while ((index = resultDigit.indexOf("亿万")) != -1) {
            resultDigit.replace(index, index + 2, YI);
        }

        while ((index = resultDigit.indexOf("零元")) != -1) {
            resultDigit.replace(index, index + 2, YUAN);
        }

        return resultDigit;
    }

    /**
     * 处理小数部分
     *
     * @param decimal 传入小数部分
     */
    public static StringBuilder handleDecimal(String decimal) {
        StringBuilder resultDecimal = new StringBuilder();
        for (int i = 0; i < decimal.length(); i++) {
            String switchMach = switchMach(decimal.charAt(i));
            String res = switchMach + CN_UNIT[i];
            resultDecimal.append(res);
        }
        return resultDecimal;
    }

    /**
     * 管理处理逻辑的方法
     * @param num 传入的浮点数
     */
    public static void processing(double num) {

        String[] stringArr = doubleToString(num);
        // 处理整数部分
        StringBuilder sbDigit = handleDigit(stringArr[0]);
        // 处理小数部分
        StringBuilder sbDecimal = handleDecimal(stringArr[1]);
        String result = String.valueOf(sbDigit) +
                sbDecimal;
        System.out.println("[" + num + "]" + "转换为大写的结果为：[" + result + "]");
        System.out.println("----------------------------------------------------");

    }

    /**
     * 匹配大写
     *
     * @param m 传入的位数上的数字
     * @return
     */
    public static String switchMach(char m) {
        switch (m) {
            case '1':
                return "壹";
            case '2':
                return "贰";
            case '3':
                return "叁";
            case '4':
                return "肆";
            case '5':
                return "伍";
            case '6':
                return "陆";
            case '7':
                return "柒";
            case '8':
                return "捌";
            case '9':
                return "玖";
            case '0':
                return "零";
            default:
                return "错误";
        }

    }
}
