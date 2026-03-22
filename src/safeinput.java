
import java.util.Scanner;
public class safeinput {

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);

        //String name = safeinput.getNonZeroLenString(pipe, "Enter your name");
        //System.out.println("Your name is: " + name);

        //int age = safeinput.getInt(pipe, "Enter your age");
        //System.out.println("Your age is: " + age);

        //double salary = safeinput.getDouble(pipe, "Enter your salary");
        //System.out.println("Your salary is: " + salary);

        //int age = safeinput.getRangedInt(pipe, "Enter your age", 0, 120);
        //System.out.println("Your age is: " + age);

        //double salary = safeinput.getRangedDouble(pipe, "Enter your salary", 0, 1000000);
        //System.out.println("Your salary is: " + salary);

        //boolean confirm = safeinput.getYNConfirm(pipe, "Do you want to continue?");
        //System.out.println("Your answer is: " + confirm);

        //String SSN = safeinput.getRegExString(pipe, "Enter your SSN", "^\\d{3}-\\d{2}-\\d{4}$");
        //String uc_id = safeinput.getRegExString(pipe, "Enter your UC ID", "^M\\d{5}$");
        //System.out.println("Your SSN is: " + SSN);

        //prettyHeader(pipe, "pretty header check");
    }







    /**
     * This method prompts the user for input and continues to prompt until a non-zero length string is entered.
     * @param pipe user input scanner
     * @param prompt shows the user checks if non zero false if is zero
     * @return
     */

    public static String getNonZeroLenString(Scanner pipe, String prompt){
        String retString = ""; // Set this to zero length. Loop runs until it isn't

        do {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();

        }while(retString.length() == 0);

        return retString;

    }

    /**
     * This method prompts the user for input and continues to prompt until a valid integer is entered.
     * @param pipe scanner to read inetger
     * @param prompt to show the user
     * @return a valid integer entered by the user
     */
    public static int getInt(Scanner pipe, String prompt){
        boolean done = false;
        int val = 0;

        do{
            System.out.print(prompt+ ": ");
            if (pipe.hasNextInt()) {
                val = pipe.nextInt();
                pipe.nextLine(); // consume the rest of the line
                done = true;
            }else{
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash);
            }
        }while (!done);
        return val;
    }


    /**
     * This method prompts the user for input and continues to prompt until a valid double is entered.
     * @param pipe scanner to read double
     * @param prompt to show the user
     * @return a valid double entered by the user
     */

    public static double getDouble(Scanner pipe, String prompt){
        boolean done = false;
        double val = 0;

        do{
            System.out.print(prompt+ ": ");
            if (pipe.hasNextDouble()) {
                val = pipe.nextDouble();
                pipe.nextLine(); // consume the rest of the line
                done = true;
            }else{
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash);
            }
        }while (!done);
        return val;
    }

    /**
     * This method prompts the user for input and continues to prompt until a valid integer within the specified range is entered.
     * @param pipe scanner to read integer
     * @param prompt to show the user
     * @param low minimum acceptable value
     * @param high maximum acceptable value
     * @return a valid integer within the specified range entered by the user
     */

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        int val = 0;

        do{
            System.out.print(prompt+ ": ");
            if (pipe.hasNextInt()) {
                val = pipe.nextInt();
                pipe.nextLine();

                if (val >= low && val <= high) {
                    done = true;
                }else{
                    System.out.println("Integer must be between " + low + " and " + high);
                    done = false;
                }



            }else{
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash);
            }
        }while (!done);
        return val;

    }

    /**
     * This method prompts the user for input and continues to prompt until a valid double within the specified range is entered.
     * @param pipe scanner to read double
     * @param prompt to show the user
     * @param low minimum acceptable value
     * @param high maximum acceptable value
     * @return a valid double within the specified range entered by the user
     */

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        boolean done = false;
        double val = 0;

        do{
            System.out.print(prompt+ ": ");
            if (pipe.hasNextDouble()) {
                val = pipe.nextDouble();
                pipe.nextLine();

                if (val >= low && val <= high) {
                    done = true;
                }else{
                    System.out.println("Double must be between " + low + " and " + high);
                }



            }else{
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash);
            }
        }while (!done);
        return val;

    }

    /**
     * This method prompts the user for input and continues to prompt until a valid "Y" or "N" is entered.
     * @param pipe scanner to read input
     * @param prompt to show the user
     * @return true if the user entered "Y", false if the user entered "N"
     */

    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean done = false;
        String val = "";
        String trash;
        do{
            System.out.print(prompt + " [Y/N]: ");
            val = pipe.nextLine();
            if (val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("N")) {
                done = true;
            }else {
                trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash);
            }

        }while (!done);
        return val.equalsIgnoreCase("Y");
    }

    /**
     * This method prompts the user for input and continues to prompt until a valid string matching the specified regular expression is entered.
     * @param pipe scanner to read input
     * @param prompt to show the user
     * @param regEx regular expression that the input must match
     * @return a valid string matching the specified regular expression entered by the user
     */

    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        boolean done = false;
        String val = "";
        do{
            System.out.print(prompt + ": ");
            val = pipe.nextLine();
            if (val.matches(regEx)) {
                done = true;
            }else {
                System.out.println("Input does not match the required format. " + regEx + "not " + val);

            }
        }while (!done);
        return val;


    }



    public static void prettyHeader(Scanner pipe, String prompt){
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        int prompt_length = prompt.length();
        int padding = (54 - prompt_length) / 2;


        String line = "***"
                + " ".repeat(padding)
                + prompt
                + " ".repeat(54 - prompt_length - padding)
                + "***";

        System.out.println();
        System.out.println(line);


        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }


    }


}

