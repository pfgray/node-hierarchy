package net.paulgray.nodehierarchy;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by pgray on 10/21/14.
 */
@Repository
public class NodeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Node getNodeById(Long id){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Node.class);
        crit.add(Restrictions.eq("id", id));
        return (Node) crit.uniqueResult();
    }

    @Transactional
    public Criteria queryChildren(Node node){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Node.class);
        crit.add(Restrictions.like("path", node.getPath() + "/%"));
        crit.add(Restrictions.not(Restrictions.like("path", node.getPath() + "/%/%")));
        return crit;
    }

    @Transactional
    public List<Node> getAllNodes(){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Node.class);
        return crit.list();
    }

}
