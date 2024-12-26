package by.aston.lesson12;

public class ExceptionExample3 {
    public static void main(String[] args) {
        try (Main main = new Main()) {

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }


}
