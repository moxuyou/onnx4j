package org.onnx4j.exceptions;

public class GraphException extends ForwarderException {

	private static final long serialVersionUID = -9110594428291367746L;

	private static final int ERR_CODE_BASE = 20000;

	public enum GraphExceptionEnums implements ExceptionEnums {

		INPUT_UNDEFINED(ERR_CODE_BASE + 1, "Input of graph named %s can not be found"),
		NO_INPUTS_UNDEFINED(ERR_CODE_BASE + 2, "No any inputs defined in grpah"),
		OUTPUT_UNDEFINED(ERR_CODE_BASE + 3, "Output of graph named %s can not be found"),
		NO_OUTPUTS_UNDEFINED(ERR_CODE_BASE + 4, "No any outputs defined in grpah");

		public int code;
		public String message;

		private GraphExceptionEnums(int code, String message) {
			this.code = code;
			this.message = message;
		}

		@Override
		public int getCode() {
			return code;
		}

		@Override
		public String getMessage() {
			return message;
		}

	}

	public GraphException(GraphExceptionEnums exceptionEnum) {
		this(exceptionEnum, new Object[] {});
	}

	public GraphException(GraphExceptionEnums exceptionEnum, Object... args) {
		super(String.format(exceptionEnum.getMessage(), args));
	}

}
