package com.example.planner.service;

import com.example.planner.model.Note;

import com.example.planner.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;


    public List<Note> noteList() {
        return (List<Note>) noteRepository.findAll();
    }
    public void  deleteNote(int id){
       noteRepository.deleteById(id);
    }
    public Note findById(int id){
      return   noteRepository.findById(id).get();
    }


}
