package panels.menuOptions;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class TextFieldPanel extends JPanel {
    public JTextField textField;
    
    public TextFieldPanel() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        
        this.add(textField);
        //this.pack();
        this.setVisible(false);
    }
}
