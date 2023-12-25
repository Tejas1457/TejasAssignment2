package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking extends Assig1_Base {

    public static String FlightTypeRound = "//input[@value='roundtrip']";
    public static String FlightTypeOne = "//input[@value='oneway']";
    public static String ServiceFirst = "//input[@value='First']";
    public static String Passenger = "//select[@name='passCount']";
    public static String DepartingFrom = "//select[@name='fromPort']";
    public static String OnMonth = "//select[@name='fromMonth']";
    public static String OnDate = "//select[@name='fromDay']";
    public static String ArrivingIn = "//select[@name='toPort']";
    public static String ReturnMonth = "//select[@name='toMonth']";
    public static String ReturnDate = "//select[@name='toDay']";
    public static String Airline = "//select[@name='airline']";
    public static String Submit = "//input[@name='findFlights']";

    public static void FlightDataEntry() {
        WebElement SubmitLocater=driver.findElement(By.xpath(Submit));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",SubmitLocater);
        TS(driver, "S4_First");
        driver.findElement(By.xpath(FlightTypeRound)).click();
        driver.findElement(By.xpath(ServiceFirst)).click();

        String data1 = DataAccess1(1, 4, "");
        Select Passenger1 = new Select(driver.findElement(By.xpath(Passenger)));
        Passenger1.selectByValue(data1);

        String data2 = DataAccess1(1, 5, "");
        Select Depart = new Select(driver.findElement(By.xpath(DepartingFrom)));
        Depart.selectByValue(data2);

        String data3 = DataAccess1(1, 6, "");
        Select OnMonth1 = new Select(driver.findElement(By.xpath(OnMonth)));
        OnMonth1.selectByVisibleText(data3);

        String data4 = DataAccess1(1, 7, "");
        Select OnDate1 = new Select(driver.findElement(By.xpath(OnDate)));
        OnDate1.selectByValue(data4);

        String data5 = DataAccess1(1, 8, "");
        Select ArriveFrom = new Select(driver.findElement(By.xpath(ArrivingIn)));
        ArriveFrom.selectByValue(data5);

        String data6 = DataAccess1(1, 9, "");
        Select RetMonth = new Select(driver.findElement(By.xpath(ReturnMonth)));
        RetMonth.selectByVisibleText(data6);

        String data7 = DataAccess1(1, 10, "");
        Select RetDate = new Select(driver.findElement(By.xpath(ReturnDate)));
        RetDate.selectByValue(data7);

        String data8 = DataAccess1(1, 11, "");
        Select Airline1 = new Select(driver.findElement(By.xpath(Airline)));
        Airline1.selectByVisibleText(data8);

        TS(driver, "S4_Second");
        driver.findElement(By.xpath(Submit)).click();
    }

    public static void BookingStatus() {
        TS(driver, "S4_Three");
        String Flighttext = driver.findElement(By.xpath("(//b/font)[1]")).getText();
        if (Flighttext.contains("No")) {
            DataWrite1("Scenario_4", "", Flighttext);
        } else {
            DataWrite1("Scenario_4", Flighttext, "");
        }
    }

}
