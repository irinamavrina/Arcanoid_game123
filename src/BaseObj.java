import java.awt.*;

public abstract class BaseObj {
    public abstract void update(int timer_cl);
    public abstract void draw(Graphics graphics);
    public abstract Rectangle get_rect();

}
