package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.service.AnimalsAPIService;
import com.example.demo.sampleAPI.data.Animals;

import jakarta.servlet.ServletException;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("searchScreen")
	public String doget(Model model) throws IOException {

		List<Animals> animalsList = animalsAPIService.getAnimalsList();
		//modelオブジェクトに追加　animalsListをビューに渡す
		model.addAttribute("animalsList", animalsList);
		return "searchScreen";

	}

	@GetMapping("detailScreen")
	public String doget(@RequestParam("animalsSelect") String index, Model model)
			throws ServletException, IOException {
		List<Animals> animals = animalsAPIService.getAnimals(index);

		model.addAttribute("animals", animals);

		return "detailScreen";
	}
}
