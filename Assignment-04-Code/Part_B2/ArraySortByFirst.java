package assignment04PartB2;
/**
 *
 * Part B.2
 *
 * Please do not change any code in the main method 
 *
 */
public class ArraySortByFirst
{
	public static void sortByFirst(int data[][])
	{
		for (int i = 0; i < data.length - 1; i++) {
			int compareValue = data[i][0];
			int [] swapArray = data[i];
			int index = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j][0] < compareValue) {
					compareValue = data[j][0];
					swapArray = data[j];
					index = j;
				}
			}
			if (data[index][0] < data[i][0]) {
				data[index] = data[i];
				data[i] = swapArray;
			}
		}
	}

	public static void display(int data[][])
	{
		for (int [] row : data) {
			for (int columnEntry : row) {
				System.out.print(columnEntry + " ");
			}
			System.out.println();
		}
	} 

	//
	// Please do not change any code in the main method
	//
	public static void main(String args[])
	{
		int array[][] = {{1, 2, 3, 4, 5}, 
				 {3, 4, 5, 1, 2}, 
				 {5, 2, 3, 4, 1}, 
				 {2, 3, 1, 4, 5}, 
				 {4, 2, 3, 1, 5}};

		System.out.println("The array is initially " );
		display(array);
		System.out.println();

		sortByFirst(array);
		System.out.println("The array after sorting is " );
		display(array);
		System.out.println();
	}
}