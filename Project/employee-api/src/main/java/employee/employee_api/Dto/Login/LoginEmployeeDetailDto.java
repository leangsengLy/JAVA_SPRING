package employee.employee_api.Dto.Login;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginEmployeeDetailDto {
    private Long LoginId;
    private String Username;
    private String Password;
    private Long EmployeeId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;

}
