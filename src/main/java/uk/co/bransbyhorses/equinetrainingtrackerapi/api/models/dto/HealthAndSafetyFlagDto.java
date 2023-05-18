package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonProperty(value = "equine")
    private EquineDto equine;

    @JsonProperty(value = "createdBy")
    private String createdBy;

    @JsonProperty(value = "createdDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime createdDate;

    @JsonProperty(value = "lastModifiedDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime lastModifiedDate;

    @JsonProperty(value = "lastModifiedBy")
    private String lastModifiedBy;
}
