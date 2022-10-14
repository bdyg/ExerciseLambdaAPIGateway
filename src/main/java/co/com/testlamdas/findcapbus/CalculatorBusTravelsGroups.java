package co.com.testlamdas.findcapbus;

import java.util.*;

public class CalculatorBusTravelsGroups {
    public String calculateCapacityBus(Map <String, String> groups){
        String[] nPersonsGroup= getStringArrayGroups(groups);
        List<Integer> numPersonsGroup = getIntArrayGroups(nPersonsGroup);
        LinkedList<Integer> ltOrden = new LinkedList<>(numPersonsGroup);
        Collections.sort(ltOrden);
        int firstGroupToBegin= ltOrden.getLast();
        boolean busHasFullCapacity = false;
        int limit = calculateLastCapacity(nPersonsGroup);
        int sizeBus = firstGroupToBegin;
        String sizesBusAccomplish= "";
        do {
            int occupiedSeats= 0;
            for (int i=0; i < nPersonsGroup.length; i++) {
                String strNumPersons = nPersonsGroup[i];
                int numPersons = Integer.parseInt(strNumPersons);
                occupiedSeats += numPersons;
                if (occupiedSeats == sizeBus){
                    occupiedSeats = 0;
                    busHasFullCapacity = true;

                }
                else if (occupiedSeats > sizeBus){
                    busHasFullCapacity = false;
                    break;
                }
                else if (i+1 == nPersonsGroup.length && occupiedSeats!=sizeBus){
                    busHasFullCapacity = false;
                }
            }
            if (busHasFullCapacity == true){
                String strSizeBus = String.valueOf(sizeBus);
                sizesBusAccomplish+= strSizeBus+",";
            }
            sizeBus++;

        }while (sizeBus < limit);
        String strLastSizeBus = String.valueOf(limit);
        sizesBusAccomplish+= strLastSizeBus;
        return sizesBusAccomplish;
    }

    public String[] getStringArrayGroups(Map <String,String> gr){
        Iterator<String> groups = gr.values().iterator();
        String[] numPersonsByGroup = groups.next().split(",");
        return numPersonsByGroup;
    }

    public List<Integer> getIntArrayGroups(String[] strNPersonsGroup){
        List<Integer> numPersonsAllGroups = new ArrayList<>();
        for (String strPersonsByGroup: strNPersonsGroup) {
            try {
                int numPersons = Integer.parseInt(strPersonsByGroup);
                numPersonsAllGroups.add(numPersons);
            }catch(NumberFormatException nfe){
                nfe.getMessage();
                nfe.printStackTrace();
                throw new NumberFormatException("The Format of value in input: \""+strPersonsByGroup+"\" is incorrect " +
                        " this is due to char that is not a number");
            }

        }
        return numPersonsAllGroups;
    }
    
    public int calculateLastCapacity(String[] nPersonsGroup){
        int lastCapacity = 0;

        for (String strNumPersons: nPersonsGroup) {
            int numPersons = Integer.parseInt(strNumPersons);
            lastCapacity+=numPersons;
        };
        return lastCapacity;
    }

}
