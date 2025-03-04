package employee.employee_api.Repository.File;

import employee.employee_api.Entity.Files.FileSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesSourceRepository extends JpaRepository<FileSource,Integer> {
}
