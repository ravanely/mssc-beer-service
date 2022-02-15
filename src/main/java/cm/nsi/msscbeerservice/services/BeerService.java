package cm.nsi.msscbeerservice.services;

import cm.nsi.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * @author ravnely
 * @project mssc-beer-service
 * @Created 15/02/2022, 21:57:58, mar.
 **/
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
