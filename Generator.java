package PGapp;

import java.util.Scanner;
import java.util.Objects;


public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner){
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym){
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public void mainLoop(){
        System.out.println("Welcome to Ziz Password Services :)");
        printMenu();

        String userOption = "-1";

        while(!userOption.equals(4)){
            userOption = keyboard.next();

            switch(userOption){
               case  "1" : {
                requestPassword();
                printMenu();
                break;
               }

               case "2" : {
                checkPassword();
                printMenu();
                break;
               }

               case "3" : {
                printUsefulInfo();
                printMenu();
                break;
               }

               case "4" : {
                printQuitMessage();
                break;
               }
               default :  {
                System.out.println();
                System.out.println("kindly select one of the available commands");
                printMenu();
               }

               
            }
        }
    }

    private Password generatePassword(int length){
    
         StringBuilder pass = new StringBuilder();
         int alphabetLength  =  alphabet.getAlphabet().length();
         int max = alphabetLength-1;
         int min = 0;
         int range = max+min-1;

         for(int i = 0;i<length; i++){
            int index  = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(pass.toString());
    }
    
    private void printUsefulInfo(){
        System.out.println();
        System.out.println("use a minimum password length of 8 characters");
        System.out.println("must include lowercase, uppercase letters, digits and special characters");
        System.out.println("avoid using same password twice");
        System.out.println("avoid character repetition keyboard patterns, dictionary words, letter or number sequences in order to create a strong password");

    }
      
    private void requestPassword(){
      boolean IncludeUpper = false;
      boolean IncludeLower= false;
      boolean IncludeNum = false;
      boolean IncludeSym = false;

      boolean correctParams;

      System.out.println();
      System.out.println("Hello, welcome to the Password Generator :) answer"
                + " the following questions by Yes or No \n");

       do{
          correctParams = false;
          String input;

          do{
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            input = keyboard.next();
            PasswordRequestError(input);
          }while(!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));


          if(isInclude(input)) IncludeLower = true;

          do{
              System.out.println("Do you want Upercase letters \"ABCD...\" to be used? ");
              input = keyboard.next();
              PasswordRequestError(input);
          }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

          if(isInclude(input)) IncludeUpper = true;

          do {
            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = keyboard.next();
            PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeNum = true;

            do {
            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
            input = keyboard.next();
            PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeSym = true;

            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                correctParams = true;
            }
       }   while(correctParams);
       
       System.out.println("Great! Now enter the length of the password");
       int length = keyboard.nextInt();

       final Generator generator = new Generator(IncludeLower,IncludeUpper, IncludeNum, IncludeSym);
       final Password password = generator.generatePassword(length);

      System.err.println("your generated password -> "+ password);
    }

    private boolean isInclude(String input){
        if(input.equalsIgnoreCase("yes")){
            return true;
        }
        else{
            return false;
        }

    }

    private void PasswordRequestError(String s){
        if(!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")){
            System.out.println("you have netered something wrong let's go over it again!!!\n");
        }
    }

    private void checkPassword(){
        System.out.println("Enter your password");
        String input = keyboard.next();
        final Password p = new Password(input);
        System.out.println(p.calculateScore());
    }

    private void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
    }
    private void printQuitMessage() {
        System.out.println("Closing the program bye bye!");
    }
    
}
