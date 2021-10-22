import java.util.Random;

public class Num {
    int numerator=0;
    int denominator=0;

    Num(int i, int j){
        numerator=i;
        denominator=j;
    }

    public static String produce(int n){//生成一个小于n的整数或分数
        Random rand = new Random();
        int a = rand.nextInt(n-1);//数中整数部分
        int numerator = rand.nextInt(4);//分子部分
        int denominator = rand.nextInt(6) + numerator;//分母部分
        String num = Integer.toString(a);
        if(numerator>=3){
            if(num.equals("0")){
                num = numerator + "/" + denominator;
            }
            else
            {
                num = a + "'" + numerator + "/" + denominator;
            }
        }
        if(num.equals("0"))
            num = Integer.toString(1);
        return num;
    }

    public static String transformF(String TrueFration){//把真分数变成假分数
        String b[] = TrueFration.split("'");
        String c[] = b[1].split("/");
        int cer = Integer.parseInt(b[0]);//整数部分
        int mol = Integer.parseInt(c[0]);//原分子部分
        int den = Integer.parseInt(c[1]);//分母部分
        int numerator = cer * den + mol; //假分数分子部分为 整数*分母+分子
        String fration = numerator + "/" + den;
        return fration;
    }

    public static String transformT(int numerator,int denominator){//把传入的数化作真分数
        if(numerator > denominator){
            if(denominator == 1){
                return numerator + "";
            }
            return numerator/denominator + "'" + numerator%denominator + "/" + denominator;
        }
        return numerator + "/" + denominator;
    }

}
