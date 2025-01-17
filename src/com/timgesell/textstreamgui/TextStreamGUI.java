package com.timgesell.textstreamgui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.timgesell.textstreamgui.ConsolePanel;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

/**
 * TextStreamGUI is a customizable Graphical User Interface based on the idea of
 * two JPanels: a ConsolePanel and a ButtonPanel
 * and two Streams: an InputStream (in) and a PrintStream (out).  <i>Both represent Streams of Text (thus the name of the class)</i>
 *
 * The coder, can interact with the Streams similarly to how they would interact with System.out and System.in
 * For example, assuming a TextStreamGUI named ui, they can use ui.out.print() and ui.out.println()
 * and they can create a Scanner object <i>new Scanner(ui.in)</i> to read from the InputStream
 *
 * The output from the PrintStream is displayed in the ConsolePanel.  This is extremely similar to writing code
 * that writes to the terminal using System.out.  The coder simply uses ui.out instead of System.out
 *
 * Data gets into the InputStream in two ways
 * 1) There is a JTextField at the bottom of the ConsolePanel.  When the user types into that JTextField, and
 *    hits the Enter key, the text from the JTextField is added to the InputStream
 * 2) There is ButtonPanel that can be customized with different ButtonPanelModules that contain various components.
 *    There is also a mainButton (a JButton) at the bottom of the ButtonPanel.  When this mainButton is clicked, text
 *    representative of the selections made in the ButtonPanelModules is added to the InputStream
 *
 * The inputStream is blocking - which means that when you read data from the InputStream (which may happen for
 * example as the result of a Scanner.nextLine() call) the method won't return until it has some data.
 * So the coder for example can call Scanner.nextLine() and the code will not advance until the Enter is pressed in
 * the JTextField OR the mainButton is clicked in the ButtonPanel.
 *
 * The ability to read data from a Stream based on Graphical User Interface Components is perhaps more intuitive
 * to the beginning coder because they don't have to worry about creating various interacting component Actions.
 * Rather, they can just read from the InputStream, which will wait for the user to make appropriate
 * selections in the UI and click the button, and then return a result indicative of the selections to the user.
 *
 * @author Tim Gesell
 * @version 08/22/2022
 */
public class TextStreamGUI {
    private JPanel mainPanel;
    private ButtonPanel buttonPanel;
    private ConsolePanel consolePanel;
    private JPanel consolePanelRootPanel;
    private JPanel buttonPanelRootPanel;
    public final PrintStream out;
    public final InputStream in;
    private StringBuffer input;

    private CellConstraints defaultButtonPanelConstraints;
    private JFrame mainFrame;


    /**
     *
     * @param title Title text for the JFrame.  Otherwise, the default is "TextStreamGUI"
     */
    public TextStreamGUI(String title) {
        mainFrame = new JFrame(title);
        input = new StringBuffer();
        consolePanel = new ConsolePanel(input);
        buttonPanel = new ButtonPanel(input);
        $$$setupUI$$$();
        out = consolePanel.out;
        in = consolePanel.in;
        defaultButtonPanelConstraints = ((FormLayout) mainPanel.getLayout()).getConstraints(buttonPanelRootPanel);
        this.hideButtonPanel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public TextStreamGUI() {
        this("TextStreamGUI");
    }

    /**
     * This method should be called on the eventThread (for example using SwingUtilities
     * invokLater() or invokeAndWait()
     */
    private void createAndShowGUI() {
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new FormLayout("fill:d:noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:259px:grow(1.1)"));
        mainPanel.setPreferredSize(new Dimension(800, 600));
        buttonPanelRootPanel.setEnabled(false);
        buttonPanelRootPanel.setPreferredSize(new Dimension(200, 600));
        CellConstraints cc = new CellConstraints();
        mainPanel.add(buttonPanelRootPanel, new CellConstraints(1, 1, 1, 1, CellConstraints.DEFAULT, CellConstraints.DEFAULT, new Insets(10, 10, 10, 10)));
        consolePanelRootPanel.setPreferredSize(new Dimension(800, 600));
        mainPanel.add(consolePanelRootPanel, cc.xy(3, 1));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    private void createUIComponents() {
        consolePanelRootPanel = consolePanel.getRootPanel();
        buttonPanelRootPanel = buttonPanel.getRootPanel();
    }

    /**
     * Clears the ConsolePanel output
     */
    public void clear() {
        consolePanel.clear();
    }

    /**
     * removes the ButtonPanel from the main TextStreamGUI JPanel
     */
    public void hideButtonPanel() {
        if (buttonPanelRootPanel.getParent() == mainPanel) {
            defaultButtonPanelConstraints = ((FormLayout) mainPanel.getLayout()).getConstraints(buttonPanelRootPanel);
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        mainPanel.remove(buttonPanelRootPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * adds the ButtonPanel back into the main TextStreamGUI JPanel (on the left side)
     */
    public void showButtonPanel() {
        if (!(buttonPanelRootPanel.getParent() == mainPanel))
            buttonPanel.getButtonModule().refreshButtons();
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        mainPanel.add(buttonPanelRootPanel, defaultButtonPanelConstraints, 0);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

    }
    public void disableTextInput()
    {
        consolePanel.setEnabled(false);
    }

    public void enableTextInput()
    {
        consolePanel.setEnabled(true);
    }

    public ButtonPanel getButtonPanel()
    {
        return buttonPanel;
    }
}
