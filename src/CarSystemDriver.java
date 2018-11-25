/**
 * Created by Nigel Guerin
 */
public class CarSystemDriver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Login log = new Login("file:image/song.wav");
        log.setVisible(true);
    }
}
