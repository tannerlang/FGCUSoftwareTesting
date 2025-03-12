package Basic_SeleniumCodes;


import com.sun.source.tree.TryTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment2
{
    public static void execute(String[] args)
    {
        //chromedriver
        System.setProperty("webdriver.chrom.driver","C://Users//tjlan//OneDrive//Desktop//Software Testing//Drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://artoftesting.com/samplesiteforselenium");

        //get title and url
        System.out.println("Title: " + driver.getTitle());

        //current url
        System.out.println("URL: " + driver.getCurrentUrl());

        //Enter Text
        WebElement textBox = driver.findElement(By.id("fname"));
        textBox.sendKeys("Test");

        //hyperlink
        try{
        WebElement link = driver.findElement(By.linkText("This is a link"));
        link.click();
        System.out.println("Hyperlink clicked");}
        catch(Exception e)
        {
            System.out.println("Link not found");
        }


        //checkbox / radiobutton
        WebElement box = driver.findElement(By.id("male"));
        box.click();


        //dropdown menu
        WebElement dropdown = driver.findElement(By.id("testingDropdown"));
        Select select = new Select(dropdown);
        select.selectByValue("Manual");

        //drag n drop
        WebElement item = driver.findElement(By.id("myImage"));
        WebElement dropLocation = driver.findElement(By.id("targetDiv"));
        Actions action = new Actions(driver);
        action.dragAndDrop(item, dropLocation).perform();

        //size of web elements
        List<WebElement> Elements = driver.findElements(By.xpath("//*"));
        System.out.println("Size of Web Elements: " + Elements.size());


        //display elements
        List<WebElement> displayElements = driver.findElements(By.xpath("//*"));
        for(WebElement it : displayElements)
        {
            System.out.println(it.getTagName() + " . " + it.getText());
        }


    }
}
