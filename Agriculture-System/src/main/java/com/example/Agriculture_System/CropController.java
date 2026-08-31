package com.example.Agriculture_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CropController {

    @Autowired
    private CropRepository cropRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Crop> listCrops = cropRepository.findAll();
        model.addAttribute("listCrops", listCrops);
        
        double totalArea = listCrops.stream()
                .mapToDouble(c -> c.getLandArea() != null ? c.getLandArea() : 0)
                .sum();
        model.addAttribute("totalCropsCount", listCrops.size());
        model.addAttribute("totalArea", totalArea);
        
        model.addAttribute("crop", new Crop());
        return "index";
    }

    @PostMapping("/saveCrop")
    public String saveCrop(@ModelAttribute("crop") Crop crop) {
        cropRepository.save(crop);
        return "redirect:/?tab=details";
    }

    @GetMapping("/deleteCrop/{id}")
    public String deleteCrop(@PathVariable(value = "id") long id) {
        cropRepository.deleteById(id);
        return "redirect:/?tab=details";
    }
}