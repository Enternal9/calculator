import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Check {

    public static void check(String exercise,String answer)throws Exception{

        String exp = "";
        String[] exps = null;
        String[] ans = null;
        String answer1;
        String answer2;
        String Correct = "(";
        String Wrong = "(";
        int CorrectNum = 0;
        int WrongNum = 0;
        FileWriter fw = new FileWriter("./check.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        FileReader fr = new FileReader("./"+exercise);
        BufferedReader br = new BufferedReader(fr);

        FileReader answerfr = new FileReader("./"+answer);
        BufferedReader answerbr = new BufferedReader(answerfr);

        for(int i=1;(exp = br.readLine())!=null;i++){
            if(exp.contains(". "))
                exps = exp.split("\\.");

            answer1 = calculate.count(exps[1]);//计算出表达式的结果
            ans = answerbr.readLine().split("\\. ");
            answer2 = ans[1];//答案文件给的结果
            if(answer1.equals(answer2)){
                Correct = Correct + i + ",";
                CorrectNum += 1;
            }else{
                Wrong = Wrong + i + ",";
                WrongNum += 1;
            }
        }
        bw.write("Correct: " + CorrectNum + "  " +  Correct + ")");
        bw.newLine();
        bw.write("Wrong: " + WrongNum + "  " + Wrong + ")");
        bw.close();


    }
}
