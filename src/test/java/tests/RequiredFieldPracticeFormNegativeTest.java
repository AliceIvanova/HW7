package tests;

import org.junit.jupiter.api.Test;
import pages.PracticePage;
import pages.components.Utils;
import utils.TestData;

public class RequiredFieldPracticeFormNegativeTest extends TestBase {
  PracticePage practicePage = new PracticePage();
  TestData testData=new TestData();


  @Test
  void fillFormTest() {

    practicePage.openTestPage("/automation-practice-form");
    Utils.removeBanner();
      practicePage.setFirstName(testData.firstName)
      .setLastName(testData.lastName)
      .setUserNumber(testData.userNumber)
    .submitButton();
    practicePage.checkFormNotAppears();

  }

}
