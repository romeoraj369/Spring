package Hospital;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PaContr {
	ResponseEntity<Patient> re;
	@Autowired
	private PaDAO pd;
	@GetMapping("/getall")
	public List<Patient> getall(){
		return pd.findAll();
	}
	
	
	  //http://localhost:8080/test0/4
	  
	  @GetMapping("/{sid}")
	  public Patient getbyId(@PathVariable("sid")int id)
	  { 
		  Optional<Patient> va = pd.findById(id); 
	  if(va.isPresent()) { return
	  va.get(); } else { return null; } }
	  	
	
	  @PostMapping("/{nam}/{dis}/{age}") public void
	  SvePtnt(@PathVariable("nam")String dname,
	          @PathVariable("dis")String ddise,
	          @PathVariable("age")Integer dage) {
	  Patient p = new Patient();
	  p.setName(dname); p.setDise(ddise);
	  p.setAge(dage); pd.save(p);
	  
	  }
	/*
	 * @RequestMapping("test1/{n}/{d}/{a}") public void pd(@PathVariable("n")String
	 * name,
	 * 
	 * @PathVariable("d")String dis,
	 * 
	 * @PathVariable("a") int age) { Patient p = new Patient(); p.setName(name);
	 * p.setDise(dis); p.setAge(age); pd.save(p); }
	 */
	//localhost:8080/test2?name=abc&dise=ghjk&age=78
	  @PostMapping("/save") 
	  public void pd(Patient p) {
		  pd.save(p); }
	 
	@PostMapping("/jsave")
	public ResponseEntity<Patient> pd1(@RequestBody Patient pt) {
		try {
			pd.save(pt);
			re = new ResponseEntity<Patient>(HttpStatus.CREATED);
			
			
		} catch (Exception e) {
			re = new ResponseEntity<Patient>(HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		return re;
	}
	@DeleteMapping("/delby/{id}")
	public ResponseEntity<Patient> delbyid(@PathVariable("id") int id){
		
		try {
			pd.deleteById(id);
			re = new ResponseEntity<Patient>(HttpStatus.OK);
			
		} catch (Exception e) {
			re = new ResponseEntity<Patient>(HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		return re;
	}
	
}
