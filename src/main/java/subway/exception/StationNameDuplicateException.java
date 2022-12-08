package subway.exception;

public class StationNameDuplicateException extends RuntimeException{
    private static final String STATION_NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 역 이름입니다.";

    public StationNameDuplicateException() {
        super(STATION_NAME_DUPLICATE_EXCEPTION_MESSAGE);
    }
}
