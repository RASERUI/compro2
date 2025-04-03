package com.russellroy.Forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
public class HomeController {
    private final List<CoffeeModel> coffeeList = new ArrayList<>();
    private int nextId = 1;

    // Initialize with sample data
    public HomeController() {
        coffeeList.add(CoffeeModel.createSampleCoffee());
        nextId = 2;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("coffees", coffeeList);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("coffee", new CoffeeModel());
        return "add";
    }

    @PostMapping("/add")
    public String processAdd(@ModelAttribute CoffeeModel coffee) {
        coffee.setId(nextId++);
        coffeeList.add(coffee);
        return "redirect:/coffee/";
    }

    @GetMapping("/edit/{id}")
    public String editCoffee(@PathVariable int id, Model model) {
        CoffeeModel coffeeToEdit = coffeeList.stream()
                .filter(coffee -> coffee.getId() == id)
                .findFirst()
                .orElse(null);

        if (coffeeToEdit != null) {
            model.addAttribute("coffee", coffeeToEdit);
            return "edit";
        }
        return "redirect:/coffee/";
    }

    @PostMapping("/edit")
    public String updateCoffee(@ModelAttribute CoffeeModel updatedCoffee) {
        coffeeList.replaceAll(coffee ->
                coffee.getId() == updatedCoffee.getId() ? updatedCoffee : coffee
        );
        return "redirect:/coffee/";
    }

    @PostMapping("/delete/{id}")
    public String deleteCoffee(@PathVariable int id) {
        coffeeList.removeIf(coffee -> coffee.getId() == id);
        return "redirect:/coffee/";
    }
}