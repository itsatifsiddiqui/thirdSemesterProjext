package extras;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class GUI extends JFrame implements GuiMethod {

    @Override
    public void init(String title, LayoutManager layout) {
        setSize(640, 480);
        setTitle(title);
        setLayout(layout);
    }

    public void init(String title, LayoutManager layout, int width, int height) {
        setSize(width, height);
        setTitle(title);
        setLayout(layout);
    }

    public JButton addButton(String title, ActionListener listener) {
        JButton button = new JButton(title);
        button.addActionListener(listener);
        add(button);
        return button;
    }

    public JTextField addTextField(String labelTitle, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        JLabel label = new JLabel(labelTitle);
        panel.add(label);
        JTextField textField = new JTextField(text);
        panel.add(textField);
        add(panel);
        return textField;

    }

    @Override
    public void addComponents(Component[] components) {
        for (Component component : components)
            add(component);
    }

    @Override
    public void end() {
        setVisible(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}