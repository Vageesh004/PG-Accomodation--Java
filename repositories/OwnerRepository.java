package com.proj4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proj4.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
   
}
