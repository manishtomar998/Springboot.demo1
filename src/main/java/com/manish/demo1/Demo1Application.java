package com.manish.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Demo1Application {

	public static void main(String[] args) throws IOException {
		
		ClassLoader classLoader = Demo1Application.class.getClassLoader();
		
		File file = new File(Objects.requireNonNull(classLoader.getResource("firebaseServiceKey.json")).getFile());
		

		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
		
		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://fir-1aa88-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(Demo1Application.class, args);
	}

}
