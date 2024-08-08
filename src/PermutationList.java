import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationList {
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        for(Integer i : arr){
            list.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        permutation(list, 0, result);
        for(List<Integer> output: result){
            System.out.println(output);
        }
    }

    private static void permutation(List<Integer> list, int left, List<List<Integer>> result) {
        if(left == list.size() - 1){
            result.add(new ArrayList<>(list));
        }
        for(int i = left; i < list.size(); i++){
            Collections.swap(list, left , i);
            permutation(list, left + 1, result);
            Collections.swap(list, left , i);
        }

    }
}
