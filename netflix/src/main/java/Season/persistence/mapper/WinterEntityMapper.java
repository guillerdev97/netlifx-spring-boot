package Season.persistence.mapper;

import Season.persistence.entity.WinterEntity;
import Season.service.model.WinterDto;
import org.springframework.stereotype.Component;

@Component
public class WinterEntityMapper implements EntityMapper<WinterEntity, WinterDto>{
    @Override
    public WinterEntity mapToEntity(final WinterDto dto) {
        return new WinterEntity(dto.getId(), dto.getCode(), dto.getDescription());
    }

    @Override
    public WinterDto mapToDto(final WinterEntity entity) {
        return new WinterDto(entity.getId(), entity.getCode(), entity.getDescription());
    }
}