package ie.atu.passanger_service.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passanger {
    @NotBlank @Size(max=40)
    private String passengerId;
    @NotBlank @Size(max=60)
    private String name;
    @NotBlank @Email
    private String email;
}
