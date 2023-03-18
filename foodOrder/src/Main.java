import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static int setBudget() throws NegativeBudgetException {

        System.out.print("Enter your budget:");
        int budget = Integer.parseInt(scan.nextLine());
        if (budget > 0) {
            return budget;
        } else if (budget < 0) {
            throw new NegativeBudgetException("Budget cannot be negative!");
        }
        return budget;
    }

    public static void controlBudget(int sum, int budget) throws NotEnoughBudgetException{
        if(budget < sum){
            throw new NotEnoughBudgetException("Budget is not enough!");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("errors.txt"));

        ArrayList<FoodOrder> foods = new ArrayList<>();
        ArrayList<FoodOrder> foodsChosen = new ArrayList<>();
        int flag;
        do {
            flag = 0;
            try {
                System.out.print("Enter file name: ");
                String fileName = scan.nextLine();
                File f = new File(fileName);
                Scanner scanFood = new Scanner(f);


                while (scanFood.hasNext()) {
                    FoodOrder food = new FoodOrder(scanFood.next(), scanFood.nextInt());
                    foods.add(food);
                }
            } catch (FileNotFoundException exception) {
                flag = 1;
                System.out.println("File does not exist!");
                writer.write("File does not exist!");
            }

        } while (flag == 1);

        int budget;
        do {
            flag = 0;
            try {
                budget = setBudget();
                System.out.println("Available food items are: ");
                FoodOrder.displayList(foods);

                System.out.print("Which food items do you want to buy? (0 to stop)  ");
                int choice = Integer.parseInt(scan.nextLine());
                while (choice != 0) {
                    FoodOrder foodOrder = new FoodOrder(foods.get(choice - 1).getName(), foods.get(choice - 1).getPrice());
                    foodsChosen.add(foodOrder);
                    choice = Integer.parseInt(scan.nextLine());
                }

                int sum = FoodOrder.totalPrice(foodsChosen);

                if (sum <= budget) {
                    System.out.println("You have bought: ");
                    for (FoodOrder foodOrder : foodsChosen) {
                        System.out.println(foodOrder.getName());
                    }
                }
                else{
                    controlBudget(sum, budget);
                }
            } catch (NegativeBudgetException e) {
                flag = 1;
                System.out.println(e.getMessage());
                writer.write("Budget cannot be negative!");
            }catch (NotEnoughBudgetException ex){
                flag = 1;
                System.out.println(ex.getMessage());
                writer.write("Budget is not enough!");
            }
        } while (flag == 1);

    }
}
