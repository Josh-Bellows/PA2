
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
public class BellowsGenzer006PA2
{
    //Private Variables and input scanner
    private static Scanner input = new Scanner (System.in);
    private static String monthNo = "";
    private static String salesRep = "";
    private static String quarter;
    private static double quarterlySales;
    private static int qtrCounter;
    private static int noOfQtrs;
    
    public static void main(String[] args)
    {
        //Public Variables
        double salesRevenue = 0.0;
        double annualSales = 0.0;
        double projectedSales = 0.0;
        double percOfTargetCo = 0.0;
        double percOfTargetRep = 0.0;

        int qtrChoice = 0;
        int monthCounter = 0;
        int noOfMonths = 3;
        int noSalesReps = 0;
        int salesRepCtr = 0;
        

        //1. User input Prompt 1: What is the projected annual sales for Tandem?
        System.out.printf("%nWhat is the projected annual sales for Tandem? ");
        projectedSales = input.nextDouble();
        
        while (projectedSales < 0)
        {
            System.out.printf("%nNOT a valid floating-point! Please re-enter the projected sales for Tandem: ");
            projectedSales = input.nextDouble();
        }//END of projectedSales input validation while loop.

        //User input Prompt 2: How many sales reps work for Tandem?.
        System.out.printf("%nHow many sales reps work for Tandem? ");
        noSalesReps = input.nextInt();
        
        while (noSalesReps < 0)
        {
            System.out.printf("%nNOT a valid integer! Please re-enter the number of sales reps for Tandem: ");
            noSalesReps = input.nextInt();
        }//END of noSalesReps input validation while loop.

        do //Start of do-while loop.
        {
            //Reinitialize qtrCounter to 1.
            //Zero out quarterlySales.
            //Post-increment salesRepCtr.
            qtrCounter = 1;
            quarterlySales = 0;
            salesRepCtr++;

            //Call promptSalesRep().
            //Call promptNoQtrs().
            promptSalesRep(noSalesReps);
            promptNoQtrs();
            //Nested while loop for number of quarters.
            while (qtrCounter <= noOfQtrs)
            {
                //Initialize monthCounter to 1.
                //Call chooseQtr().
                monthCounter = 1;
                qtrChoice = chooseQtr();
                //while loop for number of months in a quarter.
                while (monthCounter <= noOfMonths)
                {
                    //Call determineMonthNo.
                    //Call promptSalesRevenue().
                    determineMonthNo(monthCounter);
                    salesRevenue = promptSalesRevenue();
                    //Adding sales to quarter total with combined assignment.
                    //Pre-increment monthCounter.
                    quarterlySales += salesRevenue;
                    ++monthCounter;
                }//END while loop for months in a quarter.
                
                //Adding quarterlySales to annualSales with combined assignment.
                //Pre-increment qtrCounter.
                annualSales += quarterlySales;
                ++qtrCounter;

                //Call printSalesRepRevReport().
                //Calculate percOfTargetRep.
                printSalesRepRevReport();
                percOfTargetRep = quarterlySales / (projectedSales / noSalesReps) * 100;
                if (noOfQtrs < 4)
                {
                    System.out.printf((percOfTargetRep >= 50) ? "%nKeep up the GOOD work, %s. There is a possible year-end bonus!" : "%nSo far sales are lagging behind projections.", salesRep.substring(0, salesRep.indexOf(' ')).substring(0, 1).toUpperCase() + salesRep.substring(1, salesRep.indexOf(' ')));
                }//END of if-else for number of quarters.

            }//END of while loop for number of quarters.
        
        } while (salesRepCtr < noSalesReps);//END do-while loop
        
        //Calculate Corporate Sales 
        percOfTargetCo = (annualSales / projectedSales) * 100;

        System.out.printf("%n%nCORPORATE SALES PERFORMANCE%n");

        //if (percOfTargetCo >= 100)
        System.out.printf((percOfTargetCo >= 100) ? "%nIt\'s been a GOOD year so far. There could be a year-end bonus of %nabout 2-5%% if we can keep on top of our sales goals. Thank you all %nand please continue your excellent effort!" : "%nSales are lagging projections. A year-end bonus may not be possible.");

    }//END of main(args: String[]) method

    public static void promptSalesRep(int salesRepCtr)
    {
        int index = 0;
        int spaceCount = 0;
        
        System.out.printf("%nEnter the name of %s sales rep: ", salesRepCtr == 1 ? "a" : "the next");
        input.nextLine();
        salesRep = input.nextLine();

        for(char blank : salesRep.toCharArray())
            {
                if(blank == ' ')
                {
                    spaceCount++;
                }//END if blank spaces.
            }//END for loop counting blank spaces.

        StringBuilder rep = new StringBuilder(salesRep);
        rep.setCharAt(0, salesRep.toUpperCase().charAt(0));
        index = salesRep.indexOf(' ');
        
        for(int i = 1; i <= spaceCount; i++)
        {
            rep.setCharAt(++index, salesRep.toUpperCase().charAt(index));
            index = salesRep.indexOf(' ', index);
        }//END for loop to capitalize Rep names.

        salesRep = rep.toString();
    }

    public static void promptNoQtrs()
    {
    //Captures user input from scanner
        System.out.printf("%nEnter the number of quarters worked (no less than 1 or greater then 4): ");
        
        noOfQtrs = input.nextInt();
        
        while(noOfQtrs < 0 || noOfQtrs > 4)
        {
            System.out.printf("%nNOT a valid integer! Please re-enter the number of quarters worked (1-4): ");
            noOfQtrs = input.nextInt();
        }
    }

    public static int chooseQtr()
    {
        int qtrChosen;

        System.out.printf("%n1. First Quarter");
        System.out.printf("%n2. Second Quarter");
        System.out.printf("%n3. Third Quarter");
        System.out.printf("%n4. Fourth Quarter");
        System.out.printf("%n%nChoose the %squarter in which sales were earned: ", qtrCounter > 1 ? "next " : "");
        
        qtrChosen = input.nextInt();
        
        while(qtrChosen < 0 || qtrChosen > 4)
        {
            System.out.printf("%nNOT a valid integer! Please re-enter the number of quarters worked (1-4): ");
            qtrChosen = input.nextInt();
        }

        quarter = (qtrChosen == 1) ? "First Quarter" : (qtrChosen == 2) ? "Second Quarter" : (qtrChosen == 3) ? "Third Quarter" : "Fourth Quarter";

        return qtrChosen;
    }

    public static void determineMonthNo(int monthCounter)
    {
        switch (monthCounter)
        {
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

    public static double promptSalesRevenue()
    {
        double salesRev;
        
        System.out.printf("%nEnter the sales revenue for the %s month of the %s: ", monthNo, quarter);
        
        salesRev = input.nextDouble();
        
        while(salesRev < 0)
        {
            System.out.printf("%nNOT a valid floating-point!");
            salesRev = input.nextDouble();
        }
        
        return salesRev;
    }

    public static void printSalesRepRevReport()
    {
        Calendar dateTime = Calendar.getInstance();//OF %tY", noOfQtrs, dateTime
        
        System.out.printf("%n%nTANDEM ENTERPRISES");
        System.out.printf("%nSALES REVENUE FOR %d QUARTER(S) OF %tY", noOfQtrs, dateTime);
        System.out.printf("%nSALES REP:  %s", salesRep);
        System.out.printf("%n%nTotal Year-To-Date:      $%,19.2f%n", quarterlySales);
    }

}//END of BellowsGenzer006PA2 class
















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
