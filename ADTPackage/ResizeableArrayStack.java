package ADTPackage;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/7/21 
 */

/**
 * A class of stacks whose entries are stored in an array.
 */
public final class ResizeableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
    private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
    public ResizeableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor
  
    public ResizeableArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);
      
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
		topIndex = -1;
        integrityOK = true;
    } // end constructor
    
    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    public T pop()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end isEmpty

    
    public void clear()
    {
        checkIntegrity();
            
        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        } // end while
        //Assertion: topIndex is -1

    } // end clear
    
    /**
     * Function that evaluates a postfix equation in the form of the string.
     * @param postfix equation you input, in postfix form. (With spaces in between to seperate multi-digit numbers)
     * @return an int that was popped from the stack after the operations are finished. */
    public int evaluatePostfix(String postfix) {
        StackInterface<Integer> valueStack = new ResizeableArrayStack<>();
        int index = 0;

        while(index < postfix.length()) {
            char nextCharacter = checkIfDigit(postfix.charAt(index));
            char numIndex = postfix.charAt(index);
            switch(nextCharacter)
            {
                case '~':
                    int num = 0; 
                  
                    while(Character.isDigit(numIndex)) 
                    { 
                        num = num*10 + (int)(numIndex-'0'); 
                        index++; 
                        numIndex = postfix.charAt(index); 
                    } // end while
                    index--; 
                
                    valueStack.push(num);
                    break;
                case '+' : 
                    int operandOne = valueStack.pop();
                    int operandTwo = valueStack.pop();
                    valueStack.push(operandTwo+operandOne);
                    break;
                case '-' : 
                    int operandA = valueStack.pop();
                    int operandB = valueStack.pop();
                    valueStack.push(operandB-operandA);
                    break;
                case '*' : 
                    int operandX = valueStack.pop();
                    int operandY = valueStack.pop();
                    valueStack.push(operandY*operandX);
                    break;
                case '/' : 
                    int operandAlpha = valueStack.pop();
                    int operandOmega = valueStack.pop();
                    valueStack.push(operandOmega/operandAlpha);
                    break;
                
                case '^' :
                    int operandFirst = valueStack.pop();
                    int operandSecond = valueStack.pop();

                    valueStack.push((int) Math.pow(operandSecond, operandFirst));
                    break;
                default: break;
            } // end switch
            
            index++; 
        } // end while
        return valueStack.peek();
    } // end evaluatePostfix
    
    /**
     * Method that doubles the stack length if the stack is full. */
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity
    
    /**
     * Method that checks whether the input is a digit
     * @param input a character that is going to be checked
     * @return the character '~' if the input is a digit or "input" if not a digit. */
    private char checkIfDigit(char input) //checks if character is a member of the alphabet
    {
        if(Character.isDigit(input)) 
            return '~'; //signifier for a letter of the alphabet
        else 
            return input;
    } // end checkIfDigit

    /** Checks if the Stack is not corrupt 
     * @throws  IllegalStateException throws exception if the integrity is not there*/
    private void checkIntegrity()
    {
        if(!integrityOK)
            throw new SecurityException("Stack object is corrupt.");
    } // end checkIntegrity
    
    /** Checks if the desired capacity exceeds the maximum capacity. 
     * @throws  IllegalStateException throws exception if the desired capacity is higher than the max capacity. */
    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack"
            + "whose capacity exceeds allowed"
            + " maximum of "+ MAX_CAPACITY); // end if
    } // end checkCapacity
} // end ArrayStack
