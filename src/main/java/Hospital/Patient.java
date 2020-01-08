package Hospital;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pat")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String name; 
private String dise;
private Integer age;
private Integer fee;
public Integer getFee() {
	return fee;
}
public void setFee(Integer fee) {
	this.fee = fee;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getDise() {
	return dise;
}
public void setDise(String dise) {
	this.dise = dise;
}

}
