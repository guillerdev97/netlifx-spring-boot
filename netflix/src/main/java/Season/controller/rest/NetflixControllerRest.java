package season.controller.rest;

import season.persistance.entity.CategoryEntity;

import java.util.List;

public interface NetflixControllerRest {
    List<CategoryEntity> getAllCategories();
}
