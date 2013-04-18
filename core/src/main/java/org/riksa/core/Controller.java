package org.riksa.core;

/**
 * User: riksa
 * Date: 18.4.2013
 * Time: 19:39
 */
public interface Controller {
    /**
     * Amount of throttle: -1= full revers, 0 no throttle, 1=full ahead
     *
     * @return
     */
    float getThrottle();

    /**
     * Position of steering wheel. -1= full left, 0 center, 1=full right
     *
     * @return
     */
    float getSteer();
}
