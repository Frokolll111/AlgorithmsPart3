package exception;

public class ElementMissingException extends  RuntimeException{
    public ElementMissingException(String massage) {
        super(massage);
    }
}
