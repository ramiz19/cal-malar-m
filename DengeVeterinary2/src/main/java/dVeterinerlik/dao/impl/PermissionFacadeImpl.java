/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.PermissionFacadeImplLocal;
import dVeterinerlik.entity.Groups;
import dVeterinerlik.entity.Privilege;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Alaa SHATTI
 */
@Stateless
public class PermissionFacadeImpl extends BaseFacade<Privilege> implements PermissionFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public PermissionFacadeImpl() {
        super(Privilege.class);
    }

    @Override
    public boolean hasPerm(Groups g, String module, String process) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Privilege> rt = cq.from(Privilege.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("MODULE"), module),
                cb.equal(rt.get(process), true),
                cb.equal(rt.get("groups"), g)));
        Query q = getEntityManager().createQuery(cq);
        
        if (q.getResultList().isEmpty()) {
            return false;
        }

        return true;

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
