import javax.swing.*;
import java.util.ArrayList;
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

        List<AbstractButton> buttons = gui.getButtons();
        buttons.get(0).setText("Choice 1");
        //buttons.remove(4);
        buttons.add(new JRadioButton("Last Choice"));


        gui.showButtonPanel();
        gui.out.println("Make a Selection");
        gui.disableTextInput();
        String selection = input.nextLine();
        gui.out.println(selection + " was selected.");

        gui.hideButtonPanel();
        gui.enableTextInput();
    }
}
