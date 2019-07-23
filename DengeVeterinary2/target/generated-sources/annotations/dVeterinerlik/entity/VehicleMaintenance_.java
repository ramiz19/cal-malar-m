package dVeterinerlik.entity;

import dVeterinerlik.entity.Driver;
import dVeterinerlik.entity.Vehicle;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T02:00:10")
@StaticMetamodel(VehicleMaintenance.class)
public class VehicleMaintenance_ { 

    public static volatile SingularAttribute<VehicleMaintenance, Double> cost;
    public static volatile SingularAttribute<VehicleMaintenance, Driver> driver;
    public static volatile SingularAttribute<VehicleMaintenance, Long> id;
    public static volatile SingularAttribute<VehicleMaintenance, Date> transactionDate;
    public static volatile SingularAttribute<VehicleMaintenance, String> explanation;
    public static volatile SingularAttribute<VehicleMaintenance, Vehicle> vehicle;

}