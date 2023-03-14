package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.SimpleTimeZone;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomItemFromArray;

public class RegistrationWithFakerTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker(new Locale("ru"));

        String[] listGenders = {"Male", "Female", "Other"},
                months = {"January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November", "December"},
                listSubjects = {"English", "Maths", "Accounting", "Arts", "Social Studies", "Biology", "Physics"},
                listHobbies = {"Sports", "Reading", "Music"};

        String[] listStates = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String[] listCitys1 = {"Delphi", "Gurgaon", "Noida"};
        String[] listCitys2 = {"Agra", "Lucknow", "Merrut"};
        String[] listCitys3 = {"Karnal", "Panipat"};
        String[] listCitys4 = {"Jaipur", "Jaiselmer"};


        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress("en"),
                gender = getRandomItemFromArray(listGenders),
                userNumber = 7 + faker.phoneNumber().subscriberNumber(9),
                dayBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
                mountBirth = getRandomItemFromArray(months),
                yearBirth = String.valueOf(faker.number().numberBetween(1900, 2100)),
                subjects = getRandomItemFromArray(listSubjects),
                hobbies = getRandomItemFromArray(listHobbies),
                picture = "photo_2022-10-17_03-14-32.jpg",
                currentAddress = faker.address().fullAddress(),
                state = getRandomItemFromArray(listStates),
                city = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userNumber)
                .setBirthDate(dayBirth, mountBirth, yearBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city);
        registrationPage.subbmitClick();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", dayBirth + " " + mountBirth + "," + yearBirth)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "photo_2022-10-17_03-14-32.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}