public class NegativeBudgetException extends Exception {

    String message;

    public NegativeBudgetException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
