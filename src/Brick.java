import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Brick extends BaseObj {
    public Brick(){
        try {
            br_img = ImageIO.read(new File("src/Components/br.png"));
        } catch (IOException e) {
            System.out.println("ups");
        }
    }

    public void set_pos_x(double pos_x) {
        this.pos_x = pos_x;
    }

    public void set_pos_y(double pos_y) {
        this.pos_y = pos_y;
    }


    @Override
    public Rectangle get_rect() {
        return new Rectangle((int) pos_x, (int) pos_y, br_img.getWidth(), br_img.getHeight());
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(br_img, (int) pos_x, (int) pos_y, null);
    }

    @Override
    public void update(int timer_cl) {

    }

    public void delete_brick() {
        pos_y *= -1;
        pos_x *= -1;
    }

    public int getH() {
        return br_img.getHeight();
    }

    public int getW() {
        return br_img.getWidth();
    }

    private BufferedImage br_img;
    private double pos_x;
    private double pos_y;
}
