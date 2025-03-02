package employee.employee_api.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginEmployeeDetailFilterDataModel {
    public Long Id;
    public Long Pages;
    public Long Records;
    public String OrderBy;
    public String OrderByDirection;
}
