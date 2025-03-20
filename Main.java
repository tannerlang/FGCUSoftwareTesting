

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        TestSuite testSuite = new TestSuite();

        testSuite.driverSetUp();
        //testSuite.loginTest();
       // testSuite.screenshotTest();
        //testSuite.scrollTest();
        //testSuite.upDownTest();
        testSuite.webHandleTest();
        //testSuite.cleanUp();
    }
}