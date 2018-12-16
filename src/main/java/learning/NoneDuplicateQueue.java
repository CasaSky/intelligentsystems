package learning;

import java.util.PriorityQueue;

public class NoneDuplicateQueue<T> extends PriorityQueue<T> {

    @Override
    public boolean offer(T t) {
        if (!super.contains(t)) {
            return super.offer(t);
        }
        return false;
    }
}
