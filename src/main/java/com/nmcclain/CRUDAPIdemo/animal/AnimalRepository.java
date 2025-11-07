package com.nmcclain.CRUDAPIdemo.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> getAnimalsByanimalType(String animalType);

    @Query(value = "select * from animals a where a.age = ?1", nativeQuery = true)
    List<Animal> getAnimalsByAge(int age);

    @Query(value = "select * from animals a where a.name like %?1%", nativeQuery = true)
    List<Animal> getAnimalsByName(String name);
}

