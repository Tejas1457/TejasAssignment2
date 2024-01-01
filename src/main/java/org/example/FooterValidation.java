package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FooterValidation extends HeaderValidation {

    public final static String TripText = "(//div[@class='aboutDesc']/h2)[1]";
    public final static String TripSubText = "(//div[@class='font12 lineHeight16'])[1]";
    public final static String BookingText = "(//div[@class='aboutDesc']/h2)[2]";
    public final static String BookingSubText = "(//div[@class='font12 lineHeight16'])[2]";
    public final static String FlightText = "(//div[@class='aboutDesc']/h2)[3]";
    public final static String FlightSubText = "(//div[@class='font12 lineHeight16'])[3]";


    public static void tripTextValidation() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        waitForPagetoLoad_ClickableWait(TripText);
        String TripText1 = toGetElement(TripText);
        String TripSubText1 = toGetElement(TripSubText);
        StringBuffer sb = new StringBuffer(TripSubText1);
        sb.deleteCharAt(sb.length() - 1);
        String sb1=new String(sb);
        String RequiredTripText = dataAccessExcel(1, 6, "Trip Text");
        String RequiredTripSubText = dataAccessExcel(2, 6, "TripSubText");
        softAssert(RequiredTripText,TripText1,"Failed TripText Validation");
        softAssert(RequiredTripSubText,sb1,"Failed TripSubText Validation");
    }

    public static void bookingTextValidation() {
        String BookingText1 = toGetElement(BookingText);
        String BookingSubText1 = toGetElement(BookingSubText);
        String RequiredBookingText = dataAccessExcel(1, 7, "BookingText");
        String RequiredBookingSubText = dataAccessExcel(2, 7, "BookingSubText");
        softAssert(RequiredBookingText,BookingText1,"Failed BookingText Validation");
        softAssert(RequiredBookingSubText,BookingSubText1,"Failed BookingSubTextValidation");
    }

    public static void flightTextValidation() {
        String FlightText1 = toGetElement(FlightText);
        String FlightSubText1 = toGetElement(FlightSubText);
        String RequiredFlightText = dataAccessExcel(1, 8, "FlightText");
        String RequiredFlightSubText = dataAccessExcel(2, 8, "FlightSubText");
        softAssert(RequiredFlightText,FlightText1,"Failed FlightText Validation");
        softAssert(RequiredFlightSubText,FlightSubText1,"Failed FlightSubText Validation");
    }
    public static void footerPictureCapture() {
        takeScreenShot(driver, "MainPage", "Footer");
    }

}
