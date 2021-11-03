// Phuong Pham
// 9/8/20221
// Pig Latin lab
import java.util.*;
import java.io.*;

public class PigLatin
{
   public static void main (String [] args) throws Exception
   {
      // *** UNCOMMENT ONLY ONE PART AT A TIME FOR TESTING ***
      
      //part1();      // user input and display output
      part2(false); // file input/output without extension
      //part2(true);  // file input/output with extension (words reversed)
   }
    
   // reads words from user at run-time and displays pig latin equivalent
   public static void part1()
   {
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("\nwhat word? (-1 to exit) ");
         String s = sc.next();
         if (s.equals("-1"))
            System.exit(0);
         String p = pig(s);
         System.out.println(p);
      }
   }
   
   // reads words from file at run-time and writes pig latin equivalents to file
   // if reverseWords is true, also writes pig latin words backwards to file
   public static void part2(boolean reverseWords) throws Exception
   {
      Scanner sc = new Scanner(System.in);
      PrintWriter outfile = new PrintWriter("output.txt");
      PrintWriter reverseOutfile = new PrintWriter("reverseOutput.txt");
      Scanner infile = null;
      String filename = null;
   
      do {
         System.out.print("Enter input filename: ");
         filename = sc.nextLine();
         try {
            infile = new Scanner(new File(filename));
         } catch (FileNotFoundException f) {
            System.out.println("That input file does not exist");
            filename = null;
         }
      } while (filename == null);
      
      while(infile.hasNextLine())
      {
         String line = infile.nextLine();
         String [] words = line.split(" ");
         for (int i = 0; i < words.length; i++)
         {
            String p = pig(words[i]);
            outfile.print(p + " ");
            if (reverseWords)
            {
               p = reverse(p);
               reverseOutfile.print(p + " ");
            }
         }
         outfile.println();
         reverseOutfile.println();
      }
      outfile.close();
      reverseOutfile.close();
   }

   // returns the pig latinized version of the word s
   public static String pig(String s)
   {
      // ******** PUT YOUR CODE HERE **********
      if (s.length()<=0) {
         return "";
      }
      String ss = findSpecialCases(s);
      ss = capitalization(s,ss);
      ss = punctuation(s, ss);
      return ss; // return pig latinized word instead
   }
   
   // ********* PUT ANY OF YOUR HELPER METHODS HERE **********
   public static String findVowel(String s) {
      char[] stringArr = s.toCharArray();
      String vowels = "aeiuoAEIUO";
      char[] vows = vowels.toCharArray();
      
      for (int i=0; i<stringArr.length; i++) {
         Character str = stringArr[i];
         for (char vow:vows) {
            Character v = vow;
            if (str.equals(v) && i==0) { //find vowel
               return s+"way";
            } else if (str.equals(v)) {
               return s.substring(i) + s.substring(0,1).toLowerCase() + s.substring(1,i) + "ay";
            }
         }
      }
      return "INVALID";
   }
   
   public static String findSpecialCases(String s) {
      char[] stringArr = s.toCharArray();
      
      for (int i=0; i<stringArr.length; i++) {
         Character str = stringArr[i];
         if (str.equals('y') || str.equals('Y') && i==0) { //special case y 
            return s.substring(1) + s.substring(0,1) + "ay";
         } else if (str.equals('y') || str.equals('Y')) {
            return s.substring(i) + s.substring(0,i) + "ay";
         }
         if (str.equals('u') || str.equals('U')){ //special case qu
            Character strBefore = stringArr[i-1];
            if (strBefore.equals('q') || strBefore.equals('Q')) {
               return s.substring(i+1) + s.substring(0,i+1) + "ay";
            }
         }
      }
      return findVowel(s);
   }
   
   public static String capitalization(String s, String ss) {
      if (Character.isUpperCase(s.charAt(0))) {
         return ss.substring(0,1).toUpperCase() + ss.substring(1);
      }
      return ss;
   }
   
   public static String punctuation(String s, String ss) {
      String[] puncts = new String[] {"." , "?" , "!", "\""};
      String beforePuncts = "";
      String afterPuncts = "";
      
      //delete all punctuations
      for (int a=0; a<puncts.length; a++) {
         for (int i=0; i<ss.length(); i++) {
            if (ss.substring(i,i+1).equals(puncts[a])) {
               ss = ss.substring(0,i) + ss.substring(i+1);
               i--;
            }
         }
      }
      
      //add punctuations
      while (s.substring(0,1).equals(puncts[3]) && s.substring(s.length()-1).equals(puncts[3])) {
         beforePuncts = s.substring(0,1);
         afterPuncts = s.substring(s.length()-1);
         s = s.substring(1,s.length()-1);
      }
      while (s.substring(s.length()-1).equals(puncts[0]) || s.substring(s.length()-1).equals(puncts[1]) || s.substring(s.length()-1).equals(puncts[2])) {
         afterPuncts = s.substring(s.length()-1) + afterPuncts;
         s = s.substring(0,s.length()-1);
      }
      
      return beforePuncts+ss+afterPuncts;
   }
   
   // ** EXTENSION **
   // returns the string s in reverse order (Cat returned as Tac)
   public static String reverse(String s)
   {
      return s;
   }
}