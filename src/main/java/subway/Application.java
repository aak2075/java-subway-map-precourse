package subway;

import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayController subwayController = new SubwayController(new InputView(scanner));
        Initializer initializer = new Initializer();
        initializer.init();
        subwayController.run();
    }
}
