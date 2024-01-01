package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.example.DataDecrypter.dataDecrypter;


public class ValidUserLogin extends Assig2_Base {
    public final static String ContinueBtn = "//div[contains(@class,'btnContainer')]//button[contains(@class,'capText')]";
    public static final String EditTextPlaceHolder = "//input[@id='username']";
    public static final String LoginWithPasswordBtn = "//div[@class='switchLoginFlow']/a";
    public static final String PasswordEntry = "//input[@id='password']";
    public static final String LoginBtn = "//button[@class='capText font16']";

    public static void enterUserName() throws Exception {
        driver.findElement(By.xpath(EditTextPlaceHolder)).sendKeys(dataDecrypter("aaqBRLzF8Ln9gGhoD6NrbQ=="));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForPagetoLoad_ClickableWait(ContinueBtn);
        takeScreenShot(driver, "LoginPage", "LoginScreenWithDetails");
        boolean x = waitForPagetoLoad_ClickableWait(ContinueBtn);

        if (x) {
            for (int i = 0; i <= 3; i++) {
                driver.findElement(By.xpath(ContinueBtn)).click();
            }
//            JavascriptExecutor JSe = (JavascriptExecutor) driver;
//            WebElement btn = driver.findElement(By.xpath(ContinueBtn));
//            JSe.executeScript("arguments[0].click();", btn);
        }
//        WebElement element=driver.findElement(By.xpath(ContinueBtn));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(element).click(element);
//        builder.perform();
        System.out.println("Continue Pass");

        /*driver.findElement(By.xpath(ContinueBtn)).click();
        waitForPagetoLoad_ClickableWait(LoginWithPasswordBtn);
        takeScreenShot(driver, "LoginPage", "LoginWithPassword");
        driver.findElement(By.xpath(LoginWithPasswordBtn)).click();
        driver.findElement(By.xpath(PasswordEntry)).sendKeys("Zooro1457");
        waitForPagetoLoad_ClickableWait(LoginBtn);
        driver.findElement(By.xpath(LoginBtn)).click(); */

    }
}
