public class EvalException extends Exception {

	private int pos;
	private String msg;

	//passes in the position of error and messege to go with it
	public EvalException(int pos, String msg) {
		this.pos=pos;
		this.msg=msg;
	}

	//just prints the position and message
	public String toString() {
		return "eval error"
			+", pos="+pos
			+", "+msg;
	}

}
