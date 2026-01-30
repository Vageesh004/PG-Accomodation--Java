package com.proj4.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proj4.entities.*;
import com.proj4.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Register admin (optional)
    // http://localhost:8085/admin/register
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    // View all PG places
    // http://localhost:8085/admin/pgs
    @GetMapping("/pgs")
    public List<PgPlace> getAllPgPlaces() {
        return adminService.getAllPgPlaces();
    }

    // View all owners
    // http://localhost:8085/admin/owners
    @GetMapping("/owners")
    public List<Owner> getAllOwners() {
        return adminService.getAllOwners();
    }

    // View all tenants
    // http://localhost:8085/admin/tenants
    @GetMapping("/tenants")
    public List<Tenant> getAllTenants() {
        return adminService.getAllTenants();
    }

    // Delete PG
    // http://localhost:8085/admin/pg/delete/{pgId}
    @DeleteMapping("/pg/delete/{pgId}")
    public String deletePg(@PathVariable Long pgId) {
        adminService.deletePg(pgId);
        return "PG deleted by Admin";
    }

    // Delete Owner
    // http://localhost:8085/admin/owner/delete/{ownerId}
    @DeleteMapping("/owner/delete/{ownerId}")
    public String deleteOwner(@PathVariable Long ownerId) {
        adminService.deleteOwner(ownerId);
        return "Owner deleted by Admin";
    }

    // Delete Tenant
    // http://localhost:8085/admin/tenant/delete/{tenantId}
    @DeleteMapping("/tenant/delete/{tenantId}")
    public String deleteTenant(@PathVariable Long tenantId) {
        adminService.deleteTenant(tenantId);
        return "Tenant deleted by Admin";
    }
}

