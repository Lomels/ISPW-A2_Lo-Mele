package logic;

public class CalculatorController {

	public Float doOperations(CalculatorBean bean) throws Exception {
		switch (bean.getOperation()) {
		case PLUS:
			return addition(bean.getFirstMember(), bean.getSecondMember());
		case MINUS:
			return subtraction(bean.getFirstMember(), bean.getSecondMember());
		case TIMES:
			return time(bean.getFirstMember(), bean.getSecondMember());
		case DIVIDE:
			return divide(bean.getFirstMember(), bean.getSecondMember());
		case LOG:
			return logarithm(bean.getFirstMember(), bean.getSecondMember());
		default:
			return null;
		}
	}

	private Float addition(Integer firstMember, Integer secondMember) {
		return (float) (firstMember + secondMember);
	}

	private Float subtraction(Integer firstMember, Integer secondMember) {
		return (float) (firstMember - secondMember);
	}

	private Float time(Integer firstMember, Integer secondMember) {
		return (float) (firstMember * secondMember);
	}

	private Float divide(Integer firstMember, Integer secondMember) throws Exception {
		if (secondMember == 0) {
			throw new Exception("You cannot divide by zero!");
		}
		return (float) (firstMember / secondMember);

	}

	private Float logarithm(Integer firstMember, Integer secondMember) throws Exception {
		if(secondMember <= 0 || firstMember <= 0) {
			throw new Exception("Log argument or base cannot be <= 0");
		}
		return (float) (Math.log(firstMember) / Math.log(secondMember));
	}
}
