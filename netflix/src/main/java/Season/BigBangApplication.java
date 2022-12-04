package Season;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BigBangApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BigBangApplication.class, args);
	}

}

