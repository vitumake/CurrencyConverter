import model.CConv;

public class Main {
    public static void main(String[] args) {
        CConv converter = new CConv();
        System.out.println(converter.convert("USD", 100, "EUR"));
    }
}
