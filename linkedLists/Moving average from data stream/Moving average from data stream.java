/*Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3*/

class MovingAverage {

    Deque<Integer> l;
    int sizeLimit;
    double res;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.sizeLimit = size;
        l = new LinkedList<Integer>();
        res = 0.0;
    }
    
    public double next(int val) {
        if(l.size() == sizeLimit)
            res -= l.removeFirst();
        res += (double) val;
        l.add(val);
        return res/(double)l.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */