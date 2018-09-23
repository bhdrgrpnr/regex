package ee.nortal.testassignment;

import java.util.Stack;

public class Solution {
	public static int calculate(String expression) throws Exception {
		expression = expression.replaceAll("\\s+","");

		expression = processParanthesis(expression);
		return calculatePattern(expression);
	}


	private static String processParanthesis(String expression){

		while(expression.contains("(")){
			Stack<String> stack = new Stack<>();
			for(int i =0;i<expression.length();i++){
				if(expression.charAt(i) == '('){
					stack.push("(" + i);
				}
				else if(expression.charAt(i) == ')'){
					String popped = stack.pop();
					int subResult = calculatePattern(expression.substring( Integer.valueOf(popped.charAt(1))-47, i));
					expression = expression.substring(0,  Integer.valueOf(popped.charAt(1))-48) + subResult  + expression.substring( i+1, expression.length() );
					break;
				}
			}
		}

		return expression;
	}


	static private int calculatePattern(String subExpression){

		while (containsPriviligedSigns(subExpression)){
			for(int i = 0 ; i<subExpression.length() ; i++){
				if(isPriviligedSign(subExpression.charAt(i))){
					int tmp = calculate(  getNumberStarting(subExpression, i-1, i) ,  getNumberEnding(subExpression, i+1 , i+1), subExpression.charAt(i));
					subExpression = subExpression.substring(0, getNumberStartingIndex(subExpression, i-1, i)) + tmp + subExpression.substring(getNumberEndingIndex(subExpression,i ,i+1), subExpression.length());
					break;
				}
			}
		}

		while (containsSigns(subExpression)){
			for(int i = 0 ; i<subExpression.length() ; i++){
				if(isSign(subExpression.charAt(i))){
					int tmp = calculate(  getNumberStarting(subExpression, i-1, i) ,  getNumberEnding(subExpression, i+1 , i+1), subExpression.charAt(i));
					subExpression = subExpression.substring(0, getNumberStartingIndex(subExpression, i-1, i)) + tmp + subExpression.substring(getNumberEndingIndex(subExpression,i ,i+1), subExpression.length());
					break;
				}
			}
		}

		return Integer.valueOf(subExpression);

	}

	static private boolean containsPriviligedSigns(String str){
		if(str.contains("/") || str.contains("*")   ){
			return true;
		}
		else{
			return false;
		}
	}

	static private boolean containsSigns(String str){
		if(str.contains("+") || str.contains("-")|| str.contains("/")|| str.contains("*")   || str.contains("^")   ){
			return true;
		}
		else{
			return false;
		}
	}

	static private boolean isPriviligedSign(Character sign){
		if( sign == '/'  ||  sign == '*' ){
			return true;
		}
		else{
			return false;
		}
	}

	static private boolean isSign(Character sign){
		if(sign == '+' || sign == '-'  ||  sign == '/'  ||  sign == '*'  ||  sign == '^'  ){
			return true;
		}
		else{
			return false;
		}
	}

	static private int  calculate(int i, int j , char sign){

		if(sign =='+'){
			return i+j;
		}
		else if(sign =='-'){
			return i-j;
		}
		else if(sign =='*'){
			return i*j;
		}
		else if(sign =='/'){
			return i/j;
		}
		else if(sign =='^'){
			return i^j;
		}

		return 0;
	}

	static private int getNumberStarting(String str, int i, int j){

		while(i>0 && Character.isDigit(str.charAt(i))){
			i--;
		}

		return Integer.valueOf(str.substring(i, j));
	}

	static private int getNumberStartingIndex(String str, int i, int j){

		while(i>0 && Character.isDigit(str.charAt(i))){
			i--;
		}

		return i;
	}

	static private int getNumberEnding(String str, int i, int j){

		while(j<str.length() && Character.isDigit(str.charAt(j))){
			j++;
		}

		return Integer.valueOf(str.substring(i, j));
	}

	static private int getNumberEndingIndex(String str, int i, int j){

		while(j<str.length() && Character.isDigit(str.charAt(j))){
			j++;
		}

		return j;
	}
}
