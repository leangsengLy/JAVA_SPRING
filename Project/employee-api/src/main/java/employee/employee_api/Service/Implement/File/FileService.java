package employee.employee_api.Service.Implement.File;

import employee.employee_api.Entity.Files.FileSource;
import employee.employee_api.Repository.File.FilesSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
@Service
public class FileService  {
    @Autowired
    private FilesSourceRepository filesSourceRepository; // Inject the repository
    public FileSource UploadFile(MultipartFile file) throws IOException {
        FileSource newFileSource = new FileSource();
        newFileSource.setFileName(file.getOriginalFilename());
        newFileSource.setFileType(file.getContentType());
        newFileSource.setData(file.getBytes());
        newFileSource.setFileName(file.getOriginalFilename());
        newFileSource.setUploadedAt(LocalDateTime.now());
        return filesSourceRepository.save(newFileSource);
    }
}
