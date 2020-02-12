import java.util.logging.Level;
import java.util.logging.Logger;

public class Add {
    protected static Logger logger = Logger.getLogger(Add.class.getName());
    public static void main(String[] a) {
        if (a.length != 2) {
            logger.log(Level.SEVERE, "Must provide 2 integer parameters");
        } else {
            int first;
            int second;
            float third = 6.4f;
            try {
                first = Integer.parseInt(a[0]);
                second = Integer.parseInt(a[1]);
            } catch (NumberFormatException e) {
                logger.log(Level.SEVERE, "The parameters are not integers");
                return;
            }

            String result = String.format("%s + %s = %d and third is %f", a[0], a[1], first + second, third);
            logger.log(Level.INFO, result);
        }
    }
}
