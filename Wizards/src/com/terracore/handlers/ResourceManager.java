package com.terracore.handlers;

public class ResourceManager {

	protected int count = 1;

	public void addReference() {
		count++;
	}

	public boolean removeReference() {
		count--;
		return count == 0;
	}

}
