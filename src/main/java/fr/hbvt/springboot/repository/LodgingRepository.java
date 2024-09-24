package fr.hbvt.springboot.repository;

import fr.hbvt.springboot.entity.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LodgingRepository extends JpaRepository<Lodging, String> {

}