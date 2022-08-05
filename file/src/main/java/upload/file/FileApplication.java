package upload.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FileApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileApplication.class, args);
	}

}
