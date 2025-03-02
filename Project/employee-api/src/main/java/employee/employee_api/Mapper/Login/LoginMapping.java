package employee.employee_api.Mapper.Login;

import employee.employee_api.Dto.Login.LoginDto;
import employee.employee_api.Entity.Login.Login;

public class LoginMapping {
    public static LoginDto MapToDto(Login login) {
        return new LoginDto(login.getId(),login.getUsername(),login.getPassword(),login.getEmployeeId());
    }
}
