package by.aston.livecoding.exception;

public class ExceptionExample  {
    public static void main(String[] args) {
        try (Resource resource = new Resource()){
            resource.process();
        } catch (Exception e){
            System.out.println("Catch block");
        }
    }
}

class Resource implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Closing");
    }
    public void process(){
        System.out.println("Processing");
        throw new IllegalArgumentException("Runtime exception throws");
    }
}
