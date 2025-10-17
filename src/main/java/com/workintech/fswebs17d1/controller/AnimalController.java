package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private final Map<Integer, Animal> animals = new HashMap<>();

    // GET /workintech/animal
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    // GET /workintech/animal/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Integer id) {
        Animal animal = animals.get(id);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /workintech/animal
    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return ResponseEntity.ok(animal);
    }

    // PUT /workintech/animal/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Integer id, @RequestBody Animal updatedAnimal) {
        if (!animals.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        animals.put(id, updatedAnimal);
        return ResponseEntity.ok(updatedAnimal);
    }

    // DELETE /workintech/animal/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id) {
        if (!animals.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        animals.remove(id);
        return ResponseEntity.ok().build();
    }
}
