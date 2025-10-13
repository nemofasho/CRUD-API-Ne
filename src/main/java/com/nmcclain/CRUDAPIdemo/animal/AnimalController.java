package main.java.com.nmcclain.CRUDAPIdemo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping({"/animals", "/animals/"})
    public String getAllAnimals(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animalList"; // Return the name of the view (e.g., animalList.html)
    }

    @GetMapping("/animals/{animalId}")
    public String getAnimalById(@PathVariable Long animalId, Model model) {
        Animal animal = animalService.getAnimalById(animalId);
        if (animal != null) {
            model.addAttribute("animal", animal);
            model.addAttribute("title", "Animal Details");
            return "animalDetails"; // Return the name of the view (e.g., animalDetails.html)
        } else {
            model.addAttribute("error", "Animal not found");
            return "error"; // Return an error view
        }
    }

    @GetMapping("/animals/name")
    public String getAnimalsByName(@RequestParam String name, Model model) {
        if (name != null) {
        model.addAttribute("animals", animalService.getAnimalsByName(name));
        model.addAttribute("title", "Animals Named " + name);
        return "animalList"; // Return the name of the view (e.g., animalList.html)
        } else { 
            return "redirect:/animals";
        }
    }

    @GetMapping("/animals/age")
    public String getAnimalsByAge(@RequestParam int age, Model model) {
        model.addAttribute("animals", animalService.getAnimalsByAge(age));
        model.addAttribute("title", "Animals Aged " + age);
        return "animalList"; // Return the name of the view (e.g., animalList.html)
    }

    @GetMapping("/animals/type")
    public String getAnimalsByType(@RequestParam String type, Model model) {
        model.addAttribute("animals", animalService.getAnimalsByType(type));
        model.addAttribute("title", "Animals of Type " + type);
        return "animalList"; // Return the name of the view (e.g., animalList.html)
    }

    @PostMapping("/animals")
    public String addAnimal(Animal animal, @RequestParam("profilePicture") MultipartFile profilePicture, Model model) {
        Animal newAnimal = animalService.addAnimal(animal, profilePicture);
        return "redirect:/animals/" + newAnimal.getId(); // Redirect to the newly created animal's details page
    }

    @GetMapping("/animals/update/{animalId}")
    public String updateAnimal(@PathVariable Long animalId, Animal updatedAnimal, @RequestParam("profilePicture") MultipartFile profilePicture, Model model) {
        Animal animal = animalService.updateAnimal(animalId, updatedAnimal, profilePicture);
        if (animal != null) {
            return "redirect:/animals/" + animal.getId(); // Redirect to the updated animal's details page
        } else {
            model.addAttribute("error", "Animal not found");
            return "error"; // Return an error view
        }
    }

    @GetMapping("/animals/createForm")
    public String showCreateForm(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", new Animal());
        model.addAttribute("title", "Add New Animal");
        return "createAnimal"; // Return the name of the view (e.g., createAnimal.html)
    }

    @GetMapping("/animals/updateForm/{animalId}")
    public String showUpdateForm(@PathVariable Long animalId, Model model) {
        Animal animal = animalService.getAnimalById(animalId);
        if (animal != null) {
            model.addAttribute("animal", animal);
            model.addAttribute("title", "Update Animal");
            return "updateAnimal"; // Return the name of the view (e.g., updateAnimal.html)
        } else {
            model.addAttribute("error", "Animal not found");
            return "error"; // Return an error view
        }
    }

    @PostMapping("/animals/update/{animalId}")
    public Object updateAnimal(Long animalId, Animal updatedAnimal, @RequestParam("profilePicture") MultipartFile profilePicture) {
        animalService.updateAnimal(animalId, updatedAnimal, profilePicture);
        return "redirect:/animals/" + animalId;
    }

    @GetMapping("/animals/delete/{animalId}")
    public String deleteAnimal(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:/animals"; // Redirect to the list of animals after deletion
}
}

