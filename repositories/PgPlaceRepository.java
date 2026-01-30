package com.proj4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj4.entities.Owner;
import com.proj4.entities.PgPlace;
import java.util.List;

public interface PgPlaceRepository extends JpaRepository<PgPlace, Long> {
	List<PgPlace> findByCityAndAvailabilityTrue(String city);     
    List<PgPlace> findByLocalityAndAvailabilityTrue(String locality); 
    List<PgPlace> findByOwner(Owner owner);                     
}

