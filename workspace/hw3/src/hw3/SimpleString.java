package hw3;


public class SimpleString {
	protected char[] charArray;
	
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
		if(charArray.length==0){
			return true;
		}
		return false;
	}

	public int length() {
		return charArray.length;
	}

	public SimpleString concat(SimpleString simp2) {
		return null;
	}
}