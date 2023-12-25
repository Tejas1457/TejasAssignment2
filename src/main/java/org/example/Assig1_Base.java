package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class Assig1_Base {

    public static int flag;
    public static WebDriver driver;

    public static String UserName1 = "//input[@id='email']";
    public static String Password = "//input[@name='password']";
    public static String ConfirmPassword = "//input[@name='confirmPassword']";
    public static String SubmitBtn = "//input[@name='submit']";
    public static String MainUser = "//input[@name='userName']";
    public static String MainPassword = "//input[@name='password']";
    public static String MainSubmit = "//input[@name='submit']";
    public static String InvalidSpanText = "//td/span";


    static void TS(WebDriver driver, String Ssname) {
        //To take screenshot this method is used
        TakesScreenshot Picture = (TakesScreenshot) driver;
        File MyFile = Picture.getScreenshotAs(OutputType.FILE);
        File ScreenShot = new File("C:\\Users\\TF265PL\\OneDrive - EY\\Documents\\BCM_Java\\TejasBDD\\ScreenShots\\" + Ssname + ".png");
        try {
            FileHandler.copy(MyFile, ScreenShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String DataAccess1(int row, int col, String inputType) {
        //To access data from Excel
        File file = new File("./TestData/Book1.xlsx");
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
        if (inputType == "Url" || inputType == "Url1") {
            driver.get(Exceldata);
        }
        return Exceldata;
    }

    public static void DataWrite1(String FileName, String PassMsg, String FailMsg) {
        //To write data to Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(FileName);
        XSSFRow row;
        Map<String, Object[]> TestData
                = new TreeMap<String, Object[]>();

        TestData.put("1", new Object[]{"Scenario", "Pass Message", "Failure Message"});
        TestData.put("2", new Object[]{FileName, PassMsg, FailMsg});
        Set<String> keyid = TestData.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = TestData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }

            FileOutputStream out = null;
            try {
                out = new FileOutputStream(
                        new File("./TestData/" + FileName + ".xlsx"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                workbook.write(out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void BrowserSetup() throws IOException {
        //Setup and launch
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TF265PL\\OneDrive - EY\\Documents\\BCM_Java\\TejasBDD\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        if (flag == 0) {
            DataAccess1(1, 0, "Url");
        } else {
            DataAccess1(2, 0, "Url1");
        }

    }

    public static void RegisterClick() {
        TS(driver, "S1_First");
        driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
        TS(driver, "S1_Second");
    }

    public static void UserRegistration() {
        String User = DataAccess1(1, 1, "");
        String Pass = DataAccess1(1, 2, "");
        driver.findElement(By.xpath(UserName1)).sendKeys(User);
        driver.findElement(By.xpath(Password)).sendKeys(Pass);
        driver.findElement(By.xpath(ConfirmPassword)).sendKeys(Pass);
        TS(driver, "S1_Three");
        driver.findElement(By.xpath(SubmitBtn)).click();
    }

    public static void UserValidation() {
        String NoteMsg = driver.findElement(By.xpath("(//tbody/tr/td/p/font/b)[2]")).getText();
        String LastWord = NoteMsg.substring(NoteMsg.lastIndexOf(" ") + 1);
        StringBuffer sb = new StringBuffer(LastWord);
        sb.deleteCharAt(sb.length() - 1);
        String RegistredUser = String.valueOf(sb);
        String User = DataAccess1(1, 1, "");
        if (RegistredUser.equals(User)) {
            TS(driver, "S1_Four");
            DataWrite1("Scenario_1", RegistredUser + " User Login Successful", "");
        } else {
            DataWrite1("Scenario_1", "", "User Login Failed");
        }
    }

    public static void ValidUserLoginCheck() {
        String User = DataAccess1(1, 1, "UserName");
        String Pass = DataAccess1(1, 2, "Password");
        driver.findElement(By.xpath(MainUser)).sendKeys(User);
        driver.findElement(By.xpath(MainPassword)).sendKeys(Pass);
        TS(driver, "S2_First");
        driver.findElement(By.xpath(MainSubmit)).click();
        String SuccessfulLogin = driver.findElement(By.xpath("//table/tbody/tr/td/h3")).getText();
        if (SuccessfulLogin.equals("Login Successfully")) {
            TS(driver, "S2_Second");
            DataWrite1("Scenario_2", "Valid User " + User + " Able to Login Successfully", "");
        } else {
            DataWrite1("Scenario_2", "", "User Unable to login");
        }
    }

    public static void ValidUserInvalidPassword() {
        String User = DataAccess1(1, 1, "UserName");
        String InvalidPassword = DataAccess1(1, 3, "InvalidPassword");
        driver.findElement(By.xpath(MainUser)).sendKeys(User);
        driver.findElement(By.xpath(MainPassword)).sendKeys(InvalidPassword);
        TS(driver, "S3_First");
        driver.findElement(By.xpath(MainSubmit)).click();
        TS(driver, "S3_Second");
        String ErrorMsg = driver.findElement(By.xpath(InvalidSpanText)).getText();
        if (ErrorMsg.contains("correct")) {
            DataWrite1("Scenario_3", "", "Invalid UserName/Password: User Unable to login");
        } else {
            DataWrite1("Scenario_3", "User Exists: Login Successful", "");
        }
    }

    public static void BrowserClose() {
        driver.quit();
    }

}
