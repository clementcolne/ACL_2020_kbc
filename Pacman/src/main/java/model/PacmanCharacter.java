package model;

/**
 * Cette classe décrit le comportement d'un personnage
 * @author Clément Colné
 */
public class PacmanCharacter {

    private int posX;
    private int posY;
    private int life = 10;
	private int speed = 2;
	private int range = 2;
	private boolean ghost;

    /**
     * Constructeur du personnage pacman
     * @author Clément
     * @param posX Position du personnage en X
     * @param posY Position du personnage en Y
     */
    public PacmanCharacter(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     *
     * Déplace la position du personnage d'une case vers la droite
     * @author Adham
     */
    public void mooveRight() {
        posX += 1 * this.speed;
    }

    /**
     * Déplace la position du personnage d'une case vers la gauche
     * @author Adèle
     */
    public void mooveLeft() {
        posX -= 1 * this.speed;
    }

    /**
     * Déplace la position du personnage d'une case vers le haut
     * @author Raphael
     */
    public void mooveUp() {
    	posY -= 1 * this.speed;
    }

    /**
     * Déplace la position du personnage d'une case vers le bas
     * @author Clément
     */
    public void mooveDown() {
        posY += 1 * this.speed;
    }

    /**
     * @author Adèle
     * Inflige des dégats au personnage, ce qui lui fait perdre un/des points de vie
     * @param damage ampleur des dégats infligés, nombre de points de vie perdus par le personnage
     */
    public void setDamage(int damage){
        if(life-damage>=0)
            life -= damage;
        else
            life = 0;
    }
    
    /**
     * Modifier la vitesse du Pacman
     * @author Raphaël
     * @param s
     */
	public void setSpeed(int s) {
		this.speed = s;
	}
	
    /**
     * Retourner la vitesse du Pacman
     * @author Raphaël
     * @return Vitesse du pacman
     */
	public int getSpeed() {
		return this.speed;
	}
	
    /**
     * Permet de modifier le caractère fantôme du Pacman. S'il est fantôme, il peut traverser les murs
     * @author Raphaël
     * @param b true ou false
     */
	public void setGhost(boolean g) {
		this.ghost = g;
	}
	
	/**
	 * Retourne si le Pacman est un fantôme
	 * @author Raphaël
	 * @return true ou false
	 */
	public boolean getGhost() {
		return this.ghost;
	}
	
	/**
	 * Permet de modifier la portée d'attaque du Pacman (en cases)
	 * @author Raphaël
	 * @param r Portée des attaques
	 */
	public void setRange(int r) {
		if (this.range >= 1)
			this.range = r;
		else {
			this.range = 2;
		}
	}
	
	/**
	 * Retourner la portée des attaques du Pacman
	 * @author Raphaël
	 * @return Portée des attaques du Pacman
	 */
	public int getRange() {
		return this.range;
	}

    /**
     * Retourne la position en X du personnage
     * @author Clément
     * @return position en X du personnage
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Retourne la position en Y du personnage
     * @author Clément
     * @return position en Y du personnage
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @author Adèle
     * @return le nombre de point de vie du personnage
     */
    public int getLife() {
        return life;
    }

    /**
     * Retourne la position en X et en Y du personnage
     * @author Clément
     * @return toString du personnage
     */
    @Override
    public String toString() {
        return "Position pacman : (" + posX + " ; " + posY + ")";
    }
}