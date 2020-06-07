package design;

class MyCircularQueue {

    private int[] data;
    private int head, tail, capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k+1];
        head = 0;
        tail = 0;
        capacity = k+1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if((tail + 1) % capacity == head){
            return false;
        }
        data[tail++] = value;
        tail %= capacity;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(head == tail){
            return false;
        }
        head++;
        head %= capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(head == tail){
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(head == tail){
            return -1;
        }
        return tail == 0 ? data[capacity - 1] : data[tail - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public static void main(String[] args){
        //["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
        //[[3],[1],[2],[3],[4],[],[],[],[4],[]]
        MyCircularQueue obj = new MyCircularQueue(3);
        obj.enQueue(1);obj.enQueue(2);obj.enQueue(3);obj.enQueue(4);
        System.out.println(obj.Rear());
        System.out.println(obj.isEmpty());
        obj.deQueue();
        obj.enQueue(4);
        System.out.println(obj.Front());
    }
}



/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
