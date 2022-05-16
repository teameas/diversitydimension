package wf.hackathon.diversitydimension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DiversitydimensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiversitydimensionApplication.class, args);
	}


	@GetMapping("/")
	public String hello() {
		return "Welcome to Diversity Dimension APIs!";
	}

}
