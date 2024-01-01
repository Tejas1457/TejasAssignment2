package org.example;

public class ValidBIUserLogin extends Assig2_Base {
    public static final String MyBizButton = "//div[@class='appendBottom25']/ul/li[2]";
    public static final String InputEmail = "//input[@class='inputText']";
    public static final String ContinueBtn = "//span[@data-cy='MyBizLogin_118']";
    public static final String YourName = "(//input[@data-cy='FormField_144'])[1]";
    public static final String MobileNumber = "//input[@name='phoneNumber']";
    public static final String RadioBrnSelector = "(//div[@class='radio-btn']/div)[2]/label";
    public static final String CompanyName = "//input[@name='orgName']";
    public static final String EmployeeClicker = "//div[contains(text(),'Select')]";
    public static final String EmployeeSelector = "//ul[@class='customSel__option']/li[1]";
    public static final String SaveBtn = "//button[contains(text(),'SAVE')]";
    public static final String OTPText = "//p[@class='latoBold blackText appendBottom10']";
    public static final String BackBtn = "//span[contains(text(),'Back')]";

    public static void userEntersEmail() throws Exception {
        elementClicker(MyBizButton);
        elementSender(InputEmail, getFromPropertyFile("Email"));
        takeScreenShot(driver, "LoginPage", "EmailEntry");
        elementClicker(ContinueBtn);
    }

    public static void userEnterOtherDetails() throws Exception {
        elementSender(YourName, getFromPropertyFile("UserName"));
        elementSender(MobileNumber, getFromPropertyFile("MobileNumber"));
        elementClicker(RadioBrnSelector);
        elementSender(CompanyName, getFromPropertyFile("CompanyName"));
        elementClicker(EmployeeClicker);
        elementClicker(EmployeeSelector);
        waitForPagetoLoad_ClickableWait(SaveBtn);
        takeScreenShot(driver, "LoginPage", "AfterUserDetails");
        elementClicker(SaveBtn);
    }

    public static void otpPage() {
        visibilityWait(OTPText);
        takeScreenShot(driver, "LoginPage", "OTP_Page");
        elementClicker(BackBtn);
    }
}
