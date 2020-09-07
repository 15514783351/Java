/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/9/7 19:27   戴宗明       1.0         None
 */


public class Cat extends Animal {
    public void eat() {
        System.out.println("猫");
    }

    public void eat1() {
        System.out.println("eat1");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
    }
}
