package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DisruptionCode {
    VETERINARY_REVIEW("Veterinary Review", 1),
    TEAM_LOW("Team Low", 2),
    WEATHER("Weather", 3),
    YARD_BUSY("Yard Busy", 4),
    EQUINE_WELLBEING("Equine Wellbeing", 5);

    private final String string;
    private final int id;

    DisruptionCode(String string, int id) {
        this.string = string;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getString() {
        return string;
    }
}
