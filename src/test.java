
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playagain = safeinput.getYNConfirm(in, "Do you want to play again?");
        System.out.println(playagain);

    }

}
