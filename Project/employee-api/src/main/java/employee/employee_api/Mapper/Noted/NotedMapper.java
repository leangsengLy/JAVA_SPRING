package employee.employee_api.Mapper.Noted;

import employee.employee_api.Dto.Noted.NotedDto;
import employee.employee_api.Entity.Noted.Noted;

public class NotedMapper {
    public  static NotedDto toDto(Noted noted,int totalCountRecord) {
        NotedDto notedDto = new NotedDto();
        notedDto.setId(noted.getId());
        notedDto.setLabel(noted.getLabel());
        notedDto.setDescription(noted.getDescription());
        notedDto.setRecordCount(totalCountRecord);
        return notedDto;
    }
}
