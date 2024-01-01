package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HotelPageUserDetails extends Assig2_Base {
    public static final String City = " //div[contains(@class,'selectHtlCity')]";
    public static final String CityBangalore = "//div[contains(@class,'section-container')]//li[3]";
    public static final String CheckInDate = "((//div[contains(@class,'DayPicker-Body')])[2])//div[contains(@aria-label,'04')]";
    public static final String CheckOutDate = "((//div[contains(@class,'DayPicker-Body')])[2])//div[contains(@aria-label,'11')]";
    public static final String RoomClicker = "//div[contains(@data-cy,'GuestSelect')][1]//span[contains(@data-testid,'room_count')]";
    public static final String RoomSelector = "//ul[contains(@class,'gstSlct__list')]/li[2]";
    public static final String AdultClicker = "//div[contains(@data-cy,'GuestSelect')][1]//span[contains(@data-testid,'adult_count')]";
    public static final String AdultSelector = "//ul[contains(@class,'gstSlct__list')]//li[4]";
    public static final String ApplyBtn = "//div/button[contains(text(),'Apply')]";
    public static final String SearchBtn = "//button[@id='hsw_search_button']";

    public static void citySelector() {
        elementClicker(City);
        elementClicker(CityBangalore);
    }

    public static void checkInAndCheckOutDateSelector() {
        elementClicker(CheckInDate);
        elementClicker(CheckOutDate);
    }

    public static void roomSelector() {
        elementClicker(RoomClicker);
        elementClicker(RoomSelector);
        elementClicker(AdultClicker);
        elementClicker(AdultSelector);
        waitForPagetoLoad_ClickableWait(ApplyBtn);
        JavascriptExecutor JSe = (JavascriptExecutor) driver;
        WebElement btn = driver.findElement(By.xpath(ApplyBtn));
        JSe.executeScript("arguments[0].click();", btn);
        takeScreenShot(driver, "HotelBooking", "AfterDetails");

        waitForPagetoLoad_ClickableWait(SearchBtn);
        elementClicker(SearchBtn);

    }
}
