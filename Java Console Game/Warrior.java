class Warrior {

	private byte health;
	private byte attack;

	public Warrior(byte health, byte attack){
		this.health = health;
		this.attack = attack;
	}

	public byte getAttack() {
		return this.attack;
	}

	public void setAttack(byte x) {
		this.attack = x;
	}

	public byte getHealth() {
		return this.health;
	}

	public void setHealth(byte x) {
		this.health = x;
	}
}
