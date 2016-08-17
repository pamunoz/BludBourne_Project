package com.pfariasmunoz.libgdx.bludbourne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.*;
import java.util.Hashtable;
/**
 * Created by Pablo Farias on 16-08-16.
 */
public class MapManager {
    public static final String TAG = MapManager.class.getSimpleName();

    // All maps for thr game
    private Hashtable<String, String > _mapTable;
    private Hashtable<String, Vector2> _playerStartLocationTable;

    //maps
    private final static String TOP_WORLD = "TOP_WORLD";
    private final static String TOWN = "TOWN";
    private final static String CASTLE_OF_DOOM = "CASTLE_OF_DOOM";

    // Map layers
    private final static String MAP_COLLISION_LAYER = "MAP_COLLISION_LAYER";
    private final static String MAP_SPAWNS_LAYER = "MAP_SPAWNS_LAYER";
    private final static String MAP_PORTAL_LAYER = "MAP_PORTAL_LAYER";

    private final static String PLAYER_START = "PLAYER_START";
    private Vector2 _playerStartPositionRect;
    private Vector2 _closestPlayerStartPosition;
    private Vector2 _convertedUnits;

    private Vector2 _playerStart;
    private TiledMap _currentMap = null;
    private String _currentMapName;
    private MapLayer _collisionLayer = null;
    private MapLayer _portalLayer = null;
    private MapLayer _spawnsLayer = null;

    public final static float UNIT_SCALE = 1/16f;

    public MapManager() {
        _playerStart = new Vector2(0, 0);

        _mapTable = new Hashtable();

        _mapTable.put(TOP_WORLD, "maps/topworld.tmx");
        _mapTable.put(TOWN, "maps/town.tmx");
        _mapTable.put(CASTLE_OF_DOOM, "maps/castle_of_doom.tmx");

        _playerStartLocationTable = new Hashtable();

        _playerStartLocationTable.put(TOP_WORLD, _playerStart.cpy());
        _mapTable.put(CASTLE_OF_DOOM, "maps/castle_of_doom.tmx");

        _playerStartLocationTable = new Hashtable();

        _playerStartLocationTable.put(TOP_WORLD, _playerStart.cpy());
        _playerStartLocationTable.put(TOWN, _playerStart.cpy());
        _playerStartLocationTable.put(CASTLE_OF_DOOM, _playerStart.cpy());

        _playerStartPositionRect = new Vector2(0, 0);

        _closestPlayerStartPosition = new Vector2(0, 0);

        _convertedUnits = new Vector2(0, 0);
    }
}
