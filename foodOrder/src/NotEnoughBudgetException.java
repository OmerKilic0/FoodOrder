public class NotEnoughBudgetException extends Exception{

    String message;

    public NotEnoughBudgetException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
