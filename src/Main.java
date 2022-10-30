
//написать программу, которая инкрементирует count в двух параллельных потоках 10000 раз
//        вывести в консоль count, объяснить полученные результаты


public class Main {
    public static void main(String[] args) throws InterruptedException {
        //создаем экземпляр счетчика
        Counter counter = new Counter();
        //передаем в первый поток
        Thread t1 = new Thread(counter);
        //запускаем первый поток
        t1.start(); // тут запустили первый и после запуска продолжили выполнение кода
        //передаем во второй поток
        Thread t2 = new Thread(counter);
        //запускаем второй поток
        t2.start();
        //остановили для считывания переменной
        Thread.sleep( 10 );
        //получить переменную экземпляра
        System.out.println( counter.getValue() );
    }
}