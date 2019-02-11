package advanced_programming.ugu2_ingrediens.ui;


public interface IUI {
    void showMenu(); //viser menu med valgmuligheder
    void showIngredients(); //viser alle ingredienser
    void showIngredient(); //lader brugeren v�lge ingrediens ud fra id og viser denne
    void changeIngredient(); //lader brugeren v�lge ingrediens ud fra id, dern�st v�lge et felt og s� indtaste en ny v�rdi for denne
    void createIngredient(); //lader brugeren indtaste v�rdier til en ny ingrediens
}
