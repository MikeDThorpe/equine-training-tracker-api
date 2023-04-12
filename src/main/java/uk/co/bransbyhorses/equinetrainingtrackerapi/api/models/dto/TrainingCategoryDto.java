package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingCategoryDto {

    @JsonProperty(value = "id")
    private UUID id;

    @NotBlank
    @JsonProperty(value = "name")
    private String name;
}
