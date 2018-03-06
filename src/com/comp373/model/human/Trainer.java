package com.comp373.model.human;

import java.util.List;

import com.comp373.constants.ApplicationConstants;
import com.comp373.model.bankaccount.*;
import com.comp373.model.facility.Gym;
import com.comp373.models.pokemon.*;

public class Trainer extends Human {
	
	private int numOfBadges;
	List<Pokemon> pokemon;
	
	public Trainer() {
		
	}
	
	public Trainer(String fName, String lName, BankAccount account, int badges, List<Pokemon> pocketMonsters, long id) {
		super(fName, lName, account, id);
		this.setNumOfBadges(badges);
		this.pokemon = pocketMonsters;
	}

	public int getNumOfBadges() {
		return numOfBadges;
	}

	public void setNumOfBadges(int numOfBadges) {
		this.numOfBadges = numOfBadges;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	
	public void scheduleBattle(GymLeader gymLeader) {
		gymLeader.getGym().getFacilityUses().assignFacilityToUse(gymLeader.getGym(), ApplicationConstants.GYM_BATTLE);
		this.getBankAccount().transferFunds(gymLeader.getGym().getPriceToBattle(), gymLeader);
	}
}
