package dVeterinerlik.entity;

import dVeterinerlik.entity.DailyLog;
import dVeterinerlik.entity.VehicleMaintenance;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T02:00:10")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, String> plaque;
    public static volatile SingularAttribute<Vehicle, VehicleMaintenance> vehicleMaintenance;
    public static volatile SingularAttribute<Vehicle, Long> id;
    public static volatile SingularAttribute<Vehicle, String> type;
    public static volatile SingularAttribute<Vehicle, DailyLog> dailyLogs;
    public static volatile SingularAttribute<Vehicle, String> brand;

}