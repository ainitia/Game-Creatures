package Test;

public class Game {

	public static void startGame(Creature crAtt, Creature crDef) { // начало новой игры, вывод параметров игроков
		System.out.println("Новая игра!");
		System.out.println();
		System.out.println("Нападает " + crAtt.getType() + ". Его параметры:");
		crAtt.getInfo();
		System.out.println("Защищается " + crDef.getType() + ". Его параметры:");
		crDef.getInfo();
	}

	public static void fightSuccess(Creature crAtt, Creature crDef) { // обработка успешной атаки
		System.out.println("Удар нанесен успешно!");
		System.out.println();
		System.out.println("Результат атаки:");
		if (crDef.getHealth() <= 0) {
			System.out.println("Игра окончена. Атакуемый " + crDef.getType() + " уничтожен!");
			System.out.println();
		} else {
			System.out.println("Атакуемый " + crDef.getType() + " пострадал. Здоровье стало равным " + crDef.getHealth());
			System.out.println();
		}
	}

	public static void healPlayer(Player pl) { // исцеление игрока
		System.out.println("Игрок пробует исцелиться...");
		if (pl.heal() == true) {
			System.out.print("Игрок исцелен! Здоровье игрока увеличилось до " + pl.getHealth());
			System.out.println(". Осталось попыток исцелиться: " + (4 - pl.getNumOfHeal()));
			System.out.println();
		} else {
			System.out.println("Игроку не удалось исцелиться.");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Player player = new Player();
		Monster monster = new Monster();

		Game.startGame(monster, player);

		if (monster.dealDamage(player) == true) {
			Game.fightSuccess(monster, player);
			if (player.getHealth() > 0)
				Game.healPlayer(player);
		} else {
			System.out.println("Удар нанести не удалось!");
			System.out.println();
		}

		if (player.getHealth() > 0) {
			System.out.println(monster.getType() + " наносит повторный удар...");
			System.out.println();
			if (monster.dealDamage(player) == true) {
				Game.fightSuccess(monster, player);
				if (player.getHealth() > 0)
					Game.healPlayer(player);
				else {
					System.out.println("Удар нанести не удалось!");
					System.out.println();
				}
			}
		}
		Monster monster2 = new Monster();
		Monster monster3 = new Monster();

		Game.startGame(monster2, monster3);

		if (monster2.dealDamage(monster3) == true) {
			Game.fightSuccess(monster2, monster3);
		} else {
			System.out.println("Удар нанести не удалось!");
			System.out.println();
		}
	}
}
