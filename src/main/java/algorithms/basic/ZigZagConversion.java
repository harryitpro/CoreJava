package algorithms.basic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        Map<Integer, List<Character>> rowToList = new LinkedHashMap<>();
        for (int i = 1; i <= numRows; i++) {
            rowToList.put(i, new ArrayList<>());
        }
        int rowNum = 1;
        boolean direction = true;
        for (int i = 0; i < s.length(); i++) {
            rowToList.get(rowNum).add(s.charAt(i));
            if (rowNum == 1)
                direction = true;
            if (rowNum == numRows)
                direction = false;
            if (direction == true) {
                rowNum++;
            } else {
                rowNum--;
            }
        }

        StringBuilder charSequence = new StringBuilder();
        for(List<Character> chars: rowToList.values()){
            for(char c: chars){
                charSequence.append(c);
            }
        }
        return charSequence.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR"));  //PAHNAPLSIIGYIR
    }
}
