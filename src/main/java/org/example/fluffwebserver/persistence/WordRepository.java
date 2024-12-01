package org.example.fluffwebserver.persistence;

import org.example.fluffwebserver.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
