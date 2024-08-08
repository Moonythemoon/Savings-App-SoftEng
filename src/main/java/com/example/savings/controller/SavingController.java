package com.example.savings.controller;

import com.example.savings.model.Saving;
import com.example.savings.service.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SavingController {

    @Autowired
    private SavingService savingService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("savings", savingService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("saving", new Saving());
        return "add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute Saving saving, Model model) {
        if (savingService.findByCustomerNumber(saving.getCustomerNumber()) != null) {
            model.addAttribute("error", "Customer number already exists!");
            return "add";
        }
        savingService.save(saving);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Saving saving = savingService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid saving Id:" + id));
        model.addAttribute("saving", saving);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editSubmit(@PathVariable Long id, @ModelAttribute Saving saving) {
        savingService.save(saving);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        savingService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/projected/{id}")
    public String projected(@PathVariable Long id, Model model) {
        Saving saving = savingService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid saving Id:" + id));
        model.addAttribute("saving", saving);
        // Calculate projected investment and add to model
        return "projected";
    }
}
