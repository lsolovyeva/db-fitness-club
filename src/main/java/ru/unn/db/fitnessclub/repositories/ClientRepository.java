package ru.unn.db.fitnessclub.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.unn.db.fitnessclub.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
    //Iterable<Client> findByAgeLessThan(Byte age);
    //List<Client> findAll();
    //Client findByName(String name);
    //List<Client> findAllByName(String name);
}
