import java.awt.*;

public class RecordObserver implements Observer {
    public RecordObserver(Label label, Label label1) {
        this.label = label;
        this.label1 = label1;
    }

    public void update() {
        if (label1.getText().equals(0 + " points...")) cur_points = 0;
        cur_points += one_point;
        max_points = Math.max(max_points, cur_points);
        label.setText(max_points + " max points");
    }

    private final int one_point = 3;
    private int cur_points = 0;
    private int max_points = 0;
    private Label label;
    private Label label1;
}
