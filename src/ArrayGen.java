import java.util.Random;
import java.util.Scanner;
public class ArrayGen{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("[*]Please enter a positive size for the array");
        int size = inputRange(0,Integer.MAX_VALUE);
        System.out.println("[*]Please enter the minimum value");
        int min = inputRange(Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("[*]Please enter the maximum value");
        int max = inputRange(min,Integer.MAX_VALUE);

        int[] nums = new int[size];

        Randomize(nums,min,max);
        printArray(nums);

        System.out.printf("[*]The sum of the array is %d", SumArray(nums));

    }

    /*
     * inputRange - allows user to input an integer between the two given integers.
     * @param arr - integer array to be modified
     * @param min - minimum integer value that will be selected at random
     * @param max - maximum integer value that will be selected at random
     */
    public static void Randomize(int[] arr, int min, int max) {
        Random rand = new Random();
        for(int _i=0;_i<arr.length;_i++)
        {
            arr[_i] = rand.nextInt(min,max);
        }
    }

    /*
     * sumArray - Sums the values in an integer array
     * @param arr - an integer array to be summed
     * @return - integer value representing the sum of all the values in the array
     */
    public static int SumArray(int arr[]) {
        int sum = 0;
        for(int num: arr)
        {
            sum += num;
        }
        return sum;
    }

    /*
     * inputRange - allows user to input an integer between the two given integers.
     * @param lower - defines the lower bound of the input range
     * @param upper - defines the upper bound of the input range
     * @return - a user defined integer between the specified bounds
     */
    public static int inputRange(int lower, int upper)
    {
        Scanner in = new Scanner(System.in);
        int val = 0;
        boolean done = false;
        do {
            if(upper != Integer.MAX_VALUE)
            {
                if(in.hasNextInt()) {
                    val = in.nextInt();
                    if (val <lower || val > upper) {
                        System.out.printf("[!]Please enter between %d and %d\n",lower,upper);
                    }
                    else {
                        done = true;
                    }
                }
                else {
                    System.out.println("[!]Please enter an integer");
                    in.next();
                }
            }
            else
            {
                if(in.hasNextInt()) {
                    val = in.nextInt();
                    if (val < lower) {
                        System.out.printf("[!]Please enter %d or above\n",lower);
                    }
                    else {
                        done = true;
                    }
                }
                else {
                    System.out.println("[!]Please enter an integer");
                    in.next();
                }
            }
        } while (!done);

        return val;
    }

    /*
     * printArray - Prints the inputted integer array.
     * @param arr - an integer array to be printed
     */
    public static void printArray(int[] arr) {
        System.out.print("[*]The array currently is: [");
        int i=0;
        for(int num: arr)
        {
            if(!(i==arr.length-1)) System.out.printf("%d, ",num);
            else System.out.printf("%d",num);
            i++;
        }
        System.out.println("]");
    }

}
