package com.hibernateTutorial.demorepo.models.forms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservationForm {

    @Getter
    @Setter
    private String firstname;
    @Getter
    @Setter
    private String lastname;
    @Getter
    @Setter
    private String adres;
    @Getter
    @Setter
    private String date;


    //    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");

    /*public Date getFormatedDate() {

        try {
            //YYY-MM-DD
            if (date != null)
            return new Date(format.parse(date).getTime());
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }*/

    public LocalDate getFormatedDate() {
        //YYY-MM-DD
        return LocalDate.parse(date, format);
    }
}