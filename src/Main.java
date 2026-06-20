public class Main {
    static void main() {
        UserValidator validator = new UserValidator();
        validator.addRule(form -> form.email().contains("@"));
        validator.addRule(form -> form.password().length() >= 8);
        validator.addRule(form -> form.age() >= 18);

        UserForm form = new UserForm("anna@example.com", "bezpieczne123", 20);
        System.out.println(validator.isValid(form));

        ServiceOrder order = new ServiceOrder("Firma Alfa", 10, 120.0);
        PriceCalculator calculator = new PriceCalculator();

        PriceStrategy standard = o -> o.hours() * o.hourRate();
        PriceStrategy discount = o -> o.hours() * o.hourRate() * 0.90;
        PriceStrategy weekend = o -> o.hours() * o.hourRate() * 1.25;

        System.out.println(calculator.calculate(order, standard));
        System.out.println(calculator.calculate(order, discount));
        System.out.println(calculator.calculate(order, weekend));

        Order order = new Order("ORD-100", "Anna Kowalska");

        order.addItem(new Order.OrderItem("Klawiatura", 249.99, 1));
        order.addItem(new Order.OrderItem("Mysz", 99.99, 2));

        OrderSummary summary = new OrderSummary(order.getOrderNumber(),order.getCustomerName(),order.total());

        System.out.println(summary);

        LibraryAccount account = new LibraryAccount("Jan Nowak", 3, 5);
        LibraryAccount.FineCalculator calculator = account.new FineCalculator();

        double fine = calculator.calculate();

        MessagePrinter printer = message -> System.out.println("[BIBLIOTEKA] " + message);
        printer.print("Czytelnik: " + account.getReaderName() + ", opłata: " + fine + " zł");
    }
}
