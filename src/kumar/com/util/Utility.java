package kumar.com.util;

public class Utility {
	
    public static Integer checkValidInput(String input) throws IllegalArgumentException {
        Integer inputValue = Integer.parseInt(input);
        if (inputValue <= 0)
            throw new IllegalArgumentException();

        return inputValue;
    }


    public static void validatePositiveNumbers(Integer... numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Number should be > 0");
            }
        }
    }
    



}
