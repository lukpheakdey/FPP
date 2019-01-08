package grading;

import junit.framework.TestCase;
import prob1.ArrayQueueImpl;
import prob1.QueueException;


public class TestProb1 extends TestCase {
	public void testEnqueueAndSize() {
		ArrayQueueImpl queue = new ArrayQueueImpl();
		queue.enqueue(2);
		assertTrue(queue.size() == 1);
	}
	public void testSizeZero() {
		ArrayQueueImpl queue = new ArrayQueueImpl();
		assertTrue(queue.size() == 0);
	}
	
	public void testPeek() throws Exception {
		ArrayQueueImpl queue = new ArrayQueueImpl();
		queue.enqueue(2);
		assertTrue(queue.peek() == 2);
		assertTrue(queue.size() == 1);
		
	}
	
	public void testResize() {
		ArrayQueueImpl queue = new ArrayQueueImpl();
		try {
			for(int i = 0; i < 150; ++i) {
				queue.enqueue(i);
			}
			assertTrue(true);
		} catch(Exception e) {
			fail("Exception of type " + e.getClass().getSimpleName());
			
		}
	}
	
	public void testDequeue() throws Exception {
		ArrayQueueImpl queue = new ArrayQueueImpl();
		
		for(int i = 0; i < 20; ++i) {
			queue.enqueue(i);
		}
		for(int i = 0; i< 15; ++i) {
			queue.dequeue();
		}
		assertTrue(queue.size() == 5);
		 
	}
	
	public void testPeekException() {
		ArrayQueueImpl queue = new ArrayQueueImpl();
		try {
			queue.peek();
			fail("Expected QueueException");
		} catch(Exception e) {
			assertTrue(e.getClass() == QueueException.class);
		}
	}
	public void testDequeueException() {
		ArrayQueueImpl queue = new ArrayQueueImpl();
		try {
			queue.dequeue();
			fail("Expected QueueException");
		} catch(Exception e) {
			assertTrue(e.getClass() == QueueException.class);
		}
	}
}
