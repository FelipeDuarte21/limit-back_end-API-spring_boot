package com.hackathon.limit.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.limit.model.Client;
import com.hackathon.limit.model.Shedule;
import com.hackathon.limit.model.Store;
import com.hackathon.limit.model.DTO.SheduleDTO;
import com.hackathon.limit.repository.ClientRepository;
import com.hackathon.limit.repository.SheduleRepository;

@Service
public class SheduleService {
		
	@Autowired
	private SheduleRepository repository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private StoreService storeService;
	
	
	public String requestPassword(SheduleDTO shedule){
		
		Store store = this.storeService.findById(shedule.getStore());
		
		int dayOpen = this.dayOfWeek(store.getDayOpen());
		int dayClose = this.dayOfWeek(store.getDayClose());
		int hourOpen =  Integer.parseInt(store.getHourOpen().split(":")[0]);
		int hourClose = Integer.parseInt(store.getHourClose().split(":")[0]);
		
		System.out.println("Antes de Entrar");
		
		if(shedule.getDate().getDay() >= dayOpen && shedule.getDate().getDay() <= dayClose 
			&& shedule.getHour().getHours() >= hourOpen && shedule.getHour().getHours() <= hourClose) {
			
			System.out.print("Entrou aqui!");
			
			int limit = this.limit(store.getMaximumCapacity());
			
			GregorianCalendar gc = new GregorianCalendar();
		    gc.setTime(shedule.getHour());
		    
		    List<Shedule> shedules;
		    
		    boolean haveSpace = true;
			
			for(int i=0; i < shedule.getRangeTime(); i++) {
				gc.add(Calendar.MINUTE, store.getRangeTime());
				shedules = this.repository.findByStoreAndDateAndHour(store, 
						shedule.getDate(), gc.getTime());
				if(shedules.size() == limit) {
					haveSpace = false;
					break;
				}
			}
			
			if(haveSpace) {
				
				//Gerar senha
				String password = "A32546"; //Por enquanto
				
				System.out.println("Aqui 2");
				Client c = new Client();
				c.setName(shedule.getName()); 
				c.setCpf(shedule.getCpf());
				c = this.clientRepository.save(c);
				
				GregorianCalendar gc2 = new GregorianCalendar();
			    gc2.setTime(shedule.getHour());
			    
			    Shedule[] shedulesSalve = new Shedule[shedule.getRangeTime()];
				
				for(int i=0; i < shedulesSalve.length; i++) {
					gc2.add(Calendar.MINUTE, store.getRangeTime());
					shedulesSalve[i] = new Shedule();
					shedulesSalve[i].setClient(c);
					shedulesSalve[i].setStore(store);
					shedulesSalve[i].setDate(gc2.getTime());
					shedulesSalve[i].setPassword(password);
				}
				
				for(int i=0; i < shedulesSalve.length; i++) {
					shedulesSalve[i].setClient(this.clientRepository.save(shedulesSalve[i].getClient()));
					this.repository.save(shedulesSalve[i]);
				}
				
				return password;
				
			}
			
		}
		
		return null;
	}
	
	private int dayOfWeek(String day) {
		switch(day) {
			case "Domingo":
				return 0;
			case "Segunda":
				return 1;
			case "Terça":
				return 2;
			case "Quarta":
				return 3;
			case "Quinta":
				return 4;
			case "Sexta":
				return 5;
			case "Sábado":
				return 6;
			default:
				return -1;
		}
	}
	
	private int limit(int maximumCapacity) {
		
		return (50 * maximumCapacity) / 100;
		
	}
	
	public void enablePassword(String password){
		
	}
	
	public void disablePassword(String password){
		
	}
	
}
