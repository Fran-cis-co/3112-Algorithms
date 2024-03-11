package test;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args){
		int[] arr = {1,2,3};
		
		List<List<Integer>> permute = permutation(arr);
		
		for(List<Integer> pem: permute) {
			Integer[] temp = new Integer[pem.size()];
			temp = pem.toArray(temp);
			System.out.println(temp[0]);
		}
	}
	
	public static List<List<Integer>> permutation(int[] arr){
		List<List<Integer>> list = new ArrayList<>();
		permutationHelper(list, new ArrayList<>(), arr);
		return list;
	}
	
	private static void permutationHelper(List<List<Integer>> list, List<Integer> result, int[] arr) {
		if(result.size() == arr.length) {
			list.add(new ArrayList<>(result));
		} else {
			for(int i = 0; i < arr.length; i++) {
				if(result.contains(arr[i])) {
					continue;
				}
				
				result.add(arr[i]);
				permutationHelper(list, result, arr);
				result.remove(result.size() - 1);
			}
		}
	}
}
