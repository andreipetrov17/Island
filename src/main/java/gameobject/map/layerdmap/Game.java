package gameobject.map.layerdmap;

import java.util.ArrayList;

public class Game implements Runnable {
    private static Game instance;
    public static final int x = 30;
    public static final int y = 50;
    public CountryMap countryMap = new CountryMap();
    public OrganismMap organismMap = new OrganismMap();
    public ViewMap viewMap = new ViewMap();

    private Game() {

    }

    public static Game getInstance() {
        if (instance == null) instance = new Game();
        return instance;
    }

    public void initialize() {
        organismMap.unitPopulation();
        organismMap.unitCommonRes();
        viewMap.initialize(organismMap, countryMap);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true){
                Thread move  = new Thread(new Runnable() {
                    @Override
                    public void run() {
                for (int y = 1; y < organismMap.get()[0].length - 1; y++) {
                    for (int x = 1; x < organismMap.get().length - 1; x++) {
                        new Thread(((OrganismField) organismMap.get()[x][y]).population[0]).start();

                    }
                }
            }});
           move.start();
                try {
                    move.join(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                viewMap.repaintLabel();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread origin = new Thread(new Runnable() {
                @Override
                public void run() {
            for (int y = 1; y < organismMap.get()[0].length - 1; y++) {
                for (int x = 1; x < organismMap.get().length - 1; x++) {
                    ((OrganismField) organismMap.get()[x][y]).population[0].willMove.addAll(((OrganismField) organismMap.get()[x][y]).population[0].wasMoved);
                    ((OrganismField) organismMap.get()[x][y]).population[0].wasMoved.clear();
                }
            }
            }
            });
            origin.start();
                try {
                    origin.join(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

