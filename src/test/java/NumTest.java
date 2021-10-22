import org.junit.Test;

public class NumTest {
    @Test
    public void produceTest(){
        int n = 10;
        for(int i=0;i<5;i++){
            String a = Num.produce(n);
            System.out.println(a);
        }
    }

    @Test
    public void transformTest(){
        String Number = "6'3/4";
        String num = Num.transformF(Number);
        System.out.println(num);
        System.out.println(0%4);
    }
}