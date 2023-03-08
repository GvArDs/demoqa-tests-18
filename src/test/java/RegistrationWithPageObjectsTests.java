import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String userName = "Aleksey";
        String lastName = "Dunaev";
        String email = "aleks@dunaev.com";
        String gender = "Male";
        String phone = "7999123456";
//        String birthDate = "11 March 1991";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate("11", "March", "1991");

        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photo_2022-10-17_03-14-32.jpg");
        $("#currentAddress").setValue("Samara");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " Dunaev")
                .verifyResult("Student Email", "aleks@dunaev.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "7999123456")
                .verifyResult("Date of Birth", "11 March,1991");
//                .verifyResult("Subjects", )
//                .verifyResult("Hobbies", )
//                .verifyResult("Picture", )
//                .verifyResult("Address", )
//                .verifyResult("State and City", );

    }

    @Test
    void successfulRegistration1Test() {
        String userName = "Aleksey";
//        String userLastName = "Dunaev";

        registrationPage.openPage();

        registrationPage.setFirstName(userName);
        registrationPage.setLastName("Dunaev");
        registrationPage.setEmail("aleks@dunaev.com");
        registrationPage.setGender("Male");
        registrationPage.setPhone("79991234567");


        $("#dateOfBirthInput").click();
    }
}