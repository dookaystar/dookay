package dookay.dklibrary.view.animation;

/**
 * Created by ybq.
 */
public enum Style {
    ROTATING_PLANE(0),
    DOUBLE_BOUNCE(1),
    WAVE(2);
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private int value;

    Style(int value) {
        this.value = value;
    }
}
