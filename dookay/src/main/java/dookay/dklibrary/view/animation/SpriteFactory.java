package dookay.dklibrary.view.animation;

import dookay.dklibrary.view.animation.sprite.Sprite;
import dookay.dklibrary.view.animation.style.Circle;
import dookay.dklibrary.view.animation.style.FadingCircle;
import dookay.dklibrary.view.animation.style.ThreeBounce;

/**
 * Created by ybq.
 */
public class SpriteFactory {
    public static Sprite create(Style style) {
        Sprite sprite = null;
        switch (style) {
            case WAVE: // 0
                sprite = new ThreeBounce();
                break;
            case DOUBLE_BOUNCE:  // 1
                sprite = new Circle();
                break;
            case ROTATING_PLANE: // 2
                sprite = new FadingCircle();
                break;
            default:
                break;
        }
        return sprite;
    }
}
