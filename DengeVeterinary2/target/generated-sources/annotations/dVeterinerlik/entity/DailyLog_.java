package dVeterinerlik.entity;

import dVeterinerlik.entity.Driver;
import dVeterinerlik.entity.Fieldman;
import dVeterinerlik.entity.Vehicle;
import dVeterinerlik.entity.Veterinarian;
import dVeterinerlik.entity.Veterinary;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T02:00:10")
@StaticMetamodel(DailyLog.class)
public class DailyLog_ { 

    public static volatile ListAttribute<DailyLog, Veterinarian> veterinarians;
    public static volatile SingularAttribute<DailyLog, Driver> driver;
    public static volatile ListAttribute<DailyLog, Fieldman> fieldmans;
    public static volatile SingularAttribute<DailyLog, Veterinary> veterinary;
    public static volatile SingularAttribute<DailyLog, Long> id;
    public static volatile SingularAttribute<DailyLog, String> place;
    public static volatile SingularAttribute<DailyLog, Date> dateWorked;
    public static volatile SingularAttribute<DailyLog, Vehicle> vehicle;

}