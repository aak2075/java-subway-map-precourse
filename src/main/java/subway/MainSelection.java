package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.function.Consumer;

public enum MainSelection {
    StationManagement("1", MainSelection::manageStation),
    LineManagement("2", MainSelection::manageLine),
    SectionManagement("3", MainSelection::manageSection),
    PrintLines("4", MainSelection::printLines),
    Quit("Q", MainSelection::quit);

    MainSelection(String input, Consumer<InputView> execution) {
        this.input = input;
        this.execution = execution;
    }

    private final String input;
    public Consumer<InputView> execution;
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 입력은 1~4와 Q만 가능합니다.";

    public static MainSelection getFunctionByInput(String input) {
        return Arrays.stream(MainSelection.values())
                .filter(function -> function.input.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_ERROR_MESSAGE));
    }

    private static void manageStation(InputView inputView) {
        OutputView.selectStationManagement();
        StationManagementSelection select = StationManagementSelection.getFunctionByInput(inputView.input());
        select.execution.accept(inputView);
    }

    private static void manageLine(InputView inputView) {

    }

    private static void manageSection(InputView inputView) {

    }

    private static void printLines(InputView inputView) {

    }

    private static void quit(InputView inputView) {

    }
}