package subway;

import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    InputView inputView;

    public SubwayController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        OutputView.selectMain();
        OutputView.selectFunction();
        MainSelection select = MainSelection.getFunctionByInput(inputView.input());
        mainFunction(select);
    }

    private void mainFunction(MainSelection select) {
        if (select == MainSelection.Quit) {
            return;
        }
        select.getExecution().accept(inputView);
        run();
    }
}
