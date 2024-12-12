import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class DayTwo {


  public static void main(String[] args) throws FileNotFoundException {

    ArrayList<String> arrayList = new ArrayList<String>();
    Scanner file = new Scanner(new FileReader("/Users/lennard/Desktop/Test.txt"));
    while (file.hasNext()) {
      arrayList.add(file.nextLine());
    }

    System.out.println("Solution for day 2 task 1:\n" + "Total of safe reports: " + checkSafeOrUnsafe(arrayList));
    System.out.println(" ");
    System.out.println("Solution for day 2 task 2:\n" + "Total of safe reports: " + checkSafeOrUnsafeAdvanced(arrayList));


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
      }

        if(checkIfOperationIsOk(sizeOfEntry, increasing, splitInts)){
          numberOfSafeEntries ++;
        }
    }
    return numberOfSafeEntries;
  }

  public static int checkSafeOrUnsafeAdvanced(ArrayList<String> arrayList) {
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
      }

      if(checkIfOperationIsOkAdvanced(sizeOfEntry, increasing, splitInts)){
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

  public static boolean checkIfOperationIsOkAdvanced(int sizeOfEntry, boolean increasing,
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

    //für Part 2
    int isOkMeter = 0;
    if(isOk == false){
      if (increasing) {
        for (int i = 0; i < sizeOfEntry - 1; i++) {
          int result = splitInts.get(i + 1) - splitInts.get(i);
          if(isOkMeter<=1){
            if(result <= 0 || result > 3) {
              isOkMeter ++;
            }
          }
        }
      } else {
        for (int i = 0; i < sizeOfEntry -1; i++) {
          int result = splitInts.get(i) - splitInts.get(i + 1);
          if(isOkMeter<1){
            if(result <= 0 || result > 3) {
              isOkMeter ++;
            }
          }
        }
      }
    }
    if(isOkMeter > 1){
      return false;
    }
    return true;
  }
}

