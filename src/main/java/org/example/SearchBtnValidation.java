package org.example;

import java.io.IOException;

public class SearchBtnValidation extends Assig2_Base {

    public static final String ActualSearchBtnTExt = "//p[@data-cy='submit']/a";
    public static final String ActualLoginBtnText = "//p[@data-cy='LoginHeaderText']";

    public static void SearchBtnValidation() throws IOException {
        final String ExpectedSearchText = getFromPropertyFile("ExpectedSearchText");
        String ActualSearchBtnTExt1 = toGetElement(ActualSearchBtnTExt);
        softAssert(ExpectedSearchText, ActualSearchBtnTExt1, "Failed Search Btn Text Validation");
    }

    public static void LoginBtnValidation() throws IOException {
        final String ExpectedLoginBtnText = getFromPropertyFile("LoginBtnText");
        String ActualLoginBtnText1 = toGetElement(ActualLoginBtnText);
        softAssert(ExpectedLoginBtnText, ActualLoginBtnText1, "Failed Logon Btn Text Validation");
    }
}
