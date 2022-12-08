package subway.exception;

public class StationNameLengthException extends RuntimeException {
    private static final String STATION_NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 역 이름은 2글자 이상이어야 합니다.";
    public StationNameLengthException() {
        super(STATION_NAME_LENGTH_EXCEPTION_MESSAGE);
    }
}
