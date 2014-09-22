package gsn.vsensor;

import gsn.beans.StreamElement;

import gsn.beans.VSensorConfig;

import org.apache.log4j.Logger;

import com.a.agriculture.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;

public class BridgeVirtualSensorV3 extends AbstractVirtualSensor {

    private static final transient Logger logger = Logger.getLogger(BridgeVirtualSensorV3.class);
    private boolean allow_nulls = true; // by default allow nulls
   
    //No Reflection Approach
    Component1 c1;   
    Component2 c2;
    Component3 c3;
    Component4 c4;
    Component5 c5;
    Component6 c6;
    Component7 c7;
    Component8 c8;
    Component9 c9;
    Component10 c10;
    
//    //Reflection Approach
//    Class cls[]= new Class[10];
//    Object obj[]= new Object[10];
//    Method method[]= new Method[10];
    
  Class cls[];
  Object obj[];
  Method method[];    
    public boolean initialize() {
    	//charith
    	double startTime = System.nanoTime();
        //Reflection Approach
         cls= new Class[10];
         obj= new Object[10];
         method= new Method[10];
		
		try {
		
//			c1 = new Component1();
//			c2 = new Component2();
//			c3 = new Component3();
//			c4 = new Component4();
//			c5 = new Component5();
//			
//			c6 = new Component6();
//			c7 = new Component7();
//			c8 = new Component8();
//			c9 = new Component9();
//			c10 = new Component10();
			
			
//			Class[] paramString = new Class[1];	
//			paramString[0] = double.class;
			
			
			
			
			
			
			
//Latest comments			
//			cls[0] = Class.forName("com.a.agriculture.Component10");
//			obj[0] = cls[0].newInstance();
//			method[0] = cls[0].getMethod("process10", double.class);
//			
//			cls[1] = Class.forName("com.a.agriculture.Component9");
//			obj[1] = cls[1].newInstance();
//			method[1] = cls[1].getMethod("process1", double.class);
//			
//			cls[2] = Class.forName("com.a.agriculture.Component8");
//			obj[2] = cls[2].newInstance();
//			method[2] = cls[2].getMethod("process2", double.class);
//			
//			cls[3] = Class.forName("com.a.agriculture.Component7");
//			obj[3] = cls[3].newInstance();
//			method[3] = cls[3].getMethod("process3", double.class);
//			
//			cls[4] = Class.forName("com.a.agriculture.Component6");
//			obj[4] = cls[4].newInstance();
//			method[4] = cls[4].getMethod("process4", double.class);
//			
//			cls[5] = Class.forName("com.a.agriculture.Component5");
//			obj[5] = cls[5].newInstance();
//			method[5] = cls[5].getMethod("process5", double.class);
//			
//			cls[6] = Class.forName("com.a.agriculture.Component4");
//			obj[6] = cls[6].newInstance();
//			method[6] = cls[6].getMethod("process6", double.class);
//			
//			cls[7] = Class.forName("com.a.agriculture.Component3");
//			obj[7] = cls[7].newInstance();
//			method[7] = cls[7].getMethod("process7", double.class);
//			
//			cls[8] = Class.forName("com.a.agriculture.Component2");
//			obj[8] = cls[8].newInstance();
//			method[8] = cls[8].getMethod("process8", double.class);
//			
//			cls[9] = Class.forName("com.a.agriculture.Component1");
//			obj[9] = cls[9].newInstance();
//			method[9] = cls[9].getMethod("process9", double.class);
			//Latest comments				

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Latest comments	    	
		//double endTime = System.nanoTime();
		//System.out.println("Initiation Delay: "+(endTime - startTime));
		//Latest comments	

        VSensorConfig vsensor = getVirtualSensorConfiguration();
        TreeMap<String, String> params = vsensor.getMainClassInitialParams();

        String allow_nulls_str = params.get("allow-nulls");
        if (allow_nulls_str != null)
            allow_nulls = allow_nulls_str.equalsIgnoreCase("true");

        return true;
    }

    public void dataAvailable(String inputStreamName, StreamElement data) {
        if (allow_nulls){
        	//charith
        	double startTime = System.nanoTime();
        	
        	try {
//        		data.getData()[0]=  (Double) c1.process(Double.parseDouble(data.getData()[0].toString()));  
//        		data.getData()[0]=  (Double) c2.process7(Double.parseDouble(data.getData()[0].toString())); 
//        		data.getData()[0]=  (Double) c3.process6(Double.parseDouble(data.getData()[0].toString())); 
//        		data.getData()[0]=  (Double) c4.process4(Double.parseDouble(data.getData()[0].toString()));
//        		data.getData()[0]=  (Double) c5.process5(Double.parseDouble(data.getData()[0].toString()));  
//        		
//        		data.getData()[0]=  (Double) c6.process6(Double.parseDouble(data.getData()[0].toString()));  
//        		data.getData()[0]=  (Double) c7.process7(Double.parseDouble(data.getData()[0].toString()));  
//        		data.getData()[0]=  (Double) c8.process8(Double.parseDouble(data.getData()[0].toString()));  
//        		data.getData()[0]=  (Double) c9.process9(Double.parseDouble(data.getData()[0].toString()));  
//        		data.getData()[0]=  (Double) c10.process10(Double.parseDouble(data.getData()[0].toString()));  
        		//Latest comments	
//        		data.getData()[0]= (Double) method[0].invoke(obj[0], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[1].invoke(obj[1], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[2].invoke(obj[2], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[3].invoke(obj[3], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[4].invoke(obj[4], Double.parseDouble(data.getData()[0].toString())) ;
//        		
//        		data.getData()[0]= (Double) method[5].invoke(obj[5], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[6].invoke(obj[6], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[7].invoke(obj[7], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[8].invoke(obj[8], Double.parseDouble(data.getData()[0].toString())) ;
//        		data.getData()[0]= (Double) method[9].invoke(obj[9], Double.parseDouble(data.getData()[0].toString())) ;
        		//Latest comments	   		
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	
        	
        	
        	
        	//Latest comments	
        	//double endTime = System.nanoTime();
        	//System.out.println((endTime - startTime));        		
        	//System.out.println(data.getData()[0]);
        	//Latest comments	
            dataProduced(data);
        } else {
            if (!areAllFieldsNull(data))
                dataProduced(data);
            else {
                if (logger.isDebugEnabled())
                    logger.debug("Nulls received for timestamp (" + data.getTimeStamp() + "), discarded");
            }
        }
        if (logger.isDebugEnabled()) logger.debug("Data received under the name: " + inputStreamName);
    }

    public boolean areAllFieldsNull(StreamElement data) {
        boolean allFieldsNull = false;
        for (int i = 0; i < data.getData().length; i++)
            if (data.getData()[i] == null) {
                allFieldsNull = true;
                break;
            }

        return allFieldsNull;
    }

    public void dispose() {

    }

}
