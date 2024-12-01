package org.example.fluffwebserver.controller;

import org.example.fluffwebserver.persistence.WordRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public record WordController(WordRepository wordRepository) {
    @GetMapping("api/words")
    public String getWord() {
        Random rnd = new Random();
        return wordRepository.findById(rnd.nextLong(14856)).orElseThrow().getValue();
    }

}
