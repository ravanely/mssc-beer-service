package cm.nsi.msscbeerservice.mappers;

import cm.nsi.msscbeerservice.domain.Beer;
import cm.nsi.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @author ravnely
 * @project mssc-beer-service
 * @Created 13/02/2022, 15:37:58, dim.
 **/
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
