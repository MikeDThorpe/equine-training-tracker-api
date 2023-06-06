package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.ProgressCode;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SkillTrainingSessionDto {

    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "trainingCategory")
    @NotNull
    private TrainingCategoryDto trainingCategory;

    @JsonProperty(value = "trainingSkill")
    @NotNull
    private TrainingSkillDto trainingSkill;

    @JsonProperty(value = "trainingMethod")
    @NotNull
    private TrainingMethodDto trainingMethod;

    @JsonProperty(value = "trainingEnvironment")
    @NotNull
    private TrainingEnvironmentDto trainingEnvironment;

    @JsonProperty(value = "progressCode")
    @NotNull
    private ProgressCode progressCode;

    @JsonProperty(value = "trainingTimeInMinutes")
    @Size(min = 0)
    private Long trainingTimeInMinutes;

    @JsonProperty(value = "notes")
    private String notes;

    @JsonProperty(value = "createdBy")
    private String createdBy;

    @JsonProperty(value = "createdDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private OffsetDateTime createdDate;
}
