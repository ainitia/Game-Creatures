package Test;

public class Creature {
	protected int attack; // Атака
	protected int defense; // Защита
	protected int health; // Здоровье
	protected int minDamage; // начало диапазона Урона
	protected int maxDamage; // конец диапазона Урона

	public Creature() {
		attack = (int) (1 + Math.random() * 30); // случайное значение Атаки (от 1 до 30)
		defense = (int) (1 + Math.random() * 30); // случайное значение Защиты (от 1 до 30)
		health = (int) (1 + Math.random() * 100); // случайное значение Здоровья (от 0 до 100)
		maxDamage = (int) (2 + Math.random() * 29); // конец диапазона Урона N (от 2 до 30)
		minDamage = (int) (1 + Math.random() * (maxDamage - 1)); // начало диапазона Урона M (от 1 до N)
	}

	public boolean dealDamage(Creature crDef) { // метод для атаки, CrDef - защищающееся существо
		int attackMod; // модификатор атаки
		int cubeNum; // число кубика
		int damage; // урон атаки
		attackMod = Math.abs(this.getAttack() - crDef.getDefense() + 1); // вычисление модификатора атаки
		for (int i = 1; i < (attackMod + 1); i++) {
			cubeNum = (int) (1 + Math.random() * 6); // бросок кубика
			if (cubeNum == 5 || cubeNum == 6) { // если на кубике 5 или 6, вычисляется урон
				damage = (int) (this.minDamage + Math.random() * (this.maxDamage - this.minDamage + 1));
				crDef.getDamage(damage); // наносится урон
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public void getDamage(int damage) { // метод нанесения урона для того, на кого напали
		this.health = this.health - damage;
		if (this.health <= 0) {
			this.health = 0;
		}
	}

	public void getInfo() { // метод получения и вывода параметров игрока
		System.out.println("Здоровье: " + this.health + ", Атака: " + this.attack + ", Защита: " + this.defense
				+ ", Урон: " + this.minDamage + " - " + this.maxDamage);
		System.out.println();
	}

	public String getType() {
		return "Существо";
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getHealth() {
		return health;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}
}
