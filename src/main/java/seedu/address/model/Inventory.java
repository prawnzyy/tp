package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Quantity;
import seedu.address.model.ingredient.UniqueIngredientList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class Inventory implements ReadOnlyInventory {

    private final UniqueIngredientList ingredients;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        ingredients = new UniqueIngredientList();
    }

    public Inventory() {}

    /**
     * Creates an Inventory using the Ingredients in the {@code toBeCopied}
     */
    public Inventory(ReadOnlyInventory toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the ingredient list with {@code ingredients}.
     * {@code ingredients} must not contain duplicate ingredients.
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients.setIngredients(ingredients);
    }

    /**
     * Resets the existing data of this {@code Inventory} with {@code newData}.
     */
    public void resetData(ReadOnlyInventory newData) {
        requireNonNull(newData);

        setIngredients(newData.getIngredientList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasIngredient(Ingredient ingredient) {
        requireNonNull(ingredient);
        return ingredients.contains(ingredient);
    }

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public Quantity getQuantityOf(Ingredient ingredient) {
        requireNonNull(ingredient);
        return ingredients.getQuantityOf(ingredient);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addIngredient(Ingredient p) {
        ingredients.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void useIngredient(Ingredient target, Quantity quantity) {
        requireNonNull(target);
        ingredients.useIngredient(target, quantity);
    }

    /**
     * Removes {@code key} from this {@code Inventory}.
     * {@code key} must exist in the address book.
     */
    public void removeIngredient(Ingredient key) {
        ingredients.remove(key);
    }

    public void clear() {
        ingredients.clear();
    }
    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("persons", ingredients)
                .toString();
    }

    @Override
    public ObservableList<Ingredient> getIngredientList() {
        return ingredients.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Inventory)) {
            return false;
        }

        Inventory otherInventory = (Inventory) other;
        return ingredients.equals(otherInventory.ingredients);
    }

    @Override
    public int hashCode() {
        return ingredients.hashCode();
    }

}
