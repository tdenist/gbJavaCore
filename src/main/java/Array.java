import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Array {

    public static void main(String[] args){
        String words[]= {"один",
                "два",
                "три",
                "четыре",
                "пять",
                "шесть",
                "семь",
                "восемь",
                "девять",
                "десять",
                "шесть",
                "шесть",
                "один",
                "два",
                "три",
                "один",
                "десять",
                "шесть",
                "один"
        };

        System.out.println(Arrays.toString(words));

        String uniqueWords[]=new String[words.length];
        Integer countWords[]=new Integer[words.length];

        int count =0;
        int count_tmp=0;

        //решение через массивы
        //уникальные значения в массиве
        for(int i = 0; i < words.length; i++){
            count_tmp=0;
            for(int j = 0; j < words.length; j++){
                if(words[i].equals(uniqueWords[j]))
                    count_tmp++;
            }
            if(count_tmp == 0){
                uniqueWords[count] = words[i];
                count++;
            }
        }

        //количество уникальных значений
        int i = 0;
        while (uniqueWords[i] != null ){
            count_tmp = 0;
            for (int j = 0; j < words.length; j++){
                if (uniqueWords[i].equals(words[j])){
                    count_tmp ++;
                }
            }
            countWords[i] = count_tmp;
            i++;
        }

        System.out.println();
        System.out.println(Arrays.toString(uniqueWords));
        System.out.println(Arrays.toString(countWords));

        //решение через HashMap
        HashMap<String, Integer> hashMapWords = new HashMap<>();
        for (String word : words){
            if (hashMapWords.containsKey(word)){
                hashMapWords.put(word, hashMapWords.get(word)+1);
            }
            else {
                hashMapWords.put(word, 1);
            }
        }
        System.out.println();
        System.out.println(hashMapWords);
    }
}
