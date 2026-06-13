package test;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPageTitleTest extends TestBase {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка титла ")
    @DisplayName("Проверка заголовка главной страницы")
    void checkPageTitleTest() {
        step("Проверяем что заголовок главной страницы пустой", () -> {
            String expectedTitle = "";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @ParameterizedTest(name = "Проверяем что заголовок страницы New Arrival имеет 2 кнопки: {0}")
    @ValueSource(strings = {" Shop Men's", " Shop Women's"})
    void checkingSelectButtonTest(String value) {
        SelenideElement cookieButton = $("#onetrust-accept-btn-handler");

        if (cookieButton.is(visible, Duration.ofSeconds(5))) {
            cookieButton.click();

            elements(".nav-bar-category-link").findBy(text("New")).click();
            element(".banner-buttons").shouldHave(text(value));
        }
    }
}
