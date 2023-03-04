import java.io.*;
/** This class represents the generated code 
 * that will be compiled and executed by the interpreter.
 * @author Luke Davis
*/

public class Code {
// Includes the standard C library "stdio.h" and the start of the main function.
private final String[] prologue={
"#include <stdio.h>",
"double main() {",
};
// Includes the return statement and the end of the main function.
private final String[] epilogue={
"return 0;",
"}",
};

//This constructor takes the code to be interpreted and the environment as parameters.
public Code(String code, Environment env) {
	// Retrieve the file name from the system environment variables.
	String fn=System.getenv("Code");
	if (fn==null)
		return; // if the environment variable is not set, return without doing anything.
	try {
		// Create file with .c extension.
		BufferedWriter f=new BufferedWriter(new FileWriter(fn+".c"));
		for (String s: prologue)
			f.write(s+"\n"); // Write the prologue strings to the file.
		
		f.write(env.toC()); // Write the environment to C code to the file.
		f.write(code); // Write the user code to the file.
		
		for (String s: epilogue) // Adds return 0;}
			f.write(s+"\n");
		
		f.close();		// Close the file.

	} catch (Exception e) {
		System.err.println(e); // If an exception occurs during file I/O, print the error message to standard error.
	}
  }
}
