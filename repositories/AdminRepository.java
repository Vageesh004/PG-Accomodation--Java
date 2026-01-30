package com.proj4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proj4.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
