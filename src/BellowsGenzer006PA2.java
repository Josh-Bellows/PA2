
import java.util.Scanner;
import java.util.Calendar;
//Imports Scanner and Calendar

/**
 * A program that computes annual sales revenue to-date to determine
 * the status of the company’s sales revenue and whether a year-end bonus is in store for the
 * employees. Sales revenue is captured by month within a quarter; therefore, the user can enter as
 * many quarters as needed as long as the quarters are not less than 1 or greater than 4. If sales
 * revenue is on target by 50% or more for a sales rep, an encouraging message is sent; otherwise,
 * a warning is sent. If sales revenue to date for the company is greater than or equal to 100% of
 * projected annual sales, then employees qualify for a 2-5% year-end bonus; otherwise, no yearend bonus can be expected
 */
public class BellowsGenzer006PA2 {

    private static Scanner input = new Scanner(System.in);
    private static String monthNo = "";
    private static String salesRep = "";
    private static String quarter;
    private static double quarterlySales;
    private static int qtrCounter;
    private static int noOfQtrs;

    public static void main(String[] args) {

        double salesRevenue;
        double annualSales = 0;
        double projectedSales;
        double percOfTargetCo;
        double percOfTargetRep;

        int qtrChoice;
        int monthCounter;
        int noOfMonths = 3;
        int noSalesReps;
        int salesRepCtr = 0;


        //Captures user input from scanner
        System.out.print("What is the projected annual sales for Tandem? ");
        projectedSales = input.nextDouble();
        //Captures user input from scanner
        System.out.print("How many sales reps work for Tandem? ");
        noSalesReps = input.nextInt();

        //Start of do while loop
        do {
            qtrCounter = 1;
            quarterlySales = 0;
            salesRepCtr++;

            promptSalesRep(noSalesReps);
            promptNoQtrs();
            while (qtrCounter <= noOfQtrs) {

                monthCounter = 1;
                qtrChoice = chooseQtr();
                while (true) {
                    determineMonthNo(monthCounter);
                    promptSalesRevenue();
                    //Adding sales to quarter total
                    quarterlySales += salesRevenue;
                    ++monthCounter;
                }
                annualSales += quarterlySales;
                ++qtrCounter;
                printSalesRepRevReport();
                percOfTargetRep = quarterlySales / (projectedSales / noSalesReps) * 100;
                if (noOfQtrs < 4) {
                    if (percOfTargetRep >= 50) {
                        System.out.printf("%nKeep up the GOOD work, %s. There is a " + "possible year-end bonus!%n\n", salesRep.substring(0, salesRep.indexOf(' ')));
                    } else {
                        System.out.printf("%nSo far sales are lagging behind projections.\n");
                    }
                }

                percOfTargetCo = (annualSales / projectedSales) * 100;

                System.out.printf("%nCORPORATE SALES PERFORMANCE\n");

                if (percOfTargetCo >= 100) {
                    System.out.printf("%nIt’s been a GOOD year so far. There could be a year-end bonus of about 2-5%% if we can keep on top of our sales goals. Thank you all and please continue your excellent effort!");
                } else {
                    System.out.printf("%nSales are lagging projections. A year-end bonus may not be possible.");
                }
            }


        }
        while (salesRepCtr < noSalesReps);


    }


    //Start of Corporate sale calculations


    public static void promptNoQtrs() {
        //Captures user input from scanner
        System.out.print("Enter the number of quarters worked (no less than 1 or greater then 4): ");
        noOfQtrs = input.nextInt();

    }

    public static void promptSalesRep(int salesRepCtr) {
        int index;
        int spaceCount;
        StringBuilder rep;
        System.out.printf("Enter the name of %s sales rep: ", salesRepCtr == 1 ? "a" : "the next");
        input.nextLine();
        salesRep = input.nextLine();
    }

    public static int chooseQtr() {
        int qtrChosen;

        System.out.printf("%n1. First Quarter");
        System.out.printf("%n2. Second Quarter");
        System.out.printf("%n3. Third Quarter");
        System.out.printf("%n4. Fourth Quarter");
        System.out.printf("%n%nChoose the %squarter in which sales were earned: ", qtrCounter > 1 ? "next " : "");
        qtrChosen = input.nextInt();


        quarter = (qtrChosen == 1) ? "First Quarter" : (qtrChosen == 2) ? "Second Quarter" : (qtrChosen == 3) ? "Third Quarter" : "Fourth Quarter";


        return qtrChosen;
    }


    public static void determineMonthNo(int monthCounter) {
        switch (monthCounter) {
            case 1:
                monthNo = "1st";
                break;
            case 2:
                monthNo = "2nd";
                break;
            case 3:
                monthNo = "3rd";
                break;
        }

    }

    public static double promptSalesRevenue() {
        double salesRev;
        System.out.printf("%nEnter the sales revenue for the %s month of the %s: \n", monthNo, quarter);
        salesRevenue = input.nextDouble();
        return salesRev;
    }

    public static void printSalesRepRevReport() {
        Calendar dateTime = Calendar.getInstance();
        System.out.printf("%nTANDEM ENTERPRISES");
        System.out.printf("%nSALES REVENUE FOR %d QUARTER(S) OF %d", noOfQtrs, dateTime.get(dateTime.YEAR));
        System.out.printf("%nSALES REP:  %s", salesRep);
        System.out.printf("%n%nTotal Year-To-Date:      $%,19.2f%n", quarterlySales);
    }
















/* Code output
 *
What is the projected annual sales for Tandem?  [DrJava Input Box]
How many sales reps work for Tandem?  [DrJava Input Box]
Enter the name of a sales rep:  [DrJava Input Box]
Enter the number of quarters worked (no less than 1 or greater then 4):  [DrJava Input Box]

1. First Quarter
2. Second Quarter
3. Third Quarter
4. Fourth Quarter

Choose the quarter in which sales were earned:  [DrJava Input Box]

Enter the sales revenue for the 1st month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 2nd month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 3rd month of the Second Quarter:
 [DrJava Input Box]

TANDEM ENTERPRISES
SALES REVENUE FOR 1 QUARTER(S) OF 2022
SALES REP:  Julian Caesar

Total Year-To-Date:      $         250,000.00

Keep up the GOOD work, Julian. There is a possible year-end bonus!

Enter the name of the next sales rep:  [DrJava Input Box]
Enter the number of quarters worked (no less than 1 or greater then 4):  [DrJava Input Box]

1. First Quarter
2. Second Quarter
3. Third Quarter
4. Fourth Quarter

Choose the quarter in which sales were earned:  [DrJava Input Box]

Enter the sales revenue for the 1st month of the First Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 2nd month of the First Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 3rd month of the First Quarter:
 [DrJava Input Box]

1. First Quarter
2. Second Quarter
3. Third Quarter
4. Fourth Quarter

Choose the next quarter in which sales were earned:  [DrJava Input Box]

Enter the sales revenue for the 1st month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 2nd month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 3rd month of the Second Quarter:
 [DrJava Input Box]

TANDEM ENTERPRISES
SALES REVENUE FOR 2 QUARTER(S) OF 2022
SALES REP:  Monique La Femme

Total Year-To-Date:      $          32,000.00

So far sales are lagging behind projections.

CORPORATE SALES PERFORMANCE

Sales are lagging projections. A year-end bonus may not be possible.
 *
 * What is the projected annual sales for Tandem?  [DrJava Input Box]
How many sales reps work for Tandem?  [DrJava Input Box]
Enter the name of a sales rep:  [DrJava Input Box]
Enter the number of quarters worked (no less than 1 or greater then 4):  [DrJava Input Box]

1. First Quarter
2. Second Quarter
3. Third Quarter
4. Fourth Quarter

Choose the quarter in which sales were earned:  [DrJava Input Box]

Enter the sales revenue for the 1st month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 2nd month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 3rd month of the Second Quarter:
 [DrJava Input Box]

TANDEM ENTERPRISES
SALES REVENUE FOR 1 QUARTER(S) OF 2022
SALES REP:  Julian Caesar

Total Year-To-Date:      $         250,000.00

Keep up the GOOD work, Julian. There is a possible year-end bonus!

Enter the name of the next sales rep:  [DrJava Input Box]
Enter the number of quarters worked (no less than 1 or greater then 4):  [DrJava Input Box]

1. First Quarter
2. Second Quarter
3. Third Quarter
4. Fourth Quarter

Choose the quarter in which sales were earned:  [DrJava Input Box]

Enter the sales revenue for the 1st month of the First Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 2nd month of the First Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 3rd month of the First Quarter:
 [DrJava Input Box]

1. First Quarter
2. Second Quarter
3. Third Quarter
4. Fourth Quarter

Choose the next quarter in which sales were earned:  [DrJava Input Box]

Enter the sales revenue for the 1st month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 2nd month of the Second Quarter:
 [DrJava Input Box]

Enter the sales revenue for the 3rd month of the Second Quarter:
 [DrJava Input Box]

TANDEM ENTERPRISES
SALES REVENUE FOR 2 QUARTER(S) OF 2022
SALES REP:  Monique La Femme

Total Year-To-Date:      $         190,000.00

Keep up the GOOD work, Monique. There is a possible year-end bonus!


CORPORATE SALES PERFORMANCE

It’s been a GOOD year so far. There could be a year-end bonus of about 2-5% if we can keep on top of our sales goals. Thank you all and please continue your excellent effort!
 *
 *
 *
 */
}
