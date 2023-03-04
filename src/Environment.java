import java.util.HashMap;
import java.util.Map;

// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

public class Environment {

	private Map<String, Integer> variables = new HashMap<String, Integer>();

	public int put(String var, int val) {
	    // Add or update a variable in the environment.
	    variables.put(var, val);
	    return val;
	}

	public int get(int pos, String var) throws EvalException {
	    // Get the value of a variable from the environment.
	    if (!variables.containsKey(var)) {
	        // If the variable is undefined, throw an exception and label the message.
	        throw new EvalException(pos, "undefined variable: " + var);
	    }
	    return variables.get(var);
	}

	public String toC() {
	    String s = "";
	    String sep = " ";
	    for (String v : variables.keySet()) {
	        s += sep + v;
	        sep = ",";
	    }
		return s == "" ? "" : "int" + s + ";\nx=0;x=x;\n";
	}
}