package org.riksa.core;

/**
 * User: riksa
 * Date: 18.4.2013
 * Time: 19:37
 */
public class Car {
    CarAttributes carAttributes = new DefaultCarAttributes();
    private float rotation = 0f;
    private float speed = 0f;
    private float x = 0f;
    private float y = 0f;
    Controller controller;

    public Car(Controller controller, float rotation, float x, float y) {
        this.controller = controller;
        this.rotation = rotation;
        this.x = x;
        this.y = y;
    }

    public void update() {
        float targetSpeed = controller.getThrottle() * carAttributes.getTopSpeed();
        if (targetSpeed > speed) {
            speed += carAttributes.getAcceleration();
            if (speed > targetSpeed) {
                speed = targetSpeed;
            }
        } else {
            speed -= carAttributes.getAcceleration();
            if (speed < targetSpeed) {
                speed = targetSpeed;
            }
        }

        speed = speed > carAttributes.getTopSpeed() ? carAttributes.getTopSpeed() : speed;
        speed = speed < carAttributes.getMinSpeed() ? carAttributes.getMinSpeed() : speed;

        rotation += controller.getSteer() * carAttributes.getRotationSpeed();

        x += speed * Math.cos(rotation);
        y += speed * Math.sin(rotation);

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRotation() {
        return rotation;
    }
}
