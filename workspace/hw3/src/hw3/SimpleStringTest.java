package hw3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleStringTest {
	
	private SimpleString simp;
	private SimpleString simp2;
	private SimpleString simp3;
	
	private char[] charArray = 
		{'a','b','c','d','e','f','g','a','b','c'};
	
	@Before
	public void testNewSimpleString(){	
		simp=new SimpleString(charArray);
		simp2=new SimpleString(charArray);
	}
	
	@Test
	public void testCharAt(){
		char c=simp.charAt(0);
		assertEquals(c,'a');
	}
	
	@Test
	public void testContains(){
		boolean t=simp.contains('b');
		assertEquals(true,t);
		t=simp.contains('z');
		assertEquals(false,t);
	}
	
	@Test
	public void testIndexOf(){
		int re=simp.indexOf('d');
		assertEquals(3,re);
		re=simp.indexOf('x');
		assertEquals(-1,re);
	}
	
	@Test
	public void testIsEmpty(){
		boolean tr=simp.isEmpty();
		assertEquals(tr,false);
	}
	
	@Test
	public void testLength(){
		int length=simp.length();
		assertEquals(10,length);
	}
	
	@Test
	public void testConcat(){
		char[] test={'a','b','c','d','e',
				'f','g','a','b','c','a','b','c','d','e','f',
				'g','a','b','c'};
		simp3=simp.concat(simp2);
	}
	
	@Test
	public void testSubstring(){
	
	}
	
	@Test
	public void testEquals(){
	
	}
	
	@Test
	public void testHashCode(){
	
	}
}
