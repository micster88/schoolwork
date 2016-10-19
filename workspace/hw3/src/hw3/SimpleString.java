package hw3;

import java.util.Arrays;

public class SimpleString {
	private char[] charArray;
	
	public SimpleString(char[] input) {
		charArray=new char[input.length];
		System.arraycopy(input, 0, charArray, 0, input.length);
	}

	public char charAt(int index) {
		return charArray[index];
	}

	public boolean contains(char c) {
		for(int i=0; i<charArray.length; i++){
			if(charArray[i]==c){
				return true;
			}
		}
		return false;
	}

	public int indexOf(char c) {
		for(int i=0; i<charArray.length; i++){
			if(charArray[i]==c){
				return i;
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		return (charArray.length==0);
	}

	public int length() {
		return charArray.length;
	}

	public SimpleString concat(SimpleString simp) {
		char[] newArray=new char[simp.length()+this.length()];
		for(int i=0; i<this.length(); i++){
			newArray[i]=this.charAt(i);
		}
		for(int i=this.length(); i<newArray.length; i++){
			newArray[i]=simp.charAt(i-this.length());
		}
		SimpleString temp=new SimpleString(newArray);
		return temp;
	}
	
	public SimpleString substring(int start, int end) {
		char[] newArray=new char[end-start];
		System.arraycopy(charArray, start, newArray, 0, end-1);
		SimpleString temp=new SimpleString(newArray);
		return temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(charArray);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleString other = (SimpleString) obj;
		if (!Arrays.equals(charArray, other.charArray))
			return false;
		return true;
	}


}
