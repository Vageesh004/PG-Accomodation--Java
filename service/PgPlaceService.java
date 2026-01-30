package com.proj4.services;


import com.proj4.entities.PgPlace;
import com.proj4.entities.Owner;
import com.proj4.repositories.PgPlaceRepository;
import com.proj4.repositories.OwnerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PgPlaceService {

    private final PgPlaceRepository pgPlaceRepository;
    private final OwnerRepository ownerRepository;

    public PgPlaceService(PgPlaceRepository pgPlaceRepository, OwnerRepository ownerRepository) {
        this.pgPlaceRepository = pgPlaceRepository;
        this.ownerRepository = ownerRepository;
    }

    public List<PgPlace> getAvailablePgByCity(String city) {
        return pgPlaceRepository.findByCityAndAvailabilityTrue(city);
    }

    public List<PgPlace> getAvailablePgByLocality(String locality) {
        return pgPlaceRepository.findByLocalityAndAvailabilityTrue(locality);
    }

    public Optional<PgPlace> getPgById(Long id) {
        return pgPlaceRepository.findById(id);
    }

    public Optional<Owner> getOwnerByPgId(Long pgId) {
        return pgPlaceRepository.findById(pgId).map(PgPlace::getOwner);
    }

    public PgPlace addPgPlace(PgPlace pgPlace) {
        return pgPlaceRepository.save(pgPlace);
    }

    public List<PgPlace> getPgByOwner(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .map(pgPlaceRepository::findByOwner)
                .orElse(List.of());
    }

    public PgPlace updateAvailability(Long pgId, boolean availability) {
        PgPlace pg = pgPlaceRepository.findById(pgId).orElseThrow();
        pg.setAvailability(availability);
        return pgPlaceRepository.save(pg);
    }

    public void deletePgPlace(Long pgId) {
        pgPlaceRepository.deleteById(pgId);
    }
}
