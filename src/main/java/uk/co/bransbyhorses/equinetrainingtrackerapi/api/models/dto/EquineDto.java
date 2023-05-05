package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.EquineStatus;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquineDto {

    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "yard")
    private YardDto yard;

    @JsonProperty(value = "equineStatus")
    private EquineStatus equineStatus;

    @JsonProperty(value = "learnerType")
    private LearnerTypeDto learnerType;
}
