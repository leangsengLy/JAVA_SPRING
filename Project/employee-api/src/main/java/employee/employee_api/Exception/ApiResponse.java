package employee.employee_api.Exception;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private int code;
    private String message;
}
