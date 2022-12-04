package season;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NetflixApplication {

	public static void main(final String[] args) {
		SpringApplication.run(NetflixApplication.class, args);
	}

}

