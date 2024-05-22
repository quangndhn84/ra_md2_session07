package ra.session07.static_final;

import static ra.session07.static_final.AppConfig.*;

public class ConnectionDB {
    public static void main(String[] args) {
        System.out.println("DRIVER: " + DRIVER);
        System.out.println("URL: " + URL);
        System.out.println("USER NAME: " + USER_NAME);
        System.out.println("PASSWORD: " + PASSWORD);
    }
}
