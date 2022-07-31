package homeWork;

public class GroupOverFlowException extends Exception {
    public GroupOverFlowException(){
        super();
    }
    public GroupOverFlowException(String message, Throwable cause){
        super(message, cause);
    }
    public GroupOverFlowException(String message){
        super(message);
    }
    public GroupOverFlowException(Throwable cause){
        super(cause);
    }
}
