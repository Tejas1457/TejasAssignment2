package org.example;

public class InvalidLogin extends Assig2_Base {
    public static final String InputEmail = "//input[@class='inputText']";
    public static final String ContinueBtn = "//span[@data-cy='MyBizLogin_118']";
    public static final String ErrorText = "//form/p[2]";

    public static void invalidLoginCheck() throws Exception {
        elementSender(InputEmail, getFromPropertyFile("InvalidEmail"));
        myWait();
        elementClicker(ContinueBtn);
        takeScreenShot(driver, "LoginPage", "InvalidLogin");
        String TestEle = toGetElement(ErrorText);
        writeToPropertyFile("Invalid Login Text", TestEle);
    }
}
