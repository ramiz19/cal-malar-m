package dVeterinerlik.entity;

import dVeterinerlik.entity.Privilege;
import dVeterinerlik.entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-31T02:00:10")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile ListAttribute<Groups, Users> userss;
    public static volatile ListAttribute<Groups, Privilege> privileges;
    public static volatile SingularAttribute<Groups, String> name;
    public static volatile SingularAttribute<Groups, Long> id;
    public static volatile SingularAttribute<Groups, String> expo;

}