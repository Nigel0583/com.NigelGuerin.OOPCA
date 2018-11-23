/**
 * Created by Nigel Guerin
 */
public class CarSystemDriver {
    public static void main(String[] args) {
        Login log = new Login("file:image/song.wav","cars.dat","fuel.dat","customer.dat");
        log.setVisible(true);
    }
}
