package season.service.impl;

import org.springframework.stereotype.Service;
import season.service.NetflixService;

@Service
public class NetflixServiceImpl implements NetflixService {
    @Override
    public String getAllCategories() {
        return "Getting all categories";
    }
}
