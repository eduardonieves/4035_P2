package utils;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
//		if (o1.getArrivalTime() < o2.getArrivalTime())
//        {
//            return -1;
//        }
//        if (o1.getArrivalTime() > o2.getArrivalTime())
//        {
//            return 1;
//        }
        return o1.getArrivalTime() - o2.getArrivalTime();
	}

}
