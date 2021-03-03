package com.demo.swagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.swagger.model.Tech;

@RestController
@RequestMapping("/api")
public class TechController {

	ConcurrentHashMap<String, Tech> techs = new ConcurrentHashMap<>();

	@GetMapping("/{techId}")
	public Tech getTech(@PathVariable String techId) {
		return techs.get(techId);
	}

	@GetMapping("/")
	public List<Tech> getAllTechs() {
		return new ArrayList<Tech>(techs.values());
	}

	@PostMapping("/")
	public Tech addTech(@RequestBody Tech tech) {
		techs.put(tech.getTechId(), tech);
		return tech;
	}
}
