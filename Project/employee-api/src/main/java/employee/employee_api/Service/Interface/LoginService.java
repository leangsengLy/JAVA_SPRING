package employee.employee_api.Service.Interface;

import employee.employee_api.Dto.Login.LoginDto;
import employee.employee_api.Dto.Login.LoginEmployeeDetailDto;
import employee.employee_api.Entity.Login.Login;
import employee.employee_api.Model.LoginEmployeeDetailFilterDataModel;

import java.util.List;

public interface LoginService {
    Login login(Login login);
    LoginDto CreateLogin(Login login);
    Boolean isHasUserLogin(Long id);
    Boolean RemoveUserLogin(Long id,Long employeeId);
    List<LoginEmployeeDetailDto> loginEmployeeDetail(LoginEmployeeDetailFilterDataModel filter);
}
