
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given base (basePart) as int.*
     * @param basePart a String representing a number in basis [2,16]
     * @return
     */
    public static int intBase(String basePart)
    {
        int base=0;
        if(Character.isDigit(basePart.charAt(0))) {//checking if base is a digit
            base = basePart.charAt(0) - '0';       //using ascii values of numbers to convert to int
        }
        else if(Character.isLetter(basePart.charAt(0))) { // checking if base is a letter
            base = basePart.charAt(0) - 'A' + 10; //using ascii values of letters to convert to int
        }
        return base;
    }
    /**
     * Convert the given number part (numberPart) as int.*
     * @param numberPart a String representing a number
     * @param c a char representing a char of a loop
     * @return
     */
    // a function that converts a char in the string of the number part to integer type;
        public static int intDigitNumber(String numberPart,char c)
    {
        int value = 0;
        if (Character.isDigit(c)) { //checking if the digit is a digit
            value = c - '0'; //using ascii values of numbers to convert to int
        } else if (Character.isLetter(c)) { // checking if the digit is a letter
            value = c - 'A' + 10;  //using ascii values of letters to convert to int
        }
        return value;
    }

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if(!isNumber(num)) //checking if the number is in a valid format
           return ans;
        if (!num.contains("b")) // handles the free number without b case
            if( num.matches("^[0-9]+$")) { //regex to set the specific case
                ans = Integer.parseInt(num);
                return ans;
            }
            int index = num.lastIndexOf('b'); //get the index of b in the string
            String numberPart = num.substring(0, index); //get the number part in the string by the index of b
            String basePart = num.substring(index + 1);//get the base part in the string by the index of b
            int base= intBase(basePart);
            ans =0;
            int pow = numberPart.toCharArray().length -1;
        for (char c : numberPart.toCharArray()) {
            ans+= Math.pow(base, pow )* intDigitNumber(numberPart, c);;
            pow= pow-1;

        }
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        // Check for null or empty string
        if (a == null || a.isEmpty())
            return false;
        if (!a.contains("b"))                     //handles the free number without b case
            return a.matches("^[0-9]+$");

        if (!a.matches("^[0-9A-F]+b[2-9A-G]$"))  // Check if the string matches the regex
            return false;
        int index = a.lastIndexOf('b');
        String numberPart = a.substring(0, index);
        String basePart = a.substring(index + 1);
        int base= intBase(basePart);
        if (base < 2 || base > 16)
            return false;
        for (char c : numberPart.toCharArray()) {
            if (intDigitNumber(numberPart, c) >= base)
                return false;
        }
        return true;
    }


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if(num<0 || base<2 || base>16)
        return ans;
        if(num == 0)     //handling the case where num is 0
            return "0b"+base;
        String temp= ""; // creating a temporary string to reverse it later
        if(base>=10) //if base needs to be a letter
        {
            char charForBase = (char) ('A'+ base- 10); //converting the base from int to char
            String s = Character.toString(charForBase); // converting to string
            temp= temp+ s +'b';
        } else if (base<10)
        temp= temp + base+ 'b';

        while(num>0) // a loop to take apart the digits of num
        {
            int value = num% base;
            temp+= value; //adding value to temp
            num= num/base;
        }
        for(int i =temp.length()-1;i>=0; i--) //reverse the function
        {
            ans+=temp.charAt(i);
        }
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2); // if thw value of the numbers equals
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int max=0;
        for(int i=0; i<arr.length; i++)
        {
            if(!isNumber(arr[i])) //checking if the number is valid
                return 0;
            if(number2Int(arr[i])>max) { //if the value of the number bigger than num
                max = number2Int(arr[i]);
                ans=i; //saving the index
            }
        }
        return ans;
    }
}
