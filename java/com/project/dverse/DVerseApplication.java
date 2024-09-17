package com.project.dverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DVerseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DVerseApplication.class, args);//scanning classpaths, starts the emebeded servers tomcat,jetty
	}

}
