package com.proj4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proj4.entities.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
