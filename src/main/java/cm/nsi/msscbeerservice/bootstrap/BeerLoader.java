package cm.nsi.msscbeerservice.bootstrap;

import cm.nsi.msscbeerservice.domain.Beer;
import cm.nsi.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author ravnely
 * @project mssc-beer-service
 * @Created 12/02/2022, 15:39:07, sam.
 **/
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_2_UPC = "0652135198654";
    private static final String BEER_1_UPC = "0346549863465";
    private static final String BEER_3_UPC = "0083256952447";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mongo Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("11.95"))
                    .build());
        }

        System.out.println("Loaded Beers " + beerRepository.count());
    }
}
