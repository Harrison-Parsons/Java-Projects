import java.util.Scanner;

public class MorseCode {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to my Morse Code System.  Would you like to encode a word or decode a word?");
        System.out.println("A) Encode");
        System.out.println("B) Decode");
        System.out.print("> ");
        String input = in.nextLine();
        if (input.equalsIgnoreCase("a")){
            System.out.print("Enter Word to Encode: ");
            String value  = in.nextLine();
            System.out.println(value+" in morse code is "+encode(value, 0, 0));
        } else{
            System.out.print("Enter Morse Code to Decode (Must have three spaces between each letter): ");
            String value = in.nextLine();
            System.out.println(value+" in english is "+decode(value, 0, 0));
        }
    }

    public static String encode(String value, int a, int i) {
        String[] mc =
                {"._", "_...", "_._.", "_..", ".", ".._.", "__.", "....", "..", ".___", "_._",
                        "._..", "__", "_.", "___", ".__.", "__._", "._.", "...", "_", ".._", "..._",
                        ".__", "_.._", "_.__", "--.."};
        String[] ab = {"a", "b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String output = "";
        do {
            if (ab[a].equalsIgnoreCase(String.valueOf(value.charAt(i))) && i < value.length()){
                i++;
                output += mc[a] + "   ";
                a = 0;
            } else if (ab[a].equalsIgnoreCase(String.valueOf(value.charAt(i))) && i == value.length()){
                output += mc[a];
                return output;
            } else {
                a++;
            }
        } while (i < value.length());
    return output;
    }
    public static String decode(String value, int a, int i) {
        String[] mc =
                {"._", "_...", "_._.", "_..", ".", ".._.", "__.", "....", "..", ".___", "_._",
                        "._..", "__", "_.", "___", ".__.", "__._", "._.", "...", "_", ".._", "..._",
                        ".__", "_.._", "_.__", "--.."};
        String[] ab = {"a", "b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String output = "";
        String[] morseValue = value.split("   ");
        int arrayLength = 0;
        for (int l = 0; l < morseValue.length; l ++){
            if (morseValue != null){
                arrayLength ++;
            }
        }
        do {
            if (mc[a].equalsIgnoreCase(morseValue[i]) && i < arrayLength){
                i++;
                output += ab[a];
                a = 0;
            } else if (mc[a].equalsIgnoreCase(morseValue[i]) && i == arrayLength){
                output += ab[a];
                return output;
            } else {
                a++;
            }
        } while (i < arrayLength);
        return output;
    }
}
