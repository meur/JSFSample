import domain.World;
import domain.dao.WorldDao;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class MyTest1 {

    @Inject
    private WorldDao worldDao;

    @Test
    public void testDbListing() {
        final long originalListSize = worldDao.findAll().size();
        Assert.assertNotEquals("List size should not be zero", 0L, originalListSize);
        createAndPersistNewWorld();
        final long newListSize = worldDao.findAll().size();
        Assert.assertEquals("List size should be increased by 1", originalListSize + 1, newListSize);
    }

    private void createAndPersistNewWorld() {
        final World world = new World();
        world.setHelloed(true);
        world.setUniverse("keine");
        worldDao.save(world);
    }

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addPackages(false, "domain", "domain.dao")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");

        System.out.println(war.toString(true));
        return war;
    }
}
