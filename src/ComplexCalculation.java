import java.math.BigInteger;
import java.util.Objects;
//Here Thread and task(runnable) are coupled to together.

public class ComplexCalculation {

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result= new BigInteger(String.valueOf(1));
        //calculate power in each thread sum of powers;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1,power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2,power2);
        thread1.setName("First thread");
        thread2.setName("second thread");
        thread1.start();
        thread2.start();
        System.out.println("Thread 1 before join result: "+thread1.getResult());
        System.out.println("Thread 2 before join result: "+ thread2.getResult());
        thread1.join();
        thread2.join();
        System.out.println("Thread 1 after join result: "+thread1.getResult());
        System.out.println("Thread 2 after join result: "+ thread2.getResult());
        result = thread1.getResult().add(thread2.getResult());
       return result;
    }

    //Task
    private static class PowerCalculatingThread extends Thread{
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run(){
            //implement the calculation of result = base ^ power
            while(!Objects.equals(power, BigInteger.ZERO)){
                if(Thread.interrupted()){
                    System.out.println("Interrupted : "+ Thread.currentThread().getName());
                    return;
                }
                result = result.multiply(base);
                power = power.subtract(BigInteger.ONE);
                System.out.println("Inside thread: " + Thread.currentThread().getName() +" result: "+result);
            }
        }
        public BigInteger getResult(){
            return result;
        }
    }
}
