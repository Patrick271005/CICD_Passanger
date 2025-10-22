package ie.atu.passanger_service.controller.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionDetails {
    private String fieldName;
    private String fieldValue;
}
