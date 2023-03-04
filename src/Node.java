// This class, and its subclasses,
// collectively model parse-tree nodes.
// Each kind of node can be eval()-uated,
// and/or code()-generated.

public abstract class Node {

	protected int pos=0;

	// eval() method takes an environment object as a parameter and throws an EvalException when called.
	public int eval(Environment env) throws EvalException {
		throw new EvalException(pos,"cannot eval() node!");
	}

	// code() method returns an empty string by default.
	public String code() { return ""; }

}
