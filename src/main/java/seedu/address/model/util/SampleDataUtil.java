package seedu.address.model.util;

import seedu.address.model.Inventory;
import seedu.address.model.ReadOnlyInventory;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.Name;
import seedu.address.model.ingredient.Quantity;
import seedu.address.model.ingredient.Unit;

/**
 * Contains utility methods for populating {@code Inventory} with sample data.
 */
public class SampleDataUtil {
    public static Ingredient[] getSampleIngredients() {
        return new Ingredient[] {
            new Ingredient(new Name("Flour"), new Quantity(3, Unit.KILOGRAM)),
            new Ingredient(new Name("Butter"), new Quantity(50, Unit.GRAM)),
            new Ingredient(new Name("Baking Soda"), new Quantity(50, Unit.GRAM)),
            new Ingredient(new Name("Chocolate Chip"), new Quantity(300, Unit.GRAM)),
            new Ingredient(new Name("Vanilla Extract"), new Quantity(100, Unit.GRAM)),
        };
    }

    public static ReadOnlyInventory getSampleInventory() {
        Inventory sampleAb = new Inventory();
        for (Ingredient sampleIngredient : getSampleIngredients()) {
            sampleAb.addIngredient(sampleIngredient);
        }
        return sampleAb;
    }

    /*
      public static Set<Tag> getTagSet(String... strings) {
          return Arrays.stream(strings)
                  .map(Tag::new)
                  .collect(Collectors.toSet());
      }
    */
}
