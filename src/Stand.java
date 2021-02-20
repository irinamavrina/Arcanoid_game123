import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stand extends BaseObj {
    public Stand(int x_pos, int y_pos, double speed) {
        try {
            stand_img = ImageIO.read(new File("src/Components/st.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.x_pos = x_pos;
        this.speed = speed;
        this.y_pos = y_pos - stand_img.getHeight();

    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            move_l = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            move_r = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        move_l = false;
        move_r = false;
    }

    @Override
    public Rectangle get_rect() {
        return new Rectangle((int) x_pos, (int) y_pos - stand_img.getHeight(), stand_img.getWidth(), stand_img.getHeight());
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(stand_img, (int) x_pos, (int) y_pos, null);
    }

    @Override
    public void update(int timer_cl) {
        if (move_r) {
            x_pos += speed * timer_cl;
        }
        if (move_l) {
            x_pos -= speed * timer_cl;
        }
    }

    private boolean move_r = false;
    private boolean move_l = false;
    private BufferedImage stand_img;
    private double x_pos;
    private double speed;
    private double y_pos;
}
