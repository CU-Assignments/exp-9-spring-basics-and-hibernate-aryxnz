import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class BankingService {
    private SessionFactory factory;

    public BankingService(SessionFactory factory) {
        this.factory = factory;
    }

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Session session = factory.getCurrentSession();

        Account from = session.get(Account.class, fromId);
        Account to = session.get(Account.class, toId);

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        TransactionRecord tr = new TransactionRecord();
        tr.setFromAccountId(fromId);
        tr.setToAccountId(toId);
        tr.setAmount(amount);

        session.save(tr);
    }
}
