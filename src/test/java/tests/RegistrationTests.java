package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("demoqa")
    void succesfullRegistrationTest() {
        step("Открываем страницу", () -> {
            registrationPage.openPage();
        });
        step("Заполняем поля формы", () -> {
            registrationPage.setFirstName("Kotik")
                    .setLastName("Begemotikov")
                    .setEmail("kotik@begemotikov.com")
                    .setGender("Male")
                    .setUserNumber("1234567890")
                    .setDateOfBirth("10", "May", "1990")
                    .setSubject("Chemistry")
                    .setHobby("Music")
                    .uploadPicture("1126.jpg")
                    .setUserAddress("ulitsa Kotikov, don Begemotikov")
                    .setState("Haryana")
                    .setCity("Karnal")
                    .submit();
        });
        step("Проверяем результирующую таблицу", () -> {
            registrationPage.checkResult("Student Name", "Kotik Begemotikov")
                    .checkResult("Student Email", "kotik@begemotikov.com")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "1234567890")
                    .checkResult("Date of Birth", "0 May,1990")
                    .checkResult("Subjects", "Chemistry")
                    .checkResult("Hobbies", "Music")
                    .checkResult("Picture", "1126.jpg")
                    .checkResult("Address", "ulitsa Kotikov, don Begemotikov")
                    .checkResult("State and City", "Haryana Karnal");
        });
    }
}
