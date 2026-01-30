package com.proj4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj4.entities.*;
import com.proj4.repositories.*;

@Service
public class AdminService {

    @Autowired
    private PgPlaceRepository pgPlaceRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private AdminRepository adminRepository;

    public List<PgPlace> getAllPgPlaces() {
        return pgPlaceRepository.findAll();
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deletePg(Long pgId) {
        pgPlaceRepository.deleteById(pgId);
    }

    public void deleteOwner(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    public void deleteTenant(Long tenantId) {
        tenantRepository.deleteById(tenantId);
    }
}
