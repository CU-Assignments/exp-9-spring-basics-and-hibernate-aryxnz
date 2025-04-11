import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BankingService service = ctx.getBean(BankingService.class);

        try {
            service.transfer(1, 2, 1000); // successful
            service.transfer(2, 3, 99999); // should fail (insufficient balance)
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        ctx.close();
    }
}
