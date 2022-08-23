import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SingleSelectOptionModule implements ButtonModule {
    private JLabel label;
    private JPanel singleSelectOptionModule;
    private JRadioButton aRadioButton;
    private JRadioButton bRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton dRadioButton;
    private JRadioButton eRadioButton;
    private ArrayList<AbstractButton> buttons;


    public SingleSelectOptionModule(String labelText) {
        this.buttons = new ArrayList<AbstractButton>();
        $$$setupUI$$$();
        this.label.setText(labelText);
/*        this.buttons.add(aRadioButton);
        this.buttons.add(bRadioButton);
        this.buttons.add(cRadioButton);
        this.buttons.add(dRadioButton);
        this.buttons.add(eRadioButton);*/
    }

    public String getSelectionText() {
        StringBuilder input = new StringBuilder();
        for (AbstractButton b : buttons)
            if (b.isSelected()) {
                input.append(b.getText());
                input.append("\n");
            }
        return input.toString();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        singleSelectOptionModule = new JPanel();
        singleSelectOptionModule.setLayout(new FormLayout("fill:d:noGrow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        label = new JLabel();
        label.setAutoscrolls(true);
        label.setPreferredSize(new Dimension(200, 25));
        label.setText("");
        CellConstraints cc = new CellConstraints();
        singleSelectOptionModule.add(label, new CellConstraints(1, 1, 1, 1, CellConstraints.FILL, CellConstraints.DEFAULT, new Insets(5, 5, 5, 5)));
        aRadioButton.setText("A");
        singleSelectOptionModule.add(aRadioButton, cc.xy(1, 3));
        bRadioButton.setText("B");
        singleSelectOptionModule.add(bRadioButton, cc.xy(1, 5));
        cRadioButton.setText("C");
        singleSelectOptionModule.add(cRadioButton, cc.xy(1, 7));
        dRadioButton.setText("D");
        singleSelectOptionModule.add(dRadioButton, cc.xy(1, 9));
        eRadioButton.setText("E");
        singleSelectOptionModule.add(eRadioButton, cc.xy(1, 11));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return singleSelectOptionModule;
    }

    public JPanel getRootPanel() {
        return singleSelectOptionModule;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        aRadioButton = new JRadioButton();
        this.buttons.add(aRadioButton);
        bRadioButton = new JRadioButton();
        this.buttons.add(bRadioButton);
        cRadioButton = new JRadioButton();
        this.buttons.add(cRadioButton);
        dRadioButton = new JRadioButton();
        this.buttons.add(dRadioButton);
        eRadioButton = new JRadioButton();
        this.buttons.add(eRadioButton);
    }

    public List<AbstractButton> getButtons() {
        return buttons;
    }

    public void refreshButtons() {
        ButtonGroup buttonGroup;
        CellConstraints cc = new CellConstraints();
        buttonGroup = new ButtonGroup();
        singleSelectOptionModule.removeAll();
        String rowConstraints = "center:d:noGrow,";
        for (int i = 1; i <= buttons.size(); i++) {
            rowConstraints += "top:4dlu:noGrow,";
            rowConstraints += "center:max(d;4px):noGrow,";
        }
        rowConstraints = rowConstraints.substring(0, rowConstraints.length() - 1);
        singleSelectOptionModule.setLayout(new FormLayout(
                "fill:d:noGrow", rowConstraints));
        singleSelectOptionModule.add(label, new CellConstraints(1, 1, 1, 1, CellConstraints.FILL, CellConstraints.DEFAULT, new Insets(5, 5, 5, 5)));
        for (int i = 3, button = 0; button < buttons.size(); button++, i += 2) {
            singleSelectOptionModule.add(buttons.get(button), cc.xy(1, i));
            buttonGroup.add(buttons.get(button));
        }
    }
}