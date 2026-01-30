package com.proj4.controllers;

import com.proj4.entities.Owner;
import com.proj4.entities.PgPlace;
import com.proj4.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // 5️⃣ Register Owner
    // POST http://localhost:8085/owner/register
    @PostMapping("/register")
    public Owner registerOwner(@RequestBody Owner owner) {
        return ownerService.registerOwner(owner);
    }

    // 6️⃣ Add PG by Owner
    // POST http://localhost:8085/owner/{ownerId}/pg
    @PostMapping("/{ownerId}/pg")
    public PgPlace addPg(@PathVariable Long ownerId,
                         @RequestBody PgPlace pgPlace) {
        return ownerService.addPgForOwner(ownerId, pgPlace);
    }

    // 7️⃣ View PGs of Owner
    // GET http://localhost:8085/owner/{ownerId}/pgs
    @GetMapping("/{ownerId}/pgs")
    public List<PgPlace> getOwnerPgs(@PathVariable Long ownerId) {
        return ownerService.getPgByOwner(ownerId);
    }

    // 8️⃣ Update availability
    // PUT http://localhost:8085/owner/pg/{pgId}/availability?status=true
    @PutMapping("/pg/{pgId}/availability")
    public PgPlace updateAvailability(@PathVariable Long pgId,
                                      @RequestParam boolean status) {
        return ownerService.updateAvailability(pgId, status);
    }

    // 9️⃣ Delete PG
    // DELETE http://localhost:8085/owner/pg/{pgId}
    @DeleteMapping("/pg/{pgId}")
    public ResponseEntity<String> deletePg(@PathVariable Long pgId) {
        ownerService.deletePg(pgId);
        return ResponseEntity.ok("PG deleted successfully");
    }
}
