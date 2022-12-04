package Season.controller.rest.mapper;

import Season.controller.rest.model.WinterRest;
import Season.service.model.WinterDto;
import org.springframework.stereotype.Component;

@Component
public class WinterRestMapper implements RestMapper<WinterRest, WinterDto>{

    @Override
    public WinterRest mapToRest(final WinterDto dto) {
        return new WinterRest(dto.getId(), dto.getCode(), dto.getDescription());
    }

    @Override
    public WinterDto mapToDto(final WinterRest rest) {
        return new WinterDto(rest.getId(), rest.getCode(), rest.getDescription());
    }

}