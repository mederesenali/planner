package com.example.planner.controller;

import com.example.planner.model.Note;
import com.example.planner.repository.NoteRepository;
import com.example.planner.repository.UserRepository;
import com.example.planner.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;

@Controller
@AllArgsConstructor
public class NoteController {
    private final NoteService noteService;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    @GetMapping("/createNote")
    public String createNote() {
        return "noteCreation";
    }
    @PostMapping("/createNote")
    public String writeNote(Principal principal, @RequestParam String title, @RequestParam String content, @RequestParam String date, Model model) {
        LocalDate localDate=LocalDate.parse(date);
       Note note=new Note();
        var user=userRepository.findByEmail(principal.getName()).get();
        note.setContent(content);
        note.setTitle(title);
        note.setAuthor(user);
        note.setLocalDate(localDate);
        noteRepository.save(note);
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String registeredHome(Model model) {
          model.addAttribute("notes", noteService.noteList());
        return "home";
    }
    @PostMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("id") int id , Model model){
        noteService.deleteNote(id);
        return "redirect:/home";

    }
    @PostMapping("/noteDone/{id}")
    public String noteDone(@PathVariable("id") int id , Model model){
        var note=noteService.findById(id);
        note.setDone(true);
        noteRepository.save(note);

        return "redirect:/home";

    }
    @GetMapping("/updateNote/{id}")
    public String updateNote(@PathVariable("id") int id , Model model){
        var note=noteService.findById(id);
        model.addAttribute("note",note);
        return "Success";
    }
    @PostMapping("/change_note")
    public String updateNotes(@RequestParam int id , Model model, @RequestParam String title,@RequestParam String content, @RequestParam String date){
        var note1=noteService.findById(id);
        LocalDate localDate=LocalDate.parse(date);
        note1.setTitle(title);
        note1.setContent(content);
        note1.setLocalDate(localDate);
        noteRepository.save(note1);


        return "redirect:/home";
    }


}
