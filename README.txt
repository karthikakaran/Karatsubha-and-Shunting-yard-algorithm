CS 5V81.012 : Implementation of Data Structures and Algorithms
Optional Project 2 - Group 3

***********************************************************************************************************************************************************************************
Note: Timer.java needs to be compiled because most of the programs use it
so compile :  javac Timer.java
   run :      java Timer.java

***********************************************************************************************************************************************************************************
1. Karatsuba algorithm for large integer multiplication

compile : 	javac KaratsubaAlgorithm.java
run : 		java KaratsubaAlgorithm

input:		Enter n1 and n2 ::
		8
		4
		Enter a base :: 
		8
		Enter the digits of 1st number :: 
		1 2 3 4 5 6 7 1
		Enter the digits of 2st number :: 
		1 2 3 4

Output:		1 5 5 0 3 7 1 3 2 7 4 

Explanation:	Karatsubha algorithm that reduces number of multiplications for large integers is implemented recursively
		and a base condition which returns the multiplication of digits that are less than the given base eventually
		and all the calculations are performed there after and result is returned

***********************************************************************************************************************************************************************************

2. Array based Queue Implementation and resize

compile : 	javac arrayBasedQueue.java
run : 		java arrayBasedQueue

input & output:	Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		1
		Elements in the queue are
		1 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		2
		Elements in the queue are
		1 2 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		4
		Elements in the queue are
		1 2 4 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		5
		Elements in the queue are
		1 2 4 5 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		Elements in the queue are
		2 4 5 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		02
		Elements in the queue are
		2 4 5 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		45
		Elements in the queue are
		2 4 5 45 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		Elements in the queue are
		4 5 45 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		1
		Elements in the queue are
		4 5 45 1 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		44
		Elements in the queue are
		4 5 45 1 44 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		0
		Enter the number to add
		23
		Elements in the queue are
		4 5 45 1 44 23 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		Elements in the queue are
		5 45 1 44 23 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		Elements in the queue are
		45 1 44 23 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		Elements in the queue are
		1 44 23 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		Elements in the queue are
		44 23 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		Elements in the queue are
		23 
		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end
		Enter a number: 
		1
		queue is empty

		Press 0 to add elements to the queue
		Press 1 to delete elements from the queue
		Press 2 to print elements of the queue
		Press 3 to end	

Explanation:	Offer, Poll, Peek, isEmpty functions of queue are implemented using arrays.
		The array size is checked for the size and doubled while adding an element and halfed when the 
		element is removed. Every time the minimum size of 16 is ensured. The peek function for getting the 
		top element is also implemented. Every time is queue is checked for empty condition

***********************************************************************************************************************************************************************************

3. Mergesort implementation without recursion

compile : 	javac MergeSortStackImpl.java, javac StackRemember.java
run : 		java MergeSortStackImpl, java StackRemember

input:		Before sorting :: 
		10000 9999 9998 ... 1 
		
Output:		Time: 147 msec.
		Memory: 1 MB / 119 MB.
		After sorting :: 
		1 2 ... 10000
		
Explanation:	Instead of recursion coding and internal stack, while loop is used iteratively. In order to remember the stack frame or activation record data
		a class called StackRemeber is used for creating start, right. The object is created every time with this information and stored as records in 			arraylist and it is popped out every time when the left and right divisions are done. The merge fuction is called after every pop.
		In order to mark the left and right sub tree divisions two marker variables are stored in the record object. Eventually when both the left and right 			divisions of all the stack elements are marked complete the merge is performed and result is returned.

***********************************************************************************************************************************************************************************

4. Shuntingyard algorithm

compile :	javac ShuntingYardAlgorithm.java
run	:	java ShuntingYardAlgorithm

input:		Enter an expression with space to accomadate 2 digit numbers ::
		44 * ( 90 ! - 5 * ( 4 / 5 ) )

output:		Infix to Postfix result :: 
		44 90 ! 5 4 5 / * - * 

Explanation:	The algorithm is implemented using the stack for storing and processing and queue for output results.
		The precedence and associations are set for different operators. The input can be given with spaces for 
		accomadating the 2 digit numbers or if the expression contains just 1 digit numbers then " " space is not required

***********************************************************************************************************************************************************************************
