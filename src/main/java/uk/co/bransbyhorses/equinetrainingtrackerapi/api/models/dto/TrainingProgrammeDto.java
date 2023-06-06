package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
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
public class TrainingProgrammeDto {

    @JsonProperty(value = "id")
    private UUID id;

    @NotNull
    @JsonProperty(value = "trainingCategory")
    private TrainingCategoryDto trainingCategory;

    @NotNull
    @JsonProperty(value = "equine")
    private EquineDto equine;

    @JsonProperty(value = "startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private OffsetDateTime startDate;

    @JsonProperty(value = "endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private OffsetDateTime endDate;

    @JsonProperty(value = "createdDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime createdDate;

    @JsonProperty(value = "lastModifiedDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime lastModifiedDate;

    @JsonProperty(value = "createdBy")
    private String createdBy;

    @JsonProperty(value = "lastModifiedBy")
    private String lastModifiedBy;
}
