package Functions;

import controllers.GameController;

public class TestStop extends AbstractFunction {
    public TestStop(GameController gameController) {
        super(gameController);
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {


            System.out.println("stopNextCycle" + i);
            stopNextStep();
            System.out.println("stopNextStep" + i);
            stopNextStep();
        }
    }
}
