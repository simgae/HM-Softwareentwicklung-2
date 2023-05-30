package edu.hm.gaertner.simon.lab23.a509;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineSplit {

    final private String input;

    public LineSplit(String input) {
        this.input = input;
    }

    public List<List<String>> split(int counter) {

        ArrayList<List<String>> result = new ArrayList<>();

        char[] letters = input.toCharArray();

        int numberOfTrys = letters.length / counter;
        int alreadyDone = 0;

        while (numberOfTrys > 0) {
            result.add(IntStream.range(0, letters.length)
                            .skip(alreadyDone)
                            .boxed()
                            .limit(counter)
                            .map(n -> String.valueOf(letters[n]))
                            .collect(Collectors.toList()));
            numberOfTrys--;
            alreadyDone += counter;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LineSplit("text").split(2));
    }
}

