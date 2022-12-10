package subway.domain;

import java.util.List;

public class Section {
    private final Line line;
    private final List<Station> stations;

    public Section(List<Station> stations, Line line) {
        this.stations = stations;
        this.line = line;
    }

    public Station getStation(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void addStation(Station station, int order) {
        stations.add(order, station);
    }
}
