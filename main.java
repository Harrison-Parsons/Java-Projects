import java.util.*;

public class main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String formula = in.nextLine();

        System.out.println(degreeCoefficient(formula));

        System.out.println(addNegative(numFactors(-2)));

        System.out.println(possRoots(addNegative(numFactors(getConstant(termArray(formula)))), addNegative(numFactors(degreeCoefficient(formula)))));
    }
    public static int degreeCoefficient(String formula){
        formula.trim();
        if (formula.substring(0,1).equalsIgnoreCase("-")){
            String substring = formula.substring(0, 2);
            int returnValue = Integer.parseInt(substring);
            return returnValue;
        } else if (isNumeric(formula.substring(0,1)) == true){
            String substring = formula.substring(0,1);
            int returnValue = Integer.parseInt(substring);
            return returnValue;
        } else {
            return 0;
        }
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static String[] termArray(String formula){
        /*main formula that will actually parse into the array
        will have a ton of smaller functions supporting it
         */
        String[] arrayOfTerms = formula.split(" ");
        return arrayOfTerms;
    }

    public static int getConstant(String[] termArray){
        int arrayLength = termArray.length;
        String finalTerm = termArray[arrayLength-1];
        if(isNumeric(finalTerm) == true){
            return Integer.parseInt(finalTerm);
        } else {
            return Integer.parseInt(finalTerm.substring(1));
        }
    }

    public static int degreeValue(String formula){
        formula.trim();
        String substring = formula.substring(formula.indexOf("^")+1,formula.indexOf("^")+2);
        System.out.println(substring);
        int returnValue = Integer.parseInt(substring);
        return returnValue;
    }
    public static ArrayList<Integer> numFactors(int num){
        ArrayList<Integer> x = new ArrayList<Integer>();
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    x.add(i);
                }
            }
        } else {
            for (int i = -1; i>= num; i--){
                if (num%i == 0){
                    x.add(i);
                }
            }
        }
        return x;
    }
    public static ArrayList<Integer> addNegative(ArrayList<Integer> x){
        int z = x.size();
        for(int i = 0; i<z; i++){
            x.add(x.get(i)*-1);
        }
        return x;
    }

    public static ArrayList<Double> possRoots(ArrayList<Integer> constant, ArrayList<Integer> coefficient){
        int constantLength = constant.size();
        int coefficientLength = coefficient.size();
        int x = 0;
        int i = 0;
        double adge;
        ArrayList<Double> roots = new ArrayList<Double>();
        while(x <= constantLength){
            while(i < coefficientLength){
                adge = (double) constant.get(x)/coefficient.get(i);
                roots.add(adge);
                i++;
            }
            x++;
        }
        return roots;
    }
}