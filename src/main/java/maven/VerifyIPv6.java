package maven;

import java.util.Scanner;

/**
 * Created by User on 05.12.2015.
 */
public class VerifyIPv6 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String id;
        System.out.print("Enter IPv6 to verify: ");
        id = userInput.next();
        if (Utils.isStringIPv6(id)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}