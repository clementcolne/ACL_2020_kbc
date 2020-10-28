package model;

import java.awt.Color;

import model.effect.EffectMagic;

/**
 * Classe qui représente un sol associé à un effet magique
 * @author Raphaël
 *
 */
public class Magic extends Ground {
	
	private EffectMagic effect;
	
	/**
	 * Constructeur de Magic (magie)
	 * @author Raphaël
	 * @param x, position en abscisse de la case de magie
	 * @param y, position en ordonnée de la case de magie
	 */
	public Magic(int x, int y, EffectMagic eff) {
		super(x, y);
		this.effect = eff;
		this.name = 'w';
		this.color = Color.GRAY;
		this.effect = eff;
	}
	
	public EffectMagic getEffect() {
		return this.effect;
	}

}
