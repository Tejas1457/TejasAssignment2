package org.example;

import org.testng.asserts.SoftAssert;

public class WebsiteNameAndUrlValidation extends Assig2_Base {
    public static final String RequiredWebName = dataAccessExcel(1, 9, "WebsiteName");
    public static final String ActualWebName = driver.getTitle();
    public static final String RequiredUrl = dataAccessExcel(1, 0, "Url");
    public static final String ActualUrl = driver.getCurrentUrl();

    public static void nameAndUrlValidation() {
        softAssert(RequiredWebName,ActualWebName,"Failed WebName Validation");
        softAssert(RequiredUrl,ActualUrl,"Failed Url Validation");
    }
}
