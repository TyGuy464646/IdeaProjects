package com.terracore.players;

public class Player {

	private int HP;
	private int MP;
	private int MPRegen;
	private String Affinity;
	private String Name;
	
	public Player(int HP, int MP, int MPRegen, String Affinity, String Name) {
		this.HP = HP;
		this.MP = MP;
		this. MPRegen = MPRegen;
		this.Affinity = Affinity;
		this.Name = Name;
	}
	
	public int getHP(){
		return HP;
	}
	
	public int getMP(){
		return MP;
	}
	
	public int getMPRegen(){
		return MPRegen;
	}
	
	public String getAffinity(){
		return Affinity;
	}
	
	public String getName(){
		return Name;
	}
}
