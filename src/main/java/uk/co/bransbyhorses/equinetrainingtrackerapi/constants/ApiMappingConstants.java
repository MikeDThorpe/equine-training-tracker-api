package uk.co.bransbyhorses.equinetrainingtrackerapi.constants;

public final class ApiMappingConstants {

    public static final String API_VERSION = "/v1";
    public static final String BASE_API_ROUTE = "/api" + API_VERSION;
    public static final String TRAINING_ENVIRONMENT_ROUTE = BASE_API_ROUTE + "/training-environments";
    public static final String TRAINING_SKILL_ROUTE = BASE_API_ROUTE + "/training-skills";
    public static final String LEARNER_TYPE_ROUTE = BASE_API_ROUTE + "/learner-types";
    public static final String TRAINING_CATEGORY_ROUTE = BASE_API_ROUTE + "/training-categories";
    public static final String TRAINING_METHOD_ROUTE = BASE_API_ROUTE + "/training-methodss";
    public static final String YARD_ROUTE = BASE_API_ROUTE + "/yards";
    public static final String HEALTH_AND_SAFETY_FLAG_ROUTE = BASE_API_ROUTE + "/health-and-safety-flags";
    public static final String DISRUPTION_ROUTE = BASE_API_ROUTE + "/disruptions";
    public static final String EQUINE_ROUTE = BASE_API_ROUTE + "/equines";

    /** private constructor to prevent instance being created */
    private ApiMappingConstants() {}
}
