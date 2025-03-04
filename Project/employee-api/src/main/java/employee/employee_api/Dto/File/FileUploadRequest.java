package employee.employee_api.Dto.File;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequest(MultipartFile file,String name) {

}