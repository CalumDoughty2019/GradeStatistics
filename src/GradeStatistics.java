import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/*
FOR neater sums in average
https://stackoverflow.com/questions/12002332/how-to-manipulate-arrays-find-the-average-beginner-java#:~:text=Well%2C%20to%20calculate%20the%20average,loop%20instead%20of%20while%20loop.&text=int%20arrNumbers%5B%5D%20%3D%20new%20int,length%3B%20System.

For Median
https://stackoverflow.com/questions/11955728/how-to-calculate-the-median-of-an-array

For standard deviation
https://stackoverflow.com/questions/18390548/how-to-calculate-standard-deviation-using-java
 */

public class GradeStatistics {
    DecimalFormat df = new DecimalFormat("#0.00");

    //variables
    int numStudents;
    int[] students;
    int values;

    //CONSTRUCTORS
    //default constructor
    public GradeStatistics() {
        numStudents = 0;
        students = new int[0];
        values = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        //could use an if here to throw error message (I have opted for do-while)
        do {
            System.out.println("Please enter number of students: ");
            numStudents = scanner.nextInt();
            students = new int[numStudents];
            //System.out.println("");
        } while (numStudents < 0 || numStudents > 100);

        for (int i = 0; i < students.length; i++) {
            int j = i+1;
            System.out.println("Please enter the grade for student " + j + ": ");
            values = scanner.nextInt();
            students[i] = values;
        }


        System.out.println("The grades are: " + Arrays.toString(students));
        System.out.println("The average is: " + df.format(getAverage()));
        System.out.println("The median is: " + getMedian());
        System.out.println("The minimum is: " + getMinimum());
        System.out.println("The maximum is: " + getMaximum());
        System.out.println("The standard deviation is: " + getStandardDev());

    }

    //get average to 2 decimal places
    public double getAverage(){
        double sum = 0;
        double average = 0;
//        int i = 0;                        //THIS works as well, just not as neat
//        while(i < students.length) {
//            sum = sum + students[i];
//            average = sum / students.length;
//        }

        for(int a : students){
            sum += a;
            average = sum / students.length;
        }

        return average;
    }

    //get median to 2 decimal places
    public String getMedian(){
        Arrays.sort(students);
        double median;
        if (students.length % 2 == 0)
            median = ((double)students[students.length/2] + (double)students[students.length/2 - 1])/2; //if even
        else
            median = (double) students[students.length/2];

        return df.format(median);
    }

    //get minimum value
    public String getMinimum(){
        Arrays.sort(students);
        double minimum;

        minimum = students[0];

        return df.format(minimum);
    }

    //get maximum value
    public String getMaximum(){
        Arrays.sort(students);
        int i;
        double maximum;

        i = students.length;
        int j = i-1;
        maximum = students[j];

        return df.format(maximum);
    }

    //get standard deviation value to 2 decimal places
    public String getStandardDev(){
        double average = getAverage();

        //int i = 0;
        double sum=0;
        double finalsum=0;
        double[] new_average = new double[students.length];
        for (int i = 0; i<students.length; i++){
            double value = (Math.pow((students[i] - average), 2));
            new_average[i]= value;
            //System.out.println("test: "+ fvalue);
        }

        for(double i : new_average) {
            finalsum = (sum += i);
        }

        double AverageX = finalsum/(students.length);
        double SquareRoot = Math.sqrt(AverageX);
        //System.out.println("Standard Deviation: "+ SquareRoot);

        return df.format(SquareRoot);
    }
}
