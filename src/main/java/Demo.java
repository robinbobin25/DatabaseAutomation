import dao.MethodsWithPoolConnection;
import dao.MethodsWithSimpleConnection;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class Demo {
        public static void main(String[] args) throws Exception {
//            MethodsWithSimpleConnection db = new MethodsWithSimpleConnection();
//            db.findAllAndReturnList();

            MethodsWithPoolConnection db2 = new MethodsWithPoolConnection();
            db2.fromThePool();
    }
}