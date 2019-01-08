package grading;

import java.lang.reflect.Field;

import junit.framework.TestCase;
import prob1.DoublyLinkedDeleteFirst;

public class TestProb1 extends TestCase {

	public void testEmpty() {
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst(); 
		assertTrue("Expected isEmpty to return true but returned " + list.isEmpty(), list.isEmpty());
	}
	public void testZeroElements() {
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst(); 
		try {
			list.deleteFirst();
			fail("Expected IllegalStateException with 0 elements in list");
		} catch(IllegalStateException e) {
			assertTrue(true);
		} catch(Throwable t) {
			fail("Expected java.lang.IllegalStateException, but got " + t.getClass().getName());
		}
	}
	public void testOneElement() {
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst(); 
		list.addLast("Joe");
		try {
			list.deleteFirst();
			fail("Expected IllegalStateException with only one element in list");
		} catch(IllegalStateException e) {
			assertTrue(true);
		} catch(Throwable t) {
			fail("Expected IllegalStateException, but got " + t.getClass().getSimpleName());
		}
	}
	public void testTwoElements() {
		
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst(); 
		list.addLast("Joe");
		list.addLast("Tom");
		String deleted = list.deleteFirst();
		assertEquals("Expected deleted value to be 'Tom', but got " + deleted, "Tom", deleted);
		try {
			Object firstNode = readFirstNode(list);
			assertNotNull(firstNode);
			String firstValue = readFirstValue(list).toString();
			assertNotNull("Expected value in zeroth node to be 'Joe' but got null", firstValue);
			assertEquals("Expected value in zeroth node to be 'Joe' but got "+firstValue, "Joe", firstValue);
		} catch(ReflectionException e) {
			System.out.println("Unable to perform test because of reflection problems");
		}
	}
	
	

	public void testThreeElements() {
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst();
		list.addLast("Joe");
		list.addLast("Tom");
		list.addLast("Rick");
		String deleted = list.deleteFirst();
		assertEquals("Expected deleted value to be 'Tom', but got " + deleted, "Tom", deleted);
	
		try {
			Object firstNode = readFirstNode(list);
			assertNotNull("First node null ", firstNode);
			String firstValue = readFirstValue(list).toString();
			assertNotNull(firstValue);
			assertEquals("Joe", firstValue);
			Object secondNode = readSecondNode(list);
			assertNotNull("Second node null", secondNode);
			Object secondValue = readSecondValue(list).toString();
			assertNotNull(secondValue);
			assertEquals("Rick", secondValue);
		} catch(ReflectionException e) {
			System.out.println("Unable to perform test because of reflection problems");
		}
		
	}
	
	public void testPrevious() {
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst();
		list.addLast("Joe");
		list.addLast("Tom");
		list.addLast("Rick");
		String deleted = list.deleteFirst();
		assertEquals("Expected deleted value to be 'Tom', but got " + deleted, "Tom", deleted);
	
		try {
			Object firstNode = readFirstNode(list);
			assertNotNull("First node null ", firstNode);
			String firstValue = readFirstValue(list).toString();
			assertNotNull(firstValue);
			assertEquals("Joe", firstValue);
			Object secondNode = readSecondNode(list);
			assertNotNull("Second node null", secondNode);
			Object secondValue = readSecondValue(list).toString();
			assertNotNull(secondValue);
			assertEquals("Rick", secondValue);
			//previous test
			Object previousValue = readPreviousToSecondValue(list).toString();
			assertNotNull("After deleting Tom, expected previous to Rick would be Joe, but got null", 
					previousValue);
			assertEquals("After deleting Tom, expected previous to Rick would be Joe, but got " 
			        + previousValue,"Joe", previousValue);
		} catch(ReflectionException e) {
			System.out.println("Unable to perform test because of reflection problems");
		}
		
		
	}
	
    ///// reflection tools

	private NodeTools getNodeTools(DoublyLinkedDeleteFirst list) throws ReflectionException {
		NodeTools nodeTools = new NodeTools();
		Field[] listFields = list.getClass().getDeclaredFields();
		//Node Class
		Class<?> nodeClass = listFields[0].getType();
		Field[] nodeFields = nodeClass.getDeclaredFields();
		for(Field f: nodeFields) {
			System.out.println(f.getName());
		}
		list.addLast("A");
		list.addLast("B");
		
		//header node
		Field headerField = listFields[0];
		headerField.setAccessible(true);
		try {
			//get header object
			Object header = headerField.get(list);
			Field nextField = nodeClass.getDeclaredField("next");
			Field prevField = nodeClass.getDeclaredField("previous");
			Field valueField = nodeClass.getDeclaredField("value");
			nextField.setAccessible(true);
			prevField.setAccessible(true);
			valueField.setAccessible(true);
			nodeTools.header = header;
			nodeTools.nextField = nextField;
			nodeTools.valueField = valueField;
			nodeTools.prevField = prevField;
		} catch(IllegalAccessException | NoSuchFieldException e) {
			throw new ReflectionException("Problem creating NodeTools");
		}
		return nodeTools;
	}
	
	private Object readFirstNode(DoublyLinkedDeleteFirst list) throws ReflectionException {
		NodeTools tools = getNodeTools(list);
		try {
			//get Node after header
			Object firstNode = tools.nextField.get(tools.header);
			return firstNode;
		} catch(IllegalAccessException e) {
			throw new ReflectionException(e);	
		}
	}
	
	private Object readFirstValue(DoublyLinkedDeleteFirst list) throws ReflectionException {
		NodeTools tools = getNodeTools(list);
		try {
			//get Node after header
			Object firstNode = tools.nextField.get(tools.header);
			
			//get value stored in that node
			return tools.valueField.get(firstNode);
		} catch(IllegalAccessException e) {
			throw new ReflectionException(e);	
		}
	}
	private Object readSecondValue(DoublyLinkedDeleteFirst list) throws ReflectionException {
		NodeTools tools = getNodeTools(list);
		try {
			//get Node after header
			Object firstNode = tools.nextField.get(tools.header);
			
			//get next following this node and its value
			Object secondNode = tools.nextField.get(firstNode);
			Object secondValue = tools.valueField.get(secondNode);
			return secondValue;
		} catch(IllegalAccessException e) {
			throw new ReflectionException(e);	
		}
	}
	private Object readSecondNode(DoublyLinkedDeleteFirst list) throws ReflectionException {
		NodeTools tools = getNodeTools(list);
		try {
			//get Node after header
			Object firstNode = tools.nextField.get(tools.header);
			
			//get next following this node and its value
			Object secondNode = tools.nextField.get(firstNode);
			return secondNode;
		} catch(IllegalAccessException e) {
			throw new ReflectionException(e);	
		}
	}
	
	private Object readPreviousToSecondValue(DoublyLinkedDeleteFirst list) throws ReflectionException {
		NodeTools tools = getNodeTools(list);
		try {
			//get Node after header
			Object firstNode = tools.nextField.get(tools.header);
			
			//get next following this node and its value
			Object secondNode = tools.nextField.get(firstNode);
			Object previousNode = tools.prevField.get(secondNode);
			Object previousValue = tools.valueField.get(previousNode);
			return previousValue;
		} catch(IllegalAccessException e) {
			throw new ReflectionException(e);	
		}
	}
	
	static class NodeTools {
		Object header;
		Field nextField;
		Field prevField;
		Field valueField;
	}
	static class ReflectionException extends Exception {
		private static final long serialVersionUID = -2267219477307925245L;
		ReflectionException() {
			super();
		}
		ReflectionException(String msg) {
			super(msg);
		}
		ReflectionException(Throwable t) {
			super(t);
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedDeleteFirst list = new DoublyLinkedDeleteFirst();
		Field[] listFields = list.getClass().getDeclaredFields();
		//Node Class
		Class<?> nodeClass = listFields[0].getType();
		Field[] nodeFields = nodeClass.getDeclaredFields();
		for(Field f: nodeFields) {
			System.out.println(f.getName());
		}
		list.addLast("A");
		list.addLast("B");
		
		//header node
		Field headerField = listFields[0];
		headerField.setAccessible(true);
		try {
			//get header object
			Object header = headerField.get(list);
			Field nextField = nodeClass.getDeclaredField("next");
			Field prevField = nodeClass.getDeclaredField("previous");
			Field valueField = nodeClass.getDeclaredField("value");
			nextField.setAccessible(true);
			prevField.setAccessible(true);
			valueField.setAccessible(true);
			
			//get Node after header
			Object firstNode = nextField.get(header);
			
			//get value stored in that node
			Object firstValue = valueField.get(firstNode);
			
			//get next following this node and its value
			Object secondNode = nextField.get(firstNode);
			Object secondValue = valueField.get(secondNode);
			
			//get value stored in previous to secondNode
			Object previousNode = prevField.get(secondNode);
			Object previousValue = valueField.get(previousNode);
			
			System.out.println("Next after header: " + firstValue);
			System.out.println("Next after next: " + secondValue);
			System.out.println("Previous: " + previousValue);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
