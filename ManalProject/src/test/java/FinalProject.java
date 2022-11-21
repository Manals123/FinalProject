import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.WebElement;
public class FinalProject {
    //   public WebDriver driver = null;

    @BeforeEach
    void intiallaizedSelenium() {
        System.setProperty("web-driver.chrome.driver", "res/chromedriver");
        //WebDriver driver = new ChromeDriver();
    }

    @Test
//Test for registration
    void harsh() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(500);

        var firstName = driver.findElement(By.name("firstname"));
        Thread.sleep(500);
        firstName.sendKeys("Manal");
        Thread.sleep(500);

        var lastName = driver.findElement(By.name("lastname"));
        Thread.sleep(500);
        lastName.sendKeys("Saeda");
        var eMail = driver.findElement(By.id("input-email"));
        Thread.sleep(500);

        eMail.sendKeys("Manals277@gmail.com");
        Thread.sleep(500);
        var telUser = driver.findElement(By.name("telephone"));
        Thread.sleep(500);
        telUser.sendKeys("0509057710");

        var passWord = driver.findElement(By.id("input-password"));
        Thread.sleep(500);
        passWord.sendKeys("Manal123");
        Thread.sleep(500);

        var confirmPass = driver.findElement(By.id("input-confirm"));
        Thread.sleep(500);
        confirmPass.sendKeys("Manal123");
        Thread.sleep(500);

        var subScribe = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/label"));
        Thread.sleep(500);
        var noButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[2]/input"));
        Thread.sleep(500);
        noButton.click();
        Thread.sleep(500);

        var privacyButton = driver.findElement(By.name("agree"));
        Thread.sleep(500);
        privacyButton.click();
        Thread.sleep(500);

        var continueButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
        Thread.sleep(500);
        continueButton.click();
        Thread.sleep(500);
        Assertions.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/success", driver.getCurrentUrl());
    }




        //question no 2
    //log in test
    @Test
    void logIn () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
        Thread.sleep(500);

        var eMail = driver.findElement(By.id("input-email"));
        Thread.sleep(500);
        eMail.sendKeys("Manals277@gmail.com");
        Thread.sleep(500);

        var passWord = driver.findElement(By.id("input-password"));
        Thread.sleep(500);
        passWord.sendKeys("Manal123");
        Thread.sleep(500);

        var logIn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input"));
        Thread.sleep(500);
        logIn.click();
        Thread.sleep(500);

        Assertions.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/account",driver.getCurrentUrl());

    }


    //question no 3
//Add to cart test
    @Test
    void addToCart() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
        Thread.sleep(500);
        var addButton = driver.findElement(By.id("button-cart"));
        addButton.click();
        Thread.sleep(500);
        driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=33");
        Thread.sleep(500);
        var addButton1 = driver.findElement(By.id("button-cart"));
        addButton1.click();
        Thread.sleep(500);


        // check the total amount //problem with var
        WebElement total = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/ul/li[2]/div/table/tbody/tr[4]/td[2]"));
        Thread.sleep(500);
        Assertions.assertEquals(total,"$844');

    }

    //question no 4
//Opinion about the product
    @Test
    void customerOpinion() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
        var reviewsButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/ul[2]/li[3]/a"));
         reviewsButton.click();
          Thread.sleep(500);

        var YourName = driver.findElement(By.id("input-name"));
        YourName.sendKeys("Zoya");
        Thread.sleep(500);
        var YourReview  = driver.findElement(By.id("input-review"));
        String opnion = " The MacBook site is an excellent site and you can see that the site is clear, convenient and accessible for the customer.";
        YourReview.sendKeys(opnion);
    }

    }

