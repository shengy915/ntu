public class SalePerson implements Comparable{
    private String firstName;
    private String lastName;
    private int totalSales;

    public SalePerson(String firstName, String lastName, int totalSales){
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSales = totalSales;
    }

    public String toString(){
        return String.format("%s, %s : %d",lastName,firstName,totalSales);
 
    }

    public boolean equals(Object obj){
        Comparable x = ((SalePerson) obj).getFirstName();
        Comparable y = ((SalePerson) obj).getLastName();
        return ((x.compareTo(firstName))== 0 && (y.compareTo(lastName))==0);
    }

    public int compareTo(Object obj){
        Comparable x = ((SalePerson) obj).getTotalSales();
        int y = x.compareTo(totalSales);
        if (y==0){
            Comparable last = ((SalePerson) obj).getLastName();
            int z = last.compareTo(lastName);
            return z;
        }
        return y;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getTotalSales(){
        return totalSales;
    }
}
