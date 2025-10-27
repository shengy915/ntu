package lab_3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Plane {
    private PlaneSeat[] seat = new PlaneSeat[12];
    private int numEmptySeat = 12;
    private int[] customer_ids = new int[12];
    public Plane()
    {
        for (int i = 0; i<12; i++){
            seat[i] =new PlaneSeat(i + 1);
        }
    }

    private PlaneSeat[] sortSeats()
    {
        PlaneSeat[] sorted = Arrays.copyOf(seat, seat.length);

        // Sort by Customer ID, occupied seats customer id = 0
        Arrays.sort(sorted, Comparator.comparingInt(PlaneSeat::getCustomerID));

        return sorted;
    }

    public void showNumEmptySeats()
    {
        System.out.printf("There are %d empty seats\n\n", numEmptySeat);
    }

    public void showEmptySeats()
    {
        System.out.println("The following seats are empty:\n");
        for (PlaneSeat ps : seat){
            if (!ps.isOccupied()){
                System.out.printf("SeatID %d\n", ps.getSeatID());
            }
        }
    }

    public void showAssignedSeats(boolean bySeatId)
    {
        System.out.println("The seat assignments are as follows:\n");

        if (bySeatId) {
            for (PlaneSeat planeSeat : seat) {
                if (planeSeat.isOccupied())
                    System.out.printf("SeatID %d assigned to CustomerId %d\n", planeSeat.getSeatID(), planeSeat.getCustomerID());
            }
        }
        else
        {
            PlaneSeat[] sorted = sortSeats();
            for (PlaneSeat planeSeat : sorted) {
                if (planeSeat.isOccupied())
                    System.out.printf("SeatID %d assigned to CustomerId %d\n", planeSeat.getSeatID(), planeSeat.getCustomerID());
            }
        }
    }

    public void assignSeat(int seatId, int cust_id)
    {
        PlaneSeat ps = seat[seatId - 1];
        if (ps.isOccupied()){
            System.out.println("seat already taken.");
            return;
        }
        for (int i = 0; i <12; i++){
            if (customer_ids[i] == cust_id){
                System.out.println("cust id alr used");
                return;
            }
        }
        ps.assign(cust_id);
        customer_ids[seatId-1] = cust_id;
        numEmptySeat--;
        System.out.println("seat assigned!");
    }

    public void unAssignSeat(int seatId)
    {
        PlaneSeat ps = seat[seatId - 1];
        if (ps.isOccupied()){
            ps.unAssign();
            numEmptySeat++;
            customer_ids[seatId]=0;
            System.out.println("seat unassigned :(");
        } else {
            System.out.println("seat not assigned to u");
        }
    }
}