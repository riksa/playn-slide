package org.riksa.core;

import static playn.core.PlayN.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Key;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Slicky extends Game.Default {
    private static final Logger log = LoggerFactory.getLogger(Slicky.class);
    private Image carImage;
    private List<Car> cars = new ArrayList<Car>();
    private Map<Car, ImageLayer> carLayers = new HashMap<Car, ImageLayer>();

    public Slicky() {
        super(33); // call update every 33ms (30 times per second)
    }

    @Override
    public void init() {
        // create and add background image layer
        carImage = assets().getImage("images/car.gif");
        Image bgImage = assets().getImage("images/arizona.gif");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        bgLayer.setScale(2);
        graphics().rootLayer().add(bgLayer);


        cars.add(new Car(new KeyboardController(Key.W, Key.A, Key.S, Key.D), 0f, 100f, 100f));

        for (Car car : cars) {
            ImageLayer carLayer = graphics().createImageLayer(carImage);
            carLayer.setRotation(car.getRotation());
            graphics().rootLayer().addAt(carLayer, car.getX(), car.getY());
            carLayers.put(car, carLayer);
        }


    }

    @Override
    public void update(int delta) {
        for (Car car : cars) {
            car.update();
            ImageLayer imageLayer = carLayers.get(car);
            imageLayer.setTx(car.getX());
            imageLayer.setTy(car.getY());
            imageLayer.setRotation(car.getRotation());
        }
    }

    @Override
    public void paint(float alpha) {
        // the background automatically paints itself, so no need to do anything here!
    }
}
