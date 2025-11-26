public class Stack<T> {
    private T value;
    private Stack<T> next;

    public Stack() {}

    private Stack(T v, Stack<T> n) {
        value = v;
        next = n;
    }

    public Stack<T> push(T v) {
        return new Stack<>(v, this);
    }

    public Stack<T> pop() {
        return next;
    }

    public T top() {
        return value;
    }

    public boolean isEmpty() {
        return value == null && next == null;
    }
}