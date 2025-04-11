package pl.lab.bookings.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lab.bookings.dao.ApartmentRepository;
import pl.lab.bookings.model.Apartment;

import java.util.List;

@Controller
@RequestMapping("/apartments")
@RequiredArgsConstructor
public class ApartmentController {
    private final ApartmentRepository apartmentRepository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("apartments", apartmentRepository.findAll());
        model.addAttribute(new Apartment());
        return "apartments";
    }

    @PostMapping()
    public String createTable(@Valid Apartment apartment,
                              Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("apartments", apartmentRepository.findAll());
            return "apartments";
        } else {
            apartmentRepository.save(apartment);
            return "redirect:/apartments";
        }
    }
}
