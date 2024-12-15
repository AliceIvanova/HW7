package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RequiredFiedPracticeFormTest {
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";

  }
  @Test
  void requiredFieldTest() {
    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue("Alice");
    $("#lastName").setValue("Ivanova");
    $("#genterWrapper").$(byText("Female")).click();
    $("#userNumber").setValue("1234567891");
    $(byText("Submit")).scrollTo();
    $("#userForm #submit").click();

    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Alice Ivanova"));
    $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
    $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("1234567891"));
  }
}
