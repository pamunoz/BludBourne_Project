package com.pfariasmunoz.libgdx.bludbourne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;

public class MapManager {
    private static final String TAG = MapManager.class.getSimpleName();

    private Camera _camera;
    private boolean _mapChanged = false;
    private Map _currentMap;
    private Entity _player;

    public MapManager() {

    }

    public void loadMap(MapFactory.MapType mapType) {
        Map map = MapFactory.getMap(mapType);

        if (map == null) {
            Gdx.app.debug(TAG, "Map does not exits");
        }
    }
}
