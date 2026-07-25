package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement cookieButton = element("#onetrust-accept-btn-handler");
    private final ElementsCollection newPage =  elements(".nav-bar-category-link");

@Step("Clicking the cookie button if it is visible")
    public MainPage clickCookieButton() {
        if (cookieButton.is(visible, Duration.ofSeconds(5))) {
            cookieButton.click();
        }
        return this;
    }

@Step("Opening the new page")
    public ElementsCollection openNewPage() {
        newPage.findBy(text("New")).click();
        return newPage;
    }
}
