package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomItemFromArray;

public class RegistrationWithFakerTests extends TestBase {

    Faker faker = new Faker(new Locale("ru"));


    @Test
    void successfulRegistrationTest() {
        // Для рандомного выбора
        String[] listGenders = {"Male", "Female", "Other"},
                months = {"January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November", "December"},
                listSubjects = {"English", "Maths", "Accounting", "Arts", "Social Studies", "Biology", "Physics"},
                listHobbies = {"Sports", "Reading", "Music"};

        var mapStateInCity = Map.of(
                "NCR", new String[]{"Delphi", "Gurgaon", "Noida"},
                "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
                "Haryana", new String[]{"Karnal", "Panipat"},
                "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
        );

        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress("en"),
                gender = getRandomItemFromArray(listGenders),
                userNumber = 7 + faker.phoneNumber().subscriberNumber(9),
                dayBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
                monthBirth = getRandomItemFromArray(months),
                yearBirth = String.valueOf(faker.number().numberBetween(1900, 2100)),
                subjects = getRandomItemFromArray(listSubjects),
                hobbies = getRandomItemFromArray(listHobbies),
                picture = "photo_2022-10-17_03-14-32.jpg",
                currentAddress = faker.address().fullAddress(),
                state = getRandomItemFromArray(mapStateInCity.keySet().toArray(new String[1])),
                city = getRandomItemFromArray(mapStateInCity.get(state));

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userNumber)
                .setBirthDate(dayBirth, monthBirth, yearBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city);
        registrationPage.submitClick();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "photo_2022-10-17_03-14-32.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }

}