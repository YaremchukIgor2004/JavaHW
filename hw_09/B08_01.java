package hw_09;

public class B08_01 {
    private Node top;

    private static class Node {
        Object value;
        Node next;

        Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(Object value) {
        top = new Node(value, top);
    }

    public Object pop() {
        if (top == null) {
            throw new IllegalStateException("Стек порожній");
        }
        Object value = top.value;
        top = top.next;
        return value;
    }

    public Object peek() {
        if (top == null) {
            throw new IllegalStateException("Стек порожній");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size(top);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.next);
    }

    public static void main(String[] args) {
    	B08_01 mixedStack = new B08_01();

        mixedStack.push(42); // Integer
        mixedStack.push("Hello, world!"); // String
        mixedStack.push(3.14); // Double

        System.out.println("Верхній елемент: " + mixedStack.peek() + " (тип: " + mixedStack.peek().getClass().getSimpleName() + ")");
        System.out.println("Розмір стека: " + mixedStack.size());
        Object removedElement = mixedStack.pop();
        System.out.println("Видалено з стека: " + removedElement + " (тип: " + removedElement.getClass().getSimpleName() + ")");
        System.out.println("Новий верхній елемент: " + mixedStack.peek() + " (тип: " + mixedStack.peek().getClass().getSimpleName() + ")");
        System.out.println("Новий розмір стека: " + mixedStack.size());
    }
}

