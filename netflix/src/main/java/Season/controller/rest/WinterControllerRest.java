package Season.controller.rest;

import Season.controller.rest.model.D4iPageRest;
import org.springframework.data.domain.Pageable;

import Season.controller.rest.model.BigBangResponse;
import Season.controller.rest.model.WinterRest;
import Season.exception.BigBangException;

public interface WinterControllerRest {

    BigBangResponse<D4iPageRest<WinterRest>> getAllWinters(int page, int size, Pageable pageable) throws BigBangException;

    BigBangResponse<WinterRest> createWinter(WinterRest winter) throws BigBangException;

    BigBangResponse<WinterRest> getWinterById(Long id) throws BigBangException;

    BigBangResponse<WinterRest> updateWinter(WinterRest winter) throws BigBangException;

    void deleteWinter(Long id) throws BigBangException;
}
