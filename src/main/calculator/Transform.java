import java.util.Stack;

public class Transform {

    public static boolean isNum(char x){//判断是否为数字
        return (x>='0'&&x<='9');
    }

    public static int priority(char x){//判断符号的优先级
        if(x == '+' || x == '-')
            return 1;
        else if(x == '×' ||x=='÷')
           return 2;
        else if(x =='(')
            return 0;
        else
            return -1;
    }

    public static String creat(String str){//中辍表达式转后辍表达式，逆波兰算法
        int tmp = 0;
        String expression = "";//输出的式子
        String[] str1 = str.split(" ");
        String str2 = "";
        for(int i = 0;i< str1.length;i++){
            str2 += str1[i];
        }
        Stack<Character> symbolStack = new Stack<Character>();
        for(int i=0;i<str2.length();i++){
            char c = str2.charAt(i);
            if(isNum(c)) {//如果是数字，直接加进表达式中
                tmp = (c-'0');
                expression += tmp;
            }
            else if(c == '/')
                expression += c;
            else if(c == '(')//如果是左括号，直接压入符号栈
                symbolStack.push(c);
            else if(c == ')'&& !symbolStack.empty()){//如果遇到右括号且符号栈不为空，那么把符号都添加到表达式中
                while(symbolStack.peek()!='('){
                    expression += symbolStack.pop();
                }
                symbolStack.pop();
            }else{//如果是非左/右括号的运算符
                expression += " ";
                if(!symbolStack.empty()){//如果符号栈不为空，将当前符号和符号栈栈顶的符号的优先度做对比，如果优先度高，则压入符号栈
                    if((priority(c)>priority(symbolStack.peek())))
                        symbolStack.push(c);
                    else{//如果优先度没有栈顶符号高，那么将符号栈里的符号都输出到表达式中，直到找到一个优先度低于当前符号的，再压入符号栈
                        while(!symbolStack.empty()){
                            if(priority(c)<=priority(symbolStack.peek())){
                                expression += symbolStack.pop();
                                expression += " ";
                            }
                            else
                                break;
                        }
                        symbolStack.push(c);
                    }
                }
                else
                {//如果符号栈为空，直接压入符号栈
                    symbolStack.push(c);
                }
            }
        }

        while(!symbolStack.empty()){//如果遍历完整个表达式后，扔存在运算符，则将符号都输出到表达式中
            expression += " ";
            expression += symbolStack.pop();
        }
        return expression;

    }

}
