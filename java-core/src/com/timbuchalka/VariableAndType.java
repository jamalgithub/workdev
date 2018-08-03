package com.timbuchalka;

public class VariableAndType {
	
	public void byteShortIntLong() {
		//int has a width of 8 bit
        System.out.println("Size byte " + Byte.SIZE);
        System.out.println("Min byte " + Byte.MIN_VALUE);
        System.out.println("Max byte " + Byte.MAX_VALUE);
        byte byte_value = Byte.MIN_VALUE;
        byte byte_new = (byte)(byte_value/2);
        System.out.println(byte_new);
        
        //short has a width of 16 bit
        System.out.println("\nSize short " + Short.SIZE);
        System.out.println("Min short " + Short.MIN_VALUE);
        System.out.println("Max short " + Short.MAX_VALUE);
        short short_value = Short.MIN_VALUE;
        short short_new = (short)(short_value/2);
        System.out.println(short_new);
        
        //int has a width of 32 bit
        System.out.println("\nSize int " + Integer.SIZE);
        int int_min = -2_147_483_648;
        System.out.println("Min int " + int_min);
        System.out.println("Max int " + Integer.MAX_VALUE);
        int int_new = int_min/2;
        System.out.println(int_new);
        
        //int has a width of 64 bit
        System.out.println("\nSize long " + Long.SIZE);
        long long_min = -9_223_372_036_854_775_808L;
        System.out.println("Min long " + long_min);
        System.out.println("Max long " + Long.MAX_VALUE);
        
        // 1. Create a byte variable and set it to any valid byte number.
        // 2. Create a short variable and set it to any valid short number.
        // 3. Create a int variable and set it to any valid in number.
        // 4. Create a variable of type long, and make it equal to
        //    50000 + 10 times the sum of the byte, plus the short plus the int

        byte byteValue = 10;
        short shortValue = 20;
        int intValue = 50;

        long longTotal = 50_000L + 10L * (byteValue + shortValue + intValue);
        short shortTotal = (short) (1000 + 10 * (byteValue + shortValue + intValue));
        System.out.println("\nlongTotal = " + longTotal);
        System.out.println("shortTotal = " + shortTotal);
	}

	public void floatDouble() {
		// width of int = 32 (4 bytes)
		System.out.println("Size int " + Integer.SIZE);
	    int myIntValue = 5 / 3;
        // width of float = 32 (4 bytes)
	    System.out.println("Size float " + Float.SIZE);
        float myFloatValue = 5f / 3f;
        // width of double = 64 (8 bytes)
        System.out.println("Size double " + Double.SIZE);
        double myDoubleValue = 5d / 3d;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue  = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        // Convert a given number of pounds to kilograms
        // 1. Create a variable to store the number of pounds
        // 2. Calculate the number of Kilograms for the number above and store in a variable.
        // 3. Print out the result.
        //
        // NOTES: 1 pound is equal to 0.45359237 kilograms.

        double numPounds = 200d;
        double convertedKilograms = numPounds * 0.45359237d;
        System.out.println("Kilograms = " + convertedKilograms);
        // 90.7185
        double pi = 3.141_592_7d;
        System.out.println("Pi = " + pi);
	}
	
	public void charBoolean() {
		// width of 16 (2 bytes)
		System.out.println("Size char " + Character.SIZE);
	    char myChar = '\u00A9';
        System.out.println("Unicode output was: " + myChar);
        
        boolean myBoolean = false;
        boolean isMale = true;

        // 1. Find the code for the registered symbol on the same line as the copyright symbol.
        // 2. Create a variable of type char and assign it the unicode value for that symbol.
        // 3. Display in on screen.

        char registeredSymbol = '\u00AE';
        System.out.println("Registered symbol = " + registeredSymbol);
	}
	
	public void string() {
		// byte
        // short
        // int
        // long
        // float
        // double
        // char
        // boolean

        String myString = "This is a string";
        System.out.println("myString is equal to " + myString);
        myString = myString + ", and this is more.";
        System.out.println("myString is equal to " + myString);
        myString = myString + " \u00A9 2015";
        System.out.println("myString is equal to " + myString);

        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println("The result is " + numberString);

        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("LastString is equal to " + lastString);
        double doubleNumber = 120.47;
        lastString = lastString + doubleNumber;
        System.out.println("LastString value: " + lastString);
	}
	
    public static void main(String[] args) {
    	VariableAndType vt = new VariableAndType();
    	
    	//vt.byteShortIntLong();
    	//vt.floatDouble();
        //vt.charBoolean();
    	vt.string();
    }
}
