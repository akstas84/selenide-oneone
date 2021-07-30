package ru.qa.example;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class FindContibutors {

  @Test
  void firstContributorShouldBeSolnsev() {
    open("https://github.com/selenide/selenide");

    $(".BorderGrid").$(byText("Contributors"))
            .closest("div")
            .$("ul li").hover();
    $$(".Popover-message").findBy(visible)
            .shouldHave(text("Andrei Solnsev"));

  }
}
