package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProgressCode {
    NOT_ABLE("Not able"),
    LIMITED("Limited"),
    OK("Ok"),
    CONFIDENT("Confident");

    private final String string;

    ProgressCode(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
