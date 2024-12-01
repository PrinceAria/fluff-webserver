package org.example.fluffwebserver.persistence;

import jakarta.transaction.Transactional;
import org.example.fluffwebserver.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t where t.user.id = :id")
    List<Task> findTasksByUserId(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Task t SET t.completed = :value WHERE t.id = :id")
    void updateTaskById(Long id, boolean value);

    @Query("SELECT max(t.id) from Task t")
    Long getHighestId();
}
