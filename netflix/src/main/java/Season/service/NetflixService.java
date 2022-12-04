package season.service;

import season.persistance.entity.CategoryEntity;

import java.util.List;

public interface NetflixService {
    List<CategoryEntity> getAllCategories();
}
