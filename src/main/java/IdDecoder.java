import java.util.Scanner;

/**
 * Created by gladkiy_v on 13.04.2017.
 */
public class IdDecoder {
    public static void main(String[] args)   {
        System.out.println("Hello");
        boolean exit = false;
        boolean status = true;
        String inputLine = "";
        Scanner input = new Scanner(System.in);
        System.out.println("ID decoder");
        System.out.println("-----------------------");

        while(exit == false ) {
            System.out.println("-exit -close program       -h - help    -id -start convert");
            inputLine = input.nextLine();
            if(inputLine.compareTo("exit") == 0)
            {
                exit = true;
            }
            else if (inputLine.compareTo("id") == 0)
            {
                System.out.println("Enter your Id");
                inputLine = input.nextLine();
                status =  ChekInput(inputLine);
                if(status == false)
                {
                    System.out.println("Sorry. Something wrong. Try again");
                }
                else {
                    System.out.println("your ID: " + inputLine);
                    IdReport newReport= new IdReport(inputLine);
                    newReport.getReport();
                }
            }
            else if(inputLine.compareTo("help") == 0)
            {
                System.out.println("help file");
            }
            else
            {
                System.out.println("unnown command");
            }

        }
        System.out.println("Goodby!");
    }

    static boolean ChekInput(String s){

        boolean checkStatus = true;
        if(s.isEmpty())
        {
            System.out.println("You write anythig");
            System.out.println("Please, enter your ID");
            checkStatus = false;
        }
        if (s.length() != 11)
        {
            System.out.println("You write not 11 digits.");
            System.out.println("Please, enter 11 digits");
            checkStatus = false;
        }
        char[] c = s.toCharArray();
        boolean isDigit = true;
        for (char a:
                c) {
            if (a<48 || a > 57 ){
                isDigit = false;
                checkStatus = false;
            }
        }
        if (isDigit == false)
        {
            System.out.println("You write not digit");
            System.out.println("Please, enter only digits");
        }
        return checkStatus;
    }
}
