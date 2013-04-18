package org.riksa.core;

/**
 * User: riksa
 * Date: 18.4.2013
 * Time: 19:55
 */
public class DefaultCarAttributes implements CarAttributes {
    private final float acceleration = 0.1f;
    private final float rotationSpeed = 0.1f;
    private final float topSpeed = 10f;
    private final float minSpeed = -topSpeed / 2f;

    @Override
    public float getTopSpeed() {
        return topSpeed;
    }

    @Override
    public float getAcceleration() {
        return acceleration;
    }

    @Override
    public float getRotationSpeed() {
        return rotationSpeed;
    }

    @Override
    public float getMinSpeed() {
        return minSpeed;
    }
}
