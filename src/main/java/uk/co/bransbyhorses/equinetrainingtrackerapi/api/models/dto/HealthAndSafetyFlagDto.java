package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthAndSafetyFlagDto {

    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "content")
    private String content;

    @JsonProperty(value = "createdDate")
    private OffsetDateTime createdDate;

    @JsonProperty(value = "lastModifiedDate")
    private OffsetDateTime lastModifiedDate;

    @JsonProperty(value = "lastModifiedBy")
    private String lastModifiedBy;
}
