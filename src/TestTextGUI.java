import java.util.Scanner;

public class TestTextGUI {
    public static void main(String[] args) {

        TextGUI gui = new TextGUI();

        //gui.hideInputPanel();

        Scanner input = new Scanner(gui.in);

        gui.out.println("Hello");
        gui.out.print("World");
        gui.out.println("!");

        gui.out.println("Enter your name: ");
        String name = input.nextLine();
        gui.clear();
        gui.out.println("Hello " + name);

        gui.out.println("Enter your city: ");
        String city = input.nextLine();
        gui.out.println("City: " + city);

        gui.out.println("Enter your age: ");
        int age = input.nextInt();
        gui.out.println("Age: " + age);
        input.nextLine();

        gui.out.println("Enter your zip code: ");
        String zip = input.nextLine();
        gui.out.println("zip code: " + zip);
    }
}
