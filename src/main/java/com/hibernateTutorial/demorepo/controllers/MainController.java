package com.hibernateTutorial.demorepo.controllers;

import com.hibernateTutorial.demorepo.models.ReservationModel;
import com.hibernateTutorial.demorepo.models.forms.ReservationForm;
import com.hibernateTutorial.demorepo.models.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        model.addAttribute("reservations",  reservationRepository.findByDateIsBetween(LocalDate.now(), LocalDate.now().plusWeeks(1)));

        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form, BindingResult bindingResult, Model model) {
        // trzeba przekonwertowac formularz na encje
        // tworzymy konstruktor w ReservationModel, czyli mapowanie pol formularza na kolumny
        if(bindingResult.hasErrors()){
            return "index";
        } else if(reservationRepository.existsByDateEquals(form.getFormatedDate())) {
            model.addAttribute("error", "Ten dzien jest juz zajety");
            return "index";
        }
        reservationRepository.save(new ReservationModel(form));

        return "redirect:/index";
    }

    @GetMapping("/test")
    @ResponseBody
    public String index2() {
/*
        List<ReservationModel> reservationModel = reservationRepository.findByFirstname("Lukasz");
        return reservationModel.toString();*/
        //zadanie: zwrocic liczbe danych rekordow

        /*ReservationModel reservationModel = reservationRepository.findByFirstnameAndLastname("lukasz", "gebicki");
        return reservationModel.getDate().toString();*/


        List<ReservationModel> reservationModel = reservationRepository.findByDateIsBetween(LocalDate.now(), LocalDate.now().plusWeeks(1));

        return reservationModel.stream()
                .map(s -> s.toString())
                .collect(Collectors.joining(" , "));




        /*
        * Jesli mamy dwoch lukaszow to:
        * StringBuilder builder = new StringBuilder();
        * for(ReservationModel model : reservationModel){
        *   stringBuilder.append(model.toString();
        * }
        * return StringBuilder.toString();
        *
        *
        *
        * Lub za pomoca strumieni:
        * return resercationModel.stream()
        *   .map(s -> s.toString())
        *   .collect(Collectors.joining(", "));
        *
        *   https://docs.spring.io/spring-data/jpa/docs/current/reference/html
        *   Table 3. Supported keywords inside method names
        *
        * ZADANIE 1:
        * Znajdz rezerację, gdzie nazwisko zawiera w sobie literę "a"
        *
        *ReservationModel reservationModel = reservationRepository.findByLastnameContains("e");
        return reservationModel.getLastname();

        ZADANIE 2:
        Wypisz wszyskie encje w ktorych Id jest wieksze od 1

        List<ReservationModel> reservationModels = reservationRepository.findByIdGreaterThan(1);

        return reservationModels.stream()
                .map(s -> s.toString())
                .collect(Collectors.joining(" , "));

        *ZADANIE 3
        * Znajdz te rezerwacje ktore sa starsze niz 2017 rok
        *  List<ReservationModel> reservationModel = reservationRepository.findByDateAfter(LocalDate.of(2017,1,1));
        *
        *
        * ZADANIE 4
        * Wypisz wszystkie rezerwacje z przyszlego roku
        * */

    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String index3(@PathVariable int id) {
        reservationRepository.deleteById(id);

        return "index";
    }

    @GetMapping("/deletebylastname/{lastname}")
    @ResponseBody
    @Transactional
    public String index3(@PathVariable String lastname) {
        reservationRepository.deleteByLastname(lastname);

        return "index";
    }
}
