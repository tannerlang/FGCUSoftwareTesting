package Basic_SeleniumCodes;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome
{

    public static void execute(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrom.driver","C://Users//tjlan//OneDrive//Desktop//Software Testing//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.fgcu.edu/canvas/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.close();
    }
}