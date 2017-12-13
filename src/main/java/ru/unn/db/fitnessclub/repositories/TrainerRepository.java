package ru.unn.db.fitnessclub.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.unn.db.fitnessclub.entities.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, String> {

}
