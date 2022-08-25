import com.timgesell.textstreamgui.SingleSelectOptionModule;
import com.timgesell.textstreamgui.TextStreamGUI;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class TestTextStreamGUI {
    public static void main(String[] args) {

        TextStreamGUI gui = new TextStreamGUI();

        Scanner input = new Scanner(gui.in);

        gui.out.println("Hello");
        gui.out.print("World");
        gui.out.println("!");

        gui.out.println("Enter your name: ");
        String name = input.nextLine();
        gui.clear();
        gui.out.println("Hello " + name);

        gui.out.println("Enter your age: ");
        int age = input.nextInt();
        gui.out.println("Age: " + age);
        input.nextLine();

        gui.out.println("Enter your zip code: ");
        String zip = input.nextLine();
        gui.out.println("zip code: " + zip);

        List<AbstractButton> buttons = gui.getButtonPanel().getButtonModule().getButtons();
        buttons.get(0).setText("Choice 1");
        buttons.remove(3);
        buttons.add(new JRadioButton("Last Choice"));


        gui.showButtonPanel();
        gui.out.println("Make a Selection");
        gui.disableTextInput();
        String selection = input.nextLine();

        gui.hideButtonPanel();
        gui.enableTextInput();

        if (selection.equals("Choice 1"))
        {
            gui.out.println("You chose the best choice!  You chose: " + selection);
        }
        else
            gui.out.println(selection + " was selected.");
//        ArrayList<String> selections = new ArrayList<String>();
//        selections.add("C to F");
//        selections.add("F to C");
//        selections.add("miles to km");
//        selections.add("km to miles");
//        SingleSelectOptionModule buttonSet = new SingleSelectOptionModule("Test",selections);

        SingleSelectOptionModule buttonSet = new SingleSelectOptionModule("Test",
                "C to F", "F to C", "miles to km", "km to miles");
        gui.getButtonPanel().setButtonModule(buttonSet);
        gui.showButtonPanel();

        selection = input.nextLine();
        gui.out.println("You chose: " + selection);
    }
}
