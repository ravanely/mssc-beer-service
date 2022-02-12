package cm.nsi.msscbeerservice.repositories;

import cm.nsi.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author ravnely
 * @project mssc-beer-service
 * @Created 12/02/2022, 15:33:15, sam.
 **/
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
