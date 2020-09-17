package logic;

public class CalculatorBean {
	private Status operation;
	private Integer firstMember;
	private Integer secondMember;
	private Integer result;
	
	
	public Status getOperation() {
		return operation;
	}
	public void setOperation(Status operation) {
		this.operation = operation;
	}
	public Integer getFirstMember() {
		return firstMember;
	}
	public void setFirstMember(Integer firstMember) {
		this.firstMember = firstMember;
	}
	public Integer getSecondMember() {
		return secondMember;
	}
	public void setSecondMember(Integer secondMember) {
		this.secondMember = secondMember;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
}
