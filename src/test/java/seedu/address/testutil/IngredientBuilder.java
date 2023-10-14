package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.ingredient.Name;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Quantity;
import seedu.address.model.ingredient.Unit;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class IngredientBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    private Name name;
    private Quantity quantity;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public IngredientBuilder() {
        name = new Name(DEFAULT_NAME);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public IngredientBuilder(Ingredient ingredientToCopy) {
        name = ingredientToCopy.getName();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public IngredientBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    public IngredientBuilder withQuantity(double val, Unit unit) {
        this.quantity = new Quantity(val, unit);
        return this;
    }

    public Ingredient build() {
        return new Ingredient(name, quantity);
    }

}
