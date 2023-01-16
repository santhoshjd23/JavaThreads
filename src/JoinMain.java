import java.math.BigInteger;

public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        String base1 = "10";
        String power1= "10";
        String base2= "3";
        String power2="20";
        BigInteger result = complexCalculation.calculateResult(getBigInt(base1), getBigInt(power1), getBigInt(base2), getBigInt(power2));
        System.out.println("Sum of powers : "+result);
    }

    public static BigInteger getBigInt(String val){
        return new BigInteger(val);
    }
}