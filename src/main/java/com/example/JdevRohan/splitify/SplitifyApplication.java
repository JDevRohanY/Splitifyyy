package com.example.JdevRohan.splitify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitifyApplication.class, args);

		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Waiting for the user input.....");
			String input = sc.nextLine();

		}
	}

}
