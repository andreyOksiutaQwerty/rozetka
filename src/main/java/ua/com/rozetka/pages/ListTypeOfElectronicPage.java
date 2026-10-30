package ua.com.rozetka.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ListTypeOfElectronicPage {
    private SelenideElement phoneButton=$("a[title='Мобільні телефони']");


    public void selectMobilePhones(){
        phoneButton.click();
    }
}
