import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball extends BaseObj {

    public Ball(double width, double height) {
        this.pos_x = width / 2;
        this.pos_y = height / 2;
        try {
            ball_img = ImageIO.read(new File("src/Components/ball.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(ball_img, (int) pos_x, (int) pos_y, null);
    }

    @Override
    public void update(int elapsedTime) {
        pos_x += speed_x * elapsedTime;
        pos_y += speed_y * elapsedTime;

    }

    @Override
    public Rectangle get_rect() {
        return new Rectangle((int) pos_x, (int) pos_y, ball_img.getWidth(), ball_img.getHeight());
    }

    void check_ball_position(int w) {
        if (pos_x < 0 || pos_x > w) {
            speed_x = -speed_x;
            speed_x *= 1.1;
        }
        if (pos_y < 0) {
            speed_y = -speed_y;
            speed_y *= 1.1;
        }
    }

    boolean border(int h) {
        if (pos_y > h) return true;
        else return false;
    }

    public void chSpeed() {
        speed_y *= -0.8;
        speed_x *= -0.8;
    }

    public void chDirection() {
        speed_y *= -0.8;
    }

    public void set_start_pos(int w, int h) {
        pos_y = h / 2;
        pos_x = w / 2;
        speed_x = 1;
        speed_y = 1;
    }

    private BufferedImage ball_img;
    private double speed_x = 1;
    private double speed_y = 1;
    private double pos_x;
    private double pos_y;
}
