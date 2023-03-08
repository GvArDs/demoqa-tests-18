import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String userName = "Aleksey";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Dunaev")
                .setEmail("aleks@dunaev.com")
                .setGender("Male")
                .setPhone("7999123456")
                .setBirthDate("11", "March", "1991");

        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("photo_2022-10-17_03-14-32.jpg");
        $("#currentAddress").setValue("Samara");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Noida")).click();
        $(byText("Submit")).click();

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