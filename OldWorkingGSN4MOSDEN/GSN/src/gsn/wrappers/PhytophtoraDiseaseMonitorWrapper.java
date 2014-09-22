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
public class PhytophtoraDiseaseMonitorWrapper extends AbstractWrapper {
  private DataField[] collection = new DataField[] { 
		  new DataField("air_temperature", "double", "packet type"),
          new DataField("air_humidity", "double", "Presents the temperature sensor."), 
		  new DataField("air_stress", "varchar(10)", "packet type"),
          new DataField("leaf_wetness", "double", "Presents the temperature sensor."), 
          new DataField("phytophtora_disease", "varchar(30)", "Presents the light sensor."),
		  new DataField("packet_type", "int", "packet type")};
  private final transient Logger logger = Logger.getLogger(PhytophtoraDiseaseMonitorWrapper.class);
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
    Double air_temperature = 0.0, air_humidity = 0.0, leaf_wetness  = 0.0;
    int packetType = 0;
    String phytophtora_disease = null;
    String air_stress = null;
    
    while (isActive()) {
      try {
        // delay 
        Thread.sleep(rate);
      } catch (InterruptedException e) {
        logger.error(e.getMessage(), e);
      }
      
      // create some random readings
      //air_temperature=18.2;
      air_temperature=Math.random();
      //air_humidity =77.0;
      air_humidity =Math.random();

      leaf_wetness  =Math.random();
      
      
      phytophtora_disease = "false";
      air_stress = "low";
      
      
      packetType = 2;

      // post the data to GSN
      postStreamElement(new Serializable[] { air_temperature, air_humidity, air_stress, leaf_wetness, phytophtora_disease, packetType  });       
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
