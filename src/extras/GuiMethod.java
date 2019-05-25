package extras;

import java.awt.*;

public interface GuiMethod {
    
    public void init(String title, LayoutManager layout);

    public void addComponents(Component[] components);

    public void end();

}