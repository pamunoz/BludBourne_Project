package com.pfariasmunoz.libgdx.bludbourne;

/**
 * Created by Pablo Farias on 18-08-16.
 */
public interface Component {

    public static final String MESSAGE_TOKEN = ":::::";

    void dispose();

    void receiveMessage(String message);

    public static enum MESSAGE {
        CURRENT_POSITION,
        INIT_START_POSITION,
        CURRENT_DIRECTION,
        CURRENT_STATE,
        COLLISION_WITH_MAP,
        COLLISION_WITH_ENTITY,
        LOAD_ANIMATIONS,
        INIT_DIRECTION,
        INIT_STATE,
        INIT_SELECT_ENTITY,
        ENTITY_SELECTED,
        ENTITY_DESELECTED
    }
}
