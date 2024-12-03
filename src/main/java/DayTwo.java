import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class DayTwo {


  public static void main(String[] args) throws FileNotFoundException {

    ArrayList<String> arrayList = new ArrayList<String>();
    Scanner file = new Scanner(new FileReader("C:\\Users\\lre\\Desktop\\Textdokument (neu).txt"));
    while (file.hasNext()) {
      arrayList.add(file.nextLine());
    }

    checkSafeOrUnsafe(arrayList);
    System.out.println(checkSafeOrUnsafe(arrayList));

  }

  public static int checkSafeOrUnsafe(ArrayList<String> arrayList) {
    int numberOfSafeEntries = 0;

    for (String entry : arrayList) {
      String[] splitStrings = entry.split(" ");
      ArrayList<Integer> splitInts = new ArrayList<Integer>();

      for (String string : splitStrings) {
        splitInts.add(Integer.valueOf(string));
      }

      int sizeOfEntry = splitInts.size();
      boolean increasing = true;
      if (splitInts.get(0) < splitInts.get(1)) {
        increasing = true;
      } else if (splitInts.get(0) > splitInts.get(1)) {
        increasing = false;
      } else if (splitInts.get(0) == splitInts.get(1)) {
        break;
      }

      if(entry.equals("40 39 38 35 32 31 29")){
        System.out.println("hooray");
      }

        if(checkIfOperationIsOk(sizeOfEntry, increasing, splitInts)){
          numberOfSafeEntries ++;
        }
    }
    return numberOfSafeEntries;
  }

  public static boolean checkIfOperationIsOk(int sizeOfEntry, boolean increasing,
      ArrayList<Integer> splitInts) {
    boolean isOk = true;
    if (increasing) {
      for (int i = 0; i < sizeOfEntry - 1; i++) {
        int result = splitInts.get(i + 1) - splitInts.get(i);
        if (result <= 3 && result >= 1) {
          isOk = true;
        } else {
          isOk = false;
          break;
        }
      }
    } else {
      for (int i = 0; i < sizeOfEntry -1; i++) {
        int result = splitInts.get(i) - splitInts.get(i + 1);
        if (result <= 3 && result >= 1) {
          isOk = true;
        } else {
          isOk = false;
          break;
        }
      }
    }
    return isOk;
  }

  @Test
  public void boolTest(){
    String[] array = {"1 2 3 4 5", "12 11 10 9 8 7"};
    ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));
    checkSafeOrUnsafe(list);
  }
}

