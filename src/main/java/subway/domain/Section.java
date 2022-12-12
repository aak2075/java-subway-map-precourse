package subway.domain;

import java.util.List;

public class Section {
    private final List<Station> stations;

    public Section(List<Station> stations) {
        this.stations = stations;
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

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> station.getName().equals(name));
    }
}
