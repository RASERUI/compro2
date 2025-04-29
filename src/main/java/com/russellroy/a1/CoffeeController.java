package com.russellroy.a1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Arrays;
import java.util.List;

@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }



    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "") String search, Model model) {
//        List<CoffeeExam> coffeeList = coffeeService.searchCoffee(search);
//        model.addAttribute("coffees", coffeeList);
        model.addAttribute("coffee", coffeeService.searchCoffee(search));

        return "index";
    }


    @GetMapping("/delete")
    public String deleteCoffee(@RequestParam int id){
        coffeeService.deleteCoffeeExam(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add(){
        return "new";
    }



    @PostMapping("/save")
    public String save(@RequestParam String name,
                       @RequestParam String type,
                       @RequestParam String size,
                       @RequestParam double price,
                       @RequestParam String roastLevel,
                       @RequestParam String origin,
                       @RequestParam Boolean isDecaf,
                       @RequestParam int stock,
                       @RequestParam List<String> flavorNotes,
                       @RequestParam String brewMethod){

        Coffee c = new Coffee();
        c.setId(coffeeService.getId() + 1);
        c.setName(name);
        c.setType(type);
        c.setSize(size);
        c.setPrice(price);
        c.setRoastLevel(roastLevel);
        c.setOrigin(origin);
        c.setDecaf(isDecaf);
        c.setStock(stock);
        c.setFlavorNotes(flavorNotes);
        c.setBrewMethod(brewMethod);

        coffeeService.addCoffee(c);
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        Coffee c = coffeeService.getCoffee(id);
        if(c != null){
            model.addAttribute("coffee", c);
            return "edit";
        }
        return "redirect:/";
    }


    @PostMapping("/update")
    public String update(@RequestParam int id,
                         @RequestParam String name,
                         @RequestParam(required = false) List<String> type,
                         @RequestParam(required = false) List<String> size,
                         @RequestParam double price,
                         @RequestParam(required = false) List<String> roastLevel,
                         @RequestParam String origin,
                         @RequestParam(required = false) Boolean isDecaf,
                         @RequestParam int stock,
                         @RequestParam(required = false) List<String> flavorNotes,
                         @RequestParam(required = false) List<String> brewMethod) {

        Coffee c = coffeeService.getCoffee(id);
        if(c != null) {
            c.setName(name);
            if (type != null && !type.isEmpty()) {
                c.setType(type.get(0)); // Only first selected
            }
            if (size != null && !size.isEmpty()) {
                c.setSize(size.get(0));
            }
            c.setPrice(price);
            if (roastLevel != null && !roastLevel.isEmpty()) {
                c.setRoastLevel(roastLevel.get(0));
            }
            c.setOrigin(origin);
            c.setDecaf(isDecaf != null ? isDecaf : false);
            c.setStock(stock);
            if (flavorNotes != null && !flavorNotes.isEmpty()) {
                c.setFlavorNotes(flavorNotes);
            } else {
                c.setFlavorNotes(null);
            }
            if (brewMethod != null && !brewMethod.isEmpty()) {
                c.setBrewMethod(brewMethod.get(0));
            }

            coffeeService.updateCoffee(id, c);
        }
        return "redirect:/";
    }
}
