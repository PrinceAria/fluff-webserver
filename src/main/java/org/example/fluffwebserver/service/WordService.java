package org.example.fluffwebserver.service;
import org.example.fluffwebserver.entity.Word;
import org.example.fluffwebserver.persistence.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*@Service
public class WordService implements ApplicationRunner {
    @Autowired
    private WordRepository wordRepository;

    public void addWords() {
        List<Word> words;
        try {
            words = Files.lines(Path.of("src/main/resources/valid-wordle-words.txt")).map(Word::new).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        wordRepository.saveAll(words);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addWords();
    }
}*/
