package com.proj4.services;

import com.proj4.entities.Owner;
import com.proj4.entities.PgPlace;
import com.proj4.repositories.OwnerRepository;
import com.proj4.repositories.PgPlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PgPlaceRepository pgPlaceRepository;

    public OwnerService(OwnerRepository ownerRepository,
                        PgPlaceRepository pgPlaceRepository) {
        this.ownerRepository = ownerRepository;
        this.pgPlaceRepository = pgPlaceRepository;
    }

    // 1️⃣ Register Owner
    public Owner registerOwner(Owner owner) {
        if (owner.getAge() < 18) {
            throw new RuntimeException("Owner must be at least 18 years old");
        }
        return ownerRepository.save(owner);
    }

    // 2️⃣ Add PG for Owner
    public PgPlace addPgForOwner(Long ownerId, PgPlace pgPlace) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        pgPlace.setOwner(owner);
        pgPlace.setAvailability(true);
        return pgPlaceRepository.save(pgPlace);
    }

    // 3️⃣ View all PGs of an Owner
    public List<PgPlace> getPgByOwner(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        return pgPlaceRepository.findByOwner(owner);
    }

    // 4️⃣ Update availability
    public PgPlace updateAvailability(Long pgId, boolean availability) {
        PgPlace pg = pgPlaceRepository.findById(pgId)
                .orElseThrow(() -> new RuntimeException("PG not found"));

        pg.setAvailability(availability);
        return pgPlaceRepository.save(pg);
    }

    // 5️⃣ Delete PG
    public void deletePg(Long pgId) {
        pgPlaceRepository.deleteById(pgId);
    }
}
