package org.example;

import org.openqa.selenium.By;

public class HotelSelection extends Assig2_Base {
    public static final String HotelSelector = "(//div[contains(@class,'appendTop8')])[1]";

    public static void setHotelSelector() {
        waitForPagetoLoad_ClickableWait(HotelSelector);
        takeScreenShot(driver, "HotelBooking", "HotelSelector");
        elementClicker(HotelSelector);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

}

