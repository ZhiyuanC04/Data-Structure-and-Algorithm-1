public class Horse extends Animal{

    public Horse(String nm)     {
        super(nm);    // builds ala parent
    }
    public void speak()  {  // this method specific to Cow
        System.out.println("??");
    }
}
