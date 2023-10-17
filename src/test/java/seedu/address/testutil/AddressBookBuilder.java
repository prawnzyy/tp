package seedu.address.testutil;

import seedu.address.model.Inventory;
import seedu.address.model.ingredient.Ingredient;

/**
 * A utility class to help with building Inventory objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withIngredient("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private Inventory inventory;

    public AddressBookBuilder() {
        inventory = new Inventory();
    }

    public AddressBookBuilder(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Adds a new {@code Ingredient} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withIngredient(Ingredient ingredient) {
        inventory.addIngredient(ingredient);
        return this;
    }

    public Inventory build() {
        return inventory;
    }
}
