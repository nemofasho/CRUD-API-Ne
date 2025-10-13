package main.java.com.nmcclain.CRUDAPIdemo.animal;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/profilepic";

    public Object getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(@PathVariable Long animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    public Object getAnimalsByName(String name) {
        return animalRepository.findByName(name);
    }

    public Object getAnimalsByAge(int age) {
        return animalRepository.getAnimalsByAge(age);
    }

    public Object getAnimalsByType(String animalType) {
        return animalRepository.getAnimalsByType(animalType);
    }

    public Animal addAnimal(Animal animal, MultipartFile profilePicture) {
        if (profilePicture != null && !profilePicture.isEmpty()) {
            try {
                String fileName = profilePicture.getOriginalFilename();
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                try (InputStream inputStream = profilePicture.getInputStream()) {
                    Path filePath = uploadPath.resolve(fileName);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                    animal.setProfilePicturePath("/profilepic/" + fileName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Long animalId, Animal updatedAnimal, MultipartFile profilePicture) {
        return animalRepository.findById(animalId).map(animal -> {
            animal.setName(updatedAnimal.getName());
            animal.setAge(updatedAnimal.getAge());
            animal.setDescription(updatedAnimal.getDescription());
            animal.setAnimalType(updatedAnimal.getAnimalType());

            if (profilePicture != null && !profilePicture.isEmpty()) {
                try {
                    String fileName = profilePicture.getOriginalFilename();
                    Path uploadPath = Paths.get(UPLOAD_DIR);
                    if (!Files.exists(uploadPath)) {
                        Files.createDirectories(uploadPath);
                    }
                    try (InputStream inputStream = profilePicture.getInputStream()) {
                        Path filePath = uploadPath.resolve(fileName);
                        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                        animal.setProfilePicturePath("/profilepic/" + fileName);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return animalRepository.save(animal);
        }).orElse(null);
    }

    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }
}
