package tests;

import com.github.javafaker.Faker;

import java.util.Date;

public class TestData {
  Faker faker = new Faker();

  public String firstName = faker.name().firstName(),
    lastName = faker.name().lastName(),
    gender = faker.options().option("Man", "Female", "Other"),
    streetAddress = faker.address().streetAddress(),
    eMail = faker.internet().emailAddress(),
    dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
    monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
    userNumber = faker.phoneNumber().subscriberNumber(10),
    yearOfBirth = String.valueOf(faker.date().birthday(18, 130)),
    subject = faker.options().option("Hindi", "English", "Maths", "Physics",
      "Chemistry", "Biology", "Computer Science",
      "Commerce", "Accounting", "Economics", "Arts",
      "Social Studies", "History", "Civics"),
    state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

  public String getCity(String state) {
    return switch (state) {
      case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
      case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrit");
      case "Haryana" -> faker.options().option("Karnal", "Panipat");
      case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
      default -> throw new IllegalStateException("Unexpected value: " + state);
    };
  }
}