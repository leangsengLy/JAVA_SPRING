package employee.employee_api.Service.Interface;

import employee.employee_api.Entity.Noted.Noted;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NotedService {
    Noted create(Noted noted);
    List<Noted> getAllNoted();
    Noted getNotedById(Long id);
    Noted updateNoted(Noted noted);
    void deleteNoted(Long id);
}
