package Game;

import Enemy.Enemy;

import java.util.ArrayList;

public class Wave {
    private ArrayList<Enemy> enemiesInWave = new ArrayList<>();

    public ArrayList<Enemy> getEnemiesInWave() {
        return enemiesInWave;
    }

    public void setEnemiesInWave(ArrayList<Enemy> enemiesInWave) {
        this.enemiesInWave = enemiesInWave;
    }
}
