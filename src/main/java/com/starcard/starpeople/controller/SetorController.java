package com.starcard.starpeople.controller;

import com.starcard.starpeople.repository.SetorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SetorController {

    private final SetorRepository repository;

    public SetorController(SetorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/setores")
    public String listarSetores(Model model) {

        model.addAttribute("setores", repository.findAll());
        return "setores/lista";
    }
}
