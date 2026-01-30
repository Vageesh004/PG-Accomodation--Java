package com.proj4.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proj4.entities.Owner;
import com.proj4.entities.PgPlace;
import com.proj4.services.PgPlaceService;

@RestController
@RequestMapping("/pg")
public class PgController {

    @Autowired
    private PgPlaceService pgPlaceService;

    // 1️⃣ Retrieve available PG places in a specific city
    // http://localhost:8085/pg/city/{city}
    @GetMapping("/city/{city}")
    public List<PgPlace> getPgByCity(@PathVariable String city) {
        return pgPlaceService.getAvailablePgByCity(city);
    }

    // 2️⃣ List available PG places in a specific locality
    // http://localhost:8085/pg/locality/{locality}
    @GetMapping("/locality/{locality}")
    public List<PgPlace> getPgByLocality(@PathVariable String locality) {
        return pgPlaceService.getAvailablePgByLocality(locality);
    }

    // 3️⃣ Retrieve PG place details by ID
    // http://localhost:8085/pg/details/{id}
    @GetMapping("/details/{id}")
    public ResponseEntity<PgPlace> getPgDetails(@PathVariable Long id) {
        return pgPlaceService.getPgById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4️⃣ Retrieve owner details of PG (only if available)
    // http://localhost:8085/pg/owner/{id}
    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getOwnerDetails(@PathVariable Long id) {
        return pgPlaceService.getOwnerByPgId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
