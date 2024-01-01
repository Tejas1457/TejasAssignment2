package org.example;

import org.openqa.selenium.By;

public class LoginPageValidation extends Assig2_Base {
    public final static String LoginBtn = "//div[@class='makeFlex column flexOne whiteText latoBold']/p";
    public final static String SearchBtn1 = "//p[@class='makeFlex vrtlCenter ']/a";
    public final static String CloseBtn = "//span[@class='commonModal__close']";
    public final static String GoogleBtn = "//div[@class='nsm7Bb-HzV7m-LgbsSe-Bz112c']";
    public final static String ContinueBtn = "//button[@class='capText font16']";
    public static final String PersonalAccountText = "//li[@class='active']";
    public static final String EditTextTitle = "//div[@class='modalField makeFlex column appendBottom20']/label";
    public static final String EditTextPlaceHolder = "//input[@id='username']";
    public static final String BzAccountText = "(//div[@class='appendBottom25']/ul/li)[2]";


    public static void loginClick() {
        waitForPagetoLoad_ClickableWait(SearchBtn1);
        takeScreenShot(driver, "LoginPage", "HomeScreen");
        waitForPagetoLoad_ClickableWait(LoginBtn);
        driver.findElement(By.xpath(LoginBtn)).click();
        waitForPagetoLoad_ClickableWait(GoogleBtn);
        takeScreenShot(driver, "LoginPage", "LoginScreen");
    }

    public static void loginPageUiValidation() {
        String RequiredEditTextTitle = dataAccessExcel(1, 10, "EditTextTitle");
        String RequiredEditTextPlaceholder = dataAccessExcel(2, 10, "EditTextPlaceHolder");
        String RequiredPersonalACText = dataAccessExcel(1, 11, "PersonalACText");
        String RequiredBzAccountText = dataAccessExcel(2, 11, "Bz Account");
        String ActualEditTextTitle = toGetElement(EditTextTitle);
        String ActualPersonalAcText = toGetElement(PersonalAccountText);
        String ActualBzACText = toGetElement(BzAccountText);
        String ActualETextPlaceholder = driver.findElement(By.xpath(EditTextPlaceHolder)).getAttribute("placeholder");

        softAssert(RequiredPersonalACText, ActualPersonalAcText, "Failed PersonalAcText Validation");
        softAssert(RequiredBzAccountText, ActualBzACText, "Failed BusinessText Validation");
        softAssert(RequiredEditTextTitle, ActualEditTextTitle, "Failed EditText Validation");
        softAssert(RequiredEditTextPlaceholder, ActualETextPlaceholder, "Failed EditTextPlaceholder Validation");
    }

}
