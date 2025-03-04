package employee.employee_api.Controller.File;

import employee.employee_api.Dto.File.FileUploadRequest;
import employee.employee_api.Dto.File.FileUploadResponse;
import employee.employee_api.Global.GlobalHelper;
import employee.employee_api.Service.Implement.File.FileUploadImpl;
import employee.employee_api.Service.Interface.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Validated
@RestController
@RequestMapping("api/upload/file")
public class FileController {
    @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> handleUploadFile(@RequestParam("file") MultipartFile file) {
        try{
            String fileName = file.getOriginalFilename();
//            file.transferTo(new File("C:\\Users\\TUF\\Desktop\\UploadImage\\"+fileName));
            file.transferTo(new File(GlobalHelper.pathFolderImage +fileName));
            return ResponseEntity.ok("upload successfuly");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
     }
}
