package demo.sprint.repository.walmart.stub;

import demo.sprint.repository.walmart.walmartentity.ProductEntity;
import demo.sprint.repository.walmart.walmartentity.ProductQuery;

import java.util.List;
import java.util.Optional;

public class WalmartRepositoryStub {

    public static Optional<ProductEntity> expectedRequiredStub() {
        return Optional.ofNullable(ProductEntity.builder()
                .usItemId("841765146")
                .id("61VJQU4ADV44")
                .segment("Electronics")
                .type("Video Game Console")
                .name("PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense " +
                        "Controller W/ Pulse Headset Limited Bundle")
                .price(769.00)
                .currencyUnit("USD")
                .description("Explore uncharted virtual territories and slay dragons with this sleek" +
                        " Sony PlayStation 5 gaming console. The 825GB SSD allows ultra-fast load times," +
                        " while 3-D audio output produces crisp acoustics. This Sony  PlayStation 5 gaming console " +
                        "supports haptic feedback for effortless communication in multiplayer setups," +
                        " and adaptive triggers allow immersive gameplay.")
                .build());
    }

    public static List<ProductEntity> expectedResponseFindByNameStub() {
        return List.of(ProductEntity.builder()
                .usItemId("841765146")
                .id("61VJQU4ADV44")
                .segment("Electronics")
                .type("Video Game Console")
                .name("PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense Controller W/ Pulse Headset Limited Bundle")
                .price(769.00)
                .currencyUnit("USD")
                .description("Explore uncharted virtual territories and slay dragons with this sleek" +
                        " Sony PlayStation 5 gaming console. The 825GB SSD allows ultra-fast load times," +
                        " while 3-D audio output produces crisp acoustics. This Sony  PlayStation 5 gaming console " +
                        "supports haptic feedback for effortless communication in multiplayer setups," +
                        " and adaptive triggers allow immersive gameplay.")
                .build());
    }

    public static ProductEntity expectedEntityStub() {
        return ProductEntity.builder()
                .usItemId("841765146")
                .id("61VJQU4ADV44")
                .segment("Electronics")
                .type("Video Game Console")
                .name("PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense Controller W/ Pulse Headset Limited Bundle")
                .price(769.00)
                .currencyUnit("USD")
                .description("Explore uncharted virtual territories and slay dragons with this sleek" +
                        " Sony PlayStation 5 gaming console. The 825GB SSD allows ultra-fast load times," +
                        " while 3-D audio output produces crisp acoustics. This Sony  PlayStation 5 gaming console " +
                        "supports haptic feedback for effortless communication in multiplayer setups," +
                        " and adaptive triggers allow immersive gameplay.")
                .build();
    }

    public static List<ProductEntity> expectedResponseQueryStub() {
        return List.of(ProductEntity.builder()
                .usItemId("841765146")
                .name("PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense Controller W/ Pulse Headset Limited Bundle")
                .price(769.00)
                .build());
    }

    public static ProductQuery actualQueryStub() {
        return ProductQuery.builder()
                .name("PlayStation 5")
                .priceMax(799.00)
                .build();
    }
}
