//===================================================================================================================================================================
//									Program: To parse the mathematical expression given in infix and provide the output in postfix
//	@author: Nevhetha,Kritika,Karthika
// 	Date created: 2016/09/15
//	Date modified: 2016/09/19
//===================================================================================================================================================================
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShuntingYardAlgorithm {

	private ArrayDeque<String> operatorStack = new ArrayDeque<String>();
	private Queue<String> outputQueue = new LinkedList<String>();
	private int precedence = 0, currPrecedence = 0;
	private String top, itemToQueue;
	int flag = 0;
	public void processExpression(String input[]) {
		
		for(String item : input) {
			//Push into queue if element is digit
			if (item.matches("\\d+"))
				outputQueue.add(item);
			else {
			//Setting precedence for all other operators
				switch(item) {
					case "+" :  
					case "-" :
							currPrecedence = 1;
							action(item);
							break;
					case "*" :  
					case "/" :
					case "^" :
							currPrecedence = 2;
							action(item);
							break;
					case "!" :
						outputQueue.add(item);
						break;
					case "(" :
						currPrecedence = precedence;
						action(item);
						flag++;
						break;
					case ")" :
						currPrecedence = precedence;
						actionForRightParen(item);
						flag--;
						break;
				}
	
			}
		}
		if (flag > 0) 
			System.out.println("Wrong expression!!");
		else {
			while(!operatorStack.isEmpty()) {
				outputQueue.add(operatorStack.pop());
			}
		}
	}
	
	//Action performed for every operation based on Shunting yard algorithm
	public void action(String item) {
		top = operatorStack.peek();
		if (top != null) {
			if (precedence > currPrecedence) {
				itemToQueue = operatorStack.poll();
				if (!itemToQueue.equals("(")) {
					outputQueue.add(itemToQueue);
				}
				operatorStack.push(item);
			}
			else
				operatorStack.push(item);
		}
		if (top == null) {
			operatorStack.push(item);
		}
		precedence = currPrecedence;
	}
	
	//When right parenthesis is found pop out all the stack elements until a left parenthesis is found
	public void actionForRightParen(String item) {
		while (!operatorStack.isEmpty()) {
			itemToQueue = operatorStack.poll();
			if (!itemToQueue.equals(")") && !itemToQueue.equals("(")) 
				outputQueue.add(itemToQueue);
			if (itemToQueue.equals("(")) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter an expression with space to accomadate 2 digit numbers ::");
		Scanner in = new Scanner (System.in);
		String input = in.nextLine();
		String[] arrayInput = input.split(" "); //split(""); for 1 digit only expressions
		ShuntingYardAlgorithm sy = new ShuntingYardAlgorithm();
		sy.processExpression(arrayInput);
		if (sy.flag == 0) {
			System.out.println("Infix to Postfix result :: ");
			while(!sy.outputQueue.isEmpty()) {
				System.out.print(sy.outputQueue.poll() + " ");
			}
		}
		in.close();
	}

}
