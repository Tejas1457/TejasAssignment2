package org.example;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.example.DataDecrypter.dataDecrypter;

public class Assig2_Base {

    public static WebDriver driver;
    public static SoftAssert softAssert = new SoftAssert();


    public static void softAssert(String Expected, String Actual, String Msg) {
        softAssert.assertEquals(Expected, Actual, Msg);
    }

    public static boolean waitForPagetoLoad_ClickableWait(String element) {
        try {
            WebElement MyElement = driver.findElement(By.xpath(element));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(MyElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean visibilityWait(String element1) {
        try {
            WebElement MyElement = driver.findElement(By.xpath(element1));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.visibilityOf(MyElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void myWait() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void elementClicker(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    public static void elementSender(String path, String value) throws Exception {
        driver.findElement(By.xpath(path)).sendKeys(dataDecrypter(value));
    }

    public static String toGetElement(String element) {
        return driver.findElement(By.xpath(element)).getText();
    }

    public static void takeScreenShot(WebDriver driver, String FolderName, String ScreenshotName) {
        TakesScreenshot Picture = (TakesScreenshot) driver;
        File MyFile = Picture.getScreenshotAs(OutputType.FILE);
        File ScreenShot = new File("C:\\Users\\TF265PL\\OneDrive - EY\\Documents\\BCM_Java\\TejasBDD\\ScreenShotsAssig2\\" + FolderName + "\\" + ScreenshotName + ".png");
        try {
            FileHandler.copy(MyFile, ScreenShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String dataAccessExcel(int row, int col, String inputType) {
        File file = new File("./TestDataAssig2/Assig2.xlsx");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet("MyTest");
        DataFormatter formatter = new DataFormatter();
        String Exceldata = formatter.formatCellValue(sheet.getRow(row).getCell(col));
        return Exceldata;
    }

    public static String getFromPropertyFile(String key) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\TF265PL\\OneDrive - EY\\Documents\\BCM_Java\\TejasBDD\\MyPropertyFile\\Assig2.properties");
        Properties properties = new Properties();
        properties.load(fis);
        return properties.getProperty(key);
    }

    public static void writeToPropertyFile(String key, String value) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\TF265PL\\OneDrive - EY\\Documents\\BCM_Java\\TejasBDD\\MyPropertyFile\\Assig2OutPut.properties");
        Properties properties1 = new Properties();
        properties1.setProperty(key, value);
        properties1.store(fos, null);
    }

    public static void browserLaunch() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TF265PL\\OneDrive - EY\\Documents\\BCM_Java\\TejasBDD\\src\\main\\resources\\New\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get(getFromPropertyFile("url"));
    }

    public static void browserQuit() {
        softAssert.assertAll();
        driver.quit();
    }
}
