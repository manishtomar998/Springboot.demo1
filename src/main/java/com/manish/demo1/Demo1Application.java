package com.manish.demo1;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) throws IOException {
		

		FileInputStream serviceAccount =
				new FileInputStream("./firebaseServiceKey.json");
		
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://fir-1aa88-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(Demo1Application.class, args);
	}

}
