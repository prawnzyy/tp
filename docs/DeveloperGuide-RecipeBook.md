## **Appendix: Requirements**

### Product Scope

**Target User Profile**

- is a home-baker
- has a need to manage and use their inventory of ingredients
- has a need to manage a significant amount of recipes and view the ingredients needed
- is reasonably comfortable using CLI apps
- prefer desktop apps over other types
- can type fast

**Value Propositions**

Home-bakers often struggle with managing their recipe book as well as checking if they have the ingredients needed for
a particular recipe. This application is designed for home-bakers to search for the recipes that they want along with 
the necessary ingredients required to make baking a more convenient and easy process.

**User Stories**

Priorities: High (must have) - `***`, Medium (nice to have) - `**`, Low (unlikely to have) - `*`

| Priority | As a... |                              I want to ... | So that I can ...                                |
|:---------|:-------:|-------------------------------------------:|--------------------------------------------------|
| `***`    |  baker  |                              view my stock | know what and the quantity of ingredients I have |
| `***`    |  baker  |                add ingredients to my stock | update the stock I have                          |   
| `***`    |  baker  | reduce ingredients' quantities in my stock | update the stock I have after I used the items   | 
| `***`    |  baker  |                             clear my stock | have an empty stock                              |
| `***`    |  baker  |                       find recipes by name | find a specific recipe                           |     
| `***`    |  baker  |                               view recipes | see the steps and ingredients involved           |   
| `***`    |  baker  |             add recipes to the recipe book | add new recipes in my recipe book                |
| `**`     |  baker  |                             modify recipes | make changes to the recipes as required          |
| `***`    |  baker  |   view the ingredients needed for a recipe | know if I have the necessary ingredients         |
| `***`    |  baker  |                           request for help | learn how to use the recipe book when I'm lost   |

{More to be added}

### Use Cases
(For all use cases below, the System is the RecipeBook and the Actor is the user, unless specified otherwise)

#### Use case: Add an ingredient to the stock
#### MSS
1. User requests to add a specific ingredient to their stock
2. RecipeBook adds that ingredient to the stock
   
   Use case ends.

#### Extensions
- 2a. User does not specify the quantity of that ingredient 
  - RecipeBook shows an error message 
- 2b. The name of the ingredient is not recognised
  - RecipeBook shows an error message
- 2c. The specified unit is not recognised
  - RecipeBook shows an error message

#### Use case: Reduce items' quantities in the stock
#### MSS
1. User requests to use up specific quantities of an ingredient
2. RecipeBook reduces the quantity of that ingredient in the stock
   Use case ends.

#### Extensions
- 2a. User does not specify the quantity of that ingredient used
    - RecipeBook depletes the entire quantity of that ingredient
- 2b. The quantity the user requests to use is more than the current quantity in stock
    - RecipeBook depletes the entire quantity of that ingredient
- 2c. The specified unit is not recognised
    - RecipeBook shows an error message


#### Use case: View the stock of ingredients
#### MSS
1. User requests to view the stock of specific ingredients
2. RecipeBook shows the ingredient and the quantity of the ingredient
   Use case ends.


#### Extensions
- 2a. User does not specify what ingredients they would like to view 
  - RecipeBook shows the entire stock of ingredients 
- 2b. The specified ingredient(s) are not in the stock 
  - RecipeBook shows an error message

#### Use case: Find a specific recipe
#### MSS
1. User requests to view a specific recipe
2. RecipeBook shows the corresponding recipe
   Use case ends.

#### Extensions
- 2a. The specified recipe does not exist
  - RecipeBook shows an error message


### Non-Functional Requirements

1. The system should work on any *mainstream* OS as long as it has Java `11` installed.
2. The system should be able to hold 500 ingredients and recipes in total without any noticeable sluggishness.
3. The system should be usable by any novice who is not familiar with computer programs.
4. The system should be understandable by any novice who is not familiar with baking.
5. The system should log error messages for user debugging & bug reporting purposes.
6. The system should be well-documented for future extension and maintainability.
7. The system should be backwards-compatible with data from older versions.

### Glossary
- Mainstream OS: Windows, Linux, OS-X
