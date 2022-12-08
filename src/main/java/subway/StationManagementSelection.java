package subway;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.function.Consumer;

public enum StationManagementSelection {
    Register("1", StationManagementSelection::register),
    Delete("2", StationManagementSelection::delete),
    Inquire("3", StationManagementSelection::inquire),
    Back("B", StationManagementSelection::back);


    StationManagementSelection(String input, Consumer<InputView> execution) {
        this.input = input;
        this.execution = execution;
    }

    public static StationManagementSelection getFunctionByInput(String input) {
        return Arrays.stream(StationManagementSelection.values())
                .filter(select -> select.input.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private final String input;
    public final Consumer<InputView> execution;

    private static void register(InputView inputView) {
        OutputView.registerStation();
        String stationName = inputView.input();
        Station station = new Station(stationName);
        StationRepository.addStation(station);
        OutputView.completeRegisterStation();
    }

    private static void delete(InputView inputView) {
        OutputView.DeleteStation();
        String stationName = inputView.input();
        StationRepository.deleteStation(stationName);
        OutputView.completeDeleteStation();
    }

    private static void inquire(InputView inputView) {

    }

    private static void back(InputView inputView) {

    }

}
