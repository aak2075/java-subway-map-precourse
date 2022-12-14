package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<Line, Section> sections = new HashMap<>();

    public static Map<Line, Section> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(Line line, Section section) {
        sections.put(line, section);
    }

    public static void addStation(Line line, Station station, int order) {
        Section section = sections.get(line);
        section.addStation(station, order);
        sections.put(line, section);
    }

    public static void deleteStation(Line line, String name) {
        Section section = sections.get(line);
        section.deleteStation(name);
    }

    public static void deleteStation(String name) {
        Station station = StationRepository.findStationByName(name);
        SectionRepository.sections().values().stream()
                .filter(section -> section.containsStation(station))
                .forEach(section -> deleteStation(findLineByStation(station), name));
    }

    private static Line findLineByStation(Station station) {
        return SectionRepository.sections().entrySet().stream()
                .filter(entry -> entry.getValue().stations().contains(station))
                .map(Map.Entry::getKey)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
