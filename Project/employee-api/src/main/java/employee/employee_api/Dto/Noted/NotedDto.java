package employee.employee_api.Dto.Noted;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class NotedDto {
    @JsonProperty("Id")
    private Long Id;
    @JsonProperty("Label")
    private String Label;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("RecordCount")
    private int RecordCount;
}
