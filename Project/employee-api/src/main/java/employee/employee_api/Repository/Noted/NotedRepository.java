package employee.employee_api.Repository.Noted;

import employee.employee_api.Entity.Noted.Noted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotedRepository extends JpaRepository<Noted, Long> {
}
