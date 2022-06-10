import java.util.Scanner;

public class TestTextGUI {
    public static void main(String[] args) {

        TextGUI gui = new TextGUI();

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

        gui.hideButtonPanel();
        gui.out.println("Enter your zip code: ");
        String zip = input.nextLine();
        gui.out.println("zip code: " + zip);

        gui.showButtonPanel();

        gui.out.println("Make a Selection");

        String selection = input.nextLine();
        gui.out.println(selection + " was selected");

        gui.hideButtonPanel();

    }
}
