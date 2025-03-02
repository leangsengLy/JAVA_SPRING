package employee.employee_api.Exception;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private int code;
    private String message;
}
