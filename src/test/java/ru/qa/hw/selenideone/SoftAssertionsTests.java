package ru.qa.hw.selenideone;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTests {


  @BeforeAll
  static void setup() {
    Configuration.baseUrl = "https://github.com";
    Configuration.startMaximized = true;
  }

  @Test
  void softAssertionPageTest() {

    open("/selenide/selenide/wiki");
    $(withText("Show 1 more pages…")).click();
    $$(By.id("wiki-pages-box")).findBy(visible)
            .shouldHave(text("SoftAssertions"));
    $(withText("SoftAssertions")).click();
    $x("//*[@id='wiki-body']/div/ol[4]/li")
            .shouldHave(text( "Using JUnit5 extend test class:"));

  }
}
