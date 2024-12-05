import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DayThree {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new FileReader("/Users/lennard/Desktop/Test.txt"));

        System.out.println(returnSolution(fileInput));
    }

    static int returnSolution(Scanner fileInput){
        int sum = 0;
        do{
            String input = fileInput.next();
            int inputLength = input.length();
            for(int a=0; a<inputLength; a++){
                String partOneString = "";
                String partTwoString = "";
                int partOneInt = 0;
                int partTwoInt = 0;
                if(input.substring(a,a+1).equals("m")) {
                    if (a + 2 < inputLength) {
                        if (input.substring(a + 1, a + 2).equals("u")) {
                            if (a + 3 < inputLength) {
                                if (input.substring(a + 2, a + 3).equals("l")) {
                                    if (a + 4 < inputLength) {
                                        if (input.substring(a + 3, a + 4).equals("(")) {
                                            int counter = 0;
                                            while (!input.substring(a + 4 + counter, a + 5 + counter).equals(",")) {
                                                String temporary = input.substring(a + 4 + counter, a + 5 + counter);
                                                if(!(temporary.equals("0") || temporary.equals("1") || temporary.equals("2") || temporary.equals("3") || temporary.equals("4") || temporary.equals("5") || temporary.equals("6") || temporary.equals("7") || temporary.equals("8") || temporary.equals("9"))){
                                                    break;
                                                }
                                                partOneString = partOneString.concat(input.substring(a + 4 + counter, a + 5 + counter));
                                                counter++;
                                                if((a + 5 + counter) > inputLength){
                                                    break;
                                                }
                                            }
                                            counter++;
                                            if((a + 5 + counter) > inputLength){
                                                break;
                                            }
                                            while (!input.substring(a + 4 + counter, a + 5 + counter).equals(")")) {
                                                String temporary = input.substring(a + 4 + counter, a + 5 + counter);
                                                if(!(temporary.equals("0") || temporary.equals("1") || temporary.equals("2") || temporary.equals("3") || temporary.equals("4") || temporary.equals("5") || temporary.equals("6") || temporary.equals("7") || temporary.equals("8") || temporary.equals("9"))) {
                                                    break;
                                                }
                                                    partTwoString = partTwoString.concat(input.substring(a + 4 + counter, a + 5 + counter));
                                                    counter++;
                                                    if ((a + 5 + counter) > inputLength) {
                                                        break;
                                                    }

                                            }

                                                partOneInt = Integer.valueOf(partOneString);
                                                partTwoInt = Integer.valueOf(partTwoString);
                                                int multi = partOneInt * partTwoInt;
                                                sum += multi;
                                                a = a + 4 + counter;

                                        }
                                    }
                                }
                            }
                        }

                    }
                }
                }

        }while(fileInput.hasNext());

        return sum;
    }
}
