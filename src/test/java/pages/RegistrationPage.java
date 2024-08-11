package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTable;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final  SelenideElement userPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTable resultTable = new ResultTable();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.scrollTo();
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.scrollTo();
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        emailInput.scrollTo();
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.scrollTo();
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        numberInput.scrollTo();
        numberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.scrollTo();
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectInput.scrollTo();
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.scrollTo();
        hobbiesWrapper.shouldHave(text(value)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        userPicture.scrollTo();
        userPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setUserAddress(String value) {
        addressInput.scrollTo();
        addressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateCityWrapper.scrollTo();
        stateCityWrapper.$(byText("Select State")).click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        stateCityWrapper.scrollTo();
        stateCityWrapper.$(byText("Select City")).click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage submit() {
        submitButton.scrollTo();
        submitButton.click();
        return this;
    }
    public RegistrationPage checkResult(String key, String value){
        resultTable.checkResultTable(key,value);
        return this;
    }
}
