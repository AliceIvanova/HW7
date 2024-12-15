package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticePage {
  @Override
  public String toString() {
    return "PracticePage{" +
      "welcomeText='" + welcomeText + '\'' +
      '}';
  }

  public String welcomeText="Thanks for submitting the form";
  public String uploadPictureFromPath="photo_2024-11-07_16-38-58.jpg";
  private final SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    genterInput = $("#genterWrapper"),
    userNumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    uploadPictureResource=$("#uploadPicture"),
    hobbyInput = $("#hobbiesWrapper"),
    submitButtonInPracticeForm=$("#submit"),
    modalWindow=$(".modal-content"),
    addressInput=$("#currentAddress"),
    stateInput=$("#react-select-3-input"),
    cityInput=$("#react-select-4-input"),
    subjectsInput= $("#subjectsInput");

  CalendarComponent calendarComponent = new CalendarComponent();
  TableResultComponent tableResultComponent=new TableResultComponent();

  public PracticePage setFirstName(String value) {
    firstNameInput.setValue(value);
    return this;
  }

  public PracticePage setLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }

  public PracticePage setUserEmailInput(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  public PracticePage setGender(String value) {
    genterInput.$(byText(value)).click();
    return this;
  }

  public PracticePage setUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
  }

  public PracticePage setDateOfBirth(String day, String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public PracticePage setSport(String hobby) {
    hobbyInput.$(byText(hobby)).click();
    return this;
  }

  public PracticePage openTestPage (String value) {
    open(value);
    return this;
  }

  public PracticePage setUploadPicture(String value) {
    uploadPictureResource.uploadFromClasspath(value);
    return this;
  }

  public PracticePage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
  }

  public PracticePage setAddress(String value) {
        addressInput.setValue(value);
        return this;
  }

  public PracticePage setState(String value) {
    stateInput.setValue(value).pressEnter();
        return this;
  }

  public PracticePage setCity(String value) {
    cityInput.setValue(value).pressEnter();
    return this;
  }

  public PracticePage  submitButton() {
    submitButtonInPracticeForm.scrollIntoView(true).click();
    return this;
  }

  public PracticePage checkResult(String key, String value) {
    tableResultComponent.tableResult(key, value);
    return this;
  }

  public void  checkFormNotAppears() {
    modalWindow.shouldNotBe(visible);
  }
}