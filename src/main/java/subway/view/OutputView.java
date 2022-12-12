package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String MAIN_MESSAGE = "## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n";
    private static final String STATION_MANAGEMENT_MESSAGE = "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기\n";
    private static final String SELECT_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String REGISTER_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String REGISTER_STATION_COMPLETE_MESSAGE = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_COMPLETE_MESSAGE = "[INFO] 지하철 역이 삭제되었습니다.";
    private static final String INQUIRE_STATION_MESSAGE = "## 역 목록";
    private static final String SELECT_LINE_MESSAGE = "## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기";
    private static final String REGISTER_LINE_NAME_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String REGISTER_LINE_UP_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String REGISTER_LINE_DOWN_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INQUIRE_LINE_MESSAGE = "## 노선 목록";
    private static final String INFO_MESSAGE = "[INFO] ";
    private static final String DELETE_LINE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String COMPLETE_DELETE_MESSAGE = "지하철 노선이 삭제되었습니다.";

    public static void selectMain() {
        System.out.println(MAIN_MESSAGE);

    }

    public static void selectFunction() {
        System.out.println(SELECT_FUNCTION_MESSAGE);
    }

    public static void selectStationManagement() {
        System.out.println(STATION_MANAGEMENT_MESSAGE);
    }

    public static void registerStation() {
        System.out.println(REGISTER_STATION_MESSAGE);
    }

    public static void completeRegisterStation() {
        System.out.println(REGISTER_STATION_COMPLETE_MESSAGE);
    }

    public static void deleteStation() {
        System.out.println(DELETE_STATION_MESSAGE);
    }

    public static void completeDeleteStation() {
        System.out.println(DELETE_STATION_COMPLETE_MESSAGE);
    }

    public static void inquireStation(List<Station> stations) {
        System.out.println(INQUIRE_STATION_MESSAGE);
        stations.forEach(station -> System.out.println(INFO_MESSAGE + station.getName()));
    }

    public static void selectLineManagement() {
        System.out.println(SELECT_LINE_MESSAGE);
    }

    public static void registerLineName() {
        System.out.println(REGISTER_LINE_NAME_MESSAGE);
    }

    public static void registerLineUp() {
        System.out.println(REGISTER_LINE_UP_MESSAGE);
    }

    public static void registerLineDown() {
        System.out.println(REGISTER_LINE_DOWN_MESSAGE);
    }

    public static void inquireLine(List<Line> lines) {
        System.out.println(INQUIRE_LINE_MESSAGE);
        lines.forEach(line -> System.out.println(INFO_MESSAGE + line.getName()));
    }

    public static void deleteLine() {
        System.out.println(DELETE_LINE_MESSAGE);
    }

    public static void completeDeleteLine() {
        System.out.println(INFO_MESSAGE + COMPLETE_DELETE_MESSAGE);
    }
}
