package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Initializer {

    public void init() {
        addStations("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        addLines("2호선", "3호선", "신분당선");
        addSections("2호선", "교대역", "강남역", "역삼역");
        addSections("3호선", "교대역", "남부터미널역", "양재역", "매봉역");
        addSections("신분당선", "강남역", "양재역", "양재시민의숲역");
    }

    private void addStations(String... stations) {
        Arrays.stream(stations)
                .forEach(station -> StationRepository.addStation(new Station(station)));
    }

    private void addLines(String... lines) {
        Arrays.stream(lines)
                .forEach(line -> LineRepository.addLine(new Line(line)));
    }

    private void addSections(String lineName, String... stations) {
        Section section = new Section(Arrays.stream(stations)
                .map(StationRepository::findStationByName)
                .collect(Collectors.toList()));

        SectionRepository.addSection(LineRepository.findLineByName(lineName),
                section);
    }
}

