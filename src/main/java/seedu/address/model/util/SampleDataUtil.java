package seedu.address.model.util;

import java.util.ArrayList;

import seedu.address.model.Inventory;
import seedu.address.model.Name;
import seedu.address.model.ReadOnlyInventory;
import seedu.address.model.ReadOnlyRecipeBook;
import seedu.address.model.RecipeBook;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Quantity;
import seedu.address.model.ingredient.Unit;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeStep;

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

    public static Recipe[] getSampleRecipes() {
        // Recipe 1
        Ingredient flour = new Ingredient(new Name("Flour"), new Quantity(200, Unit.GRAM));
        Ingredient milk = new Ingredient(new Name("Milk"), new Quantity(100, Unit.GRAM));
        Ingredient chocolateChips = new Ingredient(new Name("Chocolate Chip"), new Quantity(50, Unit.GRAM));
        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
        ingredientList.add(flour);
        ingredientList.add(milk);
        ingredientList.add(chocolateChips);

        RecipeStep first = new RecipeStep("Mix flour with Milk", 1);
        RecipeStep second = new RecipeStep("Add Chocolate Chips", 2);
        RecipeStep third = new RecipeStep("Bake at 180C for 20 minutes", 3);
        ArrayList<RecipeStep> recipeSteps = new ArrayList<RecipeStep>();
        recipeSteps.add(first);
        recipeSteps.add(second);
        recipeSteps.add(third);

        // Recipe 2
        Ingredient cakeFlour = new Ingredient(new Name("Flour"), new Quantity(200, Unit.GRAM));
        Ingredient egg = new Ingredient(new Name("Egg"), new Quantity(2, Unit.PIECE));
        Ingredient cream = new Ingredient(new Name("Cream"), new Quantity(50, Unit.GRAM));
        ArrayList<Ingredient> ingredientListCake = new ArrayList<Ingredient>();
        ingredientListCake.add(cakeFlour);
        ingredientListCake.add(egg);
        ingredientListCake.add(cream);

        RecipeStep cakeFirst = new RecipeStep("Mix flour with Egg", 1);
        RecipeStep cakeSecond = new RecipeStep("Add Cream", 2);
        RecipeStep cakeThird = new RecipeStep("Bake at 180C for 20 minutes", 3);
        ArrayList<RecipeStep> cakeRecipeSteps = new ArrayList<RecipeStep>();
        cakeRecipeSteps.add(cakeFirst);
        cakeRecipeSteps.add(cakeSecond);
        cakeRecipeSteps.add(cakeThird);
        return new Recipe[] {
            new Recipe(new Name("Cookie"), ingredientList, recipeSteps),
            new Recipe(new Name("Cake"), ingredientListCake, cakeRecipeSteps),
        };
    }

    public static ReadOnlyRecipeBook getSampleRecipeBook() {
        RecipeBook sampleRb = new RecipeBook();
        for (Recipe sampleRecipe : getSampleRecipes()) {
            sampleRb.addRecipe(sampleRecipe);
        }
        return sampleRb;
    }


    /*
      public static Set<Tag> getTagSet(String... strings) {
          return Arrays.stream(strings)
                  .map(Tag::new)
                  .collect(Collectors.toSet());
      }
    */
}
