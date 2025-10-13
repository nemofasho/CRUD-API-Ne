package main.java.com.nmcclain.CRUDAPIdemo.animal;

import java.lang.annotation.Inherited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long animalId;

  @Column(nullable = false)
  private String name;

  private int age;
  private String description;

  @Column(nullable = false)
  private string animalType;

  private String profilePicturePath;

  public Animal() {
  }

  public Animal(Long animalId, String name, int age, String description, string animalType, String profilePicturePath) {
    this.animalId = aniamlId;
    this.name = name;
    this.age = age;
    this.description = description;
    this.animalType = animalType;
    this.profilePicturePath = profilePicturePath;
  }

  public Student(String name, int age, String description, string animalType, String profilePicturePath) {
    this.name = name;
    this.age = age;
    this.description = description;
    this.animalType = animalType;
    this.profilePicturePath = profilePicturePath;
  }

  public Long getAnimalId() {
    return animalId;
  }

  public void setAnimalId(Long id) {
    this.aniamlId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public int getAge() {
        return age;
}

  public void setAge(int age) {
        this.age = age;
    }

  public String getProfilePicturePath() {
    return profilePicturePath;
  }

  public void setProfilePicturePath(String profilePicturePath) {
    this.profilePicturePath = profilePicturePath;
  }
}
