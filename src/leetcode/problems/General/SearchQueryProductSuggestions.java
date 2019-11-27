package leetcode.problems.General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SearchQueryProductSuggestions {

    public static void main(String[] iou){
        int numProducts = 5;
        String[] repo = {"mouse","mousepad","monitor","moneypot","mobile"};
        String query = "mon";
        for (List<String> list:
             getQueryResult(numProducts,repo,query)) {
            System.out.println();
            for (String s:
                 list) {
                System.out.print(s+"   ");
            }
        }
    }
    private static List<List<String>> getQueryResult(int numProducts, String[] repo, String query){
        // sorted repository
        Arrays.sort(repo);
        List<List<String>> searchResults = new ArrayList<>();
        for(int i=2;i<=query.length();i++){
            searchResults.add(getSubQueryResult(repo, query.substring(0,i)));
        }
        return searchResults;
    }

    private static List<String> getSubQueryResult(String[] repo, String subQuery){
        PriorityQueue<String> q = new PriorityQueue<>();
        for (String prod:
             repo) {
            if(prod.startsWith(subQuery)){
                q.offer(prod);
            }
        }
        List<String> res = new ArrayList<>();
        int i=0;
        while(!q.isEmpty() && i<3 ){
            res.add(q.poll());
            i++;
        }
        return res;
    }
}
