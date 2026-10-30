package ua.com.rozetka.steps;

import ua.com.rozetka.entity.PhoneDTO;
import ua.com.rozetka.pages.ListTypeOfElectronicPage;
import ua.com.rozetka.pages.PhonesPage;
import ua.com.rozetka.pages.RozetkaHomePage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GetPhoneStep {
    private final PhonesPage phonesPage = new PhonesPage();
    private final RozetkaHomePage homePage = new RozetkaHomePage();
    private final ListTypeOfElectronicPage listTypeOfElectronicPage = new ListTypeOfElectronicPage();


    public List<PhoneDTO> getAllPhone() {
        open("/");
        open("/mobile-phones/c80003/");

        List<PhoneDTO> all = phonesPage.getAllPhones().stream().map(selenideElement ->
                new PhoneDTO(selenideElement.$("[title]").getAttribute("title")
                        .replaceFirst("^Мобільний телефон\\s+", "")
                        .replaceFirst("^ Мобільний  кнопковий телефон - смартфон \\s+", "")
                        .replaceFirst("\\s*\\([^)]*\\)$", ""),
                        Double.parseDouble(selenideElement.$(".price.leading-none.font-bold").
                                getText().replaceAll("[^0-9]", "")))).collect(Collectors.toList());
        return all;
    }

    public List<PhoneDTO> getPhoneTopSell() {
        open("/");
        open("/mobile-phones/c80003/");
        List<PhoneDTO> all = phonesPage.getAllPhones().stream()
                .filter(selenideElement -> selenideElement.$(".tile-promo-label.promo-label.promo-label_type_popularity.text-inline").exists())
                .map(selenideElement -> new PhoneDTO(selenideElement.$("[title]").getAttribute("title")
                        .replaceFirst("^Мобільний телефон\\s+", "")
                        .replaceFirst("^ Мобільний  кнопковий телефон - смартфон \\s+", "")
                        .replaceFirst("\\s*\\([^)]*\\)$", ""),
                        Double.parseDouble(selenideElement.$(".price.leading-none.font-bold").getText()
                                .replaceAll("[^0-9]", "")))).collect(Collectors.toList());
        return all;
    }


}
