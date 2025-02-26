//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package Basic_SeleniumCodes;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Chrome.execute(args);
        Edge.execute(args);
        Firefox.execute(args);
    }
}