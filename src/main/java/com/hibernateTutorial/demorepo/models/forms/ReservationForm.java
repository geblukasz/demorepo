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


    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    public Date getFormatedDate() {

        try {
            //YYY-MM-DD
            if (date != null)
            return new Date(format.parse(date).getTime());
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
