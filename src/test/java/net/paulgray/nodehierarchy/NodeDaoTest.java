package net.paulgray.nodehierarchy;

import net.paulgray.nodehierarchy.NodeDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by pgray on 10/21/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/applicationContext.xml"})
public class NodeDaoTest {

    @Autowired
    NodeDao nodeDao;

    @Test
    public void testGetAllNodes(){
        for(Node node : nodeDao.getAllNodes()){
            System.out.println(node.getId() + ": " + node.getPath());
        }
    }

    @Test
    @Transactional
    public void testGetChildrenQuery(){
        Node node = nodeDao.getNodeById(1L);
        System.out.println("Children of node: " + node.getId());
        List<Node> children = nodeDao.queryChildren(node).list();
        for(Node n : children){
            System.out.println("    " + n.getId() + "-" + n.getPath());
        }

        
        Node node2 = nodeDao.getNodeById(4L);
        System.out.println("Children of node: " + node2.getId());
        List<Node> children2 = nodeDao.queryChildren(node2).list();
        for(Node n : children2){
            System.out.println("    " + n.getId() + "-" + n.getPath());
        }
    }

}
