package employee.employee_api.Service.Interface;

import employee.employee_api.Dto.File.FileUploadRequest;
import employee.employee_api.Dto.File.FileUploadResponse;
import org.springframework.stereotype.Service;

@Service
public interface FileService {
    FileUploadResponse upload(FileUploadRequest request);
}
