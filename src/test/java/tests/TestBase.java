package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com";
  }

  public static void removeBanner() {
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
  }
  @AfterEach
  public void tearDown() {
    closeWebDriver();
  }

}
