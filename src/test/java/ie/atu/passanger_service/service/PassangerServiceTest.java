package ie.atu.passanger_service.service;

import ie.atu.passanger_service.model.Passanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PassangerServiceTest {

    private PassangerService service;

    @BeforeEach
    void setup() {
        service = new PassangerService();
    }

    @Test
    void createThenFindById() {
        Passanger p = Passanger.builder()
                .passengerId("P1")
                .name("Paul")
                .email("paul@atu.ie")
                .build();

        service.create(p);

        Optional<Passanger> found = service.findById("P1");
        assertTrue(found.isPresent());
        assertEquals("Paul", found.get().getName());
    }

    @Test
    void duplicateIdThrows() {
        service.create(Passanger.builder()
                .passengerId("P2")
                .name("Bob")
                .email("b@atu.ie")
                .build());

        assertThrows(IllegalArgumentException.class, () ->
                service.create(Passanger.builder()
                        .passengerId("P2")
                        .name("Bobby")
                        .email("bob@ex.com")
                        .build())
        );
    }
}
