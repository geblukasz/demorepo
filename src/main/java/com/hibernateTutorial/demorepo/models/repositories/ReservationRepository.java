package com.hibernateTutorial.demorepo.models.repositories;

import com.hibernateTutorial.demorepo.models.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository      //reposytorium zarządza encją               //podajemy encję i typ ID
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {

    List<ReservationModel> findByFirstname(String firstname);
    ReservationModel findByFirstnameAndLastname(String firstname, String lastname);
    ReservationModel findByLastnameContains(String text);
    List<ReservationModel> findByIdGreaterThan(int howMany);
    List<ReservationModel> findByDateAfter(LocalDate date);

    boolean existsByDateEquals(LocalDate date);


    List<ReservationModel> findByDateIsBetween(LocalDate date1, LocalDate date2);
}
