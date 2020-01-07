package mcaSem5;

class MyException extends Exception 
{ 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String s) 
    {  
        super(s); 
    } 
} 

public class CustomException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        { 
            throw new MyException("My custom exception"); 
        } 
        catch (MyException ex) 
        { 
            System.out.println("Caught"); 

            System.out.println(ex.getMessage()); 
        }

	}

}
