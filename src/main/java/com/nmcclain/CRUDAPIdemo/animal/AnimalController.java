package com.nmcclain.CRUDAPIdemo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public Object getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/animals/{animalId}")
    public Animal getAnimalById(@PathVariable Long animalId) {
          return animalService.getAnimalById(animalId);
    }

    @GetMapping("/animals/name/{name}")
    public Object getAnimalsByName(@PathVariable String name) {
       if (name != null) {
        return animalService.getAnimalsByName(name);
         } else {
            return animalService.getAllAnimals();
    }
    }

    @GetMapping("/animals/age/{age}")
    public Object getAnimalsByAge(@PathVariable int age) {
        return animalService.getAnimalsByAge(age);
    }

    @GetMapping("/animals/type/{animalType}")
    public Object getAnimalsByType(@PathVariable String animalType) {
        return animalService.getAnimalsByType(animalType);
    }

    @PostMapping("/animals")
    public Object addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    @PutMapping("/animals/{animalId}")
    public Animal updateAnimal(@PathVariable Long animalId, @RequestBody Animal animal) {
        animalService.updateAnimal(animalId, animal);
        return animalService.getAnimalById(animalId);

    }

    @DeleteMapping("/animals/{animalId}")
    public Object deleteAnimal(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);
        return animalService.getAllAnimals();
    }

    @PostMapping("/animals/writeFile")
    public Object writeJson(@RequestBody Animal animal) {
        return animalService.writeJson(animal);
    }

    @GetMapping("/animals/readFile")
    public Object readJson() {
        return animalService.readJson();
    }

}

