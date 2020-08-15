package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "world")
public class World implements Serializable {
	
	private static final long serialVersionUID = 4931841736107790659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "universe")
	private String universe;
	
	@Column(name = "helloed")
	private boolean helloed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUniverse() {
		return universe;
	}

	public void setUniverse(String universe) {
		this.universe = universe;
	}

	public boolean isHelloed() {
		return helloed;
	}

	public void setHelloed(boolean helloed) {
		this.helloed = helloed;
	}
	
	
}
