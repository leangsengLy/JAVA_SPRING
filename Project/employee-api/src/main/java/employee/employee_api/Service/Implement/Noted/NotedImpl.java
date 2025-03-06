package employee.employee_api.Service.Implement.Noted;

import employee.employee_api.Entity.Noted.Noted;
import employee.employee_api.Exception.Employee.ResourceNotFound;
import employee.employee_api.Repository.Noted.NotedRepository;
import employee.employee_api.Service.Interface.NotedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class NotedImpl implements NotedService {
    private NotedRepository repo;
    @Override
    public Noted create(Noted noted) {
        Noted data = new Noted();
        data.setLabel(noted.getLabel());
        data.setDescription(noted.getDescription());
        data.setCreatedAt(LocalDateTime.now());
        repo.save(data);
        return data;
    }

    @Override
    public List<Noted> getAllNoted() {
        return repo.findAll();
    }

    @Override
    public Noted getNotedById(Long id) {
        Optional<Noted> data = repo.findById(id);
        return data.get();
    }

    @Override
    public Noted updateNoted(Noted noted) {
        Noted find = repo.findById(noted.getId()).orElseThrow(()->new ResourceNotFound("Data not found!"));
        find.setLabel(noted.getLabel());
        find.setDescription(noted.getDescription());
        find.setCreatedAt(LocalDateTime.now());
        repo.save(find);
        return find;
    }

    @Override
    public void deleteNoted(Long id) {
        Noted find = repo.findById(id).orElseThrow(()->new ResourceNotFound("Data not found!"));
        repo.delete(find);
    }
}
