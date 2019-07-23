/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.UsersFacadeImplLocal;
import dVeterinerlik.entity.Users;
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
public class UsersFacadeImpl extends BaseFacade<Users> implements UsersFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public UsersFacadeImpl() {
        super(Users.class);
    }

    @Override
    public Users login(String email, String password) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Users> rt = cq.from(Users.class);
        cq.select(rt);
        cq.where(cb.and(cb.equal(rt.get("email"), email), cb.equal(rt.get("password"), password)));
        Query q = getEntityManager().createQuery(cq);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return (Users) q.getResultList().get(0);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   
}
