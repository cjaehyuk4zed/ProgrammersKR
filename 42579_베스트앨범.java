import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<genres.length;i++){
            String str = genres[i];
            int num = plays[i];
            map.put(str, map.getOrDefault(str, 0) + num);
        }
        
        List<Genre> list = new ArrayList<>();
        for(String str : map.keySet()){
            list.add(new Genre(str, map.get(str)));
        }
        
        Collections.sort(list, (g1, g2) -> -(g1.played - g2.played));
        map.clear();
        for(int i=0; i<list.size(); i++){
            map.put(list.get(i).genre, i+1);
        }
        
        
        List<Music> mlist = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            int num = plays[i];
            int rank = map.get(genres[i]);
            mlist.add(new Music(i, num, rank));
        }
        
        Collections.sort(mlist, new MusicSort());

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<mlist.size();i++){
            int rank = mlist.get(i).gRank;
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
            if(rankMap.get(rank) > 2){
                continue;
            }
            answerList.add(mlist.get(i).idx);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answer.length;i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    static class Genre{
        String genre;
        int played;
        public Genre(String genre, int played){
            this.genre = genre;
            this.played = played;
        }
        public Genre(){
            this.genre = "";
            this.played = -1;
        }
    }
    
    // static class GenreSort implements Comparator<Genre>{
    //     @Override
    //     public int compare(Genre g1, Genre g2){
    //         return -(g1.played - g2.played);
    //     }
    // }
    
    static class Music{
        int idx;
        int played;
        int gRank;
        public Music(int idx, int played, int gRank){
            this.idx = idx;
            this.played = played;
            this.gRank = gRank;
        }
        public Music(){
            this.idx = -1;
            this.played = -1;
            this.gRank = -1;
        }
    }
    
    static class MusicSort implements Comparator<Music>{
        @Override
        public int compare(Music m1, Music m2){
            if(m1.gRank == m2.gRank){
                if(m1.played == m2.played){
                    return m1.idx - m2.idx;
                } else{
                    return -(m1.played - m2.played);
                }
            } else{
                return m1.gRank - m2.gRank;
            }
        }
    }
}
