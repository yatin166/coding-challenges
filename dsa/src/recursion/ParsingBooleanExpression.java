package recursion;

public class ParsingBooleanExpression {

    private static boolean evaluate(String expression, int low, int high) {
        if (high - low == 1) {
            return expression.charAt(low) == 't';
        }

        char operator = expression.charAt(low);
        int counter = 0;
        boolean result = (operator == '|') ? false : true;
        int previous = low + 2;

        for (int i = low + 2; i < high; ++i) {
            char ch = expression.charAt(i);

            if ( counter == 0 && (ch == ',' || ch == ')') ) {
                boolean currentAnswer = evaluate(expression, previous, i);
                previous = i + 1;

                if (operator == '|')  {
                    result = result || currentAnswer;
                } else if (operator == '&') {
                    result = result && currentAnswer;
                } else {
                    result = !currentAnswer;
                }
            }

            if (ch == '(') {
                counter++;
            } else if (ch == ')') {
                counter--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "|(&(t,f,t),!(t))";
        System.out.println(evaluate(str, 0, str.length()));
    }
}
