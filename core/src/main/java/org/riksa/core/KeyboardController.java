package org.riksa.core;

import playn.core.Key;
import playn.core.Keyboard;

import static playn.core.PlayN.keyboard;

/**
 * User: riksa
 * Date: 18.4.2013
 * Time: 20:05
 */
public class KeyboardController implements Controller, Keyboard.Listener {
    private final Key forward;
    private final Key left;
    private final Key back;
    private final Key right;
    private float throttle = 0f;
    private float steer = 0f;

    public KeyboardController(Key forward, Key left, Key back, Key right) {
        this.forward = forward;
        this.left = left;
        this.back = back;
        this.right = right;

        keyboard().setListener(this);
    }

    @Override
    public float getThrottle() {
        return throttle;
    }

    @Override
    public float getSteer() {
        return steer;
    }

    @Override
    public void onKeyDown(Keyboard.Event event) {
        if (event.key() == forward) {
            throttle = 1f;
        }
        if (event.key() == back) {
            throttle = -1f;
        }
        if (event.key() == left) {
            steer = -1f;
        }
        if (event.key() == right) {
            steer = 1f;
        }
    }

    @Override
    public void onKeyTyped(Keyboard.TypedEvent event) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onKeyUp(Keyboard.Event event) {
        if (event.key() == forward) {
            throttle = 0f;
        }
        if (event.key() == back) {
            throttle = 0f;
        }
        if (event.key() == left) {
            steer = 0f;
        }
        if (event.key() == right) {
            steer = 0f;
        }
    }
}
