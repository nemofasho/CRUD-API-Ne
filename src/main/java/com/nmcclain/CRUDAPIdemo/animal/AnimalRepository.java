package main.java.com.nmcclain.CRUDAPIdemo.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> getAnimalsByType(String animalType);

    @Query(value = "select * from students s where s.age >= ?1", nativeQuery = true)
    List<Animal> getAnimalsByAge(int age);

    @Query(value = "select * from animals s where s.name like %?1% ", nativeQuery = true)
    List<Animal> getAnimalsByName(String name);
}

