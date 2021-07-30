package ru.qa.example;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;


public class FindSelenideTests {

  @BeforeAll
  static void setup() {
    Configuration.baseUrl = "https://github.com";
    Configuration.startMaximized = true;
  }

  @Test
  void shouldFindSelenideRepository(){
    open("");
    $("[name=q]").setValue("selenide").pressEnter();
    var firstLinkFound = $$(".repo-list li").first().$("a");
    firstLinkFound.click();
    $("h1").shouldHave(Condition.text("selenide / selenide"));
  }
}
