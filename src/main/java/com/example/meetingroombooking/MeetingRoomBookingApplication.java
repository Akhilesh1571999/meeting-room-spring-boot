package com.example.meetingroombooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




@ComponentScan (basePackages = "com.example.meetingroombooking")
@SpringBootApplication
public class MeetingRoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomBookingApplication.class, args);
	}

}
