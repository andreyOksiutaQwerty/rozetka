package ua.com.rozetka.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RozetkaHomePage {
    private SelenideElement smartphonesSectionButton =$("li[data-index='2'] a[data-testid='fat_menu_category_link']");


    public void buttonSmartphonesSectionClick(){
        smartphonesSectionButton.click();
    }
}
