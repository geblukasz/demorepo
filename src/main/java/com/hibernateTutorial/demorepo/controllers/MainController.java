package com.hibernateTutorial.demorepo.controllers;

import com.hibernateTutorial.demorepo.models.ReservationModel;
import com.hibernateTutorial.demorepo.models.forms.ReservationForm;
import com.hibernateTutorial.demorepo.models.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;

@Controller
public class MainController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model){
        // w tym miejscu będziemy sobie ręcznie zapisywać coś do tabeli
        /*ReservationModel model = new ReservationModel();
        model.setAdres("Krakow rynek");
        model.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
        model.setLastname("Pol");
        model.setFirstname("Oskar");
        reservationRepository.save(model);*/
        model.addAttribute("reservationForm", new ReservationForm());

        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") ReservationForm form) {
        // trzeba przekonwertowac formularz na encje
        // tworzymy konstruktor w ReservationModel, czyli mapowanie pol formularza na kolumny

        reservationRepository.save(new ReservationModel(form));

        return "index";
    }
}
