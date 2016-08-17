package com.pfariasmunoz.libgdx.bludbourne;

import java.util.UUID;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
/**
 * Created by Pablo Farias on 17-08-16.
 */
public class Entity {

    private static final String TAG = Entity.class.getSimpleName();
    private static final String _defaultSpritePath = "Sprites/characters/Warrior.png";

    private Vector2 _velocity;
    private String _entityID;

    private Direction _currentDirection = Direction.LEFT;
    private Direction _previousDirection = Direction.UP;

    private Animation _walkLeftAnimation;
    private Animation _walkRightAnimation;
    private Animation _walkUpAnimation;
    private Animation _walkDownAnimation;

    private Array<TextureRegion> _walkLeftFrames;
    private Array<TextureRegion> _walkRightFrames;
    private Array<TextureRegion> _walkUpFrames;
    private Array<TextureRegion> _walkDownFrames;

    protected Vector2 _nextPlayerPosition;
    protected Vector2 _currentPlayerPosition;
    protected State _state = State.IDLE;
    protected float _frameTime = 0f;
    protected Sprite _frameSprite = null;
    protected TextureRegion _currentFrame = null;

    public final int FRAME_WIDTH = 16;
    public final int FRAME_HEIGHT = 16;
    public static Rectangle boundingBox;

    public enum State {
        IDLE, WALKING;
    }

    public enum Direction {
        UP, RIGHT, DOWN, LEFT;
    }

    public Entity() {
        initEntity();
    }

    public void initEntity() {
        this._entityID = UUID.randomUUID().toString();
        this._nextPlayerPosition = new Vector2();
        this._currentPlayerPosition = new Vector2();
        this.boundingBox = new Rectangle();
        this._velocity = new Vector2(2f, 2f);

        Utility.loadTextureAsset(_defaultSpritePath);
        loadDefaultSprite();
        loadAllAnimations();
    }

    public void update(float delta) {
        _frameTime = (_frameTime + delta) % 5;
        // Want to avoid overflow

        // We want the hitbox to be at the feet for a better feel
        setBoundingBoxSize(0f, 0.5f);
    }

    public void init(float startX, float startY) {
        this._currentPlayerPosition.x = startX;
        this._currentPlayerPosition.y = startY;
        this._nextPlayerPosition.x = startX;
        this._nextPlayerPosition.y = startY;
    }

    public void setBoundingBoxSize(float percentageWidthReduced, float percentageHeightReduced) {
        // Update the current bounding box
        float width;
        float height;

        float widthReductionAmount = 1.0f - percentageWidthReduced; // .8f for 20% (1 - .20)
        float heightReductionAmount = 1.0f - percentageHeightReduced; // .8f for 20% (1 - .20)

        if (widthReductionAmount > 0 && widthReductionAmount < 1) {
            width = FRAME_WIDTH * widthReductionAmount;
        } else {
            width = FRAME_WIDTH;
        }

        if (heightReductionAmount > 0 && heightReductionAmount < 1) {
            height = FRAME_HEIGHT * heightReductionAmount;
        } else {
            height = FRAME_HEIGHT;
        }

        if (width == 0 || height == 0) {
            Gdx.app.debug(TAG, "Width and Height are 0!! " + width + ": " + height);
        }

        // Need to account for the unitscale, since the map coordinates will e in pixels
        float minX;
        float minY;
        if (MapManager.UNIT_SCALE > 0) {
            minX = _nextPlayerPosition.x / MapManager.UNIT_SCALE;
            minY = _nextPlayerPosition.y / MapManager.UNIT_SCALE;
        } else {
            minX = _nextPlayerPosition.x;
            minY = _nextPlayerPosition.y;
        }

        boundingBox.set(minX, minY, width, height);
    }

}
