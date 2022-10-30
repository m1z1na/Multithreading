import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread {
    // переменная, которую будем инкриментить
    int value = 0;
    //блокировка
    Lock lock = new ReentrantLock();


    @Override
    public void run() {

        // пока значение меньше  10000 бежим по циклу
        for (int i = 0; value < 10000; i++) {
            //блокируем
            lock.lock();
            // тут проверяем, что значение все еще меньше 10000
            if (value < 10000) {
                // прибавим 1
                int tempValue = value;
                tempValue++;
                // переприсвоим
                System.out.println(Thread.currentThread().getName() + ". Тут значение равно: " + tempValue);
                value = tempValue;
            }
            //разблокируем
            lock.unlock();
        }

    }

    public int getValue() {
        return value;
    }

}
