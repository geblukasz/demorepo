package com.hibernateTutorial.demorepo.models.repositories;

import com.hibernateTutorial.demorepo.models.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository      //reposytorium zarządza encją               //podajemy encję i typ ID
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {


}
