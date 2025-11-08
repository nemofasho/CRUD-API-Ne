package com.nmcclain.CRUDAPIdemo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// @RestController
@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping({"/animals", "/animals/"})
    public Object getAllAnimals(Model model) {
        model.addAttribute("animalsList", animalService.getAllAnimals());
        model.addAttribute("title", "All animals");
        return "animals-list";
    }

    @GetMapping("/animals/{animalId}")
    public String getAnimalById(@PathVariable Long animalId, Model model) {
          model.addAttribute("animal", animalService.getAnimalById(animalId));
          model.addAttribute("title", "Animal #: " + animalId);
          return "animal-details";
    }

    @GetMapping("/animals/name")
    public Object getAnimalsByName(@PathVariable String name, Model model) {
       if (name != null) {
        model.addAttribute("animalsList", animalService.getAnimalsByName(name));
         model.addAttribute("title", "Animals with name: " + name);
         return "animals-list";
         } else {
            return "redirect:/animals";
    }
    }

    @GetMapping("/animals/age/{age}")
    public Object getAnimalsByAge(@PathVariable int age, Model model) {
        model.addAttribute("animalsList", animalService.getAnimalsByAge(age));
        model.addAttribute("title", "Animals with age: " + age);
        return "animals-list";
    }

    @GetMapping("/animals/type/{animalType}")
    public Object getAnimalsByType(@PathVariable String animalType, Model model) {
        model.addAttribute("animalsList", animalService.getAnimalsByType(animalType));
        model.addAttribute("title", "Animals of type: " + animalType);
        return "animals-list";
    }

    @PostMapping("/animals")
    public Object addAnimal(Animal animal, @RequestParam MultipartFile picture) {
        Animal createdAnimal = animalService.addAnimal(animal);
        return "redirect:/animals/" + createdAnimal.getAnimalId();
    }

    @GetMapping("/animals/createForm")
    public Object showCreateForm(Model model) {
    Animal animal = new Animal();
    model.addAttribute("animal", animal);
    model.addAttribute("title", "Create New Animal");
    return "animals-create";
  }

    @GetMapping("/animals/updateForm/{animalId}")
    public Object showUpdateForm(@PathVariable Long animalId, Model model) {
    Animal animal = animalService.getAnimalById(animalId);
    model.addAttribute("animal", animal);
    model.addAttribute("title", "Update Animal: " + animalId);
    return "animals-update";
  }

    @PostMapping("/animals/update/{animalId}")
    public Object updateAnimal(@PathVariable Long animalId, Animal animal, @RequestParam MultipartFile picture) {
        animalService.updateAnimal(animalId, animal);
        return "redirect:/animals/" + animalId;
    }

    @GetMapping("/animals/delete/{animalId}")
    public Object deleteAnimal(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:/animals";
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

