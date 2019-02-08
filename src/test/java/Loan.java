import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Loan {
    @Test
    public void loan() {

        double baseAmount = 650;

        double amountToReturn = 620;

//    процент для  первых 10 лет
        double procFist = baseAmount * 0.1;

        double firsTen = ((procFist + baseAmount) - (baseAmount / 3));

        double secTen = (firsTen - (baseAmount / 3)) * 0.08;

        double thirdTen = (secTen - (baseAmount / 3)) * 0.06;

        double finalAmount = (firsTen + secTen + thirdTen);

        System.out.println("Your total amount : " + finalAmount);

        Assertions.assertEquals(amountToReturn, finalAmount, "Total amount is not correct ");
    }
}


