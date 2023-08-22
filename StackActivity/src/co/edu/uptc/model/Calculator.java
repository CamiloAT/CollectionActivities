package co.edu.uptc.model;

import java.util.Stack;

public class Calculator {

	private boolean isNumber(String number){
		boolean flag = true;
		try {
			Double.parseDouble(number);
		} catch (NumberFormatException nfe){
			flag=false;
		}
		return flag;
	}

	private String manageParentheses(String operation) {
		String parentheses = "";
		boolean flag = true;
		for (int i = 0; i < operation.length(); i++) {
			if (operation.charAt(i)==40) {
				if (i==0||(operation.charAt(i-1)!=110&&operation.charAt(i-1)!=115)) {
					int j = i;
					flag=true;
					while (flag) {
						if (operation.charAt(j)!=41) {
							parentheses+=operation.charAt(j);
							j++;
						}else {
							parentheses+=operation.charAt(j)+"	";
							flag=false;
						}
					}
				}
			}
		}
		return parentheses;
	}

	private String manageTrigonometric(String operation) {
		String trigonometrics = "";
		boolean flag = true;
		for (int i = 0; i < operation.length(); i++) {
			if (operation.charAt(i)==40) {
				if (i!=0&&(operation.charAt(i-1)==110||operation.charAt(i-1)==115)) {
					int j = i-3;
					flag=true;
					while (flag) {
						if (operation.charAt(j)!=41) {
							trigonometrics+=operation.charAt(j);
							j++;
						}else {
							trigonometrics+=operation.charAt(j)+"	";
							flag=false;
						}
					}
				}
			}
		}
		return trigonometrics;
	}

	private int getNumber(String operation) {
		String number = "";
		for (int i = 0; i < operation.length(); i++) {
			if (this.isNumber(""+operation.charAt(i))) {
				number+=operation.charAt(i);
			}
		}
		return Integer.parseInt(number);
	}

	private String getTrigonometricOperation(String trigonometric) {
		String output = "";
		for (int i = 0; i < 3; i++) {
			output+=trigonometric.charAt(i);
		}
		return output;
	}

	private double resultTrigonometricOperations(String operation) {
		double output = 0;
		switch (this.getTrigonometricOperation(operation)) {
		case "sin":
			output=Math.sin(Math.toRadians(this.getNumber(operation)));
			break;
		case "cos":
			output=Math.cos(Math.toRadians(this.getNumber(operation)));
			break;
		case "tan":
			output=Math.tan(Math.toRadians(this.getNumber(operation)));
			break;
		}
		return output;
	}

	private Stack<Double> getNumbers(String[] chain) {
		Stack<Double> numbers = new Stack<>();
		for (int i = 0; i < chain.length; i++) {
			if (this.isNumber(chain[i])) {
				numbers.push(Double.parseDouble(chain[i]));
			}
		}
		return numbers;
	}

	private Stack<String> getSigns(String[] chain) {
		Stack<String> signs = new Stack<>();
		for (int i = 0; i < chain.length; i++) {
			if (!this.isNumber(chain[i])) {
				signs.push(chain[i]);
			}
		}
		return signs;
	}

	private String removePrentheses(String chain, String[] parentheses, double[] results) {
		String temp2 = "";
		for (int i = 0; i < parentheses.length; i++) {
			String temp = ""+results[i];
			temp2=chain.replace(parentheses[i], temp);
		}
		return temp2;
	}

	private String removeTrigonometrics(String chain, String[] trigonometrics, double[] results) {
		String temp2 = "";
		for (int i = 0; i < trigonometrics.length; i++) {
			String temp = ""+results[i];
			temp2=chain.replace(trigonometrics[i], temp);
		}
		return temp2;
	}

	private String removeParenthesesFromString(String chain) {
		String output = "";
		for (int i = 1; i < chain.length()-1; i++) {
			output+=chain.charAt(i);
		}
		return output;
	}

	private String operateParentheses(String chain) {
		String parentheses = this.manageParentheses(chain);
		String output = chain;
		if (!parentheses.equals("")) {
			String[] separateParentheses = parentheses.split("	");
			double[] results = new double[separateParentheses.length];
			for (int i = 0; i < separateParentheses.length; i++) {
				String temp = this.removeParenthesesFromString(separateParentheses[i]);
				results[i]=this.orderOperations(temp);
			}
			output=this.removePrentheses(chain, separateParentheses, results);
		}
		return output;
	}

	private String operateTrigonometrics(String chain) {
		String trigonometrics = this.manageTrigonometric(chain);
		String output = chain;
		if (!trigonometrics.equals("")) {
			String[] separateTrigonometrics = trigonometrics.split("	");
			double[] results = new double[separateTrigonometrics.length];
			for (int i = 0; i < separateTrigonometrics.length; i++) {
				results[i]=this.resultTrigonometricOperations(separateTrigonometrics[i]);
			}
			output=this.removeTrigonometrics(chain, separateTrigonometrics, results);
		}
		return output;
	}

	private void secundaryOrderOperations(Stack<Double> numbers, Stack<String> signs, int i, double temp) {
		signs.remove(i);
		numbers.remove(i);
		numbers.remove(i);
		numbers.add(i,temp);
		i-=1;
	}

	private Double orderOperations(String chain) {
		Stack<Double> numbers = this.getNumbers(chain.split(" "));
		Stack<String> signs = this.getSigns(chain.split(" "));
		double temp = 0;
		for (int i = 0; i < signs.size(); i++) {
			if (signs.get(i).equals("*")) {
				temp=numbers.get(i)*numbers.get(i+1);
				this.secundaryOrderOperations(numbers, signs, i, temp);
			}else if(signs.get(i).equals("/")) {
				temp=numbers.get(i)/numbers.get(i+1);
				this.secundaryOrderOperations(numbers, signs, i, temp);
			}
		}
		for (int i = 0; i < signs.size(); i++) {
			if (signs.get(i).equals("+")) {
				temp=numbers.get(i)+numbers.get(i+1);
				this.secundaryOrderOperations(numbers, signs, i, temp);
			}else if(signs.get(i).equals("-")) {
				temp=numbers.get(i)-numbers.get(i+1);
				this.secundaryOrderOperations(numbers, signs, i, temp);
			}
		}
		return numbers.get(0);
	}

	public double finalOperation(String chain) {
		double output = 0;
		String temp = this.operateParentheses(this.operateTrigonometrics(chain));
		output = this.orderOperations(temp);
		return output;
	}
}
