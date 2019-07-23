package dVeterinerlik.entity;

import dVeterinerlik.entity.DailyLog;
import dVeterinerlik.entity.VehicleMaintenance;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T02:00:10")
@StaticMetamodel(Driver.class)
public class Driver_ { 

    public static volatile SingularAttribute<Driver, Date> birthday;
    public static volatile SingularAttribute<Driver, DailyLog> dailyLog;
    public static volatile SingularAttribute<Driver, String> name;
    public static volatile SingularAttribute<Driver, VehicleMaintenance> vehicleMaintenance;
    public static volatile SingularAttribute<Driver, Long> phoneNum;
    public static volatile SingularAttribute<Driver, Date> startUpDate;
    public static volatile SingularAttribute<Driver, Long> id;
    public static volatile SingularAttribute<Driver, Double> salary;
    public static volatile SingularAttribute<Driver, String> Surname;
    public static volatile SingularAttribute<Driver, String> email;
    public static volatile SingularAttribute<Driver, Long> tc;

}