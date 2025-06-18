package by.step.task_car;

// Интерфейс для замка автомобиля
interface Lockable {
    boolean unlock(Key key);

    void lock();

    boolean isLocked();
}
