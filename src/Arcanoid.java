import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Arcanoid extends JPanel {
    public Arcanoid(int width, int height, JFrame frame) {
        this.width = width;
        this.height = height;
        this.frame = frame;
        setSize(width, height);

        ball = new Ball(width, height);
        stand = new Stand(width - 100, height, 0.5);
        bricks = new ArrayList<>();
        init_brick();
        init_observers();
        Timer timer = new Timer(70, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++c;
                update(c);
                repaint();
            }
        });
        timer.start();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                stand.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                stand.keyReleased(e);
            }
        });

    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0, 0, width, height);
        ball.draw(graphics);
        stand.draw(graphics);
        for (int i = 0; i < n * n; i++)
        bricks.get(i).draw(graphics);
    }

    public void update(int click) {
        check_for_intersections();
        ball.update(click);
        stand.update(click);
        if (ball.border(height)) {
            endOfGameSubject.notifyObservers();
            ball.set_start_pos(width, height);
            c = 0;
        }
    }

    public void check_for_intersections() {
        Rectangle rectangle1 = ball.get_rect();
        for (int i = 0; i < n * n; i++) {
            if (bricks.get(i).get_rect().intersects(rectangle1)) {
                bricks.get(i).delete_brick();
                ball.chSpeed();
                pointSubject.notifyObservers();//!!!!!!!
            }
        }
        if (stand.get_rect().intersects(rectangle1)) {
            ball.chDirection();
        }
        ball.check_ball_position(width);
    }

    private void init_observers() {
        pointSubject = new PointSubject();
        endOfGameSubject = new EndOfGameSubject();
        label1 = new Label();
        label2 = new Label();

        PointObserver pointObserver = new PointObserver(label1);
        EndOfGameObserver endOfGameObserver = new EndOfGameObserver(label1);
        RecordObserver recordObserver = new RecordObserver(label2, label1);
        pointSubject.attach(pointObserver);
        pointSubject.attach(recordObserver);
        endOfGameSubject.attach(endOfGameObserver);
        Container container = new Container();
        container.setLayout(new GridLayout(1, 2));
        container.add(label2);
        container.add(label1);
        frame.add(container, BorderLayout.NORTH);
    }
    public void init_brick() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Brick brick1 = new Brick();
                brick1.set_pos_x(width / n + i * brick1.getW());
                brick1.set_pos_y(height / n + j * brick1.getH());
                bricks.add(brick1);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    private int c = 0;
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private PointSubject pointSubject;
    private EndOfGameSubject endOfGameSubject;
    private Label label1;
    private Label label2;
    private JFrame frame;
    private List<Brick>bricks;
    private int n = 5;
}
