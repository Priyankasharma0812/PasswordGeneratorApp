package PGapp;

public class Alphabet {
    public static final String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    public static final String numbers = "0123456789";
    public static final String specialCharacters = "!@#$%^&*()_-?~\\/+=";

    private final StringBuilder pool;

    public Alphabet(boolean lowercaseIncluded, boolean uppercaseIncluded, boolean numbersIncluded,boolean specialCharactersIncluded){
        
        pool = new StringBuilder();

        if(uppercaseIncluded) pool.append(upperCaseLetters);

        if(lowercaseIncluded) pool.append(lowerCaseLetters);

        if(numbersIncluded) pool.append(numbers);

        if(specialCharactersIncluded) pool.append(specialCharacters);


    }
    public String getAlphabet(){
        return pool.toString();
    }
}
