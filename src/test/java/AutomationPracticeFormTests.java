import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void beroreAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() throws InterruptedException {
        open("/automation-practice-form");
        $(byText("Submit")).click();
        $("#firstName").setValue("Aleksey");
        $("#lastName").setValue("Dunaev");
        $("#userEmail").setValue("aleks@dunaev.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("79991234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(byText("11")).click();
        $("#subjectsInput").setValue("E").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("photo_2022-10-17_03-14-32.jpg");
        $("#currentAddress").setValue("Samara");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Noida")).click();
        $(byText("Submit")).click();


        $(".modal-body").shouldHave(text("Aleksey Dunaev"), text("aleks@dunaev.com"), text("Male"), text("7999123456"), text("11 March,1991"), text("English"), text("Music"), text("photo_2022-10-17_03-14-32.jpg"), text("Samara"), text("NCR Noida"));
    }
}