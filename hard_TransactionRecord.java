import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private Date date;

    public TransactionRecord() {
        this.date = new Date();
    }

    // Getters and Setters
}
