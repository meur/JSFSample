import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class HelloWorld implements Serializable {

	private static final long serialVersionUID = -3662073815964820807L;

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HelloWorld Constructed!");
	}

	public String getMessage() {
		return "Hello World!";

	}
}