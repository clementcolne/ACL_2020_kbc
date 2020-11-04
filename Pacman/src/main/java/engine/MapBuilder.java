package engine;

import model.*;
import model.effect.EffectMagic;
import model.effect.EffectTrap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe qui décrit la construction de la map à partir d'un fichier texte
 * @author Clément Colné
 */
public class MapBuilder {

    private String path;
    // Tableau représentant la map du jeu
    private Ground[][] map;
    private int width;
    private int height;
    private Passage p1;
    private Passage p2;

    /**
     * @author Clément
     * Constructeur de la map
     * @param path chemin vers le fichier texte décrivant la map
     * @param width largeur de la map
     * @param height longueur de la map
     */
    public MapBuilder(String path, int width, int height) {
        this.path = path;
        this.width = width;
        this.height = height;
        buildMap();
    }

    /**
     * @author Clément
     * Construit la map à partir du fichier texte décrivant la map
     * @return tableau contenant des objets de type Ground décrivant la map
     */
    private void buildMap() {
        // initialisation du tableau qui contiendra les objets de la map
        this.map = new Ground[width][height];

        // lecture du fichier
        try {
            File file = new File("resources/Map/" + path);
            Scanner reader = new Scanner(file);
            // compteur de lignes
            int i = 0;
            while(i < height) {
                String data = reader.nextLine();
                for(int j = 0 ; j < data.length() ; j++) {
                    // pour chaque colonne
                    // complète la map
                    map[j][i] = getGround(data.charAt(j), j, i);
                }
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé");
            e.printStackTrace();
        }
    }

    /**
     * @author Clément
     * Retourne l'objet de type Ground correspondant au caractère en paramètre
     * @param c caractère qui décrit l'objet
     * @return objet de type Ground
     */
    private Ground getGround(char c, int x, int y) {
        Ground res = null;
        switch (c) {
            case 'w':
                // wall
                res = new Wall(x, y);
                break;
            case 'e':
                // end
                // res = new End(x, y);
                break;
            case 'm':
                // magic
                res = new Magic(x, y, new EffectMagic());
                break;
            case 't':
                // trap
                res = new Trap(x, y, new EffectTrap());
                break;
            case 'p':
                // passage
                res = new Passage(x, y);
                setPassages(res);
                break;
            default:
                // par défault, la case est un sol
                res = new Ground(x, y);
                break;
        }
        return res;
    }

    private void setPassages(Ground p) {
        if(p1 == null) {
            p1 = (Passage)p;
        }else{
            p2 = (Passage)p;
            p1.setLinkedPassage(p2);
            p2.setLinkedPassage(p1);
        }
    }

    /**
     * Retourne la case à la position x;y
     * @param x position en x
     * @param y position en y
     * @return case à la position x;y
     */
    public Ground get(int x, int y) {
        return map[x][y];
    }

    /**
     * Change le Ground [x;y] par le nouveau Ground en paramètre
     * @param x position en x
     * @param y position en y
     * @param g nouveau Ground
     */
    public void set(int x, int y, Ground g) {
        map[x][y] = g;
    }

    /**
     * @author Clément
     * Retourne la largeur de la map
     * @return la largeur de la map
     */
    public int getWidth() {
        return width;
    }

    /**
     * @author Clément
     * Retourne la hauteur de la map
     * @return la hauteur de la map
     */
    public int getHeight() {
        return height;
    }

    /**
     * @author Clément
     * Retourne la map au format texte
     * @return toString de la map
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(map == null) {
            sb.append("Map vide");
        }else{
            for (int i = 0; i < map.length; i++) {
                sb.append("[");
                for (int j = 0; j < map[i].length; j++) {
                    sb.append(map[i][j].toString());
                }
                sb.append("]\n");
            }
        }
        return sb.toString();
    }

}
