
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class TestSuite
{

    WebDriver driver;
    @BeforeClass
    //set up the driver, wait for 2 seconds after setting the driver up and loading the initial chrome page up.
    public void driverSetUp()
    {
        System.setProperty("webdriver.chrom.driver","C://Users//tjlan//OneDrive//Desktop//Software Testing//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();        //fullscreen
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    /*loads the login page, inputs the proper username tomsmith and the correct password,
    * then waits for a second before clicking the login button*/
    public void loginTest()
    {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith"); //input username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //input password
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("button.radius")).click();    //submit


        //uses an assert to check if the success message appears on the webpage after login.
        WebElement successMessage = driver.findElement(By.id("flash")); //create webelement
        //check if successful, if condition is false (test failed): display Login Failed.
        Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"), "Login Failed");
    }

    @Test
    //takes a screenshot and saves it to my software testing folder on my desktop as screenshot.png
    //before taking the screenshot I wait for 2 seconds.
    public void screenshotTest()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try{
            TakesScreenshot screenshot=(TakesScreenshot)driver;
            File src=screenshot.getScreenshotAs(OutputType.FILE);
            File des=new File("C://Users//tjlan//OneDrive//Desktop//Software Testing//screenshot.png");
            FileHandler.copy(src,des);
        } catch (IOException e)
        {
            //if screenshot fails, print why to the log, for debugging.
            System.out.println("Screenshot Failed" + e.getMessage());
        }
    }

    @Test
    //scrolls the window down 1500 pixels and back up. Waiting for 1 second before scrolling back up.
    public void scrollTest() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.get("https://demoblaze.com/");
        //after setting the driver to the new webpage, wait for 4 seconds to allow it to load so the test
        //can actually scroll up and down.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //create a javascript executor, to perform the scrolling
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        System.out.println("Scrolling down...");
        exe.executeScript("window.scrollBy(0,1500);");    //scroll down

        //wait for 1 second before scrolling back up.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Scrolling up...");
        exe.executeScript("window.scrollTo(0,0);");     //scroll up
    }

    @Test
    //go back to the hero website, to test the file upload and download.
    //wait for 2 seconds before navigating to the site.
    public void upDownTest()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.get("https://the-internet.herokuapp.com/upload");        //navigate to hero site
        WebElement uploadButton = driver.findElement(By.id("file-upload")); //find file upload, and wait two seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //input the filepath of what I want to upload
        uploadButton.sendKeys("C://Users//tjlan//OneDrive//Desktop//Software Testing//upload.txt");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //wait for half a second and click submit.
        driver.findElement(By.id("file-submit")).click();

        //wait before moving on
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //file download
        //find the file i want to download via link text, and download it.
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement downloadButton = driver.findElement(By.linkText("sample.txt"));
        downloadButton.click();

    }

    @Test
    //Handles multiple windows
    public void webHandleTest()
    {
        //wait for two seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.get("https://the-internet.herokuapp.com/windows");

        //store the main window
        String main = driver.getWindowHandle();

        //wait for 1 second
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //click to open the new window, which automatically switches the test to that window in chrome.
        driver.findElement(By.linkText("Click Here")).click();

        //wait for 1 and a half seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //switch back to the main window.
        driver.switchTo().window(main);
    }

    @AfterClass
    public void cleanUp()
    {

        //wait for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //close the test.
        if(driver != null)
        {
            driver.quit();
        }
    }
}
