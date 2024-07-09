package PGapp;

public class Password {
   String value;
   int length;

   public Password(String s){
      value = s;
      length = s.length();
   }

   public int CharType(char C){
    int val;

    if((int)C >= 65 && (int)C <=90)
    val = 1;

    else if((int)C >= 97 && (int)C <= 122)
    val = 2;

    else if((int)C>=48 && (int)C<=57)
    val = 3;

    else{
        val = 4;
    }
    return val;
   }

   public int passwordStrength(){
      String s = this.value;
      boolean UsedUpper  = false;
      boolean UsedLower  = false;
      boolean UsedNum  = false;
      boolean UsedSym  = false;
      int type;
      int score = 0;

      for(int i = 0;i<s.length();i++){
          char c = s.charAt(i);
          type = CharType(c);

          if(type == 1) UsedUpper  = true;
          if(type == 2) UsedLower  = true;
          if(type == 3) UsedNum  = true;
          if(type == 4) UsedSym  = true;
      }

      if(UsedUpper) score += 1;
      if(UsedLower) score += 1;
      if(UsedNum) score += 1;
      if(UsedSym) score += 1;

      if(s.length() >= 8) score += 1;
      if(s.length() >= 16) score += 1;

      return score;
   }

   public String  calculateScore(){
    int score = this.passwordStrength();

    if(score == 6){
        return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
    }
    else if(score >= 4 ){
        return "this is a good password but still u can  make it more strong";
    }

    else if(score>=3){
        return "this is a medium password";
    }
    else{
        return "this is a weak password";
    }
   }

   
   public String toString() {
    return value;
   }
}
