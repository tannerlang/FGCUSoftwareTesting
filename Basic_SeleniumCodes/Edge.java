//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package Basic_SeleniumCodes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge
{

    public static void execute(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C://Users//tjlan//OneDrive//Desktop//Software Testing//Drivers//msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.fgcu.edu/canvas/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.close();
    }
}