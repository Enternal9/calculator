import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperactionTest {

    @Test
    void symbol() {
    }

    @Test
    void expression() {
    int n = 1000;
    for(int i=0;i<10;i++) {
        String str = Operaction.expression(n);
        System.out.println(str);
        }
    }

    @Test
    void ioTest() {
        int d = 100;//生成100条式子
        int n = 100;//生成范围在100以内的数
        try{
            Operaction.io(d, n);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}