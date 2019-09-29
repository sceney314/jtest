package patten.builder;

/**
 * @author zhengzp
 * 2019-09-26 20:49
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder meal = new MealBuilder();

        Meal vegMeal = meal.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showProducts();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = meal.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showProducts();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }

}
