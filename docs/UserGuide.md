---
layout: default.md
title: "User Guide"
pageNav: 3
---

# [Ba]king [Br]ead User Guide

[Ba]king [Br]ead is a **desktop app for managing recipes and ingredient inventory, optimized for use via a 
Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). [Ba]king [Br]ead is targeted
towards bakers like yourselves to aid you on your baking journey. 

Tired of rummaging through your cupboard to check what ingredients and how much of it you have? Fret not, with [Ba]king [Br]ead, you will be able to manage your stock with ease so the next time you want
to bake something or go grocery shopping, you know exactly what you have! And if you are tired of having to flip through physical 
recipe books to find a recipe you want, once again [Ba]king [Br]ead has you covered! With [Ba]king [Br]ead you will be able to 
view your recipes with ease, making it much easier to manage your recipes! 

If you can type fast, [Ba]king [Br]ead can get your ingredient and recipe management tasks done faster than traditional GUI apps.

--------------------------------------------------------------------------------------------------------------------
## Table of Contents
* [Quick Start](#quick-start)
* [Navigating the GUI](#navigating-the-gui)
* [Features](#features)
  * [Help](#viewing-help-help)
  * [Add ingredient](#adding-an-ingredient-add)
  * [Use ingredient](#using-up-ingredients-use)
  * [Find quantity of ingredient](#finding-the-quantity-of-an-ingredient-by-name-stock)
  * [Clear ingredient list](#clearing-all-entries-from-ingredient-stock-clear)
  * [View list of all recipes](#listing-all-recipes-list)
  * [View a recipe](#viewing-specific-recipes-view)
  * [Add a recipe](#adding-recipes-addrecipe)
  * [Modify a recipe](#modifying-recipes-modify)
  * [Search for recipes that have an ingredient](#searching-recipes-given-an-ingredient-search)
  * [Exit the program](#exiting-the-program-exit)
  * [Save the data](#saving-the-data)
  * [Edit the data file](#editing-the-data-file)
* [FAQ](#faq)
* [Command Summary](#command-summary)

<div style="page-break-after: always;"></div>

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `bakingbread.jar` from [here](https://github.com/AY2324S1-CS2103T-F10-3/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for [Ba]king [Br]ead.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar bakingbread.jar` command to run the application.<br>
   A GUI similar to the one below should appear in a few seconds. Note how the app contains some sample data. For more
   information on how to navigate the GUI, head over to this [section](#navigating-the-gui). <br>
   ![Ui](images/Ui.png)

5. Type the command in the input box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * add n/Flour q/10 u/kg (Add Command)
    * use n/Flour q/5 u/kg  (Use Command)
    * stock Flour           (Stock Command)

6. Refer to the [Features](#features) below for details of each command.

## Navigating the GUI
![Ui](images/Ui-annotated.png)
**Input box:** This is where you will be inputting your commands.<br>
**Command result box:** Where the application will return a message regarding the outcome of command inputted.<br>
**Ingredients list:** Contain a list view of all your ingredients with their specified quantity and unit.<br>
**Recipe list:** Contains a list view of all your recipes.<br>

--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Milk`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[NAME]…​` can be used as ` ` (i.e. 0 times), `milk`, `milk flour` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME q/QUANTITY`, `q/QUANTITY n/NAME` is also acceptable.

* Parameters are case-insensitive.
  e.g. A parameter specified as `n/Milk` is functionally identical to `n/MILK` or `n/milk`.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` , `list` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

<div style="page-break-after: always;"></div>

### Adding an ingredient: `add`

Adds an ingredient to stock.

Format: `add n/NAME q/QUANTITY u/UNIT`

* If the ingredient already exists in the stock, using this command will add to the quantity specified for that 
  ingredient.

Restrictions:
* Units used must be supported.
* Quantity must be a positive number.
* If adding quantity to an ingredient that already exists, quantity conversions must be taken into account. If the unit 
  of the ingredient which is already in the stock is in GRAM/KILOGRAM, it cannot be converted to PIECE and vice versa.

Examples:
* `add n/Flour q/1 u/kg` adds 1kg of Flour to the stock.
* `add n/Milk q/600 u/g` adds 600g of Milk to the stock.

Supported Units:
| Unit     | Alias                                 |
|----------|---------------------------------------|
| GRAM     | g, gram, GRAM                         |
| KILOGRAM | kg, kilogram, KILOGRAM                |
| PIECE    | pc, pcs, piece, pieces, PIECE, PIECES |

### Using up ingredients : `use`

Depletes a specified amount of an ingredient from stock.

Format: `use n/NAME [q/QUANTITY] [u/UNIT]`

* If no quantity and unit is provided, the entire stock of the specified ingredient will be depleted.
* If the quantity depleted exceeds the current quantity in stock, the entire stock will be depleted but will not go into the negative.
* Note that the name **must** be exact. As such, `use butters` will not work if the ingredient list contains `butter`.

Restrictions:
* Units used must be supported.
* The quantity provided must be more than 0.
* When depleting the quantity of the ingredient, quantity conversions must be taken into account. If the unit
  of the ingredient that is in the stock is in GRAM/KILOGRAM, the use command cannot be inputted with the unit PIECE for that 
  specific ingredient and vice versa. For example, if the ingredient in the stock is 100g of Flour, `use n/flour q/50 u/pcs`
  would throw an error.
* When using up an ingredient, an error will be shown if the user inputs either the quantity or the unit. It is only 
  possible for both the unit and quantity to be stated or neither.

Examples:
*  `use n/Milk q/600 u/g` Depletes the current quantity of milk by 600g.
*  `use n/Egg` Fully depletes the current quantity of egg.

Supported Units:
| Unit     | Alias                                 |
|----------|---------------------------------------|
| GRAM     | g, gram, GRAM                         |
| KILOGRAM | kg, kilogram, KILOGRAM                |
| PIECE    | pc, pcs, piece, pieces, PIECE, PIECES |


### Finding the quantity of an ingredient by name: `stock`

Lists the quantity of the specified ingredients.

Format: `stock [NAME]…​`

* Multiple ingredients can be specified e.g. `stock Flour Butter` will return the quantities of both ingredients.
* If no ingredients are specified, the quantity of all ingredients will be returned.
* Only full words will be matched e.g. `Flou` will not match `Flour`.
* For ingredients with names comprising multiple words, any ingredient that contains the keyword will also be displayed 
   <br/> e.g. `stock butter` will display both `butter` and `butter stick`.

Examples:
* `stock Butter` returns `Butter: 50g`.
* `stock Butter flour` returns `Butter: 100g`, `Flour: 2000g`.<br>

### Clearing all entries from ingredient stock : `clear`

Clears all entries from the ingredient stock.

Format: `clear`

### Listing all Recipes : `list`

Lists out all recipes that is currently stored in [Ba]king [Br]ead.

Format: `list`

Examples:
* `list` lists out all recipes within [Ba]king [Br]ead.

### Viewing Specific Recipes : `view`

Views a specific recipe in [Ba]king [Br]ead.

Format: `view UUID`
* `UUID` must be an integer greater than or equal to 1.
* To toggle back to listing all recipes, use the `list` command.

Examples:
* `view 1` views the recipe with `UUID` of 1.
* `view 21` views the recipe with `UUID` of 21.

### Adding Recipes : `addrecipe`

Adds a new recipe to the recipe book. Each line in this command should be entered one by one.

Format: 
```
addrecipe 
NAME
(INGREDIENT_NAME) (INGREDIENT_QUANTITY)(INGREDIENT_UNIT)
⋮
steps start
1. STEP 1
2. STEP 2
⋮
complete recipe
```

* Name of Recipe needs to be of Alphanumeric format.
* Ingredients inputted **must** be of the format `(name) (quantity)(unit)` where an example is `flour 100g`.
* The quantity of the ingredient must be positive and the unit must be supported.
* For the recipe steps, the format to follow is `(index). (step)` where an example is `1. Mix Water and Flour`.
* For the recipe steps, you have to remember the index of step you are typing in and check it by yourself.

Example:
```
addrecipe
Bread
Water 100g
Flour 1kg
steps start
1. Mix Water and Flour
2. Bake at 180C
complete recipe
```

<box type="tip" seamless>

**Caution:** As this function relies heavily on the user's input, please do check that your input is of the correct format.
</box>

### Modifying Recipes : `modify`

Modifies the ingredients in a recipe.

Format: `modify i/UUID n/NAME q/QUANTITY u/UNIT`
* `UUID` must be an integer greater than or equal to 1.
* The quantity provided must be more than 0.
* The unit used must be supported.

Example:
* Assuming flour is used in the recipe, `modify i/1 n/Flour q/100 u/g` modifies the quantity and unit of the `Flour` ingredient in the recipe.
* Assuming flour is not used in the recipe, `modify i/1 n/Flour q/100 u/g` adds the `Flour` ingredient with its quantity 
  and unit to the recipe.

Note: After a recipe has been modified, it will be pushed to the bottom of the recipe list.

<div style="page-break-after: always;"></div>


### Deleting Recipes : `delete`

Deletes a specific recipe from [Ba]king [Br]ead when you longer need it.

Format: `delete UUID`

* `UUID` must be an integer greater than or equal to 1.

Examples:
* `delete 1` deletes the recipe with `UUID` of 1.
* `delete 21` deletes the recipe with `UUID` of 21.

### Searching Recipes given an ingredient: `search`

Searches for recipes that includes a specific ingredient in the recipe.

Format: `search NAME`

* `NAME` cannot be empty.
* `NAME` is not case-sensitive.
*  If none of the recipes contain that ingredient, an empty recipe list will be displayed instead.
*  For ingredients with multiple words, `NAME` must be an **exact** match. As such, search chocolate will not display recipes
   that contain chocolate chip.

Examples:
* `search flour` searches for all recipes that uses `flour`
* `search butter` searches for all recipes that uses `butter`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

Inventory and Recipe data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

**Tip**: When the application loads for the first time and no command is run, no inventory or recipe data will be saved.

### Editing the data file

Inventory data are saved automatically as a JSON file `[JAR file location]/data/inventory.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, Inventory will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous [Ba]king [Br]ead home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

**Note**: For `AddRecipe`, each command is to be run line and line.

| Action        | Format, Examples                                                                                                                                                                    |
|---------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**       | `add n/NAME q/QUANTITY u/UNIT` <br> e.g., `add n/milk q/600 u/g`                                                                                                                    |
| **Clear**     | `clear`                                                                                                                                                                             |
| **Use**       | `use n/NAME [q/QUANTITY] [u/UNIT]`<br> e.g., `use n/milk q/200 u/g`                                                                                                                 |
| **Stock**     | `stock [NAME]…​`<br> e.g., `stock milk egg`                                                                                                                                         |
| **List**      | `list`                                                                                                                                                                              |
| **View**      | `view UUID`<br/> e.g., `view 1`                                                                                                                                                     |
| **AddRecipe** | `addrecipe` `NAME QUANTITY…​` `steps start` `1. STEP 1` `complete recipe`<br/> e.g., `addrecipe` `Water 100g` `Flour 1kg` `steps start` `1. Mix Water with Flour` `complete recipe` |
| **Delete**    | `delete UUID`<br/> e.g., `delete 1`                                                                                                                                                 |
| **Search**    | `search NAME`<br/> e.g., `search flour`                                                                                                                                             |
| **Modify**    | `modify i/UUID n/NAME q/QUANTITY u/UNIT`<br/> e.g., `modify i/1 n/Flour q/100 u/g`                                                                                                  |
| **Help**      | `help`                                                                                                                                                                              |
| **Exit**      | `exit`                                                                                                                                                                              |
