package com.timgesell.textstreamgui;

import javax.swing.*;
import java.util.List;

public interface ButtonModule {
    public JPanel getRootPanel();
    public String getSelectionText();
    public void refreshButtons();
    public List<AbstractButton> getButtons();
}
