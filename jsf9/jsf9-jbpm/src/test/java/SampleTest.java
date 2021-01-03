import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;


public class SampleTest extends JbpmJUnitBaseTestCase {
	
	@Test
	public void testProcess() {
		createRuntimeManager("processes/sample.bpmn2");
		final RuntimeEngine engine = getRuntimeEngine(null);
		final KieSession ksession = engine.getKieSession();
		
		final ProcessInstance processInstance = ksession.startProcess("Process_1");
		
		assertProcessInstanceCompleted(processInstance.getId(), ksession);
		assertNodeTriggered(processInstance.getId(), "Hello");
		
		manager.disposeRuntimeEngine(engine);
		manager.close();
	}
}