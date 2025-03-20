import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        TestCases test = new TestCases();


        //test 1
        test.driverSetup();
        test.Test1();
        test.cleanUp();

        //test 2
        test.driverSetup();
        test.Test2();
        test.cleanUp();

        //test 3
        test.driverSetup();
        test.test3();
        test.cleanUp();

        //test 4
        test.driverSetup();
        test.Test4();
        test.cleanUp();

        //test 5
        test.driverSetup();
        test.Test5();
        test.cleanUp();
    }
}