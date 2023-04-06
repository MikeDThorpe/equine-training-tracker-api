package uk.co.bransbyhorses.equinetrainingtrackerapi.constants;

public final class ApiMappingConstants {

    public static final String BASE_API_ROUTE = "/api";
    public static final String TRAINING_ENVIRONMENT_ROUTE = BASE_API_ROUTE + "/training-environments";
    public static final String TRAINING_SKILL_ROUTE = BASE_API_ROUTE + "/training-skills";
    public static final String LEARNER_TYPE_ROUTE = BASE_API_ROUTE + "/learner-types";

    /** private constructor to prevent instance being created */
    private ApiMappingConstants() {}
}
