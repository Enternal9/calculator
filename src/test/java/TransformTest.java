import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class TransformTest {

    @Test
    void isNum() {
    }

    @Test
    void priority() {
    }

    @Test
    void creat() {
        String expeission;
        for(int i=0;i<10;i++){
            String str = Operaction.expression(100);
            System.out.println(str);
//            for(int j=0;j<str.length();j++){
//                char c = str.charAt(j);
//                System.out.println(c);
//            }
            expeission = Transform.creat(str);
            System.out.println(expeission);
            System.out.println(" ");
        }
    }

    @Test
    void creatTest(){
        String expression;
        String str = "( 1 + 1 ) x 8";
        expression = Transform.creat(str);
        System.out.println(expression);
    }
}