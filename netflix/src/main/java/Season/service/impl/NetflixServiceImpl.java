package season.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import season.persistance.entity.CategoryEntity;
import season.persistance.repository.CategoryRepository;
import season.service.NetflixService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NetflixServiceImpl implements NetflixService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}
