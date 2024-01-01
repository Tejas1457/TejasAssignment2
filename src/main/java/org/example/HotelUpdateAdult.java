package org.example;

import org.openqa.selenium.By;

public class HotelUpdateAdult extends Assig2_Base {

    public static final String RoomClicker = "//div[contains(@id,'room_guests')]";
    public static final String AdultClicker = "//span[contains(@data-testid,'adult_count')]";
    public static final String AdultSelector = "//ul[contains(@class,'gstSlct__list')]//li[3]";
    public static final String ApplyBtn = "//div/button[contains(text(),'Apply')]";

    public static void adultChanger() {
        waitForPagetoLoad_ClickableWait(RoomClicker);
        takeScreenShot(driver, "HotelBooking", "BeforeAdultNumUpdate");
        elementClicker(RoomClicker);
        elementClicker(AdultClicker);
        elementClicker(AdultSelector);
        waitForPagetoLoad_ClickableWait(ApplyBtn);
        elementClicker(ApplyBtn);
        myWait();
        takeScreenShot(driver, "HotelBooking", "AfterAdultNumUpdate");
    }
}
