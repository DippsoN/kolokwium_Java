import java.util.Stack;

public class Nawiasy {

    private static final char LEWY_OKR = '(';
    private static final char PRAWY_OKR = ')';
    private static final char LEWY_KLAMR = '{';
    private static final char PRAWY_KLAMR = '}';
    private static final char LEWY_KWADR = '[';
    private static final char PRAWY_KWADR = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case LEWY_OKR:
                case LEWY_KLAMR:
                case LEWY_KWADR:
                    stack.push(c);
                    break;
                case PRAWY_OKR:
                    if (stack.isEmpty() || stack.pop()!= LEWY_OKR) return false;
                    break;
                case PRAWY_KLAMR:
                    if (stack.isEmpty() || stack.pop()!= LEWY_KLAMR) return false;
                    break;
                case PRAWY_KWADR:
                    if (stack.isEmpty() || stack.pop()!= LEWY_KWADR) return false;
                    break;
                default:
                    // Ignorujemy inne znaki
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String testString = "[()] {} {[() ()] ()}";
        System.out.println(isBalanced(testString)); 

        testString = "[(])";
        System.out.println(isBalanced(testString));
    }
}
