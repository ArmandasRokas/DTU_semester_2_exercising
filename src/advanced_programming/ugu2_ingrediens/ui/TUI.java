package advanced_programming.ugu2_ingrediens.ui;

import advanced_programming.ugu2_ingrediens.data.IData;

import java.util.Scanner;

public class TUI    implements IUI {
    private IData data;
    private Scanner scanner;

    public TUI(IData data) {
        this.data = data;
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        scanner = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("1 Vis alle ingredienser");
        System.out.println("2 Vis ingrediens");
        System.out.println("3 �ndr ingrediens");
        System.out.println("4 Opret ingrediens");
        System.out.println("5 Afslut program");

        System.out.print("Indtast valg: ");
        int menuItem = scanner.nextInt();
        System.out.print("\n");

        switch (menuItem) {
            case 1:
                showIngredients();
                break;
            case 2:
                showIngredient();
                break;
            case 3:
                changeIngredient();
                break;
            case 4:
                createIngredient();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                showMenu();
        }
    }

    @Override
    public void showIngredients() {
        System.out.println("Liste af ingredienser:");
        for (String s : data.getAllIngredients()) {
            System.out.println(s);
        }
    }

    @Override
    public void showIngredient() {
        System.out.print("Indtast id: ");
        String input = scanner.next();
        int id = Integer.parseInt(input);
        String ingredient = data.getIngredientName(id) + " (" + data.getIngredientAmount(id) + " gram)";
        System.out.println(ingredient);
    }

    @Override
    public void changeIngredient() {
        System.out.print("Indtast id: ");
        String input = scanner.next();
        int id = Integer.parseInt(input);
        String ingredientName = data.getIngredientName(id);

        System.out.println("Du har valgt ingrediens: " + ingredientName);
        System.out.println("1 �ndr navn");
        System.out.println("2 �ndr m�ngde");
        System.out.println("3 Annull�r");

        System.out.print("Indtast valg: ");
        int menuItem = scanner.nextInt();
        switch (menuItem) {
            case 1:
                System.out.print("Indtast navn: ");
                data.setIngredientName(id, scanner.next());
                break;
            case 2:
                System.out.print("Indtast m�ngde: ");
                data.setIngredientAmount(id, scanner.nextInt());
                break;
            default:
        }
    }

    @Override
    public void createIngredient() {
        System.out.print("Indtast id: ");
        int id = scanner.nextInt();
        System.out.print("Indtast navn: ");
        String name = scanner.next();
        System.out.print("Indtast m�ngde: ");
        int amount = scanner.nextInt();

        data.createIngredient(id, name, amount);
    }
}
