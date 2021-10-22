import java.util.Stack;

public class calculate {

    public static String count(String str1){
        String str = Transform.creat(str1);
        boolean haveNum = false;
        boolean haveFraction = false;
        int tmp = 0;
        int numer = 0;
        int gcd = 0;
        char x;

        Num a=null;
        Num b=null;
        Num c=null;

        Stack<Num> number = new Stack<Num>();
        for(int i=0;i<str.length();i++){
            x = str.charAt(i);
            if(Transform.isNum(x)){
                haveNum = true;
                tmp = tmp*10 + (x-'0');//每遇到一个数字就*10+x
            }
            else{
                if(haveNum){//如果遇到数字后跟着符号的情况
                    haveNum = false;
                    if(x!='/'){//跟着的符号不为‘/’，即+。-。*、÷和空格的情况
                        if(haveFraction){//如果判定前面的数字为分数
                            Num fraction = new Num(numer,tmp);//创建分数并压入栈
                            number.push(fraction);
                            tmp = 0;
                        }else {//整数情况
                            Num interger = new Num(tmp,1);//把整数压入栈
                            number.push(interger);
                            tmp = 0;
                        }
                    }else{//数字后跟着的符号为/，即前面数字为分子的情况
                        haveFraction = true;
                        numer = tmp;//tmp是分子
                        tmp = 0;
                        continue;
                    }
                }//如果跟着的符号是+。-。*、÷和空格的情况，压出栈中的数字并进行计算
                if(x == '+'){
                    b = number.peek();
                    number.pop();
                    a = number.peek();
                    number.pop();
                    c = add(a,b);
                }
                else if(x == '-'){
                    b = number.peek();
                    number.pop();
                    a = number.peek();
                    number.pop();
                    c = subtract(a,b);
                }
                else if(x == '×'){
                    b = number.peek();
                    number.pop();
                    a = number.peek();
                    number.pop();
                    c = mul(a,b);
                }
                else if(x == '÷'){
                    b = number.peek();
                    number.pop();
                    a = number.peek();
                    number.pop();
                    c = div(a,b);
                }
                else if(x == ' '){//如果跟着的符号是空格
                    if(haveFraction)
                        haveFraction = false;
                    continue;
                }
                number.push(c);//把运算结果压入栈，进行下一次的运算
            }
        }
    if(number.size() > 1)//如果运算完栈中仍有数/运算符，则报错
        System.out.println("ERROR");
    Num z = number.peek();//z为最终的结果
    if(z.numerator != 0){//最终结果进行化简操作
        gcd = gcd(z.denominator,z.numerator);
        z.numerator /= gcd;
        z.denominator /= gcd;
    }
    number.pop();
    return Num.transformT(z.numerator,z.denominator);//把结果化作真分数
    }


    public static Num add(Num a,Num b){//加法
        Num c = new Num(1,1);
        c.numerator = a.numerator*b.denominator + a.denominator*b.numerator;
        c.denominator = a.denominator*b.denominator;
        return c;
    }
    public static Num subtract(Num a,Num b){//减法
        Num c = new Num(1,1);
        c.numerator = a.numerator*b.denominator - a.denominator*b.numerator;
        c.denominator = a.denominator*b.denominator;
        return c;
    }
    public static Num mul(Num a,Num b){//乘法
        Num c = new Num(1,1);
        c.numerator = a.numerator * b.numerator;
        c.denominator = a.denominator * b.denominator;
        return c;
    }
    public static Num div(Num a,Num b){//除法
        Num c = new Num(1,1);
        c.numerator = a.numerator * b.denominator;
        c.denominator = a.denominator * b.numerator;
        return c;
    }


    public static int gcd(int a,int b){//辗转相除法求最大公约数
        int c = a%b;
        while(c!=0){
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

}
