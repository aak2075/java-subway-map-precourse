package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<Line, Section> sections = new HashMap<>();

    public static Map<Line, Section> sections(Map<Line, Section> sections) {
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

    public static boolean deleteStation(Line line, String name) {
        Section section = sections.get(line);
        return section.deleteStation(name);
    }
}
