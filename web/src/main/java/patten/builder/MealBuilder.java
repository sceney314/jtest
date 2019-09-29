package patten.builder;

/**
 * 指挥者
 * 2019-09-26 20:48
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addProduct(new VegBurger());
        meal.addProduct(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addProduct(new ChickenBurger());
        meal.addProduct(new Pepsi());
        return meal;
    }

}
