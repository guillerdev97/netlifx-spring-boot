package Season.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import Season.persistence.entity.WinterEntity;

@Repository
public interface WinterRepository extends PagingAndSortingRepository<WinterEntity, Long> {

}
