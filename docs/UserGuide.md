---
layout: default.md
title: "User Guide"
pageNav: 3
---

# RecipeBook User Guide

RecipeBook is a **desktop app for managing recipes and ingredient inventory, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Recipe Book can get your ingredient and recipe management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `recipebook.jar` from [here](https://github.com/AY2324S1-CS2103T-F10-3/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your Inventory App.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar recipebook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * add n/Flour q/10 u/kg (Add Command)
    * use n/Flour q/5 u/kg  (Use Command)
    * stock Flour           (Stock Command)

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Milk`.

* Items in square brackets are optional [Coming in V1.3].<br>
  e.g `n/NAME q/QUANTITY u/UNIT` can be used as `n/Milk q/1000 u/ml` or as `n/Milk q/1000`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[NAME]…​` can be used as ` ` (i.e. 0 times), `milk`, `milk flour` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME q/QUANTITY`, `q/QUANTITY n/NAME` is also acceptable.

* Parameters are case-insensitive.
* e.g. A parameter specified as `n/Milk` is functionally identical to `n/MILK` or `n/milk`.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding an ingredient: `add`

Adds an ingredient to stock.

Format: `add n/NAME q/QUANTITY u/UNIT`

<box type="tip" seamless>

**Tip:** If no unit is specified, the default unit for that kind of ingredient will be used. If the ingredient does not have default unit, then grams will be used.
</box> [Coming in V1.3]

Examples:
* `add n/Flour q/1 u/kg`
* `add n/Milk q/600 u/ml`
### Using up ingredients : `use`

Depletes a specified amount of an ingredient from stock.

Format: `use n/NAME [q/QUANTITY] [u/UNIT]`

* If no quantity and unit is provided, the entire stock of the specified ingredient will be depleted.
* If the quantity depleted exceeds the current quantity in stock, the entire stock will be depleted but will not go into the negative.

Examples:
*  `use n/Milk q/600 u/ml` Depletes the current quantity of milk by 600 ml.
*  `use n/Egg` Fully depletes the current quantity of egg.

### Finding the quantity of an ingredient by name: `stock`

Lists the quantity of the specified ingredients.

Format: `stock [NAME]…​`

* Multiple ingredients can be specified e.g. `stock Flour Butter` will return the quantities of both ingredients
* If no ingredients are specified, the quantity of all ingredients will be returned
* Only full words will be matched e.g. `Flou` will not match `Flour`
* For ingredients with names comprising multiple words, the first word must be matched e.g. `Bay` will match `Bay Leaves` but `Leaves` will not
* The unit specified will be the default unit of the ingredient

Examples:
* `stock Milk` returns `Milk: 100ml`
* `stock milk flour` returns `Milk: 100ml`, `Flour: 2000g`<br>

### Clearing all entries : `clear`

Clears all entries from the ingredient stock.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Viewing Specific Recipes
Views a specific recipe in the recipe list.

Format: `view [uuid]`
* `uuid` must be an integer greater than or equal to 1
* `uuid` integer value cannot exceed the total number of recipes loaded into the recipe book.
* to toggle back to listing all recipes, use the `list` command

Examples:
* `view 1` views the recipe with `uuid` of 1
* `view 21` views the recipe with `uuid` of 21

### Listing all Recipes : `list`

Lists out all recipes that is currently stored in the recipebook.

Format: `list`

### Adding Recipes `[coming in v1.3]`

Adds a new recipe to the recipe book. The new recipe will be put in view.

Format: `addrecipe n/NAME`

**Tip:** The added recipe will have an empty ingredient list and step list. These lists can be specified using the commands found in the **Modifying Recipes** section.

<box type="tip" seamless>


### Modifying Recipes `[coming in v1.3]`

### Deleting Recipes `[coming in v1.3`

### Saving the data

Inventory data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Inventory data are saved automatically as a JSON file `[JAR file location]/data/inventory.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, Inventory will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous [Br]eaking [Br]ead home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues
--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action    | Format, Examples                                                      |
|-----------|-----------------------------------------------------------------------|
| **Add**   | `add n/NAME q/QUANTITY [u/UNIT]…​` <br> e.g., `add n/milk q/600 u/ml` |
| **Clear** | `clear`                                                               |
| **Use**   | `use n/NAME [q/QUANTITY] [u/UNIT]`<br> e.g., `use n/milk q/200 u/ml`  |
| **Stock** | `stock [NAME]…​`<br> e.g., `stock milk egg`                           |
| **Help**  | `help`                                                                |
| **List**  | `list`                                                                |
| **View**  | `view [uuid]`                                                         |
