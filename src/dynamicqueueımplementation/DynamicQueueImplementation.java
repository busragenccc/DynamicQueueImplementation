
package dynamicqueueımplementation;


public class DynamicQueueImplementation {
 private int capacity = 2;
    int queueArr[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;

    public DynamicQueueImplementation(){
     queueArr = new int[this.capacity];
    }
    
    public void enqueue(int item) {
         
        if (isQueueFull()) {
            System.out.println("Queue is full, increase capacity...");
            increaseCapacity();
        }
        rear++;
        if(rear >= queueArr.length && currentSize != queueArr.length){
            rear = 0;
        }
        queueArr[rear] = item;
        currentSize++;
        System.out.println("Adding: " + item);
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            front++;
            if(front > queueArr.length-1){
                System.out.println("removed: "+queueArr[front-1]);
                front = 0;
            } else {
                System.out.println("removed: "+queueArr[front-1]);
            }
            currentSize--;
        }
    }

    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == queueArr.length){
            status = true;
        }
        return status;
    }
     
 
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }
    private void increaseCapacity(){
         
        //create new array with double size as the current one.
        int newCapacity = this.queueArr.length*2;
        int[] newArr = new int[newCapacity];
        //copy elements to new array, copy from rear to front
        int tmpFront = front;
        int index = -1;
        while(true){
            newArr[++index] = this.queueArr[tmpFront];
            tmpFront++;
            if(tmpFront == this.queueArr.length){
                tmpFront = 0;
            }
            if(currentSize == index+1){
                break;
            }
        }
        //make new array as queue
        this.queueArr = newArr;
        System.out.println("New array capacity: "+this.queueArr.length);
        //reset front & rear values
        this.front = 0;
        this.rear = index;
    }
   
    public static void main(String[] args) {
     DynamicQueueImplementation queue = new DynamicQueueImplementation();
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.enqueue(24);
        queue.enqueue(98);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(435);
        queue.dequeue();
        queue.dequeue();
    }
}
