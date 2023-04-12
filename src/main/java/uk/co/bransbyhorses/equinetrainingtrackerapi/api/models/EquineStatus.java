package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EquineStatus {
    AWAITING_TRAINING("Awaiting Training", true),
    IN_TRAINING("In Training", true),
    RETURNED_TO_OWNER("Returned To Owner", false),
    REHOMED("Rehomed", false),
    EUTHANISED("Euthanised", false),
    OTHER("Other", false);

    private final String string;
    private final boolean categorisedAsTraining;

    EquineStatus(String string, boolean categorisedAsTraining) {
        this.string = string;
        this.categorisedAsTraining = categorisedAsTraining;
    }

    public boolean isCategorisedAsTraining() {
        return categorisedAsTraining;
    }

    @Override
    public String toString() {
        return string;
    }
}
