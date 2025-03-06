package employee.employee_api.Controller.File;

import employee.employee_api.Exception.ApiResponse;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//     @PostMapping("image/multi")
//     public ResponseEntity<?> uploadMultipartFile(@RequestParam("file") MultipartFile[] file) {
//        try {
//            if(file.length > 0){
//               for (MultipartFile file1 : file) {
//                   try {
//                       // Validate file
//                       if (file1.isEmpty()) {
//                           continue;
//                       }
//
//                       // Get original filename and validate
//                       String fileName = file1.getOriginalFilename();
//                       if (fileName == null || fileName.trim().isEmpty()) {
//                           continue;
//                       }
//                       String uploadPath = GlobalHelper.pathFolderImage + fileName;
//                       File destinationFile = new File(uploadPath);
//                       destinationFile.getParentFile().mkdirs();
//                       file1.transferTo(destinationFile);
//                       fileService.UploadMultiFile(file1);
//                   } catch (IOException e) {
//                       throw new RuntimeException(e);
//                   }
//               }
//                return ResponseEntity.ok("upload successfuly");
//            }else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//     }

    @PostMapping("image/multi")
    public ResponseEntity<?> uploadMultipartFile(@RequestParam("file") MultipartFile[] files) {
        try {
            // Check if files array is empty or null
            if (files == null || files.length == 0) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "No files provided for upload"));
            }

            List<String> uploadedFiles = new ArrayList<>();
            List<String> failedFiles = new ArrayList<>();

            // Process each file
            for (MultipartFile file : files) {
                try {
                    // Validate file
                    if (file.isEmpty()) {
                        failedFiles.add("Empty file received");
                        continue;
                    }

                    // Get original filename and validate
                    String fileName = file.getOriginalFilename();
                    if (fileName == null || fileName.trim().isEmpty()) {
                        failedFiles.add("File with no name received");
                        continue;
                    }

                    // Sanitize filename (optional but recommended)
                    fileName = System.currentTimeMillis() + "_" + fileName; // Adding timestamp to avoid duplicates

                    // Save file to destination
                    String uploadPath = GlobalHelper.pathFolderImage + fileName;
                    File destinationFile = new File(uploadPath);

                    // Create directory if it doesn't exist
                    destinationFile.getParentFile().mkdirs();

                    file.transferTo(destinationFile);
                    fileService.UploadMultiFile(file); // Assuming this service method exists

                    uploadedFiles.add(fileName);

                } catch (IOException e) {
                    failedFiles.add(file.getOriginalFilename() + ": " + e.getMessage());
                }
            }

            // Prepare response
            if (uploadedFiles.isEmpty() && !failedFiles.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiResponse(HttpStatus.BAD_REQUEST.value(), "All file uploads failed"));
            }

            String message = "Files uploaded successfully: " + uploadedFiles.size() +
                    (failedFiles.isEmpty() ? "" : ", Failed: " + failedFiles.size());

            return ResponseEntity
                    .ok(new ApiResponse(HttpStatus.BAD_REQUEST.value(), message));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Upload failed: " + e.getMessage()));
        }
    }
}
