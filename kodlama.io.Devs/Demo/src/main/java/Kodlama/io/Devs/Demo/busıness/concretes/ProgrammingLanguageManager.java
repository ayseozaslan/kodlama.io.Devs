package Kodlama.io.Devs.Demo.busıness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.Demo.busıness.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.Demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.Demo.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository; 
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}
	
    @Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}


	@Override
	public void add(ProgrammingLanguage languages) throws Exception {
		if(languages==null) {
			throw new Exception("The programming language cannot be passed empty.");
		}
		for(ProgrammingLanguage l1: programmingLanguageRepository.getAll()) {
			if(l1.getName() == languages.getName()) {
				throw new Exception("programming language available");
			}
			
		}
		
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
		
	}

	@Override
	public void update(int id, String name) {
		programmingLanguageRepository.update(id, name);
		
	}

	@Override
	public ProgrammingLanguage getById(int id) {
	
		return programmingLanguageRepository.getById(id);
	}

}