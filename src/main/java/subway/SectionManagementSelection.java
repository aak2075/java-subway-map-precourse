package subway;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.function.Consumer;

public enum SectionManagementSelection {
    REGISTER_SECTION("1", SectionManagementSelection::register),
    DELETE_SECTION("2", SectionManagementSelection::delete),
    BACK("B", SectionManagementSelection::back);

    private final String input;
    public final Consumer<InputView> execution;

    SectionManagementSelection(String input, Consumer<InputView> execution) {
        this.input = input;
        this.execution = execution;
    }

    public static SectionManagementSelection getFunctionByInput(String input) {
        return Arrays.stream(SectionManagementSelection.values())
                .filter(select -> select.input.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void register(InputView inputView) {
        OutputView.registerSectionLine();
        Line line = LineRepository.findLineByName(inputView.input());
        OutputView.registerSectionStation();
        Station station = StationRepository.findStationByName(inputView.input());
        OutputView.registerSectionOrder();
        int order = Integer.parseInt(inputView.input());
        SectionRepository.addStation(line, station, order);
    }

    public static void delete(InputView inputView) {
        OutputView.deleteSectionLine();
        Line line = LineRepository.findLineByName(inputView.input());
        OutputView.deleteSectionStation();
        SectionRepository.deleteStation(line, inputView.input());
        OutputView.deleteSectionComplete();
    }

    public static void back(InputView inputView) {

    }
}
