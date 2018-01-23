public class FunctionalProgrammingExample1 {

    public static Integer invertTheNumber(){
        Integer toInvert = 5;
        return compute((a) -> -a, toInvert);
    }

   
}
