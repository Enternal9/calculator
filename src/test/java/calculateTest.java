import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calculateTest {

    @Test
    void count() {
        int n = 100;
        String[] expression = Operaction.expression(n).split("=");

        System.out.println(expression[0] + "=" + expression[1]);
    }

    @Test
    void gcd() {
        String str = "1+1=";
        String answer = "2";
        String answer1;
        String[] strs = str.split("=");
        answer1 = calculate.count(strs[0]);
        System.out.println(answer + " "+ answer);
        if(answer.equals(answer1))
            System.out.println("correct");

    }
}