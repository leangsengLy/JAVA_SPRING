package employee.employee_api.Controller.File;

import employee.employee_api.Global.GlobalHelper;
import employee.employee_api.Service.Implement.File.FileService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Validated
@RestController
@RequestMapping("api/upload/file")
public class FileController {
    @Autowired
    private  FileService fileService;
    @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> handleUploadFile(@RequestParam("file") MultipartFile file) {
        try{
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(GlobalHelper.pathFolderImage +fileName));
            return ResponseEntity.ok("upload successfuly");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
     }
     @PostMapping(value = "image")
     public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
         try {
             fileService.UploadFile(file);
             String fileName = file.getOriginalFilename();
             file.transferTo(new File(GlobalHelper.pathFolderImage +fileName));
             return ResponseEntity.ok("upload successfuly. "+file.getOriginalFilename());
         }catch (Exception e){
             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
         }
     }
}
