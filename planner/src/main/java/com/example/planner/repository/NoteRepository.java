package com.example.planner.repository;

import com.example.planner.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note,Integer> {
}
