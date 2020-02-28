package se_Doronin.module3.activity;


/**
 * @author John Doe
 * <p>
 * This class represents a stack structure (Last-In, First-Out) implemented using
 * an array
 */
public class ArrayStack {

    private Object stack[];
    int count;

    /**
     * Create an instance of an ArrayStack.  A negative number specified in the constructor
     * will default the maximum to 1
     *
     * @param maximum number of elements the stack can hold
     */
    public ArrayStack(int maximum) {
        if (maximum < 0) {
            maximum = 1;
        }

        stack = new Object[maximum];
        count = 0;
    }

    /**
     * Returns the last element added to the stack
     *
     * @return the last element added or null if the stack is empty
     */
    public Object peek() {

        Object temp;
        if (count == 0)
            temp = null;
        temp = stack[count - 1];

        return temp;
    }

    /**
     * Pushes the specified element into the top of the stack
     *
     * @param element the element to be pushed
     * @return true if successful, false otherwise (due to stack being full)
     */
    public boolean push(Object element) {
        if (count >= getMaximum())
            return false;
        stack[count] = element;
        return true;
    }

    /**
     * Removes and returns the last element added to the stack
     *
     * @return the last element added or null if the stack is empty
     */
    public Object pop() {

        Object temp = null;

        if (count == 0)
            return null;
        count--;
        temp = stack[count];
        return temp;
    }


    /**
     * Returns the position of the first element found in the stack (using the == criterion) relative
     * to the top of the stack.  The top of the stack will be position 0
     *
     * @param element The element to find
     * @return The position of the element
     */
    public int findElement(Object element) {
        int numeration = getMaximum();
        for (int i = 0; i < getMaximum(); i++) {
            numeration--;
            if (stack[i].equals(element))
                return numeration;
        }
        return -1;
    }

    /**
     * Returns the number of elements currently contained in the stack
     *
     * @return current number of elements in the stack
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the number of elements the stack can hold
     *
     * @return maximum number of elements
     */
    public int getMaximum() {
        return stack.length;
    }
}
	

