package employee.employee_api.Controller.Noted;

import employee.employee_api.Entity.Noted.Noted;
import employee.employee_api.Exception.ApiResponse;
import employee.employee_api.Service.Interface.NotedService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("api/noted")
public class NotedController {
    private final NotedService notedService;
    @PostMapping("create")
    public ResponseEntity<?> Create(@RequestBody Noted noted) {
        try {
                if(noted==null) return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Invalid data!"), HttpStatus.NOT_FOUND);
                Noted data = notedService.create(noted);
                return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("list")
    public ResponseEntity<?> List(@RequestBody Noted noted) {
        try {
            List<Noted> list =  notedService.getAllNoted();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("update")
    public ResponseEntity<?> Update(@RequestBody Noted noted) {
        try {
            if(noted==null || noted.getId() == null) return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Invalid data!"), HttpStatus.NOT_FOUND);
            Noted find = notedService.getNotedById(noted.getId());
            if(find==null) {
                return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "data not found!"), HttpStatus.NOT_FOUND);
            }
            Noted data = notedService.updateNoted(noted);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("delete")
    public ResponseEntity<?> Delete(@RequestParam Long id) {
        try {
            if(id==null || id<1) return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Invalid data!"), HttpStatus.NOT_FOUND);
            Noted noted = notedService.getNotedById(id);
            if(noted==null) {
                return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "data not found!"), HttpStatus.NOT_FOUND);
            }
            notedService.deleteNoted(id);
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK.value(), "Delete noted successfully!"), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
