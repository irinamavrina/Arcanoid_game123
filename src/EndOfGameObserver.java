import java.awt.*;

public class EndOfGameObserver implements Observer{
    public EndOfGameObserver(Label label) {
        this.label = label;
    }

    public void update() {
        label.setText(0 + " points...");
    }

    private Label label;
}
