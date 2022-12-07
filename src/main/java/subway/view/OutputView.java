package subway.view;

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
}