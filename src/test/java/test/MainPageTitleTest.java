package test;


import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPageTitleTest extends TestBase {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка титла ")
    @DisplayName("Проверка заголовка главной страницы")
    void checkPageTitleTest() {
        step("Проверяем что заголовок главной страницы соответствует ожидаемому", () -> {
            String expectedTitle = "Speedex Tools - Speedex UAE | Top Hardware & Tools for DIY & Pros";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }


    @ParameterizedTest(name = "Проверяем что заголовок страницы New Arrival имеет 2 кнопки: {0}")
    @ValueSource(strings = {" milwaukee", " Bosch"})
    void checkingSelectButtonTest(String value) {

        mainPage.clickCookieButton()
                .searchItem(value);

    }
}

