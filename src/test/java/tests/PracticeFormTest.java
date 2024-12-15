package tests;

import org.junit.jupiter.api.*;
import pages.PracticePage;
import pages.components.Utils;
import utils.TestData;


public class PracticeFormTest extends TestBase {
  PracticePage practicePage = new PracticePage();
  TestData testData=new TestData();

  @Test
  void fillFormTest() {
    practicePage.openTestPage("/automation-practice-form");
    Utils.removeBanner();
      practicePage.setFirstName(testData.firstName)
      .setLastName(testData.lastName)
      .setUserEmailInput(testData.eMail)
      .setGender(testData.gender)
      .setDateOfBirth(testData.dayOfBirth,testData.monthOfBirth,testData.yearOfBirth)
      .setUserNumber(testData.userNumber).setSubjects(testData.subject).setAddress(testData.streetAddress)
      .setState(testData.state)
      .setCity(testData.getCity(testData.state))
      .setUploadPicture("photo_2024-11-07_16-38-58.jpg")
      .setSport(testData.hobby)

      .submitButton();

      practicePage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
      .checkResult("Student Email",testData.eMail)
      .checkResult("Gender",testData.gender)
      .checkResult("Mobile",testData.userNumber)
      .checkResult("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
      .checkResult("Subjects",testData.subject)
      .checkResult("Hobbies",testData.hobby)
      .checkResult("Picture","photo_2024-11-07_16-38-58.jpg")
      .checkResult("Address",testData.streetAddress)
      .checkResult("State and City",testData.state + " " + testData.getCity(testData.state));


  }
}