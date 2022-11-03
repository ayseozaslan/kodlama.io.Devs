package Kodlama.io.Devs.Demo.dataAccess.concretes;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.Demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.Demo.entities.concretes.ProgrammingLanguage;
//import net.bytebuddy.implementation.bytecode.Throw;


@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
    List<ProgrammingLanguage> programmingLanguages;
    
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages=new ArrayList<ProgrammingLanguage>();
		
		programmingLanguages.add(new ProgrammingLanguage(1,"c#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"java"));
		programmingLanguages.add(new ProgrammingLanguage(3,"python"));
		
	}
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		
	
		return programmingLanguages;
	}
	
	public void add(ProgrammingLanguage languages) {
		programmingLanguages.add(languages);
		
	}
		
	
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage l1:this.programmingLanguages) {
			if(l1.getId()==id) {
				return l1;
			}
			else {
				System.out.println("no data to fetch with id");
			}
		}
		return null;
		
	}
	
	public void delete(int id) {
		for(ProgrammingLanguage l1:this.programmingLanguages) {
			if(l1.getId()==id) {
				this.programmingLanguages.remove(l1);
				return;
			}
		}
	}
	
	public void update(int id,String name) {
		for(ProgrammingLanguage l1:this.programmingLanguages) {
			if(l1.getId()==id) {
				l1.setName(name);
			}
				
		}
		
	}
	
	

}
