package Season.persistence.mapper;

import java.io.Serializable;

public interface EntityMapper<E extends Serializable, D extends Serializable> {

	E mapToEntity(D dto);

	D mapToDto(E entity);

}
