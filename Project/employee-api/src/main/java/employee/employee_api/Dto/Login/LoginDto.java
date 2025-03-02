package employee.employee_api.Dto.Login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private Long id;
    private String username;
    private String password;
    private Long employeeId;
}
