import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaBasic {

    @Test
    public void javaBasic() {
        int a = 13;
        int b = 11;
        int c = sumDigits(13, 11);
        int d = sumDigits(a, b);

        System.out.println("Summ is : " + c);
        System.out.println("Summ is : " + d);
        Assertions.assertEquals(23, c, "Summ is not correct ");
    }

    private Integer sumDigits(int a, int b) {
        return a + b;
    }
}
