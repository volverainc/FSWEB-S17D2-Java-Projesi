package com.workintech.dependency.rest;

import com.workintech.dependency.model.Developer;
import com.workintech.dependency.tax.DeveloperTax;
import com.workintech.dependency.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers/")
public class DeveloperController {

    private Map<Integer, Developer> developers;
    private Taxable taxable;
    @PostConstruct
    public void init(){
        developers = new HashMap<>();
    }

    @Autowired
    public DeveloperController(Taxable taxable){
        this.taxable = taxable;
    }

    @GetMapping("/")
    public List<Developer> get(){
        return developers.values().stream().toList();
    }

    @GetMapping("{id}")
    public Developer get(@PathVariable int id){
        if(id < 0) {

        }
        if(!developers.containsKey(id)){

        }
        return developers.get(id);
    }

    @PostMapping("/")
    public Developer save(@RequestBody Developer developer){
        if(developers.containsKey(developer.getId())){

        }
        if(developer.getId() < 0 || developer.getName() == null || developer.getName().isEmpty() || developer.getSalary() < 0){

        }
        if(developer.getExperience() == Developer.Experience.JUNIOR){
            double taxDeduction = developer.getSalary() * taxable.getSimpleTaxRate();
            developer.setSalary(developer.getSalary() - taxDeduction);
        }
        else if(developer.getExperience() == Developer.Experience.MID){
            double taxDeduction = developer.getSalary() * taxable.getMiddleTaxRate();
            developer.setSalary(developer.getSalary() - taxDeduction);
        }
        else if(developer.getExperience() == Developer.Experience.SENIOR){
            double taxDeduction = developer.getSalary() * taxable.getUpperTaxRate();
            developer.setSalary(developer.getSalary() - taxDeduction);
        }

        developers.put(developer.getId(), developer);

        return developers.get(developer.getId());
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable int id, @RequestBody Developer developer){
        if(!developers.containsKey(id)){

        }
        if(developer.getId() < 0 || developer.getName() == null || developer.getName().isEmpty() || developer.getSalary() < 0){

        }

        developers.put(id, developer);

        return developers.get(id);
    }
    @DeleteMapping("/{id}")
    public Developer delete(@PathVariable int id){
        if(!developers.containsKey(id)){

        }
        developers.remove(id);
        return developers.get(id);
    }

}
