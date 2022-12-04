package Season.service.impl;

import Season.exception.BigBangException;
import Season.exception.BigBangNotFoundException;
import Season.exception.error.ErrorDto;
import Season.persistence.entity.WinterEntity;
import Season.persistence.mapper.WinterEntityMapper;
import Season.persistence.repository.WinterRepository;
import Season.service.WinterService;
import Season.service.model.WinterDto;
import Season.util.constant.ExceptionConstantsUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WinterServiceImpl implements WinterService {

    private final WinterRepository winterRepository;
    private final WinterEntityMapper winterEntityMapper;

    @Override
    public Page<WinterDto> getAllWinters(final Pageable pageable) throws BigBangException {
		return winterRepository.findAll(pageable).map(winterEntity -> winterEntityMapper.mapToDto(winterEntity));
    }

    @Override
    public WinterDto createWinter(final WinterDto winterDto) throws BigBangException {
		WinterEntity winterEntity = winterRepository.save(winterEntityMapper.mapToEntity(winterDto));
		return winterEntityMapper.mapToDto(winterEntity);
	
    }

    @Override
    public WinterDto getWinterById(final Long id) throws BigBangException {
	WinterEntity winter = winterRepository.findById(id)
		.orElseThrow(() -> new BigBangNotFoundException(new ErrorDto(ExceptionConstantsUtils.NOT_FOUND_GENERIC)));
		return winterEntityMapper.mapToDto(winter);
    }

    @Override
    public WinterDto updateWinter(final WinterDto winterDto) throws BigBangException {
	WinterEntity winter = winterRepository.findById(winterDto.getId())
		.orElseThrow(() -> new BigBangNotFoundException(new ErrorDto(ExceptionConstantsUtils.NOT_FOUND_GENERIC)));
		WinterEntity winterEntity = winterRepository.save(winterEntityMapper.mapToEntity(winterDto));
		return winterEntityMapper.mapToDto(winterEntity);
    }

    @Override
    public void deleteWinter(final Long id) throws BigBangException {
	winterRepository.deleteById(id);
    }
}
