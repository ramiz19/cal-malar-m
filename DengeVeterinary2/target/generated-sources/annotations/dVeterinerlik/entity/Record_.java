package dVeterinerlik.entity;

import dVeterinerlik.entity.Institution;
import dVeterinerlik.entity.Secretary;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T02:00:10")
@StaticMetamodel(Record.class)
public class Record_ { 

    public static volatile SingularAttribute<Record, String> note;
    public static volatile SingularAttribute<Record, Institution> institution;
    public static volatile SingularAttribute<Record, Secretary> secretary;
    public static volatile SingularAttribute<Record, Long> id;
    public static volatile SingularAttribute<Record, String> appointmentDate;

}