import java.util.Scanner;
import java.util.Calendar;

public class GenzerT006PA1 {

    public static void main(String[] args) {

        int salesRepCtr = 0;
        int noOfQtrs;
        int qtrCounter;
        int noOfMonths = 3;
        int monthCounter;
        String monthNo;
        double salesRevenue;
        double quarterlySales;
        String quarter;
        Calendar dateTime = Calendar.getInstance();
        double annualSales = 0;
        //int qrtCounter = 0;
        double percOfTargetRep;
        double percOfTargetCo;
        monthNo = "";
        String salesRep = "";

        Scanner input = new Scanner(System.in);

        System.out.print("What is the projected annual sales for Tandem? ");
        double projectedSales = input.nextDouble();

        System.out.print("How many sales reps work for Tandem? ");
        int noSalesReps = input.nextInt();

        do {
            qtrCounter = 1;
            quarterlySales = 0;
            salesRepCtr++;

            System.out.printf("%nEnter the name of %s sales rep: ", salesRepCtr == 1 ? "a" : "the next");
            input.nextLine();
            salesRep = input.nextLine();
            //salesRep = String.format("%s %s",input.next(),input.next());

            //System.out.println("salesRep = "+ salesRep);
            System.out.print("Enter the number of quarters worked (no less than 1 or greater then 4): ");
            noOfQtrs = input.nextInt();
            //System.out.println("salesRep = "+ salesRep);
            //System.out.println("noOfQtrs = "+ noOfQtrs);
            while(qtrCounter <= noOfQtrs)
            {
                //System.out.println(qtrCounter + "<=" + noOfQtrs);
                monthCounter = 1;
                System.out.printf("%n1. First Quarter");
                System.out.printf("%n2. Second Quarter");
                System.out.printf("%n3. Third Quarter");
                System.out.printf("%n4. Fourth Quarter");
                System.out.printf("%n%nChoose the %squarter in which sales were earned: ", qtrCounter > 1 ? "next " : "");
                int qtrChoice = input.nextInt();

                while(monthCounter <= noOfMonths) {

                    if (monthCounter == 1)
                        monthNo = "1st";
                    else if (monthCounter == 2)
                        monthNo = "2nd";
                    else if (monthCounter == 3)
                        monthNo = "3rd";

                    quarter = (qtrChoice == 1) ? "First Quarter" : (qtrChoice == 2) ? "Second Quarter" : (qtrChoice == 3) ? "Third Quarter" : "Fourth Quarter";
                    System.out.printf("%nEnter the sales revenue for the %s month of the %s: \n",monthNo, quarter);
                    salesRevenue = input.nextDouble();

                    quarterlySales += salesRevenue;
                    ++monthCounter;
                }

                annualSales += quarterlySales;
                ++qtrCounter;
            }
            System.out.printf("%nTANDEM ENTERPRISES");
            //dateTime.set(2002, 11, 4);
            //int date = dateTime.getYear();
            System.out.printf("%nSALES REVENUE FOR %d QUARTER(S) OF %d", noOfQtrs,dateTime.get(dateTime.YEAR));
            System.out.printf("%nSALES REP:  %s\n", salesRep);
            //System.out.printf("%nTotal Year-To-Date:  $%f\n", quarterlySales);
            System.out.printf("%n%nTotal Year-To-Date:      $%,19.2f%n", quarterlySales);
            percOfTargetRep = quarterlySales / (projectedSales/noSalesReps) * 100;
            if (noOfQtrs < 4) {
                if (percOfTargetRep >= 50) {
                    System.out.printf("%nKeep up the GOOD work, %s. There is a "+ "possible year-end bonus!%n",salesRep.substring(0, salesRep.indexOf(' ')));
                }
                else {
                    System.out.printf("%nSo far sales are lagging behind projections.");
                }
            }
        }
        while(salesRepCtr < noSalesReps);

        percOfTargetCo = (annualSales/projectedSales) * 100;

        System.out.printf("%nCORPORATE SALES PERFORMANCE");

        if (percOfTargetCo >= 100)
        {
            System.out.printf("%nIt’s been a GOOD year so far. There could be a year-end bonus of about 2-5% if we can keep on top of our sales goals. Thank you all and please continue your excellent effort!");
        }
        else {
            System.out.printf("%nSales are lagging projections. A year-end bonus may not be possible.");
        }

    }
}
