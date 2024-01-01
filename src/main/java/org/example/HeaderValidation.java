package org.example;

import org.openqa.selenium.By;

public class HeaderValidation extends Assig2_Base {

    public final static String MainLogo = "//img[contains(@src,'mmtLogoWhite')]";
    public final static String OfferText = "(//div[@class='flexOne']/p)[1]";
    public final static String OfferSubText = "(//div[@class='flexOne']/p)[2]";
    public final static String BusinessText = "//div/p[@class='whiteText']/span";
    public final static String BusinessSubText = "(//div[@class='appendRight5']/p)[2]";
    public final static String TripText = "(//div[@class='makeFlex column flexOne font10 latoBold']/p)[1]";
    public final static String TripSubText = "(//div[@class='makeFlex column flexOne font10 latoBold']/p)[2]";
    public final static String LoginText = "//div[@class='makeFlex column flexOne whiteText latoBold']/p";
    public final static String SearchBtn = "//p[@class='makeFlex vrtlCenter ']/a";


    public static void imageSrcValidation() {
        waitForPagetoLoad_ClickableWait(SearchBtn);
        takeScreenShot(driver, "MainPage", "HomePage");
        String MainLogoSRC = driver.findElement(By.xpath(MainLogo)).getAttribute("src");
        String RequiredImageSrc = dataAccessExcel(1, 1, "ImageSrc");
        softAssert(RequiredImageSrc, MainLogoSRC, "Failed Logo Validation");
    }

    public static void offerFieldValidation() {
        String OfferText1 = toGetElement(OfferText);
        String OfferSubText1 = toGetElement(OfferSubText);
        String RequiredOfferText = dataAccessExcel(1, 2, "OfferText");
        String RequiredOfferSubText = dataAccessExcel(2, 2, "OfferSubText");
        softAssert(RequiredOfferText, OfferText1, "Failed OfferText Validation");
        softAssert(RequiredOfferSubText, OfferSubText1, "Failed Offer SubText Validation");
    }

    public static void businessTextValidation() {
        String BusinessText1 = toGetElement(BusinessText);
        String BusinessSubText1 = toGetElement(BusinessSubText);
        String RequiredBusinessText = dataAccessExcel(1, 3, "BusinessText");
        String RequiresBusinessSubText = dataAccessExcel(2, 3, "BusinessSubText");
        softAssert(RequiredBusinessText, BusinessText1, "Failed BusinessText Validation");
        softAssert(RequiresBusinessSubText, BusinessSubText1, "Failed BusinessText Validation");
    }

    public static void tripTextValidation() {
        String TripText1 = toGetElement(TripText);
        String TripSubText1 = toGetElement(TripSubText);
        String RequiredTripText = dataAccessExcel(1, 4, "TripText");
        String RequiredTripSubText = dataAccessExcel(2, 4, "TripSubText");
        softAssert(RequiredTripText, TripText1, "Failed TripText Validation");
        softAssert(RequiredTripSubText, TripSubText1, "Failed Business SubText Validation");
    }

    public static void loginTextValidation() {
        String LoginText1 = toGetElement(LoginText);
        String RequiredLoginText = dataAccessExcel(1, 5, "LoginText");
        softAssert(RequiredLoginText, LoginText1, "Failed Login Text validation");
    }
}
