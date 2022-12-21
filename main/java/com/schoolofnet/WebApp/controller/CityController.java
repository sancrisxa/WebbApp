package com.schoolofnet.WebApp.controller;

import com.schoolofnet.WebApp.model.City;
import com.schoolofnet.WebApp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public String index(Model model) {

        model.addAttribute("cities", this.cityRepository.findAll());

        return "cities/index";
    }

    @GetMapping("/new")
    public String newCity(Model model) {

        model.addAttribute("city", new City());
        return "cities/new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("city") City city, Model model) {

        this.cityRepository.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/{id}")
    public String editCity(@PathVariable("id") Long id, Model model) {

        model.addAttribute("city", this.cityRepository.findById(id));

        return "cities/edit";
    }

    @PutMapping("{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("city") City city, Model model) {
        Optional<City> findCity = this.cityRepository.findById(id);


            return "redirect:/cities";
    }

    @DeleteMapping("{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<City> city = this.cityRepository.findById(id);


        return "redirect:/cities";
    }
}
