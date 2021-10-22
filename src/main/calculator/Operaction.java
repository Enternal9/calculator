import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Operaction {

    public static String symbol(){//生成符号
        Random rand  = new Random();
        int a =rand.nextInt(4);
        String symbol = null;
        if(a == 0)
            symbol = "+";
        else if(a == 1)
            symbol = "-";
        else if(a == 2)
            symbol = "×";
        else if(a == 3)
            symbol = "÷";
        return symbol;
    }

    public static String expression(int r){//生成表达式
        String str;
        String ans;
        Random rand = new Random();
        do {
            str = "";
            int t = 0;
            t = rand.nextInt(3) + 2;//式子中用于运算的数的个数
            String[] number = new String[t];
            String[] symbol = new String[t-1];
            String[] expression = new String[4*t-3];//由于分数中/和运算中的/是一致的，为了区分运算符和操作数
                                                    // 将操作数和运算符用空格隔开


            for(int i=0;i<t;i++){//生成式子中的数
                number[i] = Num.produce(r);
            }
            for(int i=0;i<t-1;i++){//生成式子中的运算符
                symbol[i] = Operaction.symbol();
            }

            for(int i =0;i<4*t-3;i++){
                if(i%4==0) //字符中奇数位为符号（基0）
                    expression[i] = number[i/4];
                else if(i%4==2)
                    expression[i] = symbol[(i+2)/4-1];
                else
                    expression[i] = " ";
            }
            for(int i = 0;i<4*t-3;i++){
                if(expression[i].contains("'"))
                    expression[i] = Num.transformF(expression[i]);
            }
            for(int i=0;i<4*t-3;i++){
                str = str + expression[i];
            }
            ans = calculate.count(str);
        }while(ans.contains("-"));
        return str + "=" + ans;
    }


    public static void io(int n,int r)throws Exception{
        FileWriter fw = new FileWriter("./Exercises.txt");
        BufferedWriter Exercises = new BufferedWriter(fw);
        FileWriter fw1 = new FileWriter("./Answer.txt");
        BufferedWriter Answer = new BufferedWriter(fw1);

        Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
        String[] exercises = new String[n];
        String[] answers = new String[n];
        for(int i=0;i<n;i++) {//生成式子和答案并写入当前目录的文件中,生成n个
            String[] output = Operaction.expression(r).split("=");//output[0]是式子 output[1]是答案
            if(map.containsKey(output[1])){
                Set<Integer> set = map.get(output[1]);
                while (set.contains(output[0].length()))
                    output = Operaction.expression(r).split("=");
                set.add(output[0].length());
            }else {
                map.put(output[1],new HashSet<Integer>(Arrays.asList(output[0].length())));
            }
            exercises[i] = output[0];
            answers[i] = output[1];

            Exercises.write(i+1 + ". " + output[0]);
            Exercises.newLine();
            Exercises.flush();

            Answer.write(i+1 + ". " + calculate.count(output[0]));
            Answer.newLine();
            Answer.flush();
        }
        Exercises.close();
        Answer.close();

    }
}
