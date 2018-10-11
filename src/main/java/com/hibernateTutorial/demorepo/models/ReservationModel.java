package com.hibernateTutorial.demorepo.models;

import com.hibernateTutorial.demorepo.models.forms.ReservationForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "reservations")
@NoArgsConstructor
public class ReservationModel {

    //nazwy pól odpowiadają nazwą kolumn,
    // ale można mapować ręcznie tak jak w przypadku klasy = @Table, albo pola = @Column

    /*
    * Nasza encja powinna posiadać konstruktor bezargumentowy - @Data tego nie zapewnia
    *
    * */

    @Id //hibernate bedzie wiedzial ze to jest klucz glowny
//    @GeneratedValue(strategy = GenerationType.AUTO) //ma nie krzyczec do nas jesli nie uzupelnimy pola id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String firstname;
    private String lastname;
    private String adres;
//    private Date date;
    //podejscie do czasu JSR 310
    private LocalDate date;
    public ReservationModel(ReservationForm form) {
        firstname = form.getFirstname();
        lastname = form.getLastname();
        date = form.getFormatedDate();
        adres = form.getAdres();
    }

}
