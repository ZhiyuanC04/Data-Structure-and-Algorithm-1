public class TestIt {
    public static void main(String[]args){

    Animal var1 = new Dog("dog");
    Animal var2 = new Cow("cow");
    WorkingDogs var3 = new WorkingDogs("workdog");
    Dog var4 = new WorkingDogs("workdog2");
    Cow var7 = new Cow("cow2");
    Snake var8 = new Snake("snake");
    Object var5 = new Cow("cow3");
    Object var6 = new Dog("dog2");

        var1.testIt1(); // one
//        var2.testIt2();
        var3.testIt1();
        var4.testIt1();
//        var5.testIt3();
//        var6.testIt1();
        var4.testIt2();
        var3.testIt3();
//        var4.testIt3();
        ((Dog)var1).testIt2(); // two dogs
//        ((Cow)var2).testIt2();
        ((Animal)var8).testIt1(); // one snake

//        var7 = var2;
        var7.testIt3(); // three cows
        ((Cow)var2).testIt3(); // three cows
}
}