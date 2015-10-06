import dao.DAOMethods;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class Demo {
        public static void main(String[] args) throws Exception {
            DAOMethods db = new DAOMethods();
            db.findAllAndReturnList();
    }
}
