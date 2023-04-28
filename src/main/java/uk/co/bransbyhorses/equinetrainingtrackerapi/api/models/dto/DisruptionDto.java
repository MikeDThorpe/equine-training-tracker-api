package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.DisruptionCode;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DisruptionDto {

    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "disruptionCode")
    private DisruptionCode disruptionCode;

    @JsonProperty(value = "startDate")
    private OffsetDateTime startDate;

    @JsonProperty(value = "endDate")
    private OffsetDateTime endDate;

    @JsonProperty(value = "isActive")
    private Boolean isActive;

    @JsonProperty(value = "createdBy")
    private String createdBy;
}
