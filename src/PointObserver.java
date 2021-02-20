import java.awt.*;

public class PointObserver implements Observer {

    public void update() {
        if (label.getText().equals(0 + " points...")) points = 0;
        points += one_point;
        label.setText(points + " points");
    }

    public PointObserver(Label label) {
        this.label = label;
    }

    private final int one_point = 3;
    private int points = 0;
    private Label label;
}
