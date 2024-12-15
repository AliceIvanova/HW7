package tests;


import org.junit.jupiter.api.Test;
import pages.PracticePage;
import pages.components.Utils;
import utils.TestData;

public class PracticeFormMinTests extends TestBase{
  PracticePage practicePage = new PracticePage();
  TestData testData=new TestData();

  @Test
  void fillFormTestMin() {
    practicePage.openTestPage("/automation-practice-form");
    Utils.removeBanner();
      practicePage.setFirstName(testData.firstName)
      .setLastName(testData.lastName)
      .setGender(testData.gender)
      .setUserNumber(testData.userNumber)
      .submitButton();
      practicePage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
      .checkResult("Gender", testData.gender)
      .checkResult("Mobile",testData.userNumber);
  }

}
