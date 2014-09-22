package gsn.vsensor;

import gsn.beans.StreamElement;

import gsn.beans.VSensorConfig;
import org.apache.log4j.Logger;
import java.util.TreeMap;

public class BridgeVirtualSensor extends AbstractVirtualSensor {

    private static final transient Logger logger = Logger.getLogger(BridgeVirtualSensor.class);
    private boolean allow_nulls = true; // by default allow nulls
   
    public boolean initialize() {
        //Change by charith to measure Delay in ColloborativeCom 2013 paper
    	VSensorConfig vsensor = getVirtualSensorConfiguration();
        TreeMap<String, String> params = vsensor.getMainClassInitialParams();

        String allow_nulls_str = params.get("allow-nulls");
        if (allow_nulls_str != null)
            allow_nulls = allow_nulls_str.equalsIgnoreCase("true");

        return true;
        
        
    }

    public void dataAvailable(String inputStreamName, StreamElement data) {
    	System.out.println(this.getVirtualSensorConfiguration().getName()+","+ System.currentTimeMillis());

    	//data.getData()[0] = Double.parseDouble(data.getData()[0].toString()) + Double.parseDouble(data.getData()[1].toString());  
    	//data.getData()[1] = Double.parseDouble(data.getData()[0].toString()) + Double.parseDouble(data.getData()[1].toString());  
    	//data.getData().
        if (allow_nulls){
        	//System.out.println("New Sensor");
        	
            dataProduced(data);
        } else {
            if (!areAllFieldsNull(data)){
                dataProduced(data);
            }
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
