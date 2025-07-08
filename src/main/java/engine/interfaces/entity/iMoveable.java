package engine.interfaces.entity;

import com.raylib.Raylib.Vector2;

public interface iMoveable {

    void moveTo(Vector2 goToPos, float moveSpeed, float deltaTime);
    void runTo(Vector2 goToPos, float moveSpeed, float deltaTime, Float runSpeed);
    boolean isMoving();
    boolean isRunning();
    Vector2 getTargetPos();

}
