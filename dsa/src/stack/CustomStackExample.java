package stack;

public class CustomStackExample {

    public static void main(String[] args) throws Exception {
        CustomStack<String> cs = new DynamicCustomStack<>();
        cs.push("4");
        cs.push("3");
        cs.push("34");
        cs.push("42");
        cs.push("14");
        cs.push("14");
        cs.push("14");
        cs.push("14");
        cs.push("14");
        cs.push("14");
        cs.push("14");
        cs.push("14");
        cs.push("14");

        System.out.println(cs.pop());
        System.out.println(cs.peek());
        System.out.println(cs.pop());
        System.out.println(cs.peek());
    }
}
