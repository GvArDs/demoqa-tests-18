package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String mount, String year) {
        $(byText(day)).click();
        $(byText(mount)).click();
        $(byText(year)).click();
    }
}
