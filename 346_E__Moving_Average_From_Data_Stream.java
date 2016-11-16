public class MovingAverage {
    int num;
    int index;
    int lastMovingTotal;
    int[] elementsInWindow;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        lastMovingTotal = 0;
        num = 0;
        index = 0;
        elementsInWindow = new int[size];
    }
    
    public double next(int val) {
        if (num < elementsInWindow.length) num++;
        
        lastMovingTotal += val;
        lastMovingTotal -= elementsInWindow[index];
        elementsInWindow[index] = val;
        index = (index + 1) % elementsInWindow.length;
        
        return (double)lastMovingTotal / (double)num;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */