package dVeterinerlik.entity;

import dVeterinerlik.entity.DailyLog;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T02:00:10")
@StaticMetamodel(Veterinary.class)
public class Veterinary_ { 

    public static volatile SingularAttribute<Veterinary, Date> birthday;
    public static volatile SingularAttribute<Veterinary, DailyLog> dailyLog;
    public static volatile SingularAttribute<Veterinary, String> name;
    public static volatile SingularAttribute<Veterinary, Long> phoneNum;
    public static volatile SingularAttribute<Veterinary, Date> startUpDate;
    public static volatile SingularAttribute<Veterinary, Long> id;
    public static volatile SingularAttribute<Veterinary, Double> salary;
    public static volatile SingularAttribute<Veterinary, String> Surname;
    public static volatile SingularAttribute<Veterinary, String> email;
    public static volatile SingularAttribute<Veterinary, Long> tc;

}