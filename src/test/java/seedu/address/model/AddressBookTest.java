package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIngredients.FLOUR;
import static seedu.address.testutil.TypicalIngredients.getTypicalInventory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.exceptions.DuplicateIngredientException;
import seedu.address.testutil.IngredientBuilder;

public class AddressBookTest {

    private final Inventory inventory = new Inventory();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), inventory.getIngredientList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> inventory.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyInventory_replacesData() {
        Inventory newData = getTypicalInventory();
        inventory.resetData(newData);
        assertEquals(newData, inventory);
    }

    @Test
    public void resetData_withDuplicateIngredients_throwsDuplicateIngredientException() {
        // Two persons with the same identity fields
        Ingredient editedAlice = new IngredientBuilder(FLOUR).build();
        List<Ingredient> newIngredients = Arrays.asList(FLOUR, editedAlice);
        AddressBookStub newData = new AddressBookStub(newIngredients);

        assertThrows(DuplicateIngredientException.class, () -> inventory.resetData(newData));
    }

    @Test
    public void hasIngredient_nullIngredient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> inventory.hasIngredient(null));
    }

    @Test
    public void hasIngredient_ingredientNotInInventory_returnsFalse() {
        assertFalse(inventory.hasIngredient(FLOUR));
    }

    @Test
    public void hasIngredient_ingredientInInventory_returnsTrue() {
        inventory.addIngredient(FLOUR);
        assertTrue(inventory.hasIngredient(FLOUR));
    }

    @Test
    public void hasIngredient_ingredientWithSameIdentityFieldsInInventory_returnsTrue() {
        inventory.addIngredient(FLOUR);
        Ingredient editedAlice = new IngredientBuilder(FLOUR).build();
        assertTrue(inventory.hasIngredient(editedAlice));
    }

    @Test
    public void getIngredientList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> inventory.getIngredientList().remove(0));
    }

    @Test
    public void toStringMethod() {
        String expected = Inventory.class.getCanonicalName() + "{persons=" + inventory.getIngredientList() + "}";
        assertEquals(expected, inventory.toString());
    }

    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    private static class AddressBookStub implements ReadOnlyInventory {
        private final ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();

        AddressBookStub(Collection<Ingredient> persons) {
            this.ingredients.setAll(persons);
        }

        @Override
        public ObservableList<Ingredient> getIngredientList() {
            return ingredients;
        }
    }

}
