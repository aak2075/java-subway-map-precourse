package subway;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public enum LineManagementSelection {
    Register("1", LineManagementSelection::register),
    Delete("2", LineManagementSelection::delete),
    Inquire("3", LineManagementSelection::inquire),
    Back("B", LineManagementSelection::back);

    private final String input;
    public final Consumer<InputView> execution;

    LineManagementSelection(String input, Consumer<InputView> execution) {
        this.input = input;
        this.execution = execution;
    }

    public static LineManagementSelection getFunctionByInput(String input) {
        return Arrays.stream(LineManagementSelection.values())
                .filter(select -> select.input.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static void register(InputView inputView) {
        OutputView.registerLineName();
        String lineName = inputView.input();
        Line line = new Line(lineName);
        LineRepository.addLine(line);
        OutputView.registerLineUp();
        Station up = new Station(inputView.input());
        OutputView.registerLineDown();
        Station down = new Station(inputView.input());
        Section section = new Section(new ArrayList<>(List.of(up, down)),line);
        SectionRepository.addSection(section);
    }

    private static void delete(InputView inputView) {
        OutputView.deleteLine();
        String lineName = inputView.input();
        LineRepository.deleteLineByName(lineName);
        OutputView.completeDeleteLine();
    }

    private static void inquire(InputView inputView) {
        OutputView.inquireLine(LineRepository.lines());

    }

    private static void back(InputView inputView) {
    }
}
