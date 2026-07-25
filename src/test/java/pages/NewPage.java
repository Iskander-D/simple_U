package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;

public class NewPage {

    private final SelenideElement newPageHeader = element(".banner-buttons");


    @Step("Checking the header of the new page")
    public NewPage checkHeader(String value) {
        newPageHeader.shouldHave(text(value));
    return this;
    }
}


