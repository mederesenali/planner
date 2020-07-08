package com.example.planner.controller;


import com.example.planner.exception.CustomerAlreadyRegisteredException;
import com.example.planner.model.UserRegisterForm;
import com.example.planner.repository.UserRepository;
import com.example.planner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class UserController {

   private final UserRepository userRepository;

   private final UserService userService;

  private  final PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }



    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String user = principal.getName();
        model.addAttribute("user", userRepository.findByEmail(user).get());
        return "profile";
    }



    @GetMapping("/login")
    public String login(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);

        return "login";
    }


    @GetMapping("/registration")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new UserRegisterForm());
        }

        return "registration";
    }

    @PostMapping("/registration")
    public String registerPage(@Valid UserRegisterForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) throws CustomerAlreadyRegisteredException {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/registration";
        }

        userService.register(customerRequestDto);
        return "redirect:/login";
    }

}
