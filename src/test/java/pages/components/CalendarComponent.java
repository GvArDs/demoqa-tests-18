package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String mount, String year) {
        $(byText(year)).click();
        $(byText(mount)).click();
        $(byText(day)).click();
    }
}
