package employee.employee_api.Service.Implement.Login;

import employee.employee_api.Dto.Login.LoginDto;
import employee.employee_api.Dto.Login.LoginEmployeeDetailDto;
import employee.employee_api.Entity.Login.Login;
import employee.employee_api.Mapper.Login.LoginMapping;
import employee.employee_api.Model.LoginEmployeeDetailFilterDataModel;
import employee.employee_api.Repository.Login.LoginRepository;
import employee.employee_api.Service.Interface.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoginImpl implements LoginService {


    private LoginRepository loginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public LoginDto CreateLogin(Login login) {
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        Login create = loginRepository.save(login);
        return LoginMapping.MapToDto(create);
    }
    @Override
    public Login login(Login login) {
        String getUsername = login.getUsername();
        Optional<Login> findUserLogin = loginRepository.findByUsername(getUsername);
        if(findUserLogin.isPresent()) {
            boolean isValid = passwordEncoder.matches(login.getPassword(), findUserLogin.get().getPassword());
            if(isValid) {
                return findUserLogin.get();
            }else return null;
        }
        return null;
    }
    @Override
    public Boolean isHasUserLogin(Long employeeId) {
        Optional<Login> findLogin;
        findLogin = loginRepository.findByEmployeeId(employeeId);
        return findLogin.isPresent();
    }
    @Override
    public Boolean RemoveUserLogin(Long id,Long employeeId) {
        Optional<Login> login = loginRepository.findByIdAndEmployeeId(id,employeeId);
        if(login.isPresent()) {
            loginRepository.deleteById(id);
            return true;
        }
        return false;

    }
    @Override
    public List<LoginEmployeeDetailDto> loginEmployeeDetail(LoginEmployeeDetailFilterDataModel filter) {
        Optional<List<LoginEmployeeDetailDto>> result = loginRepository.LoginEmployeeDetail(filter);
        if (!result.isPresent()) {
            return Collections.emptyList();
        }
        List<LoginEmployeeDetailDto> employeeDetails = result.get();
        if (filter.getId() > 0) {
            employeeDetails = employeeDetails.stream()
                    .filter(emp -> emp.getLoginId() == filter.getId())
                    .collect(Collectors.toList());
        }
        // Return the filtered list
        return employeeDetails;
    }

}
