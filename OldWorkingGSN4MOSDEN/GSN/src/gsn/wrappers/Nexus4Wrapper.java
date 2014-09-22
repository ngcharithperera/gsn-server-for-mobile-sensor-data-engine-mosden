package gsn.wrappers;

import gsn.beans.AddressBean;
import gsn.beans.DataField;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * This wrapper presents a MultiFormat protocol in which the data comes from the
 * system clock. Think about a sensor network which produces packets with
 * several different formats. In this example we have 3 different packets
 * produced by three different types of sensors. Here are the packet structures
 * : [temperature:double] , [light:double] , [temperature:double, light:double]
 * The first packet is for sensors which can only measure temperature while the
 * latter is for the sensors equipped with both temperature and light sensors.
 * 
 */
public class Nexus4Wrapper extends AbstractWrapper {
  private DataField[] collection = new DataField[] { 
		  new DataField("temperature", "double", ""),
          new DataField("humidity", "double", ""), 
		  new DataField("luminosity", "double", ""),
          new DataField("dust", "double", ""), 
          new DataField("sound", "double", ""),
          new DataField("presence", "varchar(30)", ""),
          new DataField("crack_detection", "varchar(30)", "")};
  private final transient Logger logger = Logger.getLogger(Nexus4Wrapper.class);
  private int counter;
  private AddressBean params;
  private long rate = 1000;

  public boolean initialize() {
    setName("MultiFormatWrapper" + counter++);
    
    params = getActiveAddressBean();
    
    if ( params.getPredicateValue( "rate" ) != null ) {
      rate = (long) Integer.parseInt( params.getPredicateValue( "rate"));
      
      logger.info("Sampling rate set to " + params.getPredicateValue( "rate") + " msec.");
    }
    
    return true;
  }

  public void run() {
    Double temperature = 24.12; 
    Double humidity = 26.57;
    Double luminosity  = 85.42;
    Double dust  = 0.082;
    Double sound  = 68.25;
  //  int packetType = 0;
    
    String presence = "True";
    String crack_detection = "False";
    
    while (isActive()) {
      try {
        // delay 
        Thread.sleep(rate);
      } catch (InterruptedException e) {
        logger.error(e.getMessage(), e);
      }
      
      // create some random readings
      //air_temperature=18.2;
//      air_temperature=Math.random();
//      //air_humidity =77.0;
//      air_humidity =Math.random();
//
//      leaf_wetness  =29.91;
//      
//      
//      phytophtora_disease = "false";
//      air_stress = "low";
      
      
  //    packetType = 2;

      // post the data to GSN
      postStreamElement(new Serializable[] { temperature, humidity, luminosity, dust, sound, presence, crack_detection  });       
    }
  }

  public DataField[] getOutputFormat() {
    return collection;
  }

  public String getWrapperName() {
    return "MultiFormat Sample Wrapper";
  }  

  public void dispose() {
    counter--;
  }
}
