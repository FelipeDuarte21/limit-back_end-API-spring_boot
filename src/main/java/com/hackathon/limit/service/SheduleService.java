package com.hackathon.limit.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.limit.model.Shedule;
import com.hackathon.limit.model.Store;
import com.hackathon.limit.model.DTO.SheduleDTO;
import com.hackathon.limit.model.DTO.SheduleReturnDTO;
import com.hackathon.limit.model.enums.StatusType;
import com.hackathon.limit.repository.SheduleRepository;

@Service
public class SheduleService {
		
	@Autowired
	private SheduleRepository repository;
	
	@Autowired
	private StoreService storeService;
	
	
	public SheduleReturnDTO requestPassword(SheduleDTO shedule){
		
		Store store = this.storeService.findById(shedule.getStore());
		
		//Verifica se tem tempo disponivel
		boolean haveSpace = true;
		
		int limit = this.limit(store.getMaximumCapacity());
		
		GregorianCalendar gc = this.getCalendar(shedule.getHour());
		
		for(int i=0; i < shedule.getRangeTime(); i++) {
			gc.add(Calendar.MINUTE, store.getRangeTime()*i);
			LocalDateTime ldt = this.getLocalDateTime(gc);
			List<Shedule> shedules = this.repository.findByStoreAndDateAndHour(store, 
						shedule.getDate(), ldt);
			if(shedules.size() == limit) {
				haveSpace = false;
				break;
			}
		}
			
		//Se tiver tempo, reserva o tempo
		if(haveSpace) {
				
			//Gerar senha
			String password = this.passwordGenerator();
				
				
			GregorianCalendar gc2 = this.getCalendar(shedule.getHour());
			System.out.println("hora: " + gc2.getTime());
			
			LocalDateTime end = null;
			
			for(int i=0; i < shedule.getRangeTime(); i++) {
				gc2.add(Calendar.MINUTE, store.getRangeTime()*i);
				
				Shedule s = new Shedule();
				s.setName(shedule.getName());
				s.setCpf(shedule.getCpf());
 				s.setStore(store);
				s.setDate(shedule.getDate());
				s.setHour(this.getLocalDateTime(gc2));
				s.setPassword(password);
				s.setStatus(StatusType.SHEDULED.getCod());
				this.repository.save(s);
				if(i == shedule.getRangeTime() - 1) { //Pega o tempo do ultimo
					gc2.add(Calendar.MINUTE, store.getRangeTime());
					end = this.getLocalDateTime(gc2);
				}
			}
				
			SheduleReturnDTO sheduleReturn = new SheduleReturnDTO();
			sheduleReturn.setName(shedule.getName());
			sheduleReturn.setCpf(shedule.getCpf());
			sheduleReturn.setPassword(password);
			sheduleReturn.setDate(shedule.getDate());
			sheduleReturn.setStart(shedule.getHour());
			sheduleReturn.setEnd(end);
				
			return sheduleReturn;
		}else {
			SheduleReturnDTO sheduleReturn = new SheduleReturnDTO();
			sheduleReturn.setDate(null);
			return sheduleReturn;
		}
		
	}
	
	private int limit(int maximumCapacity) {
		return (50 * maximumCapacity) / 100;
	}
	
	private GregorianCalendar getCalendar(LocalDateTime ldt) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.DATE, ldt.getDayOfMonth());
		gc.set(Calendar.MONTH, ldt.getMonth().getValue()-1);
		gc.set(Calendar.YEAR, ldt.getYear());
		gc.set(Calendar.HOUR, ldt.getHour());
		gc.set(Calendar.MINUTE, ldt.getMinute());
		gc.set(Calendar.SECOND, ldt.getSecond());
		return gc;
	}
	
	private LocalDateTime getLocalDateTime(GregorianCalendar gc) {
		LocalDateTime ldt = LocalDateTime.of(
			gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE), 
			gc.get(Calendar.HOUR), gc.get(Calendar.MINUTE));
		return ldt;
	}
	
	private String passwordGenerator() {
		
		String password = "";
		
		int qtdLetter = 2;
		int qtdNumber = 3;
		
		
		String numbers[] = {"0","1","2","3","4","5","6","7","8","9"};
		String alphabet[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","y","x","z"};
		
		Random rd = new Random();
		
		for(int i=0; i < qtdLetter; i++) {
			String letter = alphabet[rd.nextInt(alphabet.length)];
			password += letter;
		}
		
		for(int i=0; i < qtdNumber; i++) {
			String number = numbers[rd.nextInt(numbers.length)];
			password += number;
		}
		
		return password;
	}
	
	public void enablePassword(String password){
		
	}
	
	public void disablePassword(String password){
		
	}
	
}
