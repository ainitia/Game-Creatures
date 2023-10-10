package Test;


class Player extends Creature {
	int numOfHeal; // количество исцелений игрока (до 4 раз)
	
	public Player() {
		super();
		this.numOfHeal = 0;
	}
		
	public boolean heal() {
		if (this.numOfHeal < 5 && this.health < 100 && this.health > 0) { // если кол-во исцелений не макс. и здоровье < максимального
			this.numOfHeal++; // счетчик исцелений +
			this.health += 30; // исцеление на 30% от максимального здоровья
			if (this.health > 100) { // если новое здоровье > максимального, уменьшить до максимального
				this.health = 100;
			}
			return true;
		}
		return false;
	}
	
	public String getType() {
		return "Игрок";
	}
	
	public int getNumOfHeal() {
		return numOfHeal;
	}
}

