public class Lab_03 {

    public static void main(String[] args) {

        Animal animal;
        Cow cow = new Cow("Bossy");
        Dog dog = new Dog("Rover");
        Snake snake = new Snake("Ernie");

        animal = cow;
        animal = dog;
        animal = snake;
        animal.speak(); // Ssssss, snake speak.
        System.out.println(animal.toString());

        System.out.println();

        Animal[] animals = new Animal[4];
        animals[0] = cow;
        animals[1] = dog;
        animals[2] = snake;
        animals[3] = new WorkingDogs("Jack");
        for (int i = 0; i < animals.length; i++) {
            animals[i].speak();
            System.out.println(animals[i].toString());}

        System.out.println();

        // Animal class does not have work() method. Have to use WorkingDogs Class.
        WorkingDogs dog2 = new WorkingDogs("James");
        dog2.work();
        if (dog2 instanceof Working) {
            dog2.work();}


    }
}
