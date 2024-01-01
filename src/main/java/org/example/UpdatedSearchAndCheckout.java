package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class UpdatedSearchAndCheckout extends Assig2_Base {
    public static final String BookThisNow = "//div[@class='prmRoomDtlCard__footer']/span/a";
    public static final String SelectNow = "//div[@class='rmPayable__dtl--right ']/a";

    public static void checkoutWithUpdatedData() {
        elementClicker(BookThisNow);
        myWait();
        checkout();
    }

    public static void checkout() {
        myWait();
        takeScreenShot(driver, "HotelBooking", "CheckoutPage");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        myWait();
        takeScreenShot(driver, "HotelBooking", "CheckoutPageEnd");
    }
}
