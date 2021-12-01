package pl.sggw;

public class Main {
    public static void main(String[] args) {
        WzimBoundedQueue<Integer> q1 = new SimpleWzimBoundedQueue<>(3);
        q1.add(1);
        q1.add(2);
        q1.add(3);

        q1.offer(4);

        System.out.println(q1.size());
        System.out.println(q1.capacity());

    }
}
