package subway.domain;

import java.util.Collections;
import java.util.List;

public class Section {
    private final List<Station> stations;

    public Section(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station, int order) {
        stations.add(order, station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> station.getName().equals(name));
    }

    public boolean containsStation(Station station) {
        return stations.stream()
                .anyMatch(s -> s.equals(station));
    }
}
