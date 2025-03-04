package employee.employee_api.Service.Implement.File;

import employee.employee_api.Dto.File.FileUploadRequest;
import employee.employee_api.Dto.File.FileUploadResponse;
import employee.employee_api.Service.Interface.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileUploadImpl implements FileService {
    @Override
    public FileUploadResponse upload(FileUploadRequest request) {
        return null;
    }
}
