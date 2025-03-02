package employee.employee_api.Controller.Login;

import employee.employee_api.Dto.Employee.EmployeeDto;
import employee.employee_api.Dto.Login.LoginDto;
import employee.employee_api.Dto.Login.LoginEmployeeDetailDto;
import employee.employee_api.Entity.Login.Login;
import employee.employee_api.Exception.ApiResponse;
import employee.employee_api.Model.LoginEmployeeDetailFilterDataModel;
import employee.employee_api.Service.Interface.EmployeeService;
import employee.employee_api.Service.Interface.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/login")
public class LoginController {
    private final LoginService loginService;
    private final EmployeeService employeeService;
    @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody Login login) {
        try {
            if(login.getEmployeeId()<1){
                return new ResponseEntity<>(
                        new ApiResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                "Invalid input: Don't have employee ID"
                        )
                        , HttpStatus.BAD_REQUEST);
            }
            EmployeeDto findEmployee = employeeService.GetEmployeeById(login.getEmployeeId());
            if(findEmployee==null){
                return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Employee Not Found"),HttpStatus.NOT_FOUND);
            }
            Boolean isExisted = loginService.isHasUserLogin(login.getEmployeeId());
            if(isExisted) {
                return new ResponseEntity<>(new ApiResponse(HttpStatus.CONFLICT.value(),"Employee has user login already!"),HttpStatus.CONFLICT);
            }
            LoginDto create =  loginService.CreateLogin(login);

            return new ResponseEntity<>(create, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
       try {
           Login find = loginService.login(login);
           if(find!=null){
               return new ResponseEntity<>(new ApiResponse(HttpStatus.OK.value(),"Login Success"),HttpStatus.OK);
           }
           return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST.value(),"User login invalid! please check your account again! fuck you"),HttpStatus.BAD_REQUEST);
       } catch (Exception e) {
           return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @GetMapping("delete")
    public ResponseEntity<ApiResponse> RemoveLogin(@Param("id") Long id, @Param("employeeId") Long employeeId) {
        try {
            if(id<1) return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST.value(),"Invalid id"),HttpStatus.BAD_REQUEST);
            Boolean isSuccess = loginService.RemoveUserLogin(id,employeeId);
            if(isSuccess){
                return new ResponseEntity<>(new ApiResponse(HttpStatus.OK.value(),"Delete user login successfully!"),HttpStatus.OK);
            }
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(),"Delete user invalid!"),HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("login_detail")
    public ResponseEntity<?> loginDetail(@RequestBody LoginEmployeeDetailFilterDataModel filter) {
        try {
            List<LoginEmployeeDetailDto> list =  loginService.loginEmployeeDetail(filter);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
