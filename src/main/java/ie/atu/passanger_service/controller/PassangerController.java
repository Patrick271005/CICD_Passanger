package ie.atu.passanger_service.controller;

import ie.atu.passanger_service.model.Passanger;
import ie.atu.passanger_service.service.PassangerService;
import jakarta.validation.Valid;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passangers")
public class PassangerController {

    private final PassangerService service; // constructor DI

    public PassangerController(PassangerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Passanger>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passanger> getOne(@PathVariable String id) {
        Optional<Passanger> maybe = service.findById(id);
        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Passanger> create(@Valid @RequestBody Passanger p) {
        Passanger created = service.create(p);
        return ResponseEntity
                .created(URI.create("/api/passangers/" + created.getPassengerId()))
                .body(created);
    }

    @PutMapping("/api/passangers/{id}")
    public ResponseEntity<Passanger> update(@PathVariable String id, @Valid @RequestBody Passanger p) {
        Optional<Passanger> maybe = service.findById(id);
        if (maybe.isPresent()) {
            Passanger updated = maybe.get();
            updated.setName(p.getName());//update with user inputted
            updated.setPassengerId(p.getPassengerId());
            updated.setEmail(p.getEmail());

            service.update(updated);//save changes
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/api/passangers/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Optional<Passanger> maybe = service.findById(id);

        if (maybe.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();


        }
        return ResponseEntity.notFound().build();
    }




}

