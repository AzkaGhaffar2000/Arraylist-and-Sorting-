import java.util.ArrayList;
import java.util.Random;
 
 
public class Main extends MyTimer {
 
    public static void main(String[] args) {
		randomGenerator(5, 50);
	}
	public static void randomGenerator(int length, int max) {
		Main timer= new Main();
        Random number = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= length; i++) {
            list.add(number.nextInt(max));
        }
		System.out.println("UNSORTED LIST: " + list);
		System.out.println();
		String insertion= insertionSort(list, timer);
		System.out.println("TOTAL TIME FOR BINARY INSERTION: " +insertion);
		System.out.println();
		selectionSort(list, timer);
		mergeSort(list, timer);
	}

	public static String insertionSort(ArrayList<Integer> list, Main timer) {
		timer.start();
		for(int i = 0; i < list.size(); i++){
			int key = list.get(i); 
			int position= binarySearch(list, key);
			int j = i - 1; 
			while(j >= 0 && list.get(j) > key && j<=position){
				list.set(j+1, list.get(j));
				j--; 
			}
			list.set(j+1, key);
		}
		timer.stop();     
		String printing= timer.toString();
		System.out.println("SORTED LIST USING INSERTION SORT: " +list);
		System.out.println();
		return printing; 
	}
	public static void selectionSort(ArrayList<Integer> list, Main timer) {
		timer.start();
        for(int top = 0; top < list.size()-1; top++)
        {
			int minPos = top;
            int minValue = list.get(top);
            for(int k = top + 1; k < list.size(); k++)
            {
				int nextValue = list.get(k);
				String newNextValue = Integer.toString(nextValue);
				String newMinValue = Integer.toString(minValue);
                if(newNextValue.compareTo(newMinValue) < 0)
                {
                int temp = list.get(top);
                list.set(minPos,temp);
                list.set(top, minValue);
				}
			}
            
        }
		timer.stop();     
		String printing1= timer.toString();
		System.out.println("SORTED LIST USING SELECTION SORT: " + list);
		System.out.println();
		System.out.println("TOTAL TIME FOR SELCTION SORT: " +printing1);
		System.out.println();
    }
	public static void mergeSort(ArrayList<Integer> list, Main timer) {
		timer.start();
		int size = list.size();
		if(size == 1)
			return;

		if(size == 2) {
           int value0 = list.get(0);
           int value1 = list.get(1);
		   String newvalue0 = Integer.toString(value0);
		   String newvalue1 = Integer.toString(value1);
           if(newvalue0.compareTo(newvalue1) > 0) {
                list.set(0, value1);
                list.set(1, value0);
           }
           return;
		}
		int size1 = size/2;
		ArrayList<Integer>  v1 = new ArrayList<Integer>();
		ArrayList<Integer>  v2 = new ArrayList<Integer>();
		for(int i = 0; i < size1; i++)
			v1.add(list.get(i));
		for(int i = size1; i < size; i++)
			v2.add(list.get(i));
		
		System.out.println("[Table1 for MERGE SORT USING INSERTION SORT]------------------------------------------");
		System.out.println();
		String insertion1= insertionSort(v1, timer);
		System.out.println("[Table2 for MERGE SORT USING INSERTION SORT]------------------------------------------");
		System.out.println();
		String insertion2= insertionSort(v2, timer);
		merge(v1, v2, list);
		Integer result1 = Integer.valueOf(insertion1);
		Integer result2 = Integer.valueOf(insertion2);
		int result= result1 + result2; 
		timer.stop();     
		String printing2= timer.toString();
		System.out.println("TOTAL TIME FOR MERGE SORT: " +result);
    }
	public static void merge(ArrayList<Integer> table1,ArrayList<Integer> table2, ArrayList<Integer> table3) {
		int i1 = 0, i2 = 0, i3 = 0;
		int value1 = table1.get(i1);
		int value2 = table2.get(i2);
		String new_Value1 = Integer.toString(value1);
		String new_Value2 = Integer.toString(value2);
		while(i1 < table1.size() && i2 < table2.size()) {
			if(new_Value1.compareTo(new_Value2) <= 0) {
				table3.set(i3++, value1);
				i1++;
				if(i1 < table1.size())
					value1 = table1.get(i1);
				}
			else {
				table3.set(i3++, value2);
				i2++;
			if(i2 < table2.size())
               value2 = table2.get(i2);
			}
		}
		int k;
		if(i1 < table1.size()){
			for(k = i1; k < table1.size(); k++)
            table3.set(i3++, table1.get(k));
		}
		else {
			for(k = i2; k < table2.size(); k++)
           table3.set(i3++, table2.get(k));
		}
		System.out.println("FINAL SORTED LIST USING MERGE SORT: " + table3);
		System.out.println();
    }



	public static int binarySearch(ArrayList<Integer> list, int key) {
			String newKey = Integer.toString(key);
			int low = 0;
			int high = list.size() - 1;
			while (low <= high) {
				int mid = low + (high-low);
				int hold= list.get(mid);
				String newhold = Integer.toString(hold);
				int result= newKey.compareTo(newhold);
				if (result == 0) {
					return mid;
				} else if (result < 0) {
					return high = mid - 1;
				} else {
					return low = mid + 1;
				}
			}
			return (low);
	}
}