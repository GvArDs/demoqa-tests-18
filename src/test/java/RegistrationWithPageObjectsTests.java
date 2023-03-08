import org.junit.jupiter.api.Test;
import tests.TestBase;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String userName = "Aleksey";
        String lastName = "Dunaev";
        String email = "aleks@dunaev.com";
        String gender = "Male";
        String phone = "7999123456";
        String day = "11";
        String mount = "March";
        String year = "1991";
        String subjects = "English";
        String hobbies = "Music";
        String picture = "photo_2022-10-17_03-14-32.jpg";
        String currentAddress = "Samara";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(day, mount, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city);
        registrationPage.subbmitClick();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " Dunaev")
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