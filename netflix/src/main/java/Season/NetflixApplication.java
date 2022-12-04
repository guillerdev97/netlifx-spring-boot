package season;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import season.persistance.entity.CategoryEntity;
import season.persistance.repository.CategoryRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class NetflixApplication implements CommandLineRunner {
	public static void main(final String[] args) {
		SpringApplication.run(NetflixApplication.class, args);
	}

	private final CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		CategoryEntity category01 = new CategoryEntity(null, "Category01");
		CategoryEntity category02 = new CategoryEntity(null, "Category02");
		CategoryEntity category03 = new CategoryEntity(null, "Category03");

		categoryRepository.save(category01);
		categoryRepository.save(category02);
		categoryRepository.save(category03);
	}
}

