package ua.com.rozetka;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import ua.com.rozetka.entity.PhoneDTO;
import ua.com.rozetka.extension.SelenideExtension;
import ua.com.rozetka.steps.GetPhoneStep;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestExample {
    private int sizeList = 60;

    @ExtendWith(SelenideExtension.class)
    @Test
    @Order(1)
    void getNamesAndPricesForAllMobileDevicesForTheFirstPage() {
        GetPhoneStep getAllPhoneStep = new GetPhoneStep();
        List<PhoneDTO> all = getAllPhoneStep.getAllPhone();
        System.out.println("All phone");
        all.stream().forEach(phoneDTO -> System.out.println(phoneDTO));
        assertThat(all.size()).isEqualTo(sizeList);
    }

    @ExtendWith(SelenideExtension.class)
    @Test
    @Order(2)
    void getPricesAndDevicesNamesWithTheLabelTopSales() {
        GetPhoneStep getAllPhoneStep = new GetPhoneStep();
        List<PhoneDTO> topSales = getAllPhoneStep.getPhoneTopSell();
        System.out.println("Top sales phone");
        topSales.stream().forEach(phoneDTO -> System.out.println(phoneDTO));
        assertThat(topSales).isNotEqualTo(sizeList);
        assertThat(!topSales.isEmpty());

    }
}
