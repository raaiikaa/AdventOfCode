import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DaySeven {
  public static void main(String[] args) throws FileNotFoundException {
    String inputString = "";
    ArrayList<Integer> numberList = new ArrayList<>();
    ArrayList<Integer> biggestList = new ArrayList<>();
    long searchedResult = 0;
    int finalResult = 0;

    Scanner inputFile = new Scanner(new FileReader("C://Users//lre//Desktop//AdventOfCode.txt"));

    while(inputFile.hasNextLine()){
      inputString = inputFile.nextLine();
      numberList = getGivenParametersAsArrayList(inputString);
      searchedResult = getGivenSolutionAsInt(inputString);
      finalResult += checkIfPossibleAndReturnResult(searchedResult, numberList);
      if(numberList.size() > biggestList.size()){
        biggestList = numberList;
      }

      System.out.println(getGivenSolutionAsInt(inputString));
      System.out.println(getGivenParametersAsArrayList(inputString));
      System.out.println(checkIfPossibleAndReturnResult(searchedResult, numberList));
      System.out.println(finalResult);
      System.out.println(" ");
    }
    System.out.println(biggestList.size());
  }

  //returns die Zahl vor dem ':' , die das vermeintliche Ergebnis darstellt
  static long getGivenSolutionAsInt(String inputString){
    int index = 0;
    while(inputString.charAt(index) != ':'){
      index ++;
    }
    return Long.valueOf(inputString.substring(0,index));
  }

  //returns eine ArrayList, die mit den Zahlen nach dem ':' gefüllt ist
  static ArrayList<Integer> getGivenParametersAsArrayList(String inputString){
    int index = 0;
    ArrayList<Integer> numberList = new ArrayList<>();
    do{
      index ++;
    }while(inputString.charAt(index) != ' ');
    index ++;

    for(int i = index; i<inputString.length(); i++){
      String numberString = "";
      while(inputString.charAt(i) != ' '){
        numberString = numberString + inputString.charAt(i);
        if(i + 1 == inputString.length()){
          break;
        }
        i ++;
      }
      numberList.add(Integer.valueOf(numberString));
    }
    return numberList;
  }

  //returns das vermeintliche Ergebnis, wenn es mit nur '+' oder nur '*' erreicht werden kann
  static long checkIfPossibleAndReturnResult(long searchedResult, ArrayList<Integer> numberList){
    long result = 0;
    for(int i = 0; i<numberList.size(); i++){
      result = result + numberList.get(i);
      if(result == searchedResult){
        return result;
      }
    }
    result = 1;

    for(int i = 0; i<numberList.size(); i++){
      result = result * numberList.get(i);
      if(result == searchedResult){
        return result;
      }
    }
    result = 0;

    return result;
  }

  // benötigt wahrscheinlich Rekursion um zu der Lösung zu kommen
  static boolean checkIfPossibleAndReturnResultExtended(long searchedResult, ArrayList<Integer> numberList){
    int result = 0;
    int counter = 0;

    for(int i = 0; i < numberList.size(); i++){


      if(result == searchedResult){
        return true;
      }
    }



    return false;
  }


}

