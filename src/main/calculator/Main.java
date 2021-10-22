import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        int b=0;
        int n;//生成式子的数量
        int r;//式子中数字的取值范围
        String exercisefile = null;
        String answerfile = null;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String input = "";
        String[] inputs;
        boolean exit = false;
        int i = 0;

        while (!exit){
            System.out.println("请输入选项的序号： 1.生成题目   2.校验答案是否正确   3.退出");
            if(sc.hasNextInt()){
                b = sc.nextInt();
            }
            switch (b){
                case 1:
                    System.out.println("请输入题目的数量，格式：-n 10");
                    if(sc1.hasNextLine()){
                        input = sc1.nextLine();
                    }
                    inputs = input.split(" ");
                    if(inputs[0].equals("-n")){
                        n = Integer.parseInt(inputs[1]);
                    }else{
                        System.out.println("输入的指令不符合格式要求，请重试");
                        continue;
                    }

                    System.out.println("请输入题目中数字的范围，格式：-r 10");
                    if(sc1.hasNextLine()){
                        input = sc1.nextLine();
                    }
                    inputs = input.split(" ");
                    if(inputs[0].equals("-r")) {
                        r = Integer.parseInt(inputs[1]);
                    }else{
                        System.out.println("输入的指令不符合格式要求，请重试");
                        continue;
                    }
                    try{
                        Operaction.io(n,r);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("共生成" + n + "道题");
                    break;

                case 2:
                    System.out.println("请输入校验文件名，格式：-e <exercisefile>.txt -a <answerfile>.txt");
                    if(sc1.hasNextLine()){
                        input = sc1.nextLine();
                    }
                    inputs = input.split(" ");
                    if(inputs[0].equals("-e")&&inputs[2].equals("-a")){
                        exercisefile = inputs[1];
                        answerfile = inputs[3];
                    }
                    try{
                        Check.check(exercisefile,answerfile);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    exit = true;
                    break;


            }





        }
    }
}
