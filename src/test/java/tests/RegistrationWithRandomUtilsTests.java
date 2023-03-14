package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;

public class RegistrationWithRandomUtilsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String[] genders = {"Male", "Female", "Other"};

        String userName = getRandomString(10),
                lastName = getRandomString(10),
                userEmail = getRandomEmail(),
                gender = getRandomItemFromArray(genders),

                phone = "7999123456",
                dayBirth = "11",
                mountBirth = "March",
                yearBirth = "1991",
                subjects = "English",
                hobbies = "Music",
                picture = "photo_2022-10-17_03-14-32.jpg",
                currentAddress = "Samara",
                state = "NCR",
                city = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(dayBirth, mountBirth, yearBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city);
        registrationPage.subbmitClick();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", "aleks@dunaev.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "7999123456")
                .verifyResult("Date of Birth", "11 March,1991")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "photo_2022-10-17_03-14-32.jpg")
                .verifyResult("Address", "Samara")
                .verifyResult("State and City", "NCR Delhi");
    }
}