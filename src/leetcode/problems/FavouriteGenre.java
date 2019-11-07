package leetcode.problems;

import java.util.*;

//https://leetcode.com/discuss/interview-question/373006
public class FavouriteGenre {
    public static void main(String[] s){
        String[] davidSongs = {"song1", "song2", "song3", "song4", "song8"},
                emmaSongs = {"song5", "song6", "song7"};
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David",new ArrayList<>(Arrays.asList(davidSongs)));
        userSongs.put("Emma",new ArrayList(Arrays.asList(emmaSongs)));

        Map<String, List<String>> songGenres = new HashMap<>();
        String[] rock = {"song1", "song3"}, dubstep= {"song7"},
                techno = {"song2", "song4"}, pop = {"song5", "song6"}, jazz = {"song8", "song9"};

        songGenres.put("Rock" , Arrays.asList(rock));
        songGenres.put("Dubstep" , Arrays.asList(dubstep));
        songGenres.put("Techno" , Arrays.asList(techno));
        songGenres.put("Pop" , Arrays.asList(pop));
        songGenres.put("Jazz" , Arrays.asList(jazz));
        Map<String,List<String>> fav = findFavouriteGenre(userSongs, songGenres);
        for (String user:
        fav.keySet() ) {
            System.out.print(user+ " likes: ");
            for (String genre:fav.get(user)) {
                System.out.print(genre+",");
            }
            System.out.println();
        };

    }

    private static Map<String,List<String>> findFavouriteGenre
            (Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        // reverse mapping song and genres.
        Map<String,String>  songVsGenre = new HashMap<>();
        for (String genre:
             songGenres.keySet()) {
            for (String song:
                 songGenres.get(genre)) {
                songVsGenre.put(song,genre);
            }
        }
        Map<String,List<String>> userFavs =new HashMap<String,List<String>>();
        for (String user:
             userSongs.keySet()) {
            Map<String,Integer> genreCounts = new HashMap<>();
            int maxCount = 0;
            for (String song :
                 userSongs.get(user)) {
                String genre = songVsGenre.get(song);
                int count = 0;
                if(genreCounts.containsKey(genre)){
                    count = genreCounts.get(genre);
                    if(count+1 > maxCount){
                        maxCount = count+1;
                    }
                }
                genreCounts.put(genre,count+1);
            }
            // reverse map the count to genres and return max
           List<String> favList = new ArrayList<>();
            for (String genre:
                    genreCounts.keySet()) {
                if(genreCounts.get(genre) == maxCount){
                    favList.add(genre);
                }
            }
            userFavs.put(user,favList);
        }
        return userFavs;
    }
}

//    PriorityQueue<Map.Entry<String,Integer>> favQueue= new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
//        @Override
//        public int compare(Map.Entry<String, Integer> g1, Map.Entry<String, Integer> g2) {
//            if(g1.getValue() > g2.getValue()){
//                return 1;
//            }else if(g2.getValue() > g1.getValue()){
//                return -1;
//            }
//            return 0;
//        }
//    });
