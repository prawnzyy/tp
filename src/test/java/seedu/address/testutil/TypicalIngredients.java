package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.Inventory;
import seedu.address.model.ingredient.Ingredient;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalIngredients {

    public static final Ingredient ALICE = new IngredientBuilder().withName("Alice Pauline").build();
    public static final Ingredient BENSON = new IngredientBuilder().withName("Benson Meier").build();
    public static final Ingredient CARL = new IngredientBuilder().withName("Carl Kurz").build();
    public static final Ingredient DANIEL = new IngredientBuilder().withName("Daniel Meier").build();
    public static final Ingredient ELLE = new IngredientBuilder().withName("Elle Meyer").build();
    public static final Ingredient FIONA = new IngredientBuilder().withName("Fiona Kunz").build();
    public static final Ingredient GEORGE = new IngredientBuilder().withName("George Best").build();

    // Manually added
    public static final Ingredient HOON = new IngredientBuilder().withName("Hoon Meier").build();
    public static final Ingredient IDA = new IngredientBuilder().withName("Ida Mueller").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Ingredient AMY = new IngredientBuilder().withName(VALID_NAME_AMY).build();
    public static final Ingredient BOB = new IngredientBuilder().withName(VALID_NAME_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalIngredients() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static Inventory getTypicalInventory() {
        Inventory ab = new Inventory();
        for (Ingredient ingredient : getTypicalIngredients()) {
            ab.addIngredient(ingredient);
        }
        return ab;
    }

    public static List<Ingredient> getTypicalIngredients() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
