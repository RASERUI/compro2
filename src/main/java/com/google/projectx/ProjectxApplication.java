package com.google.projectx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ProjectxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectxApplication.class, args);
	}

	@GetMapping("/about-me")
	public String aboutMe(Model model){
		String fullName = "RUSSELL ROY MENDOZA IGNACIO";
		String favouriteQuote = "Might Controls Everything! And without strength, you can't protect anything. Let alone yourself. - Vergil";
		String descriptionAboutSelf = "I am a student that is currently studying in lorma colleges to pursue my destined carreer";
		model.addAttribute( "fullName", fullName);
		model.addAttribute( "favouriteQuote", favouriteQuote);
		model.addAttribute( "descriptionAboutSelf", descriptionAboutSelf);

		return "about_me";
		}

	}
