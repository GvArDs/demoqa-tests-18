package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxTests {

    @BeforeAll
    static void beroreAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
//        $("[id=userName]").setValue("Aleksey Dunaev");
        $("#userName").setValue("Aleksey Dunaev");
        $("#userEmail").setValue("aleks@mail.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Aleksey Dunaev");
        $("#submit").click();

        $("#output").shouldHave(text("Aleksey Dunaev"), text("aleks@mail.com"),
                text("Some address 1"), text("Aleksey Dunaev"));


    }

}
