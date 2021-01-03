import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;

public class EnvironmentTest {
    
    @Test
    public void mavenHomeTest() {
        final String m2Home = System.getenv("M2_HOME");
        System.out.println(m2Home);

        Assert.assertNotNull(m2Home);
    }

    @Test
    public void kieContainerTest() {
        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId( "org.hunjsfprofessional", "jsf9-jbpm", "0.0.1-SNAPSHOT");
        KieContainer kContainer = kieServices.newKieContainer( releaseId );

        Assert.assertNotNull(kContainer.getKieBase());
    }
}
