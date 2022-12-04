package Season.service;

import Season.exception.BigBangException;
import Season.service.model.WinterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WinterService {

    Page<WinterDto> getAllWinters(Pageable pageable)
	    throws BigBangException;

    WinterDto createWinter(WinterDto Winter) throws BigBangException;

    WinterDto getWinterById(Long id) throws BigBangException;

    WinterDto updateWinter(WinterDto WinterDetails) throws BigBangException;

    void deleteWinter(Long id) throws BigBangException;

}
