package org;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class queryIT {
    private static WebDriver driver;
    //String URL = "http://localhost:8081/";
    String URL="http://localhost:8090/queryForum_war/";

    @BeforeClass
    public static void setDriver() {

        System.setProperty("webdriver.gecko.driver", "geckodriver");

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);


        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");

        driver = new FirefoxDriver(firefoxOptions);

    }
    /*@Test
    public void verifyDiv() {

        String ans="";
        WebDriverWait wait= new WebDriverWait(driver, 1);
        Alert alert;
        try {
            driver.navigate().to(URL); // String getTitle = driver.getTitle(); //Scanner
            driver.findElement(By.id("op1")).sendKeys("10");
            driver.findElement(By.id("op2")).sendKeys("5");
            driver.findElement(By.id("divbtn")).click();

            wait.until(ExpectedConditions.alertIsPresent());

            alert= driver.switchTo().alert();
            ans =alert.getText().trim();
            alert.accept();
        }
        catch (Exception e) {
            System.out.println("In exception");
        }
        Assert.assertEquals(ans, "Answer = 2.0");
    }*/

    @Test
    public void it1VerifyHomePageTittle() {
        // driver.navigate().to(URL);
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("loginbtn"))));

        String getTitle = driver.getTitle();
        System.out.println(getTitle);
        // driver.quit();
        Assert.assertEquals( "IIITB Query Forum",getTitle);
    }

    @Test
    public void it3Login() {
        //Verify Home page
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("signuplink"))));

        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("loginbtn")).click();

        String currPage= driver.getCurrentUrl();
        System.out.println(currPage);
        Assert.assertTrue(currPage.contains("forum.html"));
    }

    @Test
    public void it2SignUpPageCheck() {
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("signuplink"))));

        driver.findElement(By.id("signuplink")).click(); //using Selenium click button method
        String currPage= driver.getCurrentUrl();
        System.out.println(currPage);
        Assert.assertTrue(currPage.contains("sign_up.html"));
    }

    @Test
    public void it4Logout(){
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
      /*  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("signuplink"))));

        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("test123");
        driver.findElement(By.id("loginbtn")).click();*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logoutlink"))));

        driver.findElement(By.id("logoutlink")).click();
        String currPage= driver.getCurrentUrl();
        System.out.println(currPage);

        Assert.assertTrue(currPage.contains("login.html"));


    }

    @AfterClass
    public static void delDriver() {
        driver.quit();
    }

}
