package subway.domain;

import subway.exception.StationNameDuplicateException;
import subway.exception.StationNameLengthException;

import java.util.List;
import java.util.stream.Collectors;

public class Station {
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateDuplicate(name);
        validateLength(name);
    }

    private void validateDuplicate(String name) {
        List<String> stations = StationRepository.stations()
                .stream()
                .map(Station::getName)
                .collect(Collectors.toList());

        if (stations.contains(name)) {
            throw new StationNameDuplicateException();
        }
    }

    private void validateLength(String name) {
        if (name.length() < 2) {
            throw new StationNameLengthException();
        }
    }
}
