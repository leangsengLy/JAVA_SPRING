package employee.employee_api.Repository.Login;

import employee.employee_api.Dto.Login.LoginEmployeeDetailDto;
import employee.employee_api.Entity.Login.Login;
import employee.employee_api.Model.LoginEmployeeDetailFilterDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query(value ="SELECT * FROM employee_login  WHERE username = :username AND password = :password",nativeQuery = true)
    Optional<Login> getUseLogin(@Param("username") String username,@Param("password") String password);
    Optional<Login> findByUsername(String username);
    Optional<Login> findAllById(Long employeeId);
    Optional<Login> findByUsernameAndPassword(String username, String password);
    Optional<Login> findByEmployeeId(long employeeId);
    Optional<Login> findByIdAndEmployeeId(long id, Long employeeId);
    @Query(value = "SELECT  emp_log.id \"LoginId\",\n" +
            "emp_log.username \"Username\",\n" +
            "emp_log.password \"Password\",\n" +
            "emp.id \"EmployeeId\",\n" +
            "emp.first_name \"FirstName\",\n" +
            "emp.last_name \"LastName\",\n" +
            "emp.email \"Email\",\n" +
            "emp.phone \"PhoneNumebr\"\n" +
            "FROM employee emp\n" +
            "LEFT JOIN employee_login emp_log\n" +
            "ON emp_log.employee_id= emp.id",nativeQuery = true)
    Optional<List<LoginEmployeeDetailDto>> LoginEmployeeDetail(LoginEmployeeDetailFilterDataModel filter);
}
