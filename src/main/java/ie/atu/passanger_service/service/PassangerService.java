package ie.atu.passanger_service.service;

import ie.atu.passanger_service.model.Passanger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class PassangerService {
    private final List<Passanger> store = new ArrayList<>();

    public List<Passanger> findAll() {
        return new ArrayList<>(store); // defensive copy
    }

    public Optional<Passanger> findById(String id) {
        for (Passanger p : store) {
            if (p.getPassengerId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passanger create(Passanger p) {
        if (findById(p.getPassengerId()).isPresent()) {
            throw new IllegalArgumentException("passengerId already exists");
        }
        store.add(p);
        return p;
    }
    public Passanger update(Passanger p) {
        if (findById(p.getPassengerId()).isPresent()) {
            throw new IllegalArgumentException("passengerId already exists");
        }
        store.add(p);
        return p;
    }
    public void deleteById(String id) {
        store.removeIf(p -> p.getPassengerId().equals(id));

    }
}
