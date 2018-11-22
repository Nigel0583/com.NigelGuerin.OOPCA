/**
 * Created by Nigel Guerin
 */
public interface CarSystemDriver {
     static void main(String[] args) {
        Login log = new Login("file:image/song.wav","cars.dat","fuel.dat","customer.dat");
        log.setVisible(true);
    }
}
