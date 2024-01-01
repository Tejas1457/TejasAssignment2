package org.example;

import org.openqa.selenium.By;

public class UserClickOnHotel extends Assig2_Base {
    public static final String HotelsBtn = "//li[contains(@class,'menu_Hotels')]";
    public static final String SearchBtn = "//button[@id='hsw_search_button']";

    public static void hotelClick() {
        driver.findElement(By.xpath(HotelsBtn)).click();
        waitForPagetoLoad_ClickableWait(SearchBtn);
        takeScreenShot(driver, "HotelBooking", "MainPage");
    }
}
