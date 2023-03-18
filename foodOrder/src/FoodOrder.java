import java.util.ArrayList;

public class FoodOrder {

    private String name;
    private int price;


    public FoodOrder(String name, int price){
        this.name = name;
        this.price = price;
    }

    public static int totalPrice(ArrayList<FoodOrder> food){
        int totalPrice = 0;
        for(int i=0; i<food.size(); i++){
            totalPrice += food.get(i).price;
        }
        return totalPrice;
    }

    public static void displayList(ArrayList<FoodOrder> food){
        for(int i=0; i<food.size(); i++){
            System.out.println(food.get(i).name + " (" + food.get(i).price + ")");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
