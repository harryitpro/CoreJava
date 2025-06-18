package basic.annotation;

public class MyService {
    @Loggable("DEBUG")
    public void process(String message) {
        System.out.println("processing message: " + message);
    }

    @Loggable()
    public String getResult() {
        return "Successful";
    }
}
