package com.talk2amareswaran.projects.validatedemo;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}
	
	@GetMapping("/")
    public String showForm(UserForm userForm) {
        return "form";
    }
	
	@PostMapping("/")
    public String checkUserInfo(@Valid UserForm userForm, BindingResult bindingResult) {
		
		 if (bindingResult.hasErrors()) {
	            return "form";
	        }
	        return "redirect:/results";
	}
	
}
