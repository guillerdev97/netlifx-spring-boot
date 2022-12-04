package season.controller.rest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import season.controller.rest.NetflixControllerRest;
import season.service.NetflixService;

@RestController
@RequiredArgsConstructor
public class NetflixControllerRestImpl implements NetflixControllerRest {
    private final NetflixService netflixService;

    @Override
    @GetMapping("/categories")
    public String getAllCategories() {
        return netflixService.getAllCategories();
    }
}
