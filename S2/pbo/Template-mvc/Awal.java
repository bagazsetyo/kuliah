import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Awal {

    public static void main() {
        Customer customer = new Customer();
        customer.select("*").where("kondisi1").where("kondisi2").groupBy("").orderBy("").get();
        customer.findBy("id", 1);
        customer.create(new String[]{"name", "age"}, new Object[]{"John Doe", 30});
        customer.update(new String[]{"name", "address"}, new Object[]{"John Doe", "New Address"});
        customer.deleteBy("id", 1);
    }
}
