package ua.com.rozetka.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class PhonesPage {
    private ElementsCollection allPhone=$$(".relative.d-block.overflow-hidden");


    public ElementsCollection getAllPhones(){
     return allPhone;
    }
}
