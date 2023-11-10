package com.comp301.a01sushi;

public class EelPortion implements IngredientPortion {
  private final Ingredient ingredient;
  private final double amount;

  public EelPortion(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
    this.ingredient = new Eel();
    this.amount = amount;
  }

  @Override
  public Ingredient getIngredient() {
    return ingredient;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getName() {
    return ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return ingredient.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return ingredient.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return ingredient.getCaloriesPerOunce() * amount;
  }

  @Override
  public double getCost() {
    return ingredient.getPricePerOunce() * amount;
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (!ingredient.equals(other.getIngredient())) {
      throw new IllegalArgumentException("Cannot combine different ingredients");
    }
    double combinedAmount = this.amount + other.getAmount();
    return new EelPortion(combinedAmount);
  }
}
