package app;

public class Driver {

	public static void main(String[] args) 
	{
		MyString myString = new MyString("hello world");
		MyString myString2 = new MyString(" this world is great");
		MyString myStringCopy = new MyString("hello world");
		MyString word = new MyString("is");
		
		System.out.println("To String: \n\t" + myString.toString());
		System.out.println("To Upper: \n\t" + myString.toUpper());
		System.out.println("To Lower: \n\t" + myString.toLower());
		System.out.println("Length() of 'hello world': \n\t" + myString.length());
		System.out.println("Concat 'hello world' and 'this world is great': \n\t" + myString.concat(myString2));
		System.out.println("Equals (compares 'hello world' to 'this world is great'): \n\t" + myString.equals(myString2));
		System.out.println("Get() index 3 of 'hello world': \n\t" + myString.get(3));
		System.out.println("Substring(3) of 'hello world': \n\t" + myString.substring(3));
		System.out.println("Substring(3,5) of 'hello world': \n\t" + myString.substring(3, 5));
		
		MyString concatString = new MyString(myString.concat(myString2));
		MyString copyString = new MyString(concatString);
		System.out.println("Copy Constructor: \n\t" + copyString);
		
		int compareTo = myString.compareTo(myStringCopy);
		if(compareTo == 0)
		{
			System.out.println("CompareTo: \n\tmyString is equal to myStringCopy");
		}
		else if (compareTo > 0)
		{
			System.out.println("CompareTo: \n\t myString is after to myStringCopy");

		}
		else
		{
			System.out.println("CompareTo: \n\tmyString is before to myStringCopy");
		}	
		System.out.println("Index of (finding 'is' in 'this world is great'): \n\t" + myString2.indexOf(word));
		System.out.println("Last index of(finding last 'is' in 'this world is great'): \n\t" + myString2.lastIndexOf(word));
	}
}
