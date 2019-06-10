package extras;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

@SuppressWarnings("all")
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

    public JComboBox addComboBox(String labelTitle, Object[] items) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        JLabel label = new JLabel(labelTitle);
        panel.add(label);
        JComboBox<Object> comboBox = new JComboBox<Object>(items);
        AutoCompleteDecorator.decorate(comboBox);
        panel.add(comboBox);
        add(panel);
        return comboBox;
    }

    public JComboBox showSearchBox(ArrayList<String> l,String message) {
        Object[] list =  l.toArray();
        JComboBox jcb = new JComboBox(list);
        jcb.setEditable(true);
        JOptionPane.showMessageDialog(null, jcb, message, JOptionPane.QUESTION_MESSAGE);
        return jcb;
    }

    // public Panel searchPanel(){
    // Panel searchPanel = new Panel();
    // searchPanel.setLayout(new GridLayout(2,1));
    // JComboBox search = addComboBox("labelTitle", null);
    // searchPanel.setVisible(true);
    // return searchPanel;
    // }

    public JDateChooser addCalendarBox(String labelTitle) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        JLabel label = new JLabel(labelTitle);
        panel.add(label);
        JDateChooser calendar = new JDateChooser();
        panel.add(calendar);
        add(panel);
        return calendar;
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
