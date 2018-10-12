package com.hibernateTutorial.demorepo.models.forms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservationForm {


    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 25)
    private String firstname;
    @Getter
    @Setter
    @NotBlank
    @Size(min = 3, max = 25)
    private String lastname;
    @Getter
    @Setter
    @Size(min = 3, max = 25)
    private String adres;
    @Getter
    @Setter
    //do kazdej adnotacji mozna dodac message
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "Write date in yyyy-mm-dd format")
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