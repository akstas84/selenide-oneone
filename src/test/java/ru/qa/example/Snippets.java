package ru.qa.example;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public abstract class Snippets {

  void browser_command_example() {

    open("https://google.com"); //-Dselenide.baseUrl=
    open("/customer/orders");
    open("/", AuthenticationType.BASIC, "user", "password");

    back();
    refresh();

    clearBrowserCookies();
    clearBrowserLocalStorage();

    confirm(); //OK in alert dialog
    dismiss(); //Cancel in alert dialog


    closeWindow(); // close active tab
    closeWebDriver(); // close browser

    switchTo().frame("new");
    switchTo().defaultContent();
    switchTo().window("The Internet");

  }

  void selectors_examples() {

    $("div").click();
    element("div").click(); // sinonim $ for cotlin

    $("div", 2).click(); // the thrid div
    $x("//div").click();

    $(byText("full text")).click();
    $(withText("ull text")).click();

    $("").parent();
    $("").sibling(1); //up
    $("").preceding(1); //down

    $("div").$("h1").find(byText("abc")).click();

    $(byAttribute("abc", "x")).click();

    $(By.id("mytext")).click();
    $("#mytext").click();

    $(byClassName("red")).click();
  }

  void action_examples() {
    $("").click();
    $("").doubleClick();
    $("").contextClick(); //click double click

    $("").hover();

    $("").setValue("text"); // clear and set
    $("").append("text"); // sinmple set
    $("").clear();

    $("div").sendKeys("c");
    actions().sendKeys("c").perform();
    actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform();
    $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

    $("").pressEnter();
    $("").pressEscape();
    $("").pressTab();

    actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform(); //hand drag and drop

    $("").selectOption("dropdown_option");
    $("").selectRadio("radio_options");
  }

  void assertion_examples() {

    $("").shouldBe(visible);
    $("").shouldNotBe(visible);
    $("").shouldHave(text("abc"));
    $("").shouldNotHave(text("abc"));
    $("").should(appear);
    $("").shouldNot(appear);

    $("").shouldBe(visible, Duration.ofSeconds(30));
    $("").waitUntil(visible, 3000);
  }

  void condition_examples() {

    $("").shouldBe(visible);
    $("").shouldBe(hidden);

    $("").shouldHave(text("abc"));
    $("").shouldHave(exactText("abc"));
    $("").shouldHave(textCaseSensitive("abc"));
    $("").shouldHave(exactTextCaseSensitive("abc"));
    $("").should(matchText("[0-9]abc$"));

    $("").shouldHave(cssClass("red"));
    $("").shouldHave(cssValue("front-size", "12"));

    $("").shouldHave(value("25"));
    $("").shouldHave(exactValue("25"));
    $("").shouldBe(empty);

    $("").shouldHave(attribute("disabled"));
    $("").shouldHave(attribute("name", "example"));
    $("").shouldHave(attributeMatching("name", "[0-9]abc"));

    $("").shouldBe(checked); // for checkbox

    $("").should(exist); //check element no visible in DOM

    $("").shouldBe(disabled);
    $("").shouldBe(enabled);
  }

  void collection_examples() {

    $$("div");
    $$("div").filterBy(text("123")).shouldHave(size(1));
    $$("div").excludeWith(text("123")).shouldHave(size(1));

    $$("div").first().click();
    elements("div").first().click();

    $$("div").last().click();
    $$("div").get(1).click();
    $("div", 1).click();
    $$("div").findBy(text("123")).click();

    $$("").shouldHave(size(0));
    $$("").shouldBe(CollectionCondition.empty);

    $$("").shouldHave(texts("Alfa", "Beta", "Gamma"));

  } //ToDo

  void file_operation_examples() throws FileNotFoundException {

    File file = new File("src/test/resources/readme.txt");
    $("#file-upload").uploadFile(file);
    $("#file-upload").uploadFromClasspath("readme.txt");
  } //ToDo

  void javascript_examples() {

    executeJavaScript("alert('selenide')");
    executeJavaScript("alert(argument[0]*arguments[1])", "abc", 12);
    long fortytwo = executeJavaScript("return argument[0]*arguments[1];", 6, 7);

  }
}
