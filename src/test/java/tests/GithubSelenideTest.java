package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FindingSoftAssertionsTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(withText("more pages")).click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").$(byText("Using JUnit5 extend test class:")).parent().sibling(0).shouldNotBe(empty);
    }
}
