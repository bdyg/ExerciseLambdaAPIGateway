package co.com.testlamdas.findcapbus;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorBusTravelsGroupsTest {
    @Test
    void CalculateCapacityBus() {
        Map <String,String> mapExample= new HashMap<String, String>();
        mapExample.put("groups","1,2,1,1,1,2,1,3");
        CalculatorBusTravelsGroups cbtG= new CalculatorBusTravelsGroups();
        String strResponse = cbtG.calculateCapacityBus(mapExample);
        assertEquals("3,4,6,12",strResponse);
    }

    @Test
    void CalculateLastCapacity(){
        CalculatorBusTravelsGroups cbtG= new CalculatorBusTravelsGroups();
        String [] stringArrayTest = {"1","2","3","100000000"};
        int limit = cbtG.calculateLastCapacity(stringArrayTest);
        assertEquals(100000006,limit);

    }

    @Test
    void GetArrayGroups(){
         Map <String,String> mapExample= new HashMap<String, String>();
         mapExample.put("groups","1,2,3,1523,1452,1500");
         CalculatorBusTravelsGroups cbtG= new CalculatorBusTravelsGroups();
         String [] testOutput = cbtG.getStringArrayGroups(mapExample);
         assertEquals(6,testOutput.length);
         assertEquals("1",testOutput[0]);
         assertEquals("2",testOutput[1]);
         assertEquals("3",testOutput[2]);
         assertEquals("1523",testOutput[3]);
         assertEquals("1452",testOutput[4]);
         assertEquals("1500",testOutput[5]);
    }

    @Test
    void getIntArrayGroups(){
        String [] strArrayTest = {"1","2","3","1523","1452","1500"};
        CalculatorBusTravelsGroups cbtG= new CalculatorBusTravelsGroups();
        List <Integer> testOutput = cbtG.getIntArrayGroups(strArrayTest);
        assertEquals(6,testOutput.size());
        assertEquals(1,testOutput.get(0));
        assertEquals(2,testOutput.get(1));
        assertEquals(3,testOutput.get(2));
        assertEquals(1523,testOutput.get(3));
        assertEquals(1452,testOutput.get(4));
        assertEquals(1500,testOutput.get(5));
    }
}