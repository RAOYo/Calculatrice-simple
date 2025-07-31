package operation;

public class SystemCalc {
    public static double strCalc (String a, String b, String operateur) throws NumberFormatException {
        switch (operateur) {
            case "+":
                return Double.parseDouble(a) + Double.parseDouble(b);
            case "-":
                return Double.parseDouble(a) - Double.parseDouble(b);
            case "*":
                return Double.parseDouble(a) * Double.parseDouble(b);
            case "^":
                return Math.pow(Double.parseDouble(a), Double.parseDouble(b));
            default:
                return Double.parseDouble(a) / Double.parseDouble(b);
        }
    }
}