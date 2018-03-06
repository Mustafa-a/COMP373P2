package com.comp373.view;

import com.comp373.model.human.*;

import java.util.ArrayList;
import java.util.List;

import com.comp373.model.bankaccount.*;
import com.comp373.model.building.Battledome;
import com.comp373.model.facility.Gym;
import com.comp373.models.pokemon.*;

public class BattleDomeFacilitiesClient {
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main (String args[]) throws Exception {
		
        Manager manager = new Manager();
		manager.setFirstName("Professor");
        manager.setLastName("Oak");
        manager.setHumanId(456789054);

        System.out.println("\tManager: \t\t" + manager.getFirstName() + " " + manager.getLastName()+"\n");
        System.out.println("\tManager ID: \t\t" + manager.getHumanId() + "\n");
        
        //Make manager bank account
        BankAccount mangBankAccount = new BankAccount();
        mangBankAccount.setTotalFunds(1500.67);
        manager.setBankAccount(mangBankAccount);
        System.out.println("\tManager's Bank Account funds:\t" + manager.getBankAccount().getTotalFunds() + "\n");
        System.out.println("\t"+manager.getFirstName()+"'s Bank Account number (random generation):\t"+manager.getBankAccount().getAccountNumer()+"\n");
        
        //Create a BattleDome
        Battledome redVersion = new Battledome();
        redVersion.setBuildingId("BattleDome01");
        //Assign it to the manager
        manager.setBattleDome(redVersion);
        
        //Create a trainer
        Trainer trainer = new Trainer();
        trainer.setFirstName("Ash");
        trainer.setLastName("Ketchum");
        trainer.setHumanId(12345678);
        trainer.setNumOfBadges(2);
        
        System.out.println("\tTrainer: \t\t" + trainer.getFirstName() + " " + trainer.getLastName()+"\n");
        System.out.println("\tTrainer ID: \t\t" + trainer.getHumanId() + "\n");
        System.out.println("\t"+trainer.getFirstName() +" has "+ trainer.getNumOfBadges() + " badges");
        
        //Make trainer bank account
        BankAccount trainerAccount = new BankAccount();
        trainerAccount.setTotalFunds(600.45);
        trainer.setBankAccount(trainerAccount);
        System.out.println("\tTrainers's Bank Account funds:\t" + trainer.getBankAccount().getTotalFunds() + "\n");
        System.out.println("\t"+trainer.getFirstName()+"'s Bank Account number (random generation):\t"+trainer.getBankAccount().getAccountNumer()+"\n");
        
        //Make Pokemon for Ash
        Pokemon pikachu = new Pokemon("electric", 6, "Pikachu");
        Pokemon squirtle = new Pokemon("water", 7, "Squirtle");
        Pokemon charmander = new Pokemon("fire", 8, "Charmander");

        List<Pokemon> team = new ArrayList<Pokemon>();
        team.add(pikachu);
        team.add(squirtle);
        team.add(charmander);
        
        trainer.setPokemon(team);
        
        System.out.println("\t"+trainer.getFirstName() + "'s Pokemon:");
        int numOfPokemon = team.size();
        for(int i = 0; i < numOfPokemon; i++) {
        	System.out.println("\t\t"+trainer.getPokemon().get(i).getName());
        }
        
        //Create a gym leader
        GymLeader leader = new GymLeader();
        leader.setFirstName("Brock");
        leader.setLastName("The Rock");
        leader.setHumanId(3456789);
        System.out.println("\tGym Leader: \t" + leader.getFirstName() + " " + leader.getLastName()+"\n");
        System.out.println("\tLeader ID: \t" + leader.getHumanId() + "\n");
        
        //Make BankAccount for gym leader
        BankAccount gymAccount = new BankAccount();
        gymAccount.setTotalFunds(897.06);
        leader.setBankAccount(gymAccount);
        System.out.println("\t"+leader.getFirstName()+"'s Bank Account funds:\t" + leader.getBankAccount().getTotalFunds() + "\n");
        System.out.println("\t"+leader.getFirstName()+"'s Bank Account number (random generation):\t"+leader.getBankAccount().getAccountNumer()+"\n");
        
        //Make Pokemon for Brock
        Pokemon geodude = new Pokemon("ground", 6, "Geodude");
        Pokemon onyx = new Pokemon("ground", 7, "Onyx");
        Pokemon zubat = new Pokemon("poison", 8, "Zubat");

        List<Pokemon> gymPokemon = new ArrayList<Pokemon>();
        gymPokemon.add(geodude);
        gymPokemon.add(onyx);
        gymPokemon.add(zubat);
        
        leader.setPokemon(gymPokemon);
        
        System.out.println("\t"+leader.getFirstName() + "'s Pokemon:");
        int numOfGymPokemon = gymPokemon.size();
        for(int i = 0; i < numOfGymPokemon; i++) {
        	System.out.println("\t\t"+leader.getPokemon().get(i).getName());
        }
        
        //Make a gym
        Gym pewterCity = new Gym();
        manager.getBattleDome().addNewFacility(pewterCity); //add gym to battledome
        leader.setGym(pewterCity); //assign gym to leader
        pewterCity.setCapacity(400);
        pewterCity.setOpenDate(1997, 1, 1);
        pewterCity.setPriceToBattle(15.50);
        pewterCity.setFacilityName("Pewter City Gym");
        pewterCity.addFacilityDetail("A rock type gym with " + leader.getFirstName() + " as acting gym leader.");

        System.out.println("\t"+pewterCity.getFacilityName()+"'s capacity is " + pewterCity.requestAvailableCapacity() + " and it costs $" + pewterCity.getPriceToBattle()+" to battle\n");
        System.out.println("\t"+pewterCity.getFacilityName()+" opened on "+ pewterCity.getOpenDate()+"\n");
        
        //Schedule a battle
        trainer.scheduleBattle(leader); //schedule battle with gym leader
        System.out.println("\tIs "+pewterCity.getFacilityName()+" in use now?: " + pewterCity.getFacilityState());
        System.out.println("\tGym leader "+leader.getFirstName()+" is paid a fee of $"
        +leader.getGym().getPriceToBattle() +" by " + trainer.getFirstName()+" to battle."+"\n");
        System.out.println("\t"+leader.getFirstName()+"'s new bank balance is "+ leader.getBankAccount().getTotalFunds());
        System.out.println("\t"+trainer.getFirstName()+"'s new bank balance is "+ trainer.getBankAccount().getTotalFunds()+"\n");
        
        //Brock lost.
        leader.lostBattle(trainer);
        System.out.println("\t"+leader.getFirstName()+" lost the battle and therefore paid out $"+
        (leader.getGym().getPriceToBattle()*2)+" to "+trainer.getFirstName()+"\n");
        System.out.println("\t"+leader.getFirstName()+"'s new bank balance is "+ leader.getBankAccount().getTotalFunds());
        System.out.println("\t"+trainer.getFirstName()+"'s new bank balance is "+ trainer.getBankAccount().getTotalFunds()+"\n");
        //Empty gym
        pewterCity.getFacilityUses().vacateFacility(pewterCity);
        System.out.println("\tIs "+pewterCity.getFacilityName()+" in use now?: " + pewterCity.getFacilityState());
        
        //Have damage occur & request maintenance, set to maint status
        String[] damageTypes = {"electrical", "structural"};
        pewterCity.getFacilityMaint().makeFacilityMaintRequest(damageTypes, "Lights burnt out and columns cracked", 2, pewterCity);
        System.out.println("\t"+pewterCity.getFacilityName()+" has had maintenance scheduled on "+ pewterCity.listFacilityProblems());
        System.out.println("\t"+pewterCity.getFacilityName()+" is currently "+pewterCity.getFacilityState());   
        //Print out cost of maintenance
        System.out.println("\t"+pewterCity.getFacilityName()+"'s damage costs totaled $"+ pewterCity.getFacilityMaint().calcMaintenanceCostForFacility(pewterCity.listMaintenance()));
        System.out.println("\t"+pewterCity.getFacilityName()+"'s total downtime due to the last battle was "+ pewterCity.getFacilityMaint().calcDownTimeForFacilitiy(pewterCity.listMaintenance()) + " days.");
        //Let's pretend we were having a great day and the maintenance was already 
        //done even though I requested it for 2 days from now....
        pewterCity.listMaintenance().resolveMaintIssue(pewterCity);
        System.out.println("\tMaintenance has been done, "+pewterCity.getFacilityName()+" is currently "+pewterCity.getFacilityState());  
	}
}