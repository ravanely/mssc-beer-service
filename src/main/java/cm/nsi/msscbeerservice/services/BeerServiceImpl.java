package cm.nsi.msscbeerservice.services;

import cm.nsi.msscbeerservice.domain.Beer;
import cm.nsi.msscbeerservice.exceptions.NotFoundException;
import cm.nsi.msscbeerservice.mappers.BeerMapper;
import cm.nsi.msscbeerservice.repositories.BeerRepository;
import cm.nsi.msscbeerservice.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ravnely
 * @project mssc-beer-service
 * @Created 15/02/2022, 22:02:19, mar.
 **/
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository repository;
    private final BeerMapper mapper;

    public BeerServiceImpl(BeerRepository repository, BeerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BeerDto getById(UUID beerId) {
        return mapper.beerToBeerDto(repository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return mapper.beerToBeerDto(repository.save(mapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = repository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return mapper.beerToBeerDto(repository.save(beer));
    }
}
