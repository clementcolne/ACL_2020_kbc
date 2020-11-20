package start;

import engine.MapBuilder;
import model.PacmanPainter;
import engine.GameEngineGraphical;
import model.PacmanController;
import model.PacmanGame;

/**
 * lancement du moteur avec le jeu
 */
public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		if (args.length >= 1) {
			// creation du jeu particulier et de son afficheur
			MapBuilder map = new MapBuilder(args[0]);
			PacmanGame game = new PacmanGame("helpFilePacman.txt", map);
			PacmanPainter painter = new PacmanPainter(game);
			PacmanController controller = new PacmanController();
	
			// classe qui lance le moteur de jeu generique
			GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
			engine.run();
		}
		else {
			System.err.println("Veuillez entrer le chemin vers la map à utiliser");
		}
	}

}