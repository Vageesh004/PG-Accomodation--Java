package com.proj4.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj4.entities.Tenant;
import com.proj4.repositories.TenantRepository;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    // Register tenant
    public Tenant saveTenant(Tenant tenant) {
        if (tenant.getAge() < 18) {
            throw new RuntimeException("Tenant must be at least 18 years old");
        }
        return tenantRepository.save(tenant);
    }

    // Get tenant by ID
    public Optional<Tenant> getTenantById(Long tenantId) {
        return tenantRepository.findById(tenantId);
    }

    // Delete tenant
    public void deleteTenant(Long tenantId) {
        tenantRepository.deleteById(tenantId);
    }
}

