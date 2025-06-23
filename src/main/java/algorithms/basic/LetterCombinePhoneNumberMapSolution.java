package algorithms.basic;

import java.util.*;

public class LetterCombinePhoneNumberMapSolution {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return List.of();
        //Number-Letters dictionary
        Map<Character, List<Character>> digitToLetters = Map.of(
                '2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z')
        );
        //use BFS solution: preString for each digit's letters
        //for each Letter from input digits string, combine to a string to the queue.
        //till the end of the digits string, what stay in the queue will be the final result.
        //preString solution. -- similar to the permutation algorithm.
        //DFS or BFS?  BFS, as we process one didit/(letters) at a time.
        Queue<String> preQueue = new ArrayDeque<String>();  //String or StringBuilder?
        preQueue.offer("");

        // go through digit one-by-one in the digits string
        for (int i = 0; i < digits.length(); i++) {
            Character digit = digits.charAt(i);
            List<Character> letters = digitToLetters.get(digit);
            if (letters != null && !letters.isEmpty()) {
                int queueSize = preQueue.size();
                for (int j = 0; j < queueSize; j++) {
                    String pre = preQueue.poll();
                    for (char letter : letters) {
                        preQueue.offer(pre + letter);
                    }
                }
            }
        }
        return new ArrayList<>(preQueue);
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); //[ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
